package com.xzm.tyb.service.imp;
//import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xzm.tyb.common.base.BaseServiceImpl;
import com.xzm.tyb.common.exception.RRException;
import com.xzm.tyb.dao.*;
import com.xzm.tyb.pojo.entity.*;
import com.xzm.tyb.service.TybLiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//@Service("TybLiveService")    //不要name属性也可以
@Service
public class TybLiveServiceImp extends BaseServiceImpl<TybTeacherMapper, TybTeacher> implements TybLiveService {
//    private Log logger = LogFactory.getLog(getClass());
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
        TybHanDanPaiHang hanDanPaiHang = handanPaiHangMapper.selectByPrimaryKey(id);
        return hanDanPaiHang;
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
    public List<TybLiveTop> selectLiveTopList() {
        List<TybLiveTop> liveTopList = LiveTopMapper.selectList(new QueryWrapper<>());
        return liveTopList;
    }

    /**
     * 获取直播页重要消息数据
     */
    @Override
    public TybImportantMessage selectImportantMessageById(Integer id) {
//        TybImportantMessage message = new TybImportantMessage();
        TybImportantMessage message = importantMessageMapper.selectById(id);
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
