package com.xzm.tyb.service;
import com.xzm.tyb.common.entity.ServerResponse;
import com.xzm.tyb.pojo.TybHanDanPaiHang;
import com.xzm.tyb.vo.*;
/**
 * 直播 extends IService<TybTeacher>
 */
public interface TybLiveService  {
    ServerResponse<TybHanDanPaiHang> selectHanDanByPrimaryKey(Integer id);

    ServerResponse<HandanPaiHangListVo> selectHanDanList();

    ServerResponse<LiveTopVo> selectLiveTopList();

    ServerResponse<TybImportantMessageVo> selectImportantMessageById(Integer id);

    ServerResponse<TybTeacherVo> selectTeacherList(String access_token, String phone);

    ServerResponse<TybTeacherDetailVo> selectTeacherByTeacherId(String access_token,
                                                                String phone,
                                                                Integer teacherId);
}
