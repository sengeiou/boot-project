package com.xzm.modules.tyb.dao;

import com.xzm.modules.tyb.pojo.TybUserKaiHu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper

//@Mapper
public interface TybUserKaiHuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TybUserKaiHu record);

    int insertSelective(TybUserKaiHu record);

    TybUserKaiHu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TybUserKaiHu record);

    int updateByPrimaryKey(TybUserKaiHu record);

    List<TybUserKaiHu>  selectUserKaiHuInfoByPhone(String phone);

    TybUserKaiHu selectUserKaiHuInfoByPhoneAndIdCardAndPlatformCode(
                                    @Param("phone") String phone,
                                    @Param("idCard") String idCard,
                                    @Param("platformCode") String platformCode);
}