package cn.offcn.entity;

public class Level {
    private Integer jid;

    private String jname;

    private String jdis;

    public Integer getJid() {
        return jid;
    }

    public void setJid(Integer jid) {
        this.jid = jid;
    }

    public String getJname() {
        return jname;
    }

    public void setJname(String jname) {
        this.jname = jname == null ? null : jname.trim();
    }

    public String getJdis() {
        return jdis;
    }

    public void setJdis(String jdis) {
        this.jdis = jdis == null ? null : jdis.trim();
    }
}