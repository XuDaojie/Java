package io.github.xudaojie.javase.mongodb;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.ChangeStreamIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.changestream.ChangeStreamDocument;

import org.bson.BsonTimestamp;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.junit.Before;
import org.junit.Test;

/**
 * 订阅mongodb数据变化
 * mongodb 3.6以上支持
 *
 * @author XuDaojie
 * @since 2020/9/5
 */
public class ChangeStreamTest {

    private MongoClient mongoClient;

    @Before
    public void init() {
        ConnectionString connString = new ConnectionString(
            "mongodb://127.0.0.1:30000"
        );
        MongoClientSettings settings = MongoClientSettings.builder()
            .applyConnectionString(connString)
            .retryWrites(true)
            .build();
        this.mongoClient = MongoClients.create(settings);
    }

    @Test
    public void changeStreamTest() {
        MongoDatabase database = mongoClient.getDatabase("test");
        Document document = database.getCollection("canal-oplog").find().first();
        System.out.println(document);

        ChangeStreamIterable<Document> iterable = database.watch();

        while (true) {
            ChangeStreamDocument<Document> sa = iterable.iterator().next();
            System.err.println(sa);
        }
    }

    @Test
    public void oplogTest() {
        MongoDatabase database = mongoClient.getDatabase("local");
        Bson query = Filters.and(
            Filters.eq("ns", "test.canal-oplog"),
            Filters.gt("ts", new BsonTimestamp(1599274426, 1))
        );
        MongoCursor<Document> cursor = database.getCollection("oplog.rs").find(query).limit(10).iterator();
        while (cursor.hasNext()) {
            Document document = cursor.next();
            switch (document.getString("op")) {
                case "i":
                case "u":
                case "d":
                default:
            }
        }
    }
}
