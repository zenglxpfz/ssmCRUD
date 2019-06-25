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
	 
	//����Ա����Ϣ��Ա��Ϊ����Employee
	 public void saveEmps(Employee employee) {
			
			 employeeMapper.insertSelective(employee);
		}

	 //�����û����Ƿ����
	 //����true�������
	public boolean checkUser(String empname) {
		
		//���������
		EmployeeExample example=new EmployeeExample();
		
		//ƴ�Ӳ�ѯ������������������д洢
		Criteria cri=example.createCriteria();
		//����ֻ�ǲ�ѯname����
		cri.andENameEqualTo(empname);
		//example Ϊ���ǵĲ�ѯ����
		long cone=employeeMapper.countByExample(example);
		return cone==0;
	}

	//����id��ѯ����Ա��
	public Employee selEmpbyid(Integer id) {
		
		return employeeMapper.selectByPrimaryKey(id);
	}

	//����id�ύ�����������������޸ĸ���Ա����Ϣ
	public void updateEmpbyid(Employee employee) {
		
		 employeeMapper.updateByPrimaryKeySelective(employee);
	}

	//����idɾ��Ա����Ϣ
	public int deleteEmpbyid(Integer id) {
		return employeeMapper.deleteByPrimaryKey(id);
		
	}

	//����ɾ������
	public void deleteBatch(List<Integer> ids) {
		EmployeeExample example=new EmployeeExample();
		Criteria cri=example.createCriteria();
		cri.andEIdIn(ids);
		employeeMapper.deleteByExample(example);
		
	}

}
