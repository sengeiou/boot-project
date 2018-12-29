package com.springmvc.service.impl;


import com.springmvc.dao.DepartmentMapper;
import com.springmvc.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentMapper departmentMapper;
//	@Autowired
//	private RedisCache cache;

	public List<Department> getDepts() {
		// TODO Auto-generated method stub
		List<Department> list = departmentMapper.selectByExample(null);


//		String cache_key = RedisCache.CAHCENAME;
//		List<Department> result_cache = cache.getListCache(cache_key, Department.class);
//
//
//		if (result_cache != null) {
//			String deptName = result_cache.get(0).getDeptName();
//			LOG.debug("缓存得到====="+deptName);
//			LOG.info("put cache with key:" + cache_key);
//		} else {
//			// 缓存中没有再去数据库取，并插入缓存（缓存时间为180秒）
//			result_cache = departmentMapper.selectByExample(null);
//			cache.putListCacheWithExpireTime(cache_key, result_cache, RedisCache.CAHCETIME);
//			LOG.debug("缓存得到====="+cache_key);
//			return result_cache;
//		}
		return list;
	}

}
