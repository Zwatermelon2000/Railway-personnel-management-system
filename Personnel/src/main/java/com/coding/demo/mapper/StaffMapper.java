package com.coding.demo.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import com.coding.demo.entity.Staff;
import tk.mybatis.mapper.common.Mapper;
@Repository
public interface StaffMapper extends Mapper<Staff> {  
	@Select("select * from t_staff where id='${id}' ")
    Staff selectIndividual(String id);
	@Select("select *,(select COUNT(*) from t_checking where id=t_staff.id and date between '${date}-1' and '${date}-30') as attendance from t_staff where state='在职' ")
	List<Staff> getAll(String date);
	@Select("select *,(select COUNT(*) from t_checking where id=t_staff.id and date between '${date}-1' and '${date}-30') as attendance from t_staff")
	List<Staff> addAll(String date);
    @Select("select *,(select COUNT(*) from t_checking where id=t_staff.id and date between '${date}-1' and '${date}-30') as attendance from t_staff where (id like '%${keywords}%' or '%${keywords}%'=''or name like '%${keywords}%') and (job ='${job}' or '${job}'='') and state='在职' ")
    List<Staff> selectByKey(String keywords,String job,String date);
    @Select("select id,name,idCard,job,sex,phone,mail,card,address from t_staff where id ='${id}'")
    Staff selectDetail(String id);
    @Select("select id,name,idCard,job,sex,phone,mail,card,address,birthday,(select COUNT(*) from t_checking where id=t_staff.id and date between '${date}-1' and '${date}-30') as attendance from t_staff where id ='${id}'")
    Staff view(String id,String date);
    @Update("update t_staff set name='${name}',sex='${sex}',idCard='${idCard}',phone='${phone}',address='${address}',mail='${mail}',job='${job}',card='${card}' where id='${id}' ")
    int revise(String id,String name,String sex,String idCard,String phone,String address,String mail,String job,String card);    
    @Select("update t_staff set password='${newPassword}' where id='${id}' and password='${oldPassword}'")
    String changePassword(String id,String newPassword,String oldPassword);
    @Select("select * from t_staff where state='在职' ")
	List<Staff> all();
    @Update("update t_staff set state='离职' where id='${id}'")
    int deleteStaff(String id);
}
