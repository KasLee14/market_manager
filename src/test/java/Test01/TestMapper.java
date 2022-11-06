package Test01;

import lan.mapper.*;
import lan.pojo.*;
import lan.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestMapper {
    @Test
    public void Test01(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        SupermarketMapper supermarketsMapper = sqlSession.getMapper(SupermarketMapper.class);
        Supermarket supermarket = supermarketsMapper.selectByPrimaryKey("PS2101");
        System.out.println(supermarket);
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void Test02(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
        DeptExample deptExample = new DeptExample();
        //SystemUserExample.Criteria criteria = systemUserExample.createCriteria();
        DeptExample.Criteria criteria = deptExample.createCriteria();
        criteria.andDeptIdEqualTo("DT007");
        List<Dept> depts = deptMapper.selectByExample(deptExample);
        System.out.println(depts);
        SqlSessionUtil.close(sqlSession);
    }
}
