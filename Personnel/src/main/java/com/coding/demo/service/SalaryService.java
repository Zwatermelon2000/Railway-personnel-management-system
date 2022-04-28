package com.coding.demo.service;
import com.coding.demo.entity.Salary;
import com.coding.demo.mapper.CheckingMapper;
import com.coding.demo.mapper.SalaryMapper;
import com.coding.demo.mapper.StaffMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class SalaryService  {
	@Autowired
	public SalaryMapper salaryMapper;
	@Autowired
	public StaffMapper staffMapper;
	@Autowired
	private CheckingMapper  checkingMapper;
	public PageInfo<Salary> selectDetail(Integer page, Integer size){
		PageHelper.startPage(page,size);
		PageInfo<Salary> pageInfo = new PageInfo<Salary>(salaryMapper.selectDetail()); 
        return pageInfo;
    }
	public List<Salary> selectDetail(){
		return salaryMapper.selectDetail();
	}
	public PageInfo<Salary> selectByKey(String keywords,String salaryMonth,Integer page, Integer size) {
		PageHelper.startPage(page,size);
		System.out.println(salaryMonth);
		String judge = null;
		if(salaryMonth.equals("")) {
			salaryMonth="(null)";
			judge="or 'null'='null'";
		}else {
			judge="";
		}
		System.out.println(salaryMonth);
		List<Salary> salaryList=salaryMapper.selectByKey(keywords,salaryMonth,judge);
		PageInfo<Salary> pageInfo =new PageInfo<Salary>(salaryList);	    
		return pageInfo;
	}
	public PageInfo<Salary> clearMonth(String keywords,Integer page, Integer size) {
		PageHelper.startPage(page,size);
		List<Salary> salaryList=salaryMapper.clearMonth(keywords);
		PageInfo<Salary> pageInfo =new PageInfo<Salary>(salaryList);	    
		return pageInfo;
	}
	public List<Salary> view() {
		return salaryMapper.view();
	}
	public int amount() {
		return salaryMapper.amount();
	}
	public List<Salary> sameMonth(String salaryMonth) {
		return salaryMapper.sameMonth(salaryMonth);
	}
	public int countMonth(String salaryMonth) {
		return salaryMapper.countMonth(salaryMonth);
	}
	public int updateSalary() {
		String salaryMonth;
		double achievement,basicSalary=0,salary;
		Date nowDate = new Date();
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");				
		String now=dateFormat.format(nowDate);	
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		if(now.substring(8).equals("11")) {
			for(int i=0;i<salaryMapper.view().size();i++) {
				if(now.equals(salaryMapper.view().get(i).getSalaryMonth().format(fmt))) {
					return 0;
				}
			}
			salaryMonth=now;
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
		    Date date = new Date();
		    Calendar calendar = Calendar.getInstance();
		    calendar.setTime(date); // 设置为当前时间
		    calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1); // 设置为上一个月
		    date = calendar.getTime();     
		    String lastMonth = format.format(date);
		    int lastDayNum=calendar.getActualMaximum(Calendar.DAY_OF_MONTH);			
			for(int i=0;i<staffMapper.all().size();i++){
				String id=staffMapper.all().get(i).getId();
				String job=staffMapper.all().get(i).getJob();	
				int checkDay=checkingMapper.num(lastMonth+"-01",lastMonth+"-"+lastDayNum,id);
				if(checkDay==lastDayNum) {
					achievement=200;
				}
				else {
					achievement=0;
				}		
				if(job.equals("人事管理")) {
					basicSalary=9000;
				}
				else if(job.equals("财务管理")){
					basicSalary=8000;
		        }
		        else if(job.equals("铁路管理")){
		        	basicSalary=5500;
		        }
		        else if(job.equals("用户管理")){
		        	basicSalary=5500;
		        } 
		        else if(job.equals("普通职员")) {
		        	basicSalary=4000;
		        } 
				salary=basicSalary+achievement;
				salaryMapper.updateSalary(id, achievement, basicSalary, salary, salaryMonth);
			}
			return 1;
		}
		else {
			return 0;
		}
	}
	public int delete(String id) {
		Salary salary=new Salary();
		salary.setId(id);
		return salaryMapper.delete(salary);
	}
}
