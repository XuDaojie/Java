package io.github.xudaojie.mybatis;

import com.google.common.base.Stopwatch;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import io.github.xudaojie.mybatis.bean.FooBean;
import io.github.xudaojie.mybatis.mapper.FooMapper;

public class MyBatisTest {

    @Test
    public void sqlSessionTest() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        sqlSessionFactory.getConfiguration().setCacheEnabled(false);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);

//        SqlSession session = sqlSessionFactory.openSession(true);
        SqlSession session = sqlSessionFactory.openSession();
//        SqlSession sessionReuse = sqlSessionFactory.openSession(ExecutorType.REUSE);
//        SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH);
        FooMapper mapper = session.getMapper(FooMapper.class);

        Stopwatch stopwatch = Stopwatch.createStarted();
        for (long i = 0; i < 3; i++) {
            FooBean goodsBean = mapper.findById(1L);
            session.commit();
            System.out.println(goodsBean);
        }
        System.out.println(stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");

        FooBean goodsBean = new FooBean();
        goodsBean.setFoo("asdasdasd");
        mapper.save(goodsBean);
        session.commit();

//        session.close();
    }

    @Test
    public void batchInsertTest() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);

        SqlSession sessionSimple = sqlSessionFactory.openSession();
        SqlSession sessionReuse = sqlSessionFactory.openSession(ExecutorType.REUSE);
        SqlSession sessionBatch = sqlSessionFactory.openSession(ExecutorType.BATCH);


        Stopwatch stopwatch = Stopwatch.createStarted();
        batchInsertFoo(sessionSimple, 2);
        sessionSimple.close();
        System.out.println("Simple: " + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
//
//        stopwatch.reset();
//        stopwatch.start();
//        batchInsertFoo(sessionReuse, 100);
//        sessionReuse.close();
//        System.out.println("Reuse: " + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");

//        stopwatch.reset();
//        stopwatch.start();
//        batchInsertFoo(sessionBatch, 100);
//        sessionBatch.close();
//        System.out.println("Batch: " + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");


    }

    private void batchInsertFoo(SqlSession session, long count) {
        FooMapper mapper = session.getMapper(FooMapper.class);
        for (long i = 0; i < count; i++) {
            FooBean fooBean = new FooBean();
            fooBean.setFoo("foo_" + System.currentTimeMillis());
            mapper.save(fooBean);
            session.commit();
        }
    }
}
