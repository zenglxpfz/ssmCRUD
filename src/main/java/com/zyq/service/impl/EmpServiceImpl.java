package com.zyq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyq.mapper.EmployeeMapper;
import com.zyq.pojo.Employee;
import com.zyq.pojo.EmployeeExample;
import com.zyq.pojo.EmployeeExample.Criteria;
import com.zyq.service.EmpService;


@Service
public class EmpServiceImpl implements EmpService{

	@Autowired
	private EmployeeMapper employeeMapper;
	
	 public List<Employee> selEmployee() {
		
		return employeeMapper.selectByExampleWithDept(null);
	}
	 
	//新增员工信息，员工为类型Employee
	 public void saveEmps(Employee employee) {
			
			 employeeMapper.insertSelective(employee);
		}

	 //检验用户名是否可用
	 //返回true代表可用
	public boolean checkUser(String empname) {
		
		//创建类对象
		EmployeeExample example=new EmployeeExample();
		
		//拼接查询条件，整合在类对象中存储
		Criteria cri=example.createCriteria();
		//现在只是查询name条件
		cri.andENameEqualTo(empname);
		//example 为我们的查询条件
		long cone=employeeMapper.countByExample(example);
		return cone==0;
	}

	//根据id查询单个员工
	public Employee selEmpbyid(Integer id) {
		
		return employeeMapper.selectByPrimaryKey(id);
	}

	//根据id提交表单所有属性整个类修改个人员工信息
	public void updateEmpbyid(Employee employee) {
		
		 employeeMapper.updateByPrimaryKeySelective(employee);
	}

	//根据id删除员工信息
	public int deleteEmpbyid(Integer id) {
		return employeeMapper.deleteByPrimaryKey(id);
		
	}

	//批量删除方法
	public void deleteBatch(List<Integer> ids) {
		EmployeeExample example=new EmployeeExample();
		Criteria cri=example.createCriteria();
		cri.andEIdIn(ids);
		employeeMapper.deleteByExample(example);
		
	}

}
