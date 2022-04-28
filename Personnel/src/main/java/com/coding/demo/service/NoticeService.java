package com.coding.demo.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.coding.demo.entity.Notice;
import com.coding.demo.mapper.NoticeMapper;
@Service
public class NoticeService{
	@Autowired
	public NoticeMapper noticeMapper;
	public int publish(String title,String notice,String time,String person) {
		String id;
		if(noticeMapper.selectAll().size()==0) {
			id="100001";
		}
		else {
			id=String.valueOf(Integer.valueOf(noticeMapper.selectAll().get(noticeMapper.selectAll().size()-1).getId())+1);
		}
		return noticeMapper.insertNotice(title, notice, time, person, id);
	}
	public List<Notice> selectAll() {
		return noticeMapper.all();
	}
	public int delete(Notice notice) {
		return noticeMapper.delete(notice);
	}
}
