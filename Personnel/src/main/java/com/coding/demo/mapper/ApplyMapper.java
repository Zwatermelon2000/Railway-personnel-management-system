package com.coding.demo.mapper;
import com.coding.demo.entity.Apply;
import tk.mybatis.mapper.common.Mapper;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
@Repository
public interface ApplyMapper extends Mapper<Apply> {
	@Insert("insert into t_apply (firstFile,id,date,endFile,name,isPass) VALUES ('${firstFile}','${id}','${date}','${endFile}','${name}',0) ON duplicate KEY UPDATE firstFile = firstFile")
	void insertFile(String firstFile,String id,String date,String endFile,String name);
	@Update("update t_apply set isPass=${isPass} where id='${id}'")
	int isPass(String id,int isPass);
	@Select("select * from t_apply where id='${id}'")
	Apply showPDF(String id);
	@Select("select * from t_apply where isPass=${isPass}")
	List<Apply> all(int isPass);
}
