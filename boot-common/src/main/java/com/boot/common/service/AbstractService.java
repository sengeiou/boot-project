//package com.xzm.common.service;
//
////import com.example.demo.core.ret.ServiceException;
//import com.xzm.common.dao.Mapper;
//import RRException;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.apache.ibatis.exceptions.TooManyResultsException;
//import tk.mybatis.mapper.entity.Condition;
//
//import javax.annotation.Resource;
//import java.lang.reflect.Field;
//import java.lang.reflect.ParameterizedType;
//import java.util.List;
//
////import tk.mybatis.mapper.common.Mapper;
////import javax.xml.rpc.ServiceException;
//
///**
// * @Description: 基于通用MyBatis Mapper插件的Service接口的实现
// * @author 张瑶
// * @date 2018/4/18 11:28
// */
//public abstract class AbstractService<T> implements Service<T> {
//	public Log logger = LogFactory.getLog(getClass());
//	@Resource
//	public Mapper<T> mapper;
//
//	/**
//	 * 	当前泛型真实类型的Class
// 	 */
//	private Class<T> modelClass;
//
//	@SuppressWarnings("unchecked")
//	public AbstractService() {
//		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
//		modelClass = (Class<T>) pt.getActualTypeArguments()[0];
//	}
//
//	@Override
//	public Integer insert(T model) {
//		return mapper.insertSelective(model);
//	}
//
//	@Override
//	public Integer deleteById(String id) {
//		return mapper.deleteByPrimaryKey(id);
//	}
//
//	@Override
//	public Integer deleteByIds(String ids) {
//		return mapper.deleteByIds(ids);
//	}
//
//	@Override
//	public Integer update(T model) {
//		return mapper.updateByPrimaryKeySelective(model);
//	}
//
//	@Override
//	public T selectById(String id) {
//		return mapper.selectByPrimaryKey(id);
//	}
//
//	@Override
//	public T selectBy(String fieldName, Object value) throws TooManyResultsException {
//		try {
//			T model = modelClass.newInstance();
//			Field field = modelClass.getDeclaredField(fieldName);
//			field.setAccessible(true);
//			field.set(model, value);
//			return mapper.selectOne(model);
//		} catch (ReflectiveOperationException e) {
//			throw new RRException(e.getMessage(), e);
//		}
//	}
//
////	private  void  test(){
////		try {
////			T model = modelClass.newInstance();
////			Field field = modelClass.getDeclaredField(fieldName);
////			field.setAccessible(true);
////			field.set(model, value);
////			return mapper.selectOne(model);
////		} catch (ReflectiveOperationException e) {
////			throw new RRException(e.getMessage(), e);
////		}
////	}
//	@Override
//	public List<T> selectListBy(String fieldName, Object value)  {
//		try {
//			T model = modelClass.newInstance();
//			Field field = modelClass.getDeclaredField(fieldName);
//			field.setAccessible(true);
//			field.set(model, value);
//			return mapper.select(model);
//		} catch (ReflectiveOperationException e) {
//			throw new RRException(e.getMessage(), e);
//		}
//	}
//
//	@Override
//	public List<T> selectListByIds(String ids) {
//		return mapper.selectByIds(ids);
//	}
//
//	@Override
//	public List<T> selectByCondition(Condition condition) {
//		return mapper.selectByCondition(condition);
//	}
//
//	@Override
//	public List<T> selectAll() {
//		return mapper.selectAll();
//	}
//
//	@Override
//	public List<T> select(T record){
//		return mapper.select(record);
//	}
//
//	@Override
//	public T selectOne(T recoed){
//		return mapper.selectOne(recoed);
//	}
//}