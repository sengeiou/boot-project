package net.chenlin.dp.modules.tyb.service;

import java.util.Map;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.modules.tyb.entity.HandanPaiHangEntity;


/**
 * 老师喊单排行表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年4月08日 下午6:45:19
 */
public interface HandanPaiHangService {

	Page<HandanPaiHangEntity> listHandanPaiHang(Map<String, Object> params);
	
	R saveHandanPaiHang(HandanPaiHangEntity handanPaiHang);
	
	R getHandanPaiHangById(Long id);
	
	R updateHandanPaiHang(HandanPaiHangEntity handanPaiHang);
	
	R batchRemove(Long[] id);
	
}
