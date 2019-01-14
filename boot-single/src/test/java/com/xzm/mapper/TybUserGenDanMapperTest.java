package com.xzm.mapper;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


/**
 * 单元测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TybUserGenDanMapperTest {
    private SqlSessionFactory sqlSessionFactory;

    /**
     * 模拟mvc测试对象
     */
    private MockMvc mockMvc;// 2

    /**
     * web项目上下文
     */
    @Autowired
    private WebApplicationContext webApplicationContext; // 3
    /**
     * 所有测试方法执行之前执行该方法
     */
    @Before
    public void before() {
        //获取mockmvc对象实例
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build(); // 4
    }


    /**
     * 测试
     */
    @Test
    public void testUserGenDanByPhone()
    {

    }

    /**
     * 测试访问/ Controller下的index地址
     * @throws Exception
     */
    @Test
    public void testIndex() throws Exception {
        MvcResult mvcResult = mockMvc
                .perform(
                        MockMvcRequestBuilders.get("/index")
                                .param("name","admin")
                )
                .andReturn(); // 5
        int status = mvcResult.getResponse().getStatus(); // 6
        String responseString = mvcResult.getResponse().getContentAsString(); // 7

//        Assert.assertEquals("请求错误", 200, status); // 8
//        Assert.assertEquals("返回结果不一致", "this is index pageadmin", responseString); // 9
    }




}
