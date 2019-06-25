package com.zyq.test;

import java.util.List;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.github.pagehelper.PageInfo;
import com.zyq.pojo.Employee;

/**
 * 使用spring测试模块提供的测试请求功能，测试curd请求的准确性
 * 
 * 
 * 
 * 
 * 
 * 
 * */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"classpath:applicationContext.xml","file:src/main/resources/springmvc.xml"})
public class MvcTest {
	//传入springmvc的IOC
	@Autowired
	WebApplicationContext context;
	
//虚拟MVC请求，获取到处理结果
	MockMvc mockMvc;
	
	@Before
	public void initMokcMvc(){
		mockMvc=MockMvcBuilders.webAppContextSetup(context).build();
		
	}
	
	@Test
	public void testPage() throws Exception{
		//模拟请求拿到返回值
		MvcResult result=mockMvc.perform(MockMvcRequestBuilders.get("/emp").param("pn","1")).andReturn();
		
	//成功以后，请求域中有pageinFo，可以取出来pageInfo验证
		MockHttpServletRequest re= result.getRequest();
		PageInfo pi=(PageInfo) re.getAttribute("pageInfo");
		System.out.println("当前页码："+pi.getPageNum());
		 System.out.println("总页码："+pi.getPages());
	        System.out.println("总记录数："+pi.getTotal());
	        System.out.println("连续显示的页码");
	        int[] nums=pi.getNavigatepageNums();
	        for(int i:nums){
	            System.out.println(" "+i);
	        }

        //获取员工数据
	        List<Employee> list= pi.getList();
	        for(Employee employee:list){
            System.out.println("id:"+employee.geteId()+" name:"+employee.geteName());
	        }
	}
}
