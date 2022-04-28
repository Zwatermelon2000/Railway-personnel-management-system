package com.coding.demo.entity;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Table;
@Table(name="t_staff")
public class Staff {
	@Column(name="id")
    private String id;
	@Column(name="password")
    private String password;
	@Column(name="name")
    private String name;
	@Column(name="sex")
    private String sex;
	@Column(name="idCard")
    private String idCard;
	@Column(name="phone")
    private String phone;
	@Column(name="address")
    private String address;
	@Column(name="birthday")
    private Date birthday;
	@Column(name="mail")
    private String mail;
	@Column(name="job")
    private String job;
	@Column(name="card")
    private String card;
	@Column(name="state")
    private String state;
	private Integer attendance;
	public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getIdCard() {
        return idCard;
    }
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public String getJob() {
        return job;
    }
    public void setJob(String job) {
        this.job = job;
    }
    public String getCard() {
        return card;
    }
    public void setCard(String card) {
        this.card = card;
    }
    public Integer getAttendance() {
        return attendance;
    }
    public void setAttendance(Integer attendance) {
        this.attendance = attendance;
    }
    public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
    @Override
    public String toString() {
        return "Staff{" +
            "id=" + id +
            ", password=" + password +
            ", name=" + name +
            ", sex=" + sex +
            ", idCard=" + idCard +
            ", phone=" + phone +
            ", address=" + address +
            ", birthday=" + birthday +
            ", mail=" + mail +
            ", job=" + job +
            ", card=" + card +
            ", attendance=" + attendance +
        "}";
    }
}
