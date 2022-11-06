package lan.service;

import lan.mapper.SupermarketMapper;
import lan.pojo.Supermarket;
import lan.pojo.SupermarketExample;
import lan.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class SupermarketService {
    private static SqlSession sqlSession = null;
    private static SupermarketMapper supermarketMapper = null;

    private static void start(){
        sqlSession = SqlSessionUtil.openSession();
        supermarketMapper = sqlSession.getMapper(SupermarketMapper.class);
    }

    private static void end(){
        SqlSessionUtil.close(sqlSession);
        sqlSession = null;
        supermarketMapper = null;
    }

    public static Supermarket selectById(String Id) {
        start();
        Supermarket supermarket = supermarketMapper.selectByPrimaryKey(Id);
        end();
        return supermarket;
    }

    public static Supermarket selectByName(String name) {
        start();
        SupermarketExample supermarketExample = new SupermarketExample();
        SupermarketExample.Criteria criteria = supermarketExample.createCriteria();
        criteria.andSupermarketNameEqualTo(name);
        List<Supermarket> supermarkets = supermarketMapper.selectByExample(supermarketExample);
        end();
        return supermarkets.get(0);
    }

    public static List<Supermarket> selectAll(){
        start();
        List<Supermarket> supermarkets = supermarketMapper.selectByExample(null);
        end();
        return supermarkets;
    }

    public static void insert(Supermarket supermarket) throws Exception {
        start();
        supermarketMapper.insert(supermarket);
        sqlSession.commit();
        end();
    }

    public static void insertList(@NotNull List<Supermarket> sups) throws Exception {
        start();
        sups.forEach(supermarket -> supermarketMapper.insert(supermarket));
        sqlSession.commit();
        end();
    }

    public static void updateById(Supermarket supermarket) throws Exception {
        start();
        supermarketMapper.updateByPrimaryKey(supermarket);
        sqlSession.commit();
        end();
    }

    public static void deleteById(String Id) throws Exception {
        start();
        supermarketMapper.deleteByPrimaryKey(Id);
        sqlSession.commit();
        end();
    }
}
