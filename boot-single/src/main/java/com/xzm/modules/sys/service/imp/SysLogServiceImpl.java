//package com.xzm.modules.sys.service.imp;
//
////import net.chenlin.dp.common.entity.Page;
////import net.chenlin.dp.common.entity.Query;
////import net.chenlin.dp.common.entity.R;
////import net.chenlin.dp.common.utils.CommonUtils;
////import net.chenlin.dp.modules.sys.entity.SysLogEntity;
////import net.chenlin.dp.modules.sys.manager.SysLogManager;
////import net.chenlin.dp.modules.sys.service.SysLogService;
//
//import com.xzm.common.entity.R;
//import com.xzm.common.utils.CommonUtils;
//import com.xzm.modules.sys.dao.SysLogMapper;
//import com.xzm.modules.sys.entity.SysLogEntity;
//import com.xzm.modules.sys.service.SysLogService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Map;
//
///**
// * 系统日志
// *
// * @author ZhouChenglin
// * @email yczclcn@163.com
// * @url www.chenlintech.com
// * @date 2017年8月14日 下午8:41:29
// */
//@Service
//public class SysLogServiceImpl implements SysLogService {
//
//    @Autowired
//    private SysLogMapper sysLogMapper;
//
//    @Override
//    public R listLog(Map<String, Object> params) {
////		Query query = new Query(params);
////		Page<SysLogEntity> page = new Page<>(query);
////		sysLogManager.list(page, query);
//        List<SysLogEntity> list = sysLogMapper.list();
//        return R.ok().put("page", list);
//    }
//
////	@Override
////	public List<SysLogEntity> listLog(Page<SysLogEntity> page, Query query) {
////		Query query = new Query(params);
////		Page<SysLogEntity> page = new Page<>(query);
////		sysLogManager.listLog(page, query);
////		return page;
////	}
//
//    @Override
//    public R batchRemove(Long[] id) {
//        int count = sysLogMapper.batchRemove(id);
//        return CommonUtils.msg(id, count);
//    }
//
//    @Override
//    public R batchRemoveAll() {
//        int count = sysLogMapper.batchRemoveAll();
//        return CommonUtils.msg(count);
//    }
//
//    @Override
//    public R saveLog(SysLogEntity log) {
//        int save = sysLogMapper.save(log);
//        if (save > 0) {
//            return R.ok();
//        }
//        return R.error();
//    }
//
//}
