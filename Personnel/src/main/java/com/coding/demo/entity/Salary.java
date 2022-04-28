package com.coding.demo.entity;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;
@Table(name ="t_salary")
public class Salary implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name="id")
    private String id;
    @Column(name="achievement")
    private BigDecimal achievement;
    @Column(name="basicSalary")
    private BigDecimal basicSalary;
    @Column(name="salary")
    private BigDecimal salary;
    @Column(name="salaryMonth")
    private LocalDate salaryMonth;
    private String name;
    private String sex;
    private String phone;
    private String mail;
    private String card;
    public String getCard() {
		return card;
	}
	public void setIdCard(String card) {
		this.card = card;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
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
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public BigDecimal getAchievement() {
        return achievement;
    }
    public void setAchievement(BigDecimal achievement) {
        this.achievement = achievement;
    }
    public BigDecimal getBasicSalary() {
        return basicSalary;
    }
    public void setBasicSalary(BigDecimal basicSalary) {
        this.basicSalary = basicSalary;
    }
    public BigDecimal getSalary() {
        return salary;
    }
    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
    public LocalDate getSalaryMonth() {
        return salaryMonth;
    }
    public void setSalaryMonth(LocalDate salaryMonth) {
        this.salaryMonth = salaryMonth;
    }
    @Override
    public String toString() {
        return "Salary{" +
            "id=" + id +
            "achievement=" + achievement +
            "basicSalary=" + basicSalary +
            ", salary=" + salary +
            ", salaryMonth=" + salaryMonth +
        "}";
    }
}
