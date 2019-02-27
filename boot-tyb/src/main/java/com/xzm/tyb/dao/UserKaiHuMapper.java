package com.xzm.tyb.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xzm.tyb.pojo.entity.TybUserKaiHu;
import org.apache.ibatis.annotations.Param;

import java.util.List;
//@Mapper

//@Mapper
public interface UserKaiHuMapper extends BaseMapper<TybUserKaiHu> {
    int deleteByPrimaryKey(Integer id);

//    int insert(TybUserKaiHu record);

    int insertSelective(TybUserKaiHu record);

    TybUserKaiHu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TybUserKaiHu record);

    int updateByPrimaryKey(TybUserKaiHu record);

    List<TybUserKaiHu> selectUserKaiHuInfoByPhone(String phone);

    TybUserKaiHu selectUserKaiHuInfoByPhoneAndIdCardAndPlatformCode(@Param("phone") String phone,
                                                                    @Param("idCard") String idCard,
                                                                    @Param("platformCode") String platformCode);
}