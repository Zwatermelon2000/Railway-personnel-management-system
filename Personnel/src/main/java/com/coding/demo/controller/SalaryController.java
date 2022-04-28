package com.coding.demo.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.coding.demo.result.Result;
import com.coding.demo.result.ResultFactory;
import com.coding.demo.entity.Salary;
import com.coding.demo.service.SalaryService;
import com.github.pagehelper.PageInfo;
@ResponseBody
@RestController
@RequestMapping("/salary")
public class SalaryController {
	@Autowired
	private SalaryService salaryService;
	@RequestMapping(value = "/page")
	public Result page(Integer page,Integer size) {	
	    return ResultFactory.buildSuccessResult(salaryService.selectDetail(page,size));
	}
	@RequestMapping(value = "/search")
	public Result selectByKey(String keywords,String salaryMonth,Integer page, Integer size) {
		PageInfo<Salary> userList=salaryService.selectByKey(keywords,salaryMonth,page,size);	
		return ResultFactory.buildSuccessResult(userList);		
	}
	@RequestMapping(value = "/clearMonth")
	public Result clearMonth(String keywords,Integer page, Integer size) {
		PageInfo<Salary> userList=salaryService.clearMonth(keywords,page,size);	
		return ResultFactory.buildSuccessResult(userList);		
	}	
	@RequestMapping(value = "/view")
	public Result view(){
		List<Salary> salary=salaryService.view();		
		return ResultFactory.buildSuccessResult(salary);	
	}
	@RequestMapping(value = "/amount")
	public Result amount(){	
		return ResultFactory.buildSuccessResult(salaryService.amount());	
	}
	@RequestMapping(value = "/sameMonth")
	public Result sameMonth(String salaryMonth){	
		return ResultFactory.buildSuccessResult(salaryService.sameMonth(salaryMonth));	
	}
	@RequestMapping(value = "/countMonth")
	public Result countMonth(String salaryMonth){	
		return ResultFactory.buildSuccessResult(salaryService.countMonth(salaryMonth));	
	}
	@RequestMapping(value = "/updateSalary")
	public void updateSalary() {	
		salaryService.updateSalary();		
	}
}
