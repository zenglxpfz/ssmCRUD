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
 * ʹ��spring����ģ���ṩ�Ĳ��������ܣ�����curd�����׼ȷ��
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
	//����springmvc��IOC
	@Autowired
	WebApplicationContext context;
	
//����MVC���󣬻�ȡ��������
	MockMvc mockMvc;
	
	@Before
	public void initMokcMvc(){
		mockMvc=MockMvcBuilders.webAppContextSetup(context).build();
		
	}
	
	@Test
	public void testPage() throws Exception{
		//ģ�������õ�����ֵ
		MvcResult result=mockMvc.perform(MockMvcRequestBuilders.get("/emp").param("pn","1")).andReturn();
		
	//�ɹ��Ժ�����������pageinFo������ȡ����pageInfo��֤
		MockHttpServletRequest re= result.getRequest();
		PageInfo pi=(PageInfo) re.getAttribute("pageInfo");
		System.out.println("��ǰҳ�룺"+pi.getPageNum());
		 System.out.println("��ҳ�룺"+pi.getPages());
	        System.out.println("�ܼ�¼����"+pi.getTotal());
	        System.out.println("������ʾ��ҳ��");
	        int[] nums=pi.getNavigatepageNums();
	        for(int i:nums){
	            System.out.println(" "+i);
	        }

        //��ȡԱ������
	        List<Employee> list= pi.getList();
	        for(Employee employee:list){
            System.out.println("id:"+employee.geteId()+" name:"+employee.geteName());
	        }
	}
}
