package io.github.xudaojie.javase.protobuf;

/**
 * @author XuDaojie
 * @since 2020/8/10
 */
public class ProtoBufTest {
    public void searchRequestTest() {
        SearchRequestPacket.SearchRequest requestPacket = SearchRequestPacket.SearchRequest.newBuilder()
            .setQuery("1")
            .setPageNumber(1)
            .setResultPerPage(1)
            .build();
    }
}
