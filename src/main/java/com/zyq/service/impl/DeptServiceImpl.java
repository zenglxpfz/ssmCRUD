package com.zyq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyq.mapper.DepartmentMapper;
import com.zyq.pojo.Department;
import com.zyq.service.DeptService;

@Service
public class DeptServiceImpl implements DeptService{

	@Autowired
	private DepartmentMapper departmentMapper;
	
	//查询全部不用数据
	public List<Department> showDepts() {
		
		//按照条件查询
		return departmentMapper.selectByExample(null);
	}

}
