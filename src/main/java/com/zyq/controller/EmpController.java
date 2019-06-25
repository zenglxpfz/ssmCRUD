package com.zyq.controller;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyq.pojo.Employee;
import com.zyq.pojo.Mag;
import com.zyq.service.EmpService;

//����springMVC������������
@Controller
public class EmpController {
	
	    @Autowired
        EmpService empServiceImpl;
	
	    
	    //��ҳ�淵��json���ݣ�ajax����
	    @RequestMapping("/emps")
	    @ResponseBody
	    public Mag empJson(@RequestParam(value="pn")Integer pn){
	    	
	    	//�ⲻ��һ����ҳ��ѯ
			//����pageHandler��ҳ���
			//�ڲ�ѯ֮ǰֻ��Ҫ���ã�����ҳ�룬�Լ�ÿҳ��С����
			PageHelper.startPage(pn,5);
		 	//startPage������ŵ������ѯ����һ����ҳ��ѯ
		  List<Employee> emps=empServiceImpl.selEmployee();	
		 //System.out.println(emps);
			//ʹ��pageInfo��֤��ѯ��Ľ����ֻ��Ҫ��PageInfo����ҳ�漴�ɣ����ǰ��б�����������
			//��װ����ϸ�ķ�ҳ��Ϣ�����������ǲ�ѯ���������ݣ����Դ���������ʾ��ҳ��5
		    PageInfo page=new PageInfo(emps,5);
		    
		    return Mag.success().add("pageInfo",page);
	    }
	    
	@RequestMapping("/emp")
	public String showEmp(@RequestParam(value="pn",defaultValue="1")Integer pn,Model model){
		//�ⲻ��һ����ҳ��ѯ
		//����pageHandler��ҳ���
		//�ڲ�ѯ֮ǰֻ��Ҫ���ã�����ҳ�룬�Լ�ÿҳ��С����
		PageHelper.startPage(pn,5);
	 	//startPage������ŵ������ѯ����һ����ҳ��ѯ
	  List<Employee> emps=empServiceImpl.selEmployee();	
	 // System.out.println(emps);
		//ʹ��pageInfo��֤��ѯ��Ľ����ֻ��Ҫ��PageInfo����ҳ�漴�ɣ����ǰ��б�����������
		//��װ����ϸ�ķ�ҳ��Ϣ�����������ǲ�ѯ���������ݣ����Դ���������ʾ��ҳ��5
	    PageInfo page=new PageInfo(emps,5);
	    
	    //Model�ӿڣ�����Ҳ������request�������У���ײ�
	    model.addAttribute("pageInfo",page);
	   //s System.out.println(page);
	    
		return "show";
		
	}
	/*
	 * 1��֧��jsr303У��
	 * 2������Hibernate����validator��
	 * 3.�����Ǳ߼�ע�����ҪУ��
	 * 4.�ô������м�ע�����Ҫ����У�飬���õ�У������BindingResult��
	 * 
	 * */
	
	//��������Ա��,ͨ������ʽ�������ĸ�����������method=RequestMethod.*
	@RequestMapping(value="/emp",method=RequestMethod.POST)
	@ResponseBody
	public Mag saveEmp(@Valid Employee employee,BindingResult result){
		
		//У��ʧ��
		if(result.hasErrors()){
			//���������Ϣ
			Map<String,Object> map=new HashMap<String, Object>();
			//�����������
			List<FieldError> errors=result.getFieldErrors();
			for(FieldError fieldError:errors){
				System.out.println("������ֶ���"+fieldError.getField());
				System.out.println("������Ϣ"+fieldError.getDefaultMessage());
				
				map.put(fieldError.getField(),fieldError.getDefaultMessage());
			}
			//��ģ̬������ʾʧ����Ϣ
			return Mag.fault().add("errorFields", map);
		}else{
		empServiceImpl.saveEmps(employee);
		return Mag.success();
	}}
	
	//У���û����Ƿ����
	@RequestMapping("/checkuser")
	@ResponseBody
	public Mag checkuser(@RequestParam("eName")String empname){
		//���ж��û����Ƿ�Ϸ�
		String regx="(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})";
		//.matches(regx)��java���ж������Ƿ����������ʽ�ķ�����true�����ϣ�����false,���У��
		if(!empname.matches(regx)){
			return Mag.fault().add("va_mag","�û���������6-16λӢ�ĺ�������ϻ���2-5λ����");
		}
		//����ҵ�������ݷ������ͣ�true����false
	boolean b=empServiceImpl.checkUser(empname);
	
	if(b){
		
		return Mag.success();
	}else{
		
		return Mag.fault().add("va_mag","�û���������");
	}
		
	}
	
	//����Ա��id��ѯ����Ա����Ϣ
	@RequestMapping(value="/emp/{id}",method=RequestMethod.GET)
	@ResponseBody
	public Mag selEmp(@PathVariable("id") Integer id){
		Employee emp=empServiceImpl.selEmpbyid(id);
		return Mag.success().add("Emp",emp);
	}
	
	//����Ա��id�޸ĸ���Ա����ϢeIdҪ��������һ�������Զ�ָ����Ӧֵ���е�ֵ
		@RequestMapping(value="/emp/{eId}",method=RequestMethod.PUT)
		@ResponseBody
		public Mag updateEmp(Employee employee){
			empServiceImpl.updateEmpbyid(employee);
			return Mag.success();
		}
		
		
		/**
		 * ɾ������һ��������û�ж��ߡ�-�����ж�,���д�����������һ��
		 * 
		 */
		
		//����Ա��idɾ������Ա����ϢeIdҪ��������һ�������Զ�ָ����Ӧֵ���е�ֵ��ע��PathVariable("id")��·�����õ��������Ĳ��������ݸ��¶����id
		@RequestMapping(value="/empem/{ids}",method=RequestMethod.DELETE)
		//@RequestMapping(value="/empem/{id}")
		@ResponseBody
		public Mag deleteempbyid(@PathVariable("ids") String ids){
			//����������Ĳ�������������ż�������ɾ��
			if(ids.contains("-")){
				//����һ���б������������һ����id
				List<Integer> del_ids=new ArrayList<Integer>();
				String[] str_ids=ids.split("-");
				//��װid�ļ���
				for(String string:str_ids){
					del_ids.add(Integer.parseInt(string));
				}
				empServiceImpl.deleteBatch(del_ids);
			}else{
				
				//����ɾ��
				Integer id=Integer.parseInt(ids);
				empServiceImpl.deleteEmpbyid(id);
			}	
				
					return Mag.success();
				}
		
}
