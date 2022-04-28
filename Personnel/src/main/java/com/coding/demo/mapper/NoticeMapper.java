package com.coding.demo.mapper;
import com.coding.demo.entity.Notice;
import tk.mybatis.mapper.common.Mapper;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
@Repository
public interface NoticeMapper extends Mapper<Notice> {
	@Insert("insert into t_notice (id,title,person,notice,date) values('${id}','${title}','${person}','${notice}','${date}')")
	int insertNotice(String title,String notice,String date,String person,String id);
	@Select("select * from t_notice order by date desc")
	List<Notice> all();
}
