package com.xzm.tyb.service;
import com.xzm.tyb.pojo.TybHanDanPaiHang;
import com.xzm.tyb.vo.*;
/**
 * 直播 extends IService<TybTeacher>
 */
public interface TybLiveService  {
    TybHanDanPaiHang selectHanDanByPrimaryKey(Integer id);

    HandanPaiHangListVo selectHanDanList();

    LiveTopVo selectLiveTopList();

    TybImportantMessageVo selectImportantMessageById(Integer id);

    TybTeacherVo selectTeacherList(String access_token, String phone);

    TybTeacherDetailVo selectTeacherByTeacherId(String access_token,
                                                                String phone,
                                                                Integer teacherId);
}
