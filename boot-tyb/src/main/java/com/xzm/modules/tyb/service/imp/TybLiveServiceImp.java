package com.xzm.modules.tyb.service.imp;
import com.xzm.common.entity.ServerResponse;
import com.xzm.common.exception.RRException;
import com.xzm.modules.tyb.dao.*;
import com.xzm.modules.tyb.pojo.*;
import com.xzm.modules.tyb.service.TybLiveService;
import com.xzm.modules.tyb.vo.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.List;

@Service
public class TybLiveServiceImp implements TybLiveService {
    private  Log logger = LogFactory.getLog(getClass());
    @Autowired
    private TybHanDanPaiHangMapper handanPaiHangMapper;
    @Autowired
    private  TybLiveTopMapper LiveTopMapper;
    @Autowired
    private TybImportantMessageMapper importantMessageMapper;
    @Autowired
    private TybTeacherMapper tybTeacherMapper;
    @Autowired
    private TybUserGenDanMapper tybUserGenDanMapper;
    @Override
    public ServerResponse<TybHanDanPaiHang> selectHanDanByPrimaryKey(Integer id) {
        TybHanDanPaiHang handanPaiHang = handanPaiHangMapper.selectByPrimaryKey(id);
        return ServerResponse.createBySuccess(handanPaiHang);
    }

    /**
     *获取老师历史喊单
     */
    @Override
    public ServerResponse<HandanPaiHangListVo> selectHanDanList() {
        List<TybHanDanPaiHang> paiHangList = handanPaiHangMapper.selectHanDanList();
        HandanPaiHangListVo handanPaiHangListVo = new HandanPaiHangListVo();
        handanPaiHangListVo.setHandan(paiHangList);
        return ServerResponse.createBySuccess("老师喊单数据获取成功",handanPaiHangListVo);
    }


    /**
     * 直播首页三个直播室 List数据
     */
    @Override
    public ServerResponse<LiveTopVo> selectLiveTopList() {
        List<liveTop> liveTopList = LiveTopMapper.selectLiveTopList();
        LiveTopVo liveTopVo = new LiveTopVo();
        liveTopVo.setLive(liveTopList);
        return ServerResponse.createBySuccess(liveTopVo);
    }

    /**
     * 获取直播页重要消息数据
     */
    @Override
    public ServerResponse<TybImportantMessageVo> selectImportantMessageById(Integer id) {
        TybImportantMessage message = importantMessageMapper.selectByPrimaryKey(id);
        TybImportantMessageVo importantMessageVo = new TybImportantMessageVo();
        importantMessageVo.setObject(message);
        return ServerResponse.createBySuccess(importantMessageVo);
    }

    /**
     * 查询人气讲师列表
     */
    @Override
    public ServerResponse<TybTeacherVo> selectTeacherList(String access_token, String phone) {
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
        return ServerResponse.createBySuccess(tybTeacherVo);
    }


    /**
     * 根据老师ID查询讲师信息
     */
    @Override
    public ServerResponse<TybTeacherDetailVo> selectTeacherByTeacherId(String access_token, String phone, Integer teacherId) {
//        List<TybUserGenDan> userGenDansList = tybUserGenDanMapper.selectUserGenDanByUserPhone(phone);
//        userGenDansList.forEach(item -> {
//            Integer teacherId = item.getTeacherId();
//            logger.debug("====查询用户老师ID==" + teacherId);
//        });
        int count = tybTeacherMapper.selectTeacherByPrimaryKey(teacherId);
        logger.debug("===查询老师数量===" + count);
        if(count<0){
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
        return ServerResponse.createBySuccess(teacherDetailVo);
    }
}
