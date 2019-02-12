package com.xzm.tyb.common.base;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Controller公共组件
 */
public abstract class BaseController {
	//logback
	protected Logger logger = LoggerFactory.getLogger(getClass());
	protected String TAG = getClass().getName();

//	protected   Log logger = LogFactory.getLog(getClass());
}
