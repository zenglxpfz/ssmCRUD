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
	
	//��ѯȫ����������
	public List<Department> showDepts() {
		
		//����������ѯ
		return departmentMapper.selectByExample(null);
	}

}
