package com.xzm.tyb.service;

import com.xzm.tyb.common.base.IBaseService;
import com.xzm.tyb.pojo.entity.TybHanDanPaiHang;
import com.xzm.tyb.pojo.entity.TybImportantMessage;
import com.xzm.tyb.pojo.entity.TybTeacher;
import com.xzm.tyb.pojo.entity.TybLiveTop;

import java.util.List;


/**
 * 直播 extends IService<TybTeacher>
 */
public interface TybLiveService extends IBaseService<TybTeacher> {
    TybHanDanPaiHang selectHanDanByPrimaryKey(Integer id);

    List<TybHanDanPaiHang> selectHanDanList();

    List<TybLiveTop> selectLiveTopList();

    TybImportantMessage selectImportantMessageById(Integer id);

    List<TybTeacher> selectTeacherList(String phone);

    TybTeacher selectTeacherByTeacherId(Integer teacherId);
}
