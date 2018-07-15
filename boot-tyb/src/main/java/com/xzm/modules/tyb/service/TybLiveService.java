package com.xzm.modules.tyb.service;

import com.xzm.common.entity.ServerResponse;
import com.xzm.modules.common.service.Service;
import com.xzm.modules.tyb.pojo.TybHanDanPaiHang;
import com.xzm.modules.tyb.pojo.TybTeacher;
import com.xzm.modules.tyb.vo.*;

/**
 * 直播
 */
public interface TybLiveService extends Service<TybTeacher> {
    ServerResponse<TybHanDanPaiHang> selectHanDanByPrimaryKey(Integer id);

    ServerResponse<HandanPaiHangListVo> selectHanDanList();

    ServerResponse<LiveTopVo> selectLiveTopList();

    ServerResponse<TybImportantMessageVo> selectImportantMessageById(Integer id);

    ServerResponse<TybTeacherVo> selectTeacherList(String access_token, String phone);

    ServerResponse<TybTeacherDetailVo> selectTeacherByTeacherId(String access_token,
                                                                String phone,
                                                                Integer teacherId);
}
