package com.xzm.mapper;

import com.xzm.modules.tyb.dao.TybTeacherHanDanMapper;
import com.xzm.modules.tyb.dao.TybTeacherMapper;
import com.xzm.modules.tyb.dao.TybUserGenDanMapper;
import com.xzm.tyb.pojo.TybTeacher;
import com.xzm.tyb.pojo.TybTeacherHanDan;
import com.xzm.tyb.pojo.TybUserGenDan;
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

import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    private TybUserGenDanMapper userGenDanMapper;
    @Autowired
    private TybTeacherMapper teacherMapper;
    @Autowired
    private TybTeacherHanDanMapper teacherHanDanMapper;
    /**
     * 所有测试方法执行之前执行该方法
     */
    @Before
    public void before() {
        //获取mockmvc对象实例
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build(); // 4
    }
    @Test
    public void testUserGenDanTeacherList() {
       List<Integer> ids= new ArrayList<>();
        List<TybUserGenDan> list = userGenDanMapper.selectUserGenDanByUserPhone("18907447909");
        list.forEach(item -> {
            ids.add(item.getTeacherId());
            System.out.println("==="+item.getTeacherId());
        });
        List<TybTeacher> tybTeacherList = teacherMapper.selectTeacherListByIds(ids);
        tybTeacherList.forEach(item -> {
            System.out.println("老师名字==="+item.getTeacherName());
        });
    }

    @Test
    public void selectGenDanTeacherListByTeacherIdsTest() {
        List<Integer> ids= new ArrayList<>();
        List<TybUserGenDan> list = userGenDanMapper.selectUserGenDanByUserPhone("18907447909");
        list.forEach(item -> {
            ids.add(item.getTeacherId());
            System.out.println("==="+item.getTeacherId());
        });
        List<TybTeacherHanDan> tybTeacherHanDanList = teacherHanDanMapper.selectGenDanTeacherListByTeacherIds(ids);
        tybTeacherHanDanList.forEach(item -> {
            System.out.println("老师品种==="+item.getPingZhong());
        });
    }


    /**
     * 测试
     */
    @Test
    public void testUserGenDanByPhone()
    {
        List<TybUserGenDan> list = userGenDanMapper.selectUserGenDanByUserPhone("18907447909");
        list.forEach(item -> {
            System.out.println("==="+item.getTeacherId());
        });
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
