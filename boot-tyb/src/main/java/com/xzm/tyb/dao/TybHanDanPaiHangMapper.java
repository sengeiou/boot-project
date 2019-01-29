package com.xzm.tyb.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xzm.tyb.pojo.entity.TybHanDanPaiHang;

import java.util.List;

//@Mapper
//@Mapper
public interface TybHanDanPaiHangMapper extends BaseMapper<TybHanDanPaiHang> {
    TybHanDanPaiHang selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TybHanDanPaiHang record);

    int updateByPrimaryKey(TybHanDanPaiHang record);

    List<TybHanDanPaiHang> selectHanDanList();
}