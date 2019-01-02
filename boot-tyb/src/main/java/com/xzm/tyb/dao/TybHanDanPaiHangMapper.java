package com.xzm.tyb.dao;

import com.xzm.tyb.pojo.TybHanDanPaiHang;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
//@Mapper
//@Mapper

public interface TybHanDanPaiHangMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TybHanDanPaiHang record);

    int insertSelective(TybHanDanPaiHang record);

    TybHanDanPaiHang selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TybHanDanPaiHang record);

    int updateByPrimaryKey(TybHanDanPaiHang record);

    List<TybHanDanPaiHang> selectHanDanList();
}