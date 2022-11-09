package lan.service;

import lan.mapper.SupermarketMapper;
import lan.pojo.Supermarket;
import lan.pojo.SupermarketExample;
import lan.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class SupermarketService {

    private SqlSession sqlSession = null;
    private SupermarketMapper supermarketMapper = null;

    private void start(){
        sqlSession = SqlSessionUtil.openSession();
        supermarketMapper = sqlSession.getMapper(SupermarketMapper.class);
    }

    private void end(){
        SqlSessionUtil.close(sqlSession);
        sqlSession = null;
        supermarketMapper = null;
    }

    public Supermarket selectById(String Id) {
        start();
        Supermarket supermarket = supermarketMapper.selectByPrimaryKey(Id);
        end();
        return supermarket;
    }

    public Supermarket selectByName(String name) {
        start();
        SupermarketExample supermarketExample = new SupermarketExample();
        SupermarketExample.Criteria criteria = supermarketExample.createCriteria();
        criteria.andSupermarketNameEqualTo(name);
        List<Supermarket> supermarkets = supermarketMapper.selectByExample(supermarketExample);
        end();
        return supermarkets.get(0);
    }

    public List<Supermarket> selectAll(){
        start();
        List<Supermarket> supermarkets = supermarketMapper.selectByExample(null);
        end();
        return supermarkets;
    }

    public void insert(Supermarket supermarket) throws Exception {
        start();
        supermarketMapper.insert(supermarket);
        sqlSession.commit();
        end();
    }

    public void insertList(@NotNull List<Supermarket> sups) throws Exception {
        start();
        sups.forEach(supermarket -> supermarketMapper.insert(supermarket));
        sqlSession.commit();
        end();
    }

    public void updateById(Supermarket supermarket) throws Exception {
        start();
        supermarketMapper.updateByPrimaryKey(supermarket);
        sqlSession.commit();
        end();

    }

    public void deleteById(String Id) throws Exception {
        start();
        supermarketMapper.deleteByPrimaryKey(Id);
        sqlSession.commit();
        end();
    }
}
