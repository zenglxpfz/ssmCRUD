package com.zyq.test;

import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zyq.mapper.DepartmentMapper;
import com.zyq.mapper.EmployeeMapper;
import com.zyq.pojo.Employee;

/**
 * ����mapper�㹤��
 * �Ƽ�ʹ��spring����Ŀ����ʹ��spring�ĵ�Ԫ���ԣ������Զ���ע������Ҫ�����
 * 1.����springtestģ��
 * 2.@ContextConfigurationָ�������ļ�λ��
 * 3.ֱ��autowired Ҫʹ�õ��������
 * */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MapperTest {
	//����mapper����autowired(�Զ�ע�����������ݶ����������õĶ����У���spring��bean�Զ���������)
	@Autowired
    DepartmentMapper departmentMapper;
	
	@Autowired
	EmployeeMapper employeeMapper;
	
	@Autowired
	SqlSession sqlSession;
	
  @Test
	public void testCRUD(){
		
	  /**
		 * 1.����SpringIOC����
		 * ApplicationContext ioc=new classPathXmlApplicationContext();
		 * 2.�������л�ȡmapper
		 *  DepartmentMapper bean=ioc.getBean( DepartmentMapper.class);
		 * 
		 * 
		 * */
	  
	  System.out.println(departmentMapper);
	  
		//���뼸������
		//departmentMapper.insertSelective(new Department(null,"������"));
		//departmentMapper.insertSelective(new Department(null,"���Բ�"));
		//departmentMapper.insertSelective(new Department(null,"������"));
	  
	  //���뼸��Ա��
	  //employeeMapper.insertSelective(new Employee("fff","��","123@qq.com",1));
	  //employeeMapper.insertSelective(new Employee("ggg","��","666@qq.com",1));
	  //employeeMapper.insertSelective(new Employee("����","��","8883@qq.com",2));
	//  employeeMapper.insertSelective(new Employee("���","Ů","13333@qq.com",2));
	  EmployeeMapper mapper=sqlSession.getMapper(EmployeeMapper.class);
	  for(int i=0;i<10;i++){
		 //String uid=UUID.randomUUID().toString().substring(0,5)+i;
		  mapper.insertSelective(new Employee(null,"11","Ů","22@qq.com",2));
		  
	  }
	  System.out.println("cesss");
	}
	
}

