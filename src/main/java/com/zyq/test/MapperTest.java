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
 * 测试mapper层工作
 * 推荐使用spring的项目可以使用spring的单元测试，可以自动化注入我们要的组件
 * 1.导入springtest模块
 * 2.@ContextConfiguration指定配置文件位置
 * 3.直接autowired 要使用的组件即可
 * */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MapperTest {
	//定义mapper属性autowired(自动注入这个类的内容东西到创建好的对象中，由spring的bean自动创建对象)
	@Autowired
    DepartmentMapper departmentMapper;
	
	@Autowired
	EmployeeMapper employeeMapper;
	
	@Autowired
	SqlSession sqlSession;
	
  @Test
	public void testCRUD(){
		
	  /**
		 * 1.创建SpringIOC容器
		 * ApplicationContext ioc=new classPathXmlApplicationContext();
		 * 2.从容器中获取mapper
		 *  DepartmentMapper bean=ioc.getBean( DepartmentMapper.class);
		 * 
		 * 
		 * */
	  
	  System.out.println(departmentMapper);
	  
		//插入几个部门
		//departmentMapper.insertSelective(new Department(null,"开发部"));
		//departmentMapper.insertSelective(new Department(null,"测试部"));
		//departmentMapper.insertSelective(new Department(null,"开发部"));
	  
	  //插入几个员工
	  //employeeMapper.insertSelective(new Employee("fff","男","123@qq.com",1));
	  //employeeMapper.insertSelective(new Employee("ggg","男","666@qq.com",1));
	  //employeeMapper.insertSelective(new Employee("渣男","男","8883@qq.com",2));
	//  employeeMapper.insertSelective(new Employee("婊子","女","13333@qq.com",2));
	  EmployeeMapper mapper=sqlSession.getMapper(EmployeeMapper.class);
	  for(int i=0;i<10;i++){
		 //String uid=UUID.randomUUID().toString().substring(0,5)+i;
		  mapper.insertSelective(new Employee(null,"11","女","22@qq.com",2));
		  
	  }
	  System.out.println("cesss");
	}
	
}

