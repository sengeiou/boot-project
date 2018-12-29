package net.chenlin.dp.modules.tyb.service.imp;

import java.util.Map;

import net.chenlin.dp.modules.tyb.dao.HandanPaiHangMapper;
import net.chenlin.dp.modules.tyb.entity.HandanPaiHangEntity;
import net.chenlin.dp.modules.tyb.service.HandanPaiHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.common.utils.CommonUtils;
//import net.chenlin.dp.jdt.entity.HandanPaiHangEntity;
//import net.chenlin.dp.jdt.manager.HandanPaiHangManager;
//import net.chenlin.dp.jdt.service.HandanPaiHangService;

/**
 * 老师喊单排行表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年4月08日 下午6:45:19
 */
@Service
public class HandanPaiHangServiceImpl implements HandanPaiHangService {

	@Autowired
	private HandanPaiHangMapper handanPaiHangManager;

	@Override
	public Page<HandanPaiHangEntity> listHandanPaiHang(Map<String, Object> params) {
		Query query = new Query(params);
		Page<HandanPaiHangEntity> page = new Page<>(query);
		handanPaiHangManager.listHandanPaiHang(page, query);
		return page;
	}

	@Override
	public R saveHandanPaiHang(HandanPaiHangEntity role) {
		int count = handanPaiHangManager.saveHandanPaiHang(role);
		return CommonUtils.msg(count);
	}

	@Override
	public R getHandanPaiHangById(Long id) {
		HandanPaiHangEntity handanPaiHang = handanPaiHangManager.getHandanPaiHangById(id);
		return CommonUtils.msg(handanPaiHang);
	}

	@Override
	public R updateHandanPaiHang(HandanPaiHangEntity handanPaiHang) {
		int count = handanPaiHangManager.updateHandanPaiHang(handanPaiHang);
		return CommonUtils.msg(count);
	}

	@Override
	public R batchRemove(Long[] id) {
		int count = handanPaiHangManager.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

}
