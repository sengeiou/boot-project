package com.boot.common.constant;

public class ProjectConstant {
	/**
	 * 修改之后
	 */
	// 项目基础包名称，根据自己公司的项目修改
	public static final String BASE_PACKAGE = "com.xzm";
//	com.xzm.modules.*.dao

	// Model所在包
	public static final String MODEL_PACKAGE = BASE_PACKAGE  + ".modules."  + "*.pojo";

	// Mapper所在包
	public static final String MAPPER_PACKAGE = BASE_PACKAGE  + ".modules." + "*.dao";

	// Service所在包
	public static final String SERVICE_PACKAGE = BASE_PACKAGE  + ".modules." + "*.service";

	// ServiceImpl所在包
	public static final String SERVICE_IMPL_PACKAGE = BASE_PACKAGE +  ".modules." + "*.impl";

	// Controller所在包
	public static final String CONTROLLER_PACKAGE = BASE_PACKAGE  +  ".modules." +  "*.controller";

	// Mapper插件基础接口的完全限定名
	public static final String MAPPER_INTERFACE_REFERENCE = BASE_PACKAGE + ".modules.common.dao.Mapper";

	//文件上传储存的地址
	public static final String SAVEFILEPATH = "F://img";


	/**
	 * @description 最先配置
	 */

//	// 项目基础包名称，根据自己公司的项目修改
//	public static final String BASE_PACKAGE = "com.xzm";
////	com.xzm.modules.*.dao
//
//	// Model所在包
//	public static final String MODEL_PACKAGE = BASE_PACKAGE  + "modules" + "" + ".pojo";
//
//	// Mapper所在包
//	public static final String MAPPER_PACKAGE = BASE_PACKAGE + ".dao";
//
//	// Service所在包
//	public static final String SERVICE_PACKAGE = BASE_PACKAGE + ".service";
//
//	// ServiceImpl所在包
//	public static final String SERVICE_IMPL_PACKAGE = SERVICE_PACKAGE + ".impl";
//
//	// Controller所在包
//	public static final String CONTROLLER_PACKAGE = BASE_PACKAGE + ".controller";
//
//	// Mapper插件基础接口的完全限定名
//	public static final String MAPPER_INTERFACE_REFERENCE = BASE_PACKAGE + ".core.universal.Mapper";
//
//	//文件上传储存的地址
//	public static final String SAVEFILEPATH = "F://img";
}
