package com.xzm.tyb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xzm.tyb.pojo.TybHanDanPaiHang;
import com.xzm.tyb.pojo.TybImportantMessage;
import com.xzm.tyb.pojo.TybTeacher;
import com.xzm.tyb.pojo.liveTop;

import java.util.List;


/**
 * 直播 extends IService<TybTeacher>
 */
public interface TybLiveService extends IService<TybTeacher> {
    TybHanDanPaiHang selectHanDanByPrimaryKey(Integer id);

    List<TybHanDanPaiHang> selectHanDanList();

    List<liveTop> selectLiveTopList();

    TybImportantMessage selectImportantMessageById(Integer id);

    List<TybTeacher> selectTeacherList(String access_token, String phone);

    TybTeacher selectTeacherByTeacherId(String access_token,
                                                                String phone,
                                                                Integer teacherId);
}
