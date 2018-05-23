package com.his.vo;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "personal")
public class Personal implements Serializable {


    @Id
    private Integer id;
    private String mask;
    private String name;
    private String sex;
    private String date;
    private String adress;
    private String telephone;
    private String btype;
    private String history;
    private String heighr;
    private String weight;
    private String d;
    private String act;
    private String result;

    private String sl;
    private String pf;
    private String xf;
    private String gp;
    private String fb;
    private String lbj;
    private String g;
    private String jzx;


    public String getSl() {
        return sl;
    }

    public void setSl(String sl) {
        this.sl = sl;
    }

    public String getPf() {
        return pf;
    }

    public void setPf(String pf) {
        this.pf = pf;
    }

    public String getXf() {
        return xf;
    }

    public void setXf(String xf) {
        this.xf = xf;
    }

    public String getGp() {
        return gp;
    }

    public void setGp(String gp) {
        this.gp = gp;
    }

    public String getFb() {
        return fb;
    }

    public void setFb(String fb) {
        this.fb = fb;
    }

    public String getLbj() {
        return lbj;
    }

    public void setLbj(String lbj) {
        this.lbj = lbj;
    }

    public String getG() {
        return g;
    }

    public void setG(String g) {
        this.g = g;
    }

    public String getJzx() {
        return jzx;
    }

    public void setJzx(String jzx) {
        this.jzx = jzx;
    }

    /**
     * 字段 列名 数据类型 描述
     * 1 Cmask Varchar(20) 身份证号码
     * 2 Cname  Varchar（5） 姓名
     * 3 Dsex Varchar（2） 性别
     * 4 Cdate Date 出生年月
     * 5 Cadress Varchar（30） 联系地址
     * 6 Ctelephone Int（11） 联系电话
     * 7 Cbtype Varchar（4） 血型
     * 8 Chistory Varchar（50） 药物过敏史
     * 9 Cheighr height（3，2） 身高
     * 10 Cweight weight（3,1） 体重
     * <p>
     * 12 Cd Date 诊断时间
     * 13 Cact Varchar（50） 病况
     * 14 Cresult Varchar（50） 诊断结果
     */



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMask() {
        return mask;
    }

    public void setMask(String mask) {
        this.mask = mask;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getBtype() {
        return btype;
    }

    public void setBtype(String btype) {
        this.btype = btype;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getHeighr() {
        return heighr;
    }

    public void setHeighr(String heighr) {
        this.heighr = heighr;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public String getAct() {
        return act;
    }

    public void setAct(String act) {
        this.act = act;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
