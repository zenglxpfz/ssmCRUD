package com.zyq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zyq.pojo.Department;
import com.zyq.pojo.Mag;
import com.zyq.service.DeptService;
//处理部门查询
@Controller
public class DeptController {

	@Autowired
	private DeptService deptServiceImpl;
	
	@RequestMapping("/depts")
	@ResponseBody
	public Mag getDepts(){
		 List<Department> list=deptServiceImpl.showDepts();
		
		 //先存储到一个类方法里面
		 //System.out.println(list);
		 return  Mag.success().add("depts",list);
		 
	}
}
