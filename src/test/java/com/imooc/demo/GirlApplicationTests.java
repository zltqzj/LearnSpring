package com.imooc.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.imooc.demo.controller.GirlController;
import com.imooc.demo.domain.Girl;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.hasValue;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "classpath:applicationContext.xml","classpath:servlet-context.xml"})
@SpringBootTest
public class GirlApplicationTests {
    private MockMvc mockMvc;


    private GirlController girlController;

    MockHttpServletRequest mockHttpServletRequest;


    private ObjectMapper mapper = new ObjectMapper();

    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;


    @Before
    public void setUp() throws Exception {
        girlController = new GirlController();
        mockMvc = MockMvcBuilders.standaloneSetup(girlController).build();
        mockHttpServletRequest = new MockHttpServletRequest();
    }


    @Test
    public void testIndex() throws Exception {
        mockHttpServletRequest = new MockHttpServletRequest();
        mockHttpServletRequest.addParameter("key","value");

        String result = girlController.girlListByAge1( mockHttpServletRequest );
        System.out.println( result );


        /*
    https://github.com/zapper112/mTraining-ivr/blob/acb6f8e83d39ede43c577a7293377aea968f0d7e/src/test/java/com/zapper/testIVR/controller/QuizControllerTest.java

         MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/superadmin/listarea"))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        HttpServletRequest request = result.getRequest();



        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/girls/8" )).andDo(MockMvcResultHandlers.print());
        MvcResult mvcResult = resultActions.andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        Girl girl = mapper.readValue(result, Girl.class);
        System.out.println("=====客户端获得反馈数据:" + girl.getCupSize());
        assertTrue("g".equals(girl.getCupSize()));

        .andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().encoding("UTF-8"))
		.andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))

        String a = "$[0]";
        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/girls/age/6" )).andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.jsonPath(a, Matchers.hasValue(6)));
        MvcResult mvcResult = resultActions.andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("=====客户端获得反馈数据:" + result);

        String a = "$";
        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/girls/age/6" )).andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.jsonPath(a).isArray());
        MvcResult mvcResult = resultActions.andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("=====客户端获得反馈数据:" + result);


        String a = "$[0].age";
        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/girls/age/6" )).andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.jsonPath(a).isNumber());
        MvcResult mvcResult = resultActions.andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("=====客户端获得反馈数据:" + result);

        String a = "$.length()";
        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/girls/age/6" )).andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.jsonPath(a).value(1));
        MvcResult mvcResult = resultActions.andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("=====客户端获得反馈数据:" + result);


         ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/girls/age/6" )).andExpect(MockMvcResultMatchers.jsonPath("$[0].age").value(6) );
        MvcResult mvcResult = resultActions.andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("=====客户端获得反馈数据:" + result);


          // 查询数据库
        String name = jdbcTemplate.queryForObject("select age from girl where id = ?", String.class,
                7);
        System.out.println(name);

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



    /*

    private QuizController quizController;
  MockHttpServletRequest mockHttpServletRequest;

  @Test
  @Ignore
  public void testContinuingQuestion() {
    quizController = new QuizController();
    mockHttpServletRequest = new MockHttpServletRequest();
    mockHttpServletRequest.addParameter("cid","100");
    mockHttpServletRequest.addParameter("event","gotDtmf");
    mockHttpServletRequest.addParameter("data","2");
    System.out.println(quizController.startQuizService(mockHttpServletRequest));
  }
    */

    @Test
    public void contextLoads() {
    }

}
