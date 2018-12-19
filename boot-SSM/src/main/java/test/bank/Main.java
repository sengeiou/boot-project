package test.bank;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	/**
	 *      假设有一个如下应用场景：
	 *      （1）一个银行在每月的月初都需要向客户发送上个月的账单，账单发送的方式可以为纸质邮寄、或者短信方式。
	 *      （2）还有一个潜在的需求：为了安全起见，
	 *      在每个函数操作过程中都需要记录日志，记录参数传入是否正常，函数是否正常结束，以便出错时系统管理员查账。
	 * @param args
	 */
	public static void main(String[] args) {
	
		ApplicationContext context = new ClassPathXmlApplicationContext("test/testApplicationContext.xml");
		ReportService reportService = (ReportService)context.getBean("reportService");
		reportService.generateMonthlyReport(2011, 7);
		
	}
	
}
