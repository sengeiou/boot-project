package com.xzm.modules.tyb.dao;

import com.xzm.modules.tyb.pojo.TybHanDanPaiHang;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface TybHanDanPaiHangMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TybHanDanPaiHang record);

    int insertSelective(TybHanDanPaiHang record);

    TybHanDanPaiHang selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TybHanDanPaiHang record);

    int updateByPrimaryKey(TybHanDanPaiHang record);

    List<TybHanDanPaiHang> selectHanDanList();
}