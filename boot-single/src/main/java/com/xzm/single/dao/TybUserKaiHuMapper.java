package com.xzm.single.dao;

import com.xzm.single.pojo.TybUserKaiHu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
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