package lan.service;

import lan.mapper.DeptMapper;
import lan.pojo.Dept;
import lan.pojo.DeptExample;
import lan.pojo.Supermarket;
import lan.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class DeptService {
    private static SqlSession sqlSession = null;
    private static DeptMapper deptMapper = null;

    private static void start(){
        sqlSession = SqlSessionUtil.openSession();
        deptMapper = sqlSession.getMapper(DeptMapper.class);
    }

    private static void end(){
        SqlSessionUtil.close(sqlSession);
        sqlSession = null;
        deptMapper = null;
    }

    public static Dept selectById(String Id){
        start();
        Dept dept = deptMapper.selectByPrimaryKey(Id);
        end();
        return dept;
    }

    public static Dept selectByName(String supermarketName, String deptName) {
        Supermarket supermarket = SupermarketService.selectByName(supermarketName);
        start();
        DeptExample deptExample = new DeptExample();
        DeptExample.Criteria criteria = deptExample.createCriteria();
        criteria.andSupermarketIdEqualTo(supermarket.getSupermarketId());
        criteria.andDeptNameEqualTo(deptName);
        List<Dept> depts = deptMapper.selectByExample(deptExample);
        end();
        return depts.get(0);
    }

    public static List<Dept> selectAll(){
        start();
        List<Dept> depts = deptMapper.selectByExample(null);
        end();
        return depts;
    }

    public static List<Dept> selectBySupermarketId(String supId) {
        start();
        DeptExample deptExample = new DeptExample();
        DeptExample.Criteria criteria = deptExample.createCriteria();
        criteria.andSupermarketIdEqualTo(supId);
        List<Dept> depts = deptMapper.selectByExample(deptExample);
        end();
        return depts;
    }

    public static void insert(Dept dept) throws Exception {
        start();
        deptMapper.insert(dept);
        sqlSession.commit();
        end();
    }

    public static void insertList(@NotNull List<Dept> depts) throws Exception {
        start();
        depts.forEach(dept -> deptMapper.insert(dept));
        sqlSession.commit();
        end();
    }

    public static void update(Dept dept) throws Exception {
        start();
        deptMapper.updateByPrimaryKey(dept);
        sqlSession.commit();
        end();
    }

    public static void deleteById(String Id) throws Exception {
        start();
        deptMapper.deleteByPrimaryKey(Id);
        sqlSession.commit();
        end();
    }
}
