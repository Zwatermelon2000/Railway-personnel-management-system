package com.coding.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.coding.demo.result.Result;
import com.coding.demo.result.ResultFactory;
import com.coding.demo.service.CheckingService;
@RestController
@RequestMapping("/checking")
public class CheckingController {
	@Autowired
	private CheckingService checkingService;
	@RequestMapping(value = "/attendance")
	public Result insert(String id,String date) {
		if(checkingService.insert(id,date)==0) {
			return ResultFactory.buildFailResult("今日已签到");
		}
		return ResultFactory.buildSuccessResult(checkingService.insert(id,date));
	}
	@RequestMapping(value = "/all")
	public Result selectAll(String id) {
		return ResultFactory.buildSuccessResult(checkingService.selectAll(id));
	}
	@RequestMapping(value = "/count")
	public Result count(String id) {
		return ResultFactory.buildSuccessResult(checkingService.selectCount(id));
	}
}