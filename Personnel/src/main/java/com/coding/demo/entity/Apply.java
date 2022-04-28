package com.coding.demo.entity;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Table;
@Table(name="t_apply")
public class Apply{
	@Column(name="id")
	private String id;
	@Column(name="name")
    private String name;
	@Column(name="firstFile")
    private String firstFile;
    @Column(name="endFile")
    private String endFile;
    @Column(name="isPass")
    private Integer isPass;
    @Column(name="date")
    private Date date;
    public String getFirstFile() {
        return firstFile;
    }
    public void setFirstFile(String firstFile) {
        this.firstFile = firstFile;
    }
    public String getEndFile() {
        return endFile;
    }
    public void setEndFile(String endFile) {
        this.endFile = endFile;
    }
    public Integer getIsPass() {
        return isPass;
    }
    public void setIsPass(Integer isPass) {
        this.isPass = isPass;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    @Override
    public String toString() {
        return "Apply{" +
            "firstFile=" + firstFile +
            ", endFile=" + endFile +
            ", isPass=" + isPass +
            ", date=" + date +
            ", id=" + id +
            ", name=" + name +
        "}";
    }
}
