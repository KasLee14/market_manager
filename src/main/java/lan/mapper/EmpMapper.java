package lan.mapper;

import java.util.List;
import lan.pojo.Emp;
import lan.pojo.EmpExample;
import org.apache.ibatis.annotations.Param;

public interface EmpMapper {
    long countByExample(EmpExample example);

    int deleteByExample(EmpExample example);

    int deleteByPrimaryKey(String empId);

    int insert(Emp row);

    int insertSelective(Emp row);

    List<Emp> selectByExample(EmpExample example);

    Emp selectByPrimaryKey(String empId);

    int updateByExampleSelective(@Param("row") Emp row, @Param("example") EmpExample example);

    int updateByExample(@Param("row") Emp row, @Param("example") EmpExample example);

    int updateByPrimaryKeySelective(Emp row);

    int updateByPrimaryKey(Emp row);

    List<Emp> selectByExampleWithDept(EmpExample example);

    Emp selectByPrimaryKeyWithDept(String empId);
}