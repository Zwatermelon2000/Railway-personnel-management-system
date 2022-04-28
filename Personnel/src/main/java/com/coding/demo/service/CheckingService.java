package com.coding.demo.service;
import com.coding.demo.entity.Checking;
import com.coding.demo.mapper.CheckingMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CheckingService{
	@Autowired
	private CheckingMapper  checkingMapper;
	public int insert(String id,String date) {
		List<Checking> checkDate=selectAll(id);
		Checking checking = new Checking();		
		for(int i=0;i<selectCount(id);i++) {
			if(checkDate.get(i).getDate().equals(date)) {
				return 0;				
			}							
		}
		checking.setId(id);
		checking.setDate(date);
		return checkingMapper.insert(checking);
	}
	public List<Checking> selectAll(String id) {
		return checkingMapper.selectDate(id);
	}
	public int selectCount(String id) {
		return checkingMapper.selectDate(id).size();
	}
}
