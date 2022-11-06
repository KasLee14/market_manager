package lan.mapper;

import java.util.List;
import lan.pojo.Supermarket;
import lan.pojo.SupermarketExample;
import org.apache.ibatis.annotations.Param;

public interface SupermarketMapper {
    long countByExample(SupermarketExample example);

    int deleteByExample(SupermarketExample example);

    int deleteByPrimaryKey(String supermarketId);

    int insert(Supermarket row);

    int insertSelective(Supermarket row);

    List<Supermarket> selectByExample(SupermarketExample example);

    Supermarket selectByPrimaryKey(String supermarketId);

    int updateByExampleSelective(@Param("row") Supermarket row, @Param("example") SupermarketExample example);

    int updateByExample(@Param("row") Supermarket row, @Param("example") SupermarketExample example);

    int updateByPrimaryKeySelective(Supermarket row);

    int updateByPrimaryKey(Supermarket row);


}