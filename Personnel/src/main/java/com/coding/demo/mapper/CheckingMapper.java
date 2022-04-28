package com.coding.demo.mapper;
import com.coding.demo.entity.Checking;
import tk.mybatis.mapper.common.Mapper;
import java.util.List;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
@Repository
public interface CheckingMapper extends Mapper<Checking> {
	@Select("select date from t_checking where id='${id}'")
	List<Checking> selectDate(String id);
	@Select("select Count(*) from t_checking where id='${id}' and (date between '${initial}' and '${end}')")
	int num(String initial,String end,String id);
}