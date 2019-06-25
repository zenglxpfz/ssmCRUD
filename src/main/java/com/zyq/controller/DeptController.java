package com.zyq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zyq.pojo.Department;
import com.zyq.pojo.Mag;
import com.zyq.service.DeptService;
//�����Ų�ѯ
@Controller
public class DeptController {

	@Autowired
	private DeptService deptServiceImpl;
	
	@RequestMapping("/depts")
	@ResponseBody
	public Mag getDepts(){
		 List<Department> list=deptServiceImpl.showDepts();
		
		 //�ȴ洢��һ���෽������
		 //System.out.println(list);
		 return  Mag.success().add("depts",list);
		 
	}
}
