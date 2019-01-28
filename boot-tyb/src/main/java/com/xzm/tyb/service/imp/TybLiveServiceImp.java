package com.xzm.tyb.service.imp;
//import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzm.tyb.common.exception.RRException;
import com.xzm.tyb.dao.*;
import com.xzm.tyb.pojo.*;
import com.xzm.tyb.service.TybLiveService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TybLiveServiceImp extends ServiceImpl<TybTeacherMapper, TybTeacher> implements TybLiveService {
    private Log logger = LogFactory.getLog(getClass());
    @Autowired
    private TybHanDanPaiHangMapper handanPaiHangMapper;
    @Autowired
    private TybLiveTopMapper LiveTopMapper;
    @Autowired
    private TybImportantMessageMapper importantMessageMapper;
    @Autowired
    private TybTeacherMapper tybTeacherMapper;
    @Autowired
    private TybUserGenDanMapper tybUserGenDanMapper;

    @Override
    public TybHanDanPaiHang selectHanDanByPrimaryKey(Integer id) {
        TybHanDanPaiHang handanPaiHang = handanPaiHangMapper.selectByPrimaryKey(id);
        return handanPaiHang;
    }

    /**
     * 获取老师历史喊单
     */
    @Override
    public List<TybHanDanPaiHang> selectHanDanList() {
        List<TybHanDanPaiHang> paiHangList = handanPaiHangMapper.selectHanDanList();
        return paiHangList;
    }


    /**
     * 直播首页三个直播室 List数据
     */
    @Override
    public List<liveTop> selectLiveTopList() {
        List<liveTop> liveTopList = LiveTopMapper.selectLiveTopList();
        return liveTopList;
    }

    /**
     * 获取直播页重要消息数据
     */
    @Override
    public TybImportantMessage selectImportantMessageById(Integer id) {
        TybImportantMessage message = importantMessageMapper.selectById(new TybImportantMessage(1));
        return message;
    }

    /**
     * 查询人气讲师列表
     */
    @Override
    public List<TybTeacher> selectTeacherList(String phone) {
        List<TybUserGenDan> userGenDansList = tybUserGenDanMapper.selectUserGenDanByUserPhone(phone);
        userGenDansList.forEach(item -> {
            Integer teacherId = item.getTeacherId();
            logger.debug("====查询用户老师ID==" + teacherId);
        });
        List<TybTeacher> tybTeachers = tybTeacherMapper.selectTeacherList();
        tybTeachers.forEach(teacherItem -> {

        });
        return tybTeachers;
    }


    /**
     * 根据老师ID查询讲师信息
     */
    @Override
    public TybTeacher selectTeacherByTeacherId(Integer teacherId) {
        int count = tybTeacherMapper.selectTeacherByPrimaryKey(teacherId);
        logger.debug("===查询老师数量===" + count);
        if (count < 1) {
            throw new RRException("老师不存在", 600001);
        }
        TybTeacher tybTeacher = tybTeacherMapper.selectByPrimaryKey(teacherId);
        return tybTeacher;
    }
}
