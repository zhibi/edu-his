package com.his.vo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name = "info")
public class Info implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;		    //id
    private Integer userid;
    private Date addtime;
    private Integer pulse;//Âö²«
    private Integer blood1;//µÍÑªÑ¹
    private Integer blood2;//¸ßÑªÑ¹
    private Integer heart;//ÐÄÂÊ

    @Transient
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public Integer getPulse() {
        return pulse;
    }

    public void setPulse(Integer pulse) {
        this.pulse = pulse;
    }

    public Integer getBlood1() {
        return blood1;
    }

    public void setBlood1(Integer blood1) {
        this.blood1 = blood1;
    }

    public Integer getBlood2() {
        return blood2;
    }

    public void setBlood2(Integer blood2) {
        this.blood2 = blood2;
    }

    public Integer getHeart() {
        return heart;
    }

    public void setHeart(Integer heart) {
        this.heart = heart;
    }


}
