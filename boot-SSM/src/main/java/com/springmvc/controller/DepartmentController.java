package com.springmvc.controller;
import com.springmvc.entity.Department;
import com.springmvc.entity.Msg;
import com.springmvc.service.impl.DepartmentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 处理和部门有关的请求
 * @author lfy
 *
 */
@Controller
public class DepartmentController {

	private Logger logger = Logger.getLogger(getClass());
	@Autowired
	private DepartmentService departmentService;

	/**
	 * 返回所有的部门信息
	 */
	@RequestMapping(value = "/depts",method = RequestMethod.GET)
	@ResponseBody
	public Msg getDepts(){
		//查出的所有部门信息


		logger.debug("查询部门信息==");
		List<Department> list = departmentService.getDepts();
		logger.debug("查询部门信息=="+list.get(0).getDeptName());
		return Msg.success().add("depts", list);
	}

}
