package io.github.xudaojie.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import io.github.xudaojie.mybatis.bean.GoodsBean;
import io.github.xudaojie.mybatis.mapper.GoodsMapper;

public class AppTest {

    @Test
    public void sqlSessionTest() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);

        SqlSession session = sqlSessionFactory.openSession();
        GoodsMapper mapper = session.getMapper(GoodsMapper.class);
        GoodsBean goodsBean = mapper.findById(3181659L);
        System.out.println(goodsBean);
        session.close();
    }
}
