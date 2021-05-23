package mytest;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.util.concurrent.TimeUnit;

public class MybatisTest {


    public static void main(String[] args) throws Exception {

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mytest/mybatis-config.xml"));


//        mapper.equals("");
//        User user = mapper.getUser(1);

        new Thread(() -> {
            SqlSession sqlSession = sqlSessionFactory.openSession();
            Mapper mapper = sqlSession.getMapper(Mapper.class);
            while (true) {
                User mapperUserById = mapper.getUser(1);
                System.out.println(Thread.currentThread().getName() + " -> " + mapperUserById.getName());
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                SqlSession sqlSession = sqlSessionFactory.openSession();
                Mapper mapper = sqlSession.getMapper(Mapper.class);
                User mapperUserById = mapper.getUser(1);
                System.out.println(Thread.currentThread().getName() + " -> " + mapperUserById.getName());
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

}
