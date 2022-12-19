package com.spring.bean;

import java.util.List;

/**
 * @author bin
 * @date 2022-12-12-16:15
 */
public class Clazz {
    private Integer Cid;
    private String cname;

    private List<Student> student;

    public Clazz() {
    }

    public Clazz(Integer cid, String cname) {
        Cid = cid;
        this.cname = cname;
    }

    public Clazz(Integer cid, String cname, List<Student> student) {
        Cid = cid;
        this.cname = cname;
        this.student = student;
    }

    public Integer getCid() {
        return Cid;
    }

    public void setCid(Integer cid) {
        Cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "Cid=" + Cid +
                ", cname='" + cname + '\'' +
                ", student=" + student +
                '}';
    }
}
