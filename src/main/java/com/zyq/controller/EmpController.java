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

//交给springMVC管理，创建对象
@Controller
public class EmpController {
	
	    @Autowired
        EmpService empServiceImpl;
	
	    
	    //给页面返回json数据，ajax请求
	    @RequestMapping("/emps")
	    @ResponseBody
	    public Mag empJson(@RequestParam(value="pn")Integer pn){
	    	
	    	//这不是一个分页查询
			//引入pageHandler分页插件
			//在查询之前只需要调用，传入页码，以及每页大小即可
			PageHelper.startPage(pn,5);
		 	//startPage后面跟着的这个查询就是一个分页查询
		  List<Employee> emps=empServiceImpl.selEmployee();	
		 //System.out.println(emps);
			//使用pageInfo保证查询后的结果，只需要把PageInfo交给页面即可，就是把列表传到作用域中
			//封装了详细的分页信息，包括有我们查询出来的数据，可以传入连续显示的页数5
		    PageInfo page=new PageInfo(emps,5);
		    
		    return Mag.success().add("pageInfo",page);
	    }
	    
	@RequestMapping("/emp")
	public String showEmp(@RequestParam(value="pn",defaultValue="1")Integer pn,Model model){
		//这不是一个分页查询
		//引入pageHandler分页插件
		//在查询之前只需要调用，传入页码，以及每页大小即可
		PageHelper.startPage(pn,5);
	 	//startPage后面跟着的这个查询就是一个分页查询
	  List<Employee> emps=empServiceImpl.selEmployee();	
	 // System.out.println(emps);
		//使用pageInfo保证查询后的结果，只需要把PageInfo交给页面即可，就是把列表传到作用域中
		//封装了详细的分页信息，包括有我们查询出来的数据，可以传入连续显示的页数5
	    PageInfo page=new PageInfo(emps,5);
	    
	    //Model接口，最终也放在了request作用域中，最底层
	    model.addAttribute("pageInfo",page);
	   //s System.out.println(page);
	    
		return "show";
		
	}
	/*
	 * 1。支持jsr303校验
	 * 2、导入Hibernate——validator包
	 * 3.属性那边加注解代表要校验
	 * 4.该传递类中加注解代表要进行校验，并拿到校验结果在BindingResult中
	 * 
	 * */
	
	//保存新增员工,通过请求方式来区分哪个控制器，加method=RequestMethod.*
	@RequestMapping(value="/emp",method=RequestMethod.POST)
	@ResponseBody
	public Mag saveEmp(@Valid Employee employee,BindingResult result){
		
		//校验失败
		if(result.hasErrors()){
			//保存错误信息
			Map<String,Object> map=new HashMap<String, Object>();
			//错误的嘻嘻嘻
			List<FieldError> errors=result.getFieldErrors();
			for(FieldError fieldError:errors){
				System.out.println("错误的字段名"+fieldError.getField());
				System.out.println("错误信息"+fieldError.getDefaultMessage());
				
				map.put(fieldError.getField(),fieldError.getDefaultMessage());
			}
			//在模态框中显示失败信息
			return Mag.fault().add("errorFields", map);
		}else{
		empServiceImpl.saveEmps(employee);
		return Mag.success();
	}}
	
	//校验用户名是否存在
	@RequestMapping("/checkuser")
	@ResponseBody
	public Mag checkuser(@RequestParam("eName")String empname){
		//先判断用户名是否合法
		String regx="(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})";
		//.matches(regx)是java中判断内容是否符合正则表达式的方法，true（符合）或者false,后端校验
		if(!empname.matches(regx)){
			return Mag.fault().add("va_mag","用户名必须是6-16位英文和数字组合或者2-5位中文");
		}
		//接收业务层的数据返回类型，true或者false
	boolean b=empServiceImpl.checkUser(empname);
	
	if(b){
		
		return Mag.success();
	}else{
		
		return Mag.fault().add("va_mag","用户名不可用");
	}
		
	}
	
	//根据员工id查询个人员工信息
	@RequestMapping(value="/emp/{id}",method=RequestMethod.GET)
	@ResponseBody
	public Mag selEmp(@PathVariable("id") Integer id){
		Employee emp=empServiceImpl.selEmpbyid(id);
		return Mag.success().add("Emp",emp);
	}
	
	//根据员工id修改个人员工信息eId要和属性名一样，会自动指定对应值类中的值
		@RequestMapping(value="/emp/{eId}",method=RequestMethod.PUT)
		@ResponseBody
		public Mag updateEmp(Employee employee){
			empServiceImpl.updateEmpbyid(employee);
			return Mag.success();
		}
		
		
		/**
		 * 删除二合一，根据有没有短线“-”来判断,进行处理批量还是一个
		 * 
		 */
		
		//根据员工id删除个人员工信息eId要和属性名一样，会自动指定对应值类中的值，注解PathVariable("id")从路径中拿到带过来的参数，传递给新定义的id
		@RequestMapping(value="/empem/{ids}",method=RequestMethod.DELETE)
		//@RequestMapping(value="/empem/{id}")
		@ResponseBody
		public Mag deleteempbyid(@PathVariable("ids") String ids){
			//如果传过来的参数含有这个符号即是批量删除
			if(ids.contains("-")){
				//创建一个列表保存解析出来的一个个id
				List<Integer> del_ids=new ArrayList<Integer>();
				String[] str_ids=ids.split("-");
				//组装id的集合
				for(String string:str_ids){
					del_ids.add(Integer.parseInt(string));
				}
				empServiceImpl.deleteBatch(del_ids);
			}else{
				
				//单个删除
				Integer id=Integer.parseInt(ids);
				empServiceImpl.deleteEmpbyid(id);
			}	
				
					return Mag.success();
				}
		
}
