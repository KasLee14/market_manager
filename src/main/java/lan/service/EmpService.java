package lan.service;

import lan.mapper.EmpMapper;
import lan.pojo.Emp;
import lan.pojo.EmpExample;
import lan.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class EmpService {
    private static SqlSession sqlSession = null;
    private static EmpMapper empMapper = null;

    private static void start(){
        sqlSession = SqlSessionUtil.openSession();
        empMapper = sqlSession.getMapper(EmpMapper.class);
    }

    private static void end(){
        SqlSessionUtil.close(sqlSession);
        sqlSession = null;
        empMapper = null;
    }

    public static Emp selectName(String name){
        start();
        EmpExample empExample = new EmpExample();
        EmpExample.Criteria criteria = empExample.createCriteria();
        criteria.andEmpNameEqualTo(name);
        List<Emp> emps = empMapper.selectByExample(empExample);
        end();
        return emps.get(0);
    }

    public static Emp selectById(String Id) {
        start();
        Emp emp = empMapper.selectByPrimaryKey(Id);
        end();
        return emp;
    }

    public static List<Emp> selectAll(){
        start();
        List<Emp> emps = empMapper.selectByExample(null);
        end();
        return emps;
    }

    public static List<Emp> selectByDeptId(String Id){
        start();
        EmpExample empExample = new EmpExample();
        EmpExample.Criteria criteria = empExample.createCriteria();
        criteria.andDeptIdEqualTo(Id);
        List<Emp> emps = empMapper.selectByExample(empExample);
        end();
        return emps;
    }

    public static void insert(Emp emp) throws Exception {
        start();
        empMapper.insert(emp);
        sqlSession.commit();
        end();
    }

    public static void update(Emp emp) throws Exception {
        start();
        empMapper.updateByPrimaryKey(emp);
        sqlSession.commit();
        end();
    }

    public static void deleteById(String Id) throws Exception {
        start();
        empMapper.deleteByPrimaryKey(Id);
        sqlSession.commit();
        end();
    }
}
