package lan.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionUtil {
    static SqlSessionFactory sqlSessionFactory = null;

    static {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<>();

    public static SqlSession openSession(){
        SqlSession sqlSession = threadLocal.get();
        if(sqlSession == null){
            sqlSession = sqlSessionFactory.openSession();
            threadLocal.set(sqlSession);
        }
        return sqlSession;
    }

    public static void close(SqlSession sqlSession){
        if (sqlSession != null) {
            sqlSession.close();
            threadLocal.remove();
        }

    }

}
