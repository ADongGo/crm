package cn.offcn.entity;

import java.util.Date;
import java.util.List;

public class Evaluate {
    private Integer evaid;

    private Integer forumfk;

    private Integer empfk;

    private Integer evaidfk;

    private Date updatetime;

    private Date evatime;

    private Integer evastatus;

    private String evacontent;

    private Employee employee;

    private Employee employee2;

    public Employee getEmployee2() {
        return employee2;
    }

    public void setEmployee2(Employee employee2) {
        this.employee2 = employee2;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Integer getEvaid() {
        return evaid;
    }

    public void setEvaid(Integer evaid) {
        this.evaid = evaid;
    }

    public Integer getForumfk() {
        return forumfk;
    }

    public void setForumfk(Integer forumfk) {
        this.forumfk = forumfk;
    }

    public Integer getEmpfk() {
        return empfk;
    }

    public void setEmpfk(Integer empfk) {
        this.empfk = empfk;
    }

    public Integer getEvaidfk() {
        return evaidfk;
    }

    public void setEvaidfk(Integer evaidfk) {
        this.evaidfk = evaidfk;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Date getEvatime() {
        return evatime;
    }

    public void setEvatime(Date evatime) {
        this.evatime = evatime;
    }

    public Integer getEvastatus() {
        return evastatus;
    }

    public void setEvastatus(Integer evastatus) {
        this.evastatus = evastatus;
    }

    public String getEvacontent() {
        return evacontent;
    }

    public void setEvacontent(String evacontent) {
        this.evacontent = evacontent == null ? null : evacontent.trim();
    }
}