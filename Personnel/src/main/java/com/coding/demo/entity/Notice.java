package com.coding.demo.entity;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Table;
@Table(name="t_notice")
public class Notice{
    @Column(name="notice")
    private String notice;
    @Column(name="date")
    private Date date;
    @Column(name="person")
    private String person;
    @Column(name="title")
    private String title;
    @Column(name="id")
    private String id;
    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNotice() {
        return notice;
    }
    public void setNotice(String notice) {
        this.notice = notice;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public String getPerson() {
        return person;
    }
    public void setPerson(String person) {
        this.person = person;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    @Override
    public String toString() {
        return "Notice{" +
            "notice=" + notice +
            ", date=" + date +
            ", person=" + person +
            ", title=" + title +
            ", id=" + id +
        "}";
    }
}
