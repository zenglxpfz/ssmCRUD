package com.zyq.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zyq.pojo.Employee;

@Service
public interface EmpService {

	//��ѯ����Ա����Ϣ
	List<Employee> selEmployee();
	
	//����Ա����Ϣ
	void saveEmps(Employee x);

	//У���Ƿ����ظ���
	boolean checkUser(String empname);

	//����id��ѯ����Ա��
	Employee selEmpbyid(Integer id);

	//����id�ύ�����������������޸ĸ���Ա����Ϣ
	void updateEmpbyid(Employee employee);

	//����idɾ��Ա����Ϣ
	int deleteEmpbyid(Integer id);

	//����ɾ��
	void deleteBatch(List<Integer> ids);
	
}

