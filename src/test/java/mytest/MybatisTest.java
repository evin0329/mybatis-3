package mytest;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.sql.Statement;

public class MybatisTest {


    public static void main(String[] args) throws Exception {

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mytest/mybatis-config.xml"));


        SqlSession sqlSession = sqlSessionFactory.openSession();

        Mapper mapper = sqlSession.getMapper(Mapper.class);
        User user = mapper.getUser(1);
        System.out.println(user);
    }

}
