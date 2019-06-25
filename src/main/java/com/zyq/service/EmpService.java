package com.zyq.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zyq.pojo.Employee;

@Service
public interface EmpService {

	//查询所有员工信息
	List<Employee> selEmployee();
	
	//新增员工信息
	void saveEmps(Employee x);

	//校验是否有重复名
	boolean checkUser(String empname);

	//根据id查询单个员工
	Employee selEmpbyid(Integer id);

	//根据id提交表单所有属性整个类修改个人员工信息
	void updateEmpbyid(Employee employee);

	//根据id删除员工信息
	int deleteEmpbyid(Integer id);

	//批量删除
	void deleteBatch(List<Integer> ids);
	
}

