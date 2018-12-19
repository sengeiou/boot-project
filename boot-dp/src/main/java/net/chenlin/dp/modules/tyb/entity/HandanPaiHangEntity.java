package net.chenlin.dp.modules.tyb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;



/**
 * 老师喊单排行表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年4月08日 下午6:45:19
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class HandanPaiHangEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * id
	 */
	private Integer id;
	
	/**
	 * 讲师名称
	 */
	private String title;
	
	/**
	 * 产品类型
	 */
	private String producttype;
	
	/**
	 * 喊单时间
	 */
	private String ordertime;
	
	/**
	 * 盈利单位
	 */
	private String point;
	
	/**
	 * 盈利点
	 */
	private String profit;
	
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	/**
	 * 修改时间
	 */
	private Date updataTime;
	


	
}
