package com.coding.demo.service;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.coding.demo.entity.Staff;
import com.coding.demo.mapper.StaffMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class StaffService {
	@Autowired
	public StaffMapper staffMapper;
	public String date() {
		Date date = new Date();
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM");		
		String str=dateFormat.format(date);	
		return str;
	}
	public Staff selectIndividual(String id) {
		if(staffMapper.selectIndividual(id)==null) {
			return null;
		}else {
			return staffMapper.selectIndividual(id);
		}
	}
    public int add(Staff staff){
        return staffMapper.insertSelective(staff);
    }
	public int delete(String id){
        return staffMapper.deleteStaff(id);
    }
	public PageInfo<Staff> getAll(Integer page, Integer size){
		PageHelper.startPage(page,size);
		PageInfo<Staff> pageInfo = new PageInfo<Staff>(staffMapper.getAll(date())); 
        return pageInfo;
    }
	public List<Staff> getAll(){
        return staffMapper.getAll(date());
    }
	public List<Staff> selectAll(){
        return staffMapper.addAll(date());
    }
	public Staff showDetail(String id) {
		return staffMapper.selectDetail(id);
	}
	public int update(String id,String name,String sex,String idCard,String phone,String address,String mail,String job,String card) {
		return staffMapper.revise(id,name,sex,idCard,phone,address,mail,job,card);
	}
	public Staff view(String id) {
		return staffMapper.view(id,date());
	}	
	public PageInfo<Staff> selectByKey(String keywords,String job,Integer page, Integer size) {
		PageHelper.startPage(page,size);
		List<Staff> staffList=staffMapper.selectByKey(keywords,job,date()) ;
		PageInfo<Staff> pageInfo =new PageInfo<Staff>(staffList) ;
        if(job.equals("全部")) {
        	job="";        
        	staffList=staffMapper.selectByKey(keywords,job,date());
        	pageInfo =new PageInfo<Staff>(staffList);            
            return pageInfo;	
        }
			return pageInfo;
	}
	public String changePassword(String id,String newPassword,String oldPassword) {
		return staffMapper.changePassword(id,newPassword,oldPassword);
	}		
}
