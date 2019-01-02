package com.xzm.modules.tyb.service;

import com.xzm.common.entity.ServerResponse;
import com.xzm.modules.tyb.vo.*;
import com.xzm.tyb.pojo.TybHanDanPaiHang;


/**
 * 直播
 */
public interface TybLiveService {
    ServerResponse<TybHanDanPaiHang> selectHanDanByPrimaryKey(Integer id);
    ServerResponse<HandanPaiHangListVo> selectHanDanList();
    ServerResponse<LiveTopVo> selectLiveTopList();
    ServerResponse<TybImportantMessageVo> selectImportantMessageById(Integer id);
    ServerResponse<TybTeacherVo> selectTeacherList(String access_token, String phone);
    ServerResponse<TybTeacherDetailVo> selectTeacherByTeacherId(String access_token, String phone, Integer teacherId);
}
