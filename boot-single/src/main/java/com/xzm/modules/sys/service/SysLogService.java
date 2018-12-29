package com.xzm.modules.sys.service;


import com.xzm.common.entity.R;
import com.xzm.modules.sys.entity.SysLogEntity;

import java.util.Map;

/**
 * 系统日志
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2017年8月14日 下午8:40:52
 */
public interface SysLogService {

//	Page<SysLogEntity> listLog(Map<String, Object> params);

//	List<SysLogEntity> listLog(Page<SysLogEntity> page, Query query);
	R listLog(Map<String, Object> params);

	R batchRemove(Long[] id);
	
	R batchRemoveAll();

	R saveLog(SysLogEntity log);


//	void saveLog(SysLogEntity log);
//
//	List<SysLogEntity> listLog(Page<SysLogEntity> page, Query query);
//
//	int batchRemove(Long[] id);
//
//	int batchRemoveAll();
}
