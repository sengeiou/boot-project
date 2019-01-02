package com.xzm.single.dao;
//import TybHanDanPaiHang;

import com.xzm.single.pojo.TybHanDanPaiHang;
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