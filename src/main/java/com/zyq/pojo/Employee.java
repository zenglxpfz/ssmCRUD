package com.zyq.pojo;

import javax.validation.constraints.Pattern;

public class Employee {
    private Integer eId;

    @Pattern(regexp="(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})",message="�û���������6-16λӢ�ĺ�������ϻ���2-5λ����")
    private String eName;

    private String sex;

    //@Email
    @Pattern(regexp="^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$",message="�����ʽ����ȷ")
    private String email;

    private Integer dId;
    
    //��ѯԱ��ʱͬʱ�Ѳ�����Ϣ��ʾ����
    private Department department;
    
    

    public Employee() {
		super();
	}

	public Employee(Integer eId, String eName, String sex, String email, Integer dId) {
		super();
		this.eId=eId;
		this.eName = eName;
		this.sex = sex;
		this.email = email;
		this.dId = dId;
		
	}

	@Override
	public String toString() {
		return "Employee [eId=" + eId + ", eName=" + eName + ", sex=" + sex + ", email=" + email + ", dId=" + dId
				+ ", department=" + department + "]";
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName == null ? null : eName.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }
}