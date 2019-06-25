package com.zyq.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zyq.pojo.Department;

@Service
public interface DeptService {

	List<Department> showDepts();
	
	
}
