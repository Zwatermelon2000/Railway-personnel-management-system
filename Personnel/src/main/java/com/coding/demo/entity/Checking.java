package com.coding.demo.entity;
import javax.persistence.Column;
import javax.persistence.Table;
@Table(name="t_checking")
public class Checking{
	@Column(name="id")
    private String id;
	@Column(name="date")
    private String date;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    @Override
    public String toString() {
        return "Checking{" +
            "id=" + id +
            ", date=" + date +
        "}";
    }
}
