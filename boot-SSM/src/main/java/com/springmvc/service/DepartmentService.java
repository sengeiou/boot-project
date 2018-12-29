package com.springmvc.service;


import com.springmvc.dao.DepartmentMapper;
import com.springmvc.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public interface DepartmentService {

//	@Autowired
//	public DepartmentMapper departmentMapper;

//	public List<Department> getDepts() {
//		// TODO Auto-generated method stub
//		List<Department> list = departmentMapper.selectByExample(null);
//		return list;
//	}
	public List<Department> getDepts();
}
