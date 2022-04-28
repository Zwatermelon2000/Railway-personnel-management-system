package com.coding.demo.mapper;
import com.coding.demo.entity.Salary;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
@Repository
@Mapper
public interface SalaryMapper extends tk.mybatis.mapper.common.Mapper<Salary> {
	@Select("select * from t_salary ts,t_staff tm where ts.id=tm.id")
    List<Salary> selectDetail();
	@Select("select * from t_salary ts,t_staff tm where (ts.id=tm.id) and (ts.id like '%${keywords}%' or tm.name like '%${keywords}%') and (salaryMonth in ${salaryMonth} ${judge})") //salaryMonth ='${state}' and salaryMonth ='${state1}' or '${state}'=''
    List<Salary> selectByKey(String keywords,String salaryMonth,String judge);
	@Select("select * from t_salary ts,t_staff tm where (ts.id=tm.id) and (ts.id like '%${keywords}%' or tm.name like '%${keywords}%') ")
    List<Salary> clearMonth(String keywords);
    @Select("select distinct salaryMonth from t_salary")
    List<Salary> view();
    @Select("select count(distinct salaryMonth) from t_salary")
    int amount();
    @Select("select * from t_salary ts,t_staff tm where (ts.id=tm.id) and (salaryMonth ='${salaryMonth}') ")
    List<Salary> sameMonth(String salaryMonth);
    @Select("select COUNT(*) from t_salary ts,t_staff tm where (ts.id=tm.id) and (salaryMonth ='${salaryMonth}')")
    int countMonth(String salaryMonth);
    @Select("Insert into t_salary values('${id}','${achievement}','${basicSalary}','${salary}','${salaryMonth}')")
    void updateSalary(String id,double achievement,double basicSalary,double salary,String salaryMonth );
}
