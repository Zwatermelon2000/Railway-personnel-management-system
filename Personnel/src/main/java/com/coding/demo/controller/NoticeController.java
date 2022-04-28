package com.coding.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.coding.demo.entity.Notice;
import com.coding.demo.result.Result;
import com.coding.demo.result.ResultFactory;
import com.coding.demo.service.NoticeService;
@RestController
@RequestMapping("/notice")
public class NoticeController {
	@Autowired
	private NoticeService noticeService;
	@RequestMapping(value = "/publish")
	public Result publish(String title,String notice,String date,String person) {	
		return ResultFactory.buildSuccessResult(noticeService.publish(title, notice, date, person));
	}
	@RequestMapping(value = "/all") 
	public Result selectAll() {	
		return ResultFactory.buildSuccessResult(noticeService.selectAll());
	}	
	@RequestMapping(value = "/delete") 
	public Result delete(String id) {	
		Notice notice=new Notice();
		notice.setId(id);
		if(noticeService.delete(notice)==1) {
			return ResultFactory.buildSuccessResult(noticeService.selectAll());
		}
		else {
			return ResultFactory.buildFailResult("删除失败");
		}
	}
}
