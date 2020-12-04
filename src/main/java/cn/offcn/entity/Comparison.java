package cn.offcn.entity;

public class Comparison {
    private Integer cid;

    private String company;

    private Double turnonver;

    private Double targetmoney;

    private String plan;

    private String disparity;

    private Integer empFk;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public Double getTurnonver() {
        return turnonver;
    }

    public void setTurnonver(Double turnonver) {
        this.turnonver = turnonver;
    }

    public Double getTargetmoney() {
        return targetmoney;
    }

    public void setTargetmoney(Double targetmoney) {
        this.targetmoney = targetmoney;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan == null ? null : plan.trim();
    }

    public String getDisparity() {
        return disparity;
    }

    public void setDisparity(String disparity) {
        this.disparity = disparity == null ? null : disparity.trim();
    }

    public Integer getEmpFk() {
        return empFk;
    }

    public void setEmpFk(Integer empFk) {
        this.empFk = empFk;
    }
}