package com.coding.demo.controller;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.coding.demo.entity.Staff;
import com.coding.demo.result.Result;
import com.coding.demo.result.ResultFactory;
import com.coding.demo.service.SalaryService;
import com.coding.demo.service.StaffService;
import com.coding.demo.util.Md5Util;
import com.github.pagehelper.PageInfo;
@ResponseBody
@RestController
@RequestMapping("/staff")
public class StaffController {
	@Autowired
    private StaffService staffService;
	@Autowired
    private SalaryService salaryService;
    @RequestMapping(value = "/login")
	public Result login(String id,String password,String job,HttpSession session,HttpServletResponse response) {		
		Staff exsitStaff=staffService.selectIndividual(id);
		if(exsitStaff==null) {	
			return ResultFactory.buildFailResult("该工号的账号不存在");
		}
		if (!exsitStaff.getPassword().equals(Md5Util.MD5(password))) {        
            return ResultFactory.buildFailResult("密码错误,请重新输入");
        }
		if(exsitStaff.getState().equals("离职")) {
			return ResultFactory.buildFailResult("您已离职无权访问");
		}
		if(job.equals("管理员")&&exsitStaff.getJob().equals("人事管理")) {
			return ResultFactory.buildSuccessResult(exsitStaff);
		}
		else if(job.equals("用户")&&(!exsitStaff.getJob().equals("人事管理"))) {
			return ResultFactory.buildSuccessResult(exsitStaff);
		}
		else {
			return ResultFactory.buildFailResult("登录错误");
		}
	}
    @RequestMapping(value = "/add")
    public Result add(String name,String sex,String idCard,String phone,String address,String mail,String job,String card) throws ParseException {
        String birthday;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");              
        Staff staff = new Staff();
        int x=staffService.getAll().size()-1;
        int max=Integer.valueOf(staffService.selectAll().get(0).getId().substring(4));
        for(int i=1;i<=x;i++) {
        	if(Integer.valueOf(staffService.selectAll().get(i).getId().substring(4))>max) {
        		max=Integer.valueOf(staffService.selectAll().get(i).getId().substring(4));
        	}
        }
        int num=max+1;
        staff.setPassword(Md5Util.MD5("88888888"));
        staff.setName(name);
        staff.setSex(sex);
        staff.setIdCard(idCard);
        if(job.equals("人事管理")) {
        	staff.setId("2101"+String.valueOf(num));
        }
        else if(job.equals("财务管理")){
        	staff.setId("2102"+String.valueOf(num));
        }
        else if(job.equals("铁路管理")){
        	staff.setId("2103"+String.valueOf(num));
        }
        else if(job.equals("用户管理")){
        	staff.setId("2104"+String.valueOf(num));
        } 
        else if(job.equals("普通职员")) {
        	staff.setId("2105"+String.valueOf(num));
        }       
        staff.setPhone(phone);
        staff.setAddress(address);
        birthday=staff.getIdCard().substring(6, 10)+"-"+staff.getIdCard().substring(10, 12)+"-"+staff.getIdCard().substring(12, 14);
        try {
			staff.setBirthday(sdf.parse(birthday));
		} catch (ParseException e) {
			e.printStackTrace();
		}
        staff.setMail(mail);
        staff.setJob(job);
        staff.setCard(card);
        staff.setState("在职");
        if (staffService.add(staff) != 1) {
            return ResultFactory.buildFailResult("添加失败");
        } 
        return ResultFactory.buildSuccessResult(staffService.getAll());
    }	
	@RequestMapping(value = "/all")
	public Result showPart() {
		List<Staff> staffList = staffService.getAll();
		return ResultFactory.buildSuccessResult(staffList);				
	}
	@RequestMapping(value = "/view")
	public Result view(String id) {
		Staff staff=staffService.view(id);	
		System.out.println(staff);
		return ResultFactory.buildSuccessResult(staff);	
	}	
	@RequestMapping(value = "/detail")
	public Result showDetail(String id) {
		Staff staff=staffService.showDetail(id);
		return ResultFactory.buildSuccessResult(staff);	
	}	
	@RequestMapping(value = "/edit")
	public Result update(String id,String name,String sex,String idCard,String phone,String address,String mail,String job,String card) {			
		if(staffService.update(id,name,sex,idCard,phone,address,mail,job,card)==1) {
			return ResultFactory.buildSuccessResult(staffService.getAll());
		}
		else {			
			return ResultFactory.buildFailResult("修改失败");
		}		
	}
	@RequestMapping(value = "/editIndividual")
	public Result updateIndividual(String id,String name,String sex,String idCard,String phone,String address,String mail,String job,String card) {			
		if(staffService.update(id,name,sex,idCard,phone,address,mail,job,card)==1) {
			return ResultFactory.buildSuccessResult(staffService.selectIndividual(id));
		}
		else {			
			return ResultFactory.buildFailResult("修改失败");
		}		
	}	
	@RequestMapping(value = "/delete")
	public Result logout(String id) {		
		if(staffService.delete(id)==1) {
			salaryService.delete(id);
			return ResultFactory.buildSuccessResult(staffService.getAll());
		}
		else {
			return ResultFactory.buildFailResult("删除失败");
		}		
	}	
	@RequestMapping(value = "/page")
	public Result page(Integer page,Integer size) {	
	    return ResultFactory.buildSuccessResult(staffService.getAll(page,size));
	}	
	@RequestMapping(value = "/search")
	public Result selectByKey(String keywords,String job,Integer page,Integer size) {
		PageInfo<Staff> staffList=staffService.selectByKey(keywords,job,page,size);	
		return ResultFactory.buildSuccessResult(staffList);		
	}
	@RequestMapping(value = "/changePassword")
	public Result changePassword(String id,String newPassword,String oldPassword) {
		oldPassword=Md5Util.MD5(oldPassword);
		newPassword=Md5Util.MD5(newPassword);
		Staff staff=staffService.selectIndividual(id);
		if(!staff.getPassword().equals(oldPassword)) {
			System.out.println("原密码输入错误");
			return ResultFactory.buildFailResult("原密码输入错误");
		}else if(newPassword.equals(oldPassword)) {
			return ResultFactory.buildFailResult("新密码和旧密码不能一样");
		}	
		return ResultFactory.buildSuccessResult(staffService.changePassword(id,newPassword,oldPassword));
	}
}