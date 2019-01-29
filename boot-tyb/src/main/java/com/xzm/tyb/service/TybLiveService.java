package com.xzm.tyb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xzm.tyb.pojo.entity.TybHanDanPaiHang;
import com.xzm.tyb.pojo.entity.TybImportantMessage;
import com.xzm.tyb.pojo.entity.TybTeacher;
import com.xzm.tyb.pojo.entity.LiveTop;

import java.util.List;


/**
 * 直播 extends IService<TybTeacher>
 */
public interface TybLiveService extends IService<TybTeacher> {
    TybHanDanPaiHang selectHanDanByPrimaryKey(Integer id);

    List<TybHanDanPaiHang> selectHanDanList();

    List<LiveTop> selectLiveTopList();

    TybImportantMessage selectImportantMessageById(Integer id);

    List<TybTeacher> selectTeacherList(String phone);

    TybTeacher selectTeacherByTeacherId(Integer teacherId);
}
