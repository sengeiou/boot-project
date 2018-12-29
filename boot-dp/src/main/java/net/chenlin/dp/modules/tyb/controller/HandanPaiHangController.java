package net.chenlin.dp.modules.tyb.controller;

import java.util.Map;

import net.chenlin.dp.modules.sys.controller.AbstractController;
import net.chenlin.dp.modules.tyb.entity.HandanPaiHangEntity;
import net.chenlin.dp.modules.tyb.service.HandanPaiHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.chenlin.dp.common.annotation.SysLog;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.R;


/**
 * 老师喊单排行表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年4月08日 下午6:45:19
 */
@RestController
@RequestMapping("tyb/live")
public class HandanPaiHangController extends AbstractController {
	
	@Autowired
	private HandanPaiHangService handanPaiHangService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@GetMapping("/list")
	public Page<HandanPaiHangEntity> list(@RequestBody Map<String, Object> params) {
		return handanPaiHangService.listHandanPaiHang(params);
	}
		
	/**
	 * 新增
	 * @param handanPaiHang
	 * @return
	 */
	@SysLog("新增老师喊单排行表")
	@RequestMapping("/save")
	public R save(@RequestBody HandanPaiHangEntity handanPaiHang) {
		return handanPaiHangService.saveHandanPaiHang(handanPaiHang);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public R getById(@RequestBody Long id) {
		return handanPaiHangService.getHandanPaiHangById(id);
	}
	
	/**
	 * 修改
	 * @param handanPaiHang
	 * @return
	 */
	@SysLog("修改老师喊单排行表")
	@RequestMapping("/update")
	public R update(@RequestBody HandanPaiHangEntity handanPaiHang) {
		return handanPaiHangService.updateHandanPaiHang(handanPaiHang);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除老师喊单排行表")
	@RequestMapping("/remove")
	public R batchRemove(@RequestBody Long[] id) {
		return handanPaiHangService.batchRemove(id);
	}
	
}
