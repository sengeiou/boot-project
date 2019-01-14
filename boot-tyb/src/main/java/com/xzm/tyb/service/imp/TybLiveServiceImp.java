package com.xzm.tyb.service.imp;
//import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzm.tyb.common.exception.RRException;
import com.xzm.tyb.dao.*;
import com.xzm.tyb.pojo.*;
import com.xzm.tyb.service.TybLiveService;
import com.xzm.tyb.vo.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TybLiveServiceImp extends ServiceImpl<TybTeacherMapper,TybTeacher> implements TybLiveService {
    private  Log logger = LogFactory.getLog(getClass());
    @Resource
    private TybHanDanPaiHangMapper handanPaiHangMapper;
    @Resource
    private TybLiveTopMapper LiveTopMapper;
    @Resource
    private TybImportantMessageMapper importantMessageMapper;
    @Resource
    private TybTeacherMapper tybTeacherMapper;
    @Resource
    private TybUserGenDanMapper tybUserGenDanMapper;
    @Override
    public TybHanDanPaiHang selectHanDanByPrimaryKey(Integer id) {
        TybHanDanPaiHang handanPaiHang = handanPaiHangMapper.selectByPrimaryKey(id);
        return handanPaiHang;
    }

    /**
     *获取老师历史喊单
     */
    @Override
    public HandanPaiHangListVo selectHanDanList() {
        List<TybHanDanPaiHang> paiHangList = handanPaiHangMapper.selectHanDanList();
        HandanPaiHangListVo handanPaiHangListVo = new HandanPaiHangListVo();
        handanPaiHangListVo.setHandan(paiHangList);
        return handanPaiHangListVo;
    }


    /**
     * 直播首页三个直播室 List数据
     */
    @Override
    public LiveTopVo selectLiveTopList() {
        List<liveTop> liveTopList = LiveTopMapper.selectLiveTopList();
        LiveTopVo liveTopVo = new LiveTopVo();
        liveTopVo.setLive(liveTopList);
        return liveTopVo;
    }

    /**
     * 获取直播页重要消息数据
     */
    @Override
    public TybImportantMessageVo selectImportantMessageById(Integer id) {
        TybImportantMessage message = importantMessageMapper.selectById(new TybImportantMessage(1));
        TybImportantMessageVo importantMessageVo = new TybImportantMessageVo();
        importantMessageVo.setObject(message);
        return importantMessageVo;
    }

    /**
     * 查询人气讲师列表
     */
    @Override
    public TybTeacherVo selectTeacherList(String access_token, String phone) {
        List<TybUserGenDan> userGenDansList = tybUserGenDanMapper.selectUserGenDanByUserPhone(phone);
        userGenDansList.forEach(item -> {
            Integer teacherId = item.getTeacherId();
            logger.debug("====查询用户老师ID==" + teacherId);
        });
        List<TybTeacher> tybTeachers = tybTeacherMapper.selectTeacherList();
        tybTeachers.forEach(teacherItem -> {

        });
        TybTeacherVo tybTeacherVo = new TybTeacherVo();
        tybTeacherVo.setObject(tybTeachers);
        return tybTeacherVo;
    }


    /**
     * 根据老师ID查询讲师信息
     */
    @Override
    public TybTeacherDetailVo selectTeacherByTeacherId(String access_token, String phone, Integer teacherId) {
//        List<TybUserGenDan> userGenDansList = tybUserGenDanMapper.selectUserGenDanByUserPhone(phone);
//        userGenDansList.forEach(item -> {
//            Integer teacherId = item.getTeacherId();
//            logger.debug("====查询用户老师ID==" + teacherId);
//        });
        int count = tybTeacherMapper.selectTeacherByPrimaryKey(teacherId);
        logger.debug("===查询老师数量===" + count);
        if(count<1){
            logger.debug("===查询老师数量xxxx===" + count);
            throw new RRException("老师不存在", 600001);
        }
        TybTeacher tybTeacher = tybTeacherMapper.selectByPrimaryKey(teacherId);
        TybTeacherDetailVo teacherDetailVo = new TybTeacherDetailVo();
        TybTeacherDetailVo.TeacherDetail teacherDetail = new TybTeacherDetailVo.TeacherDetail();
        teacherDetail.setStatus(0);
        teacherDetail.setId(teacherId);
        teacherDetail.setThumb(tybTeacher.getThumb());
        teacherDetail.setTeacherName(tybTeacher.getTeacherName());
        teacherDetail.setDianZanCount(tybTeacher.getDianZanCount());
        teacherDetail.setHdcgl(tybTeacher.getHdcgl());
        teacherDetail.setProfit(tybTeacher.getProfit());
        teacherDetail.setGenDanCount(tybTeacher.getGenDanCount());
        teacherDetail.setPinZhong(tybTeacher.getPinZhong());
        teacherDetail.setCangWei(tybTeacher.getCangWei());
        teacherDetail.setDianWei(tybTeacher.getDianWei());
        teacherDetail.setShouYi(tybTeacher.getShouYi());
        teacherDetail.setContent(tybTeacher.getContent());
        teacherDetailVo.setObject(teacherDetail);
        return teacherDetailVo;
    }
}
