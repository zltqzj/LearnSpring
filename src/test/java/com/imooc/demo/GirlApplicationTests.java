package com.imooc.demo;

import com.imooc.demo.controller.GirlController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "classpath:applicationContext.xml","classpath:servlet-context.xml"})
//@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlApplicationTests {
    private MockMvc mockMvc;

    @Autowired
    private GirlController girlController;

    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;


    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(girlController).build();
    }


    @Test
    public void testIndex() throws Exception {

        String name = jdbcTemplate.queryForObject("select age from girl where id = ?", String.class,
                7);
        System.out.println("----------");

        System.out.println(name);
        /*
        // get方法
        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/girls/age/6" ));
        MvcResult mvcResult = resultActions.andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("=====客户端获得反馈数据:" + result);


        // post带参数
        ResultActions resultActions1 = this.mockMvc.perform(MockMvcRequestBuilders.post("/girls1" ).param("age", "67").param( "cupSize" ,"g"));
        MvcResult mvcResult1 = resultActions1.andReturn();
        String result1 = mvcResult1.getResponse().getContentAsString();
        System.out.println("=====客户端获得反馈数据:" + result1);

        // 返回值预期
        ResultActions resultActions2 = this.mockMvc.perform(MockMvcRequestBuilders.post("/girls1" ).param("age", "67").param( "cupSize" ,"g")).andExpect( MockMvcResultMatchers.status().isOk());
        MvcResult mvcResult2 = resultActions2.andReturn();
        String result2 = mvcResult2.getResponse().getContentAsString();
        System.out.println("=====客户端获得反馈数据:" + result2);
        */
    }

    @Test
    public void contextLoads() {
    }

}
