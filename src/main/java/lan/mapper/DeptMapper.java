package lan.mapper;

import java.util.List;
import lan.pojo.Dept;
import lan.pojo.DeptExample;
import org.apache.ibatis.annotations.Param;

public interface DeptMapper {
    long countByExample(DeptExample example);

    int deleteByExample(DeptExample example);

    int deleteByPrimaryKey(String deptId);

    int insert(Dept row);

    int insertSelective(Dept row);

    List<Dept> selectByExample(DeptExample example);

    Dept selectByPrimaryKey(String deptId);

    int updateByExampleSelective(@Param("row") Dept row, @Param("example") DeptExample example);

    int updateByExample(@Param("row") Dept row, @Param("example") DeptExample example);

    int updateByPrimaryKeySelective(Dept row);

    int updateByPrimaryKey(Dept row);

    List<Dept> selectByExampleWithSupermarket(DeptExample example);

    Dept selectByPrimaryKeyWithSupermarket(String deptId);
}