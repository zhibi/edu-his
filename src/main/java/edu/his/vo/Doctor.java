package edu.his.vo;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 医生
 */
@Table(name = "doctor")
public class Doctor implements Serializable {
	@Id
	private Integer id;		    //id
	private String name;		//姓名
	private String card;		//证件号
	private String phone;	    //手机
	private String gender;		//性别
	private Integer age;		//年龄
	private String email;		//电子邮箱
	private String dep;		//科室
	private String major;       //
	private String remark;		//备注

	private String w1;
	private String w2;
	private String w3;
	private String w4;
	private String w5;
	private String w6;
	private String w7;

	public String getW1() {
		return w1;
	}

	public void setW1(String w1) {
		this.w1 = w1;
	}

	public String getW2() {
		return w2;
	}

	public void setW2(String w2) {
		this.w2 = w2;
	}

	public String getW3() {
		return w3;
	}

	public void setW3(String w3) {
		this.w3 = w3;
	}

	public String getW4() {
		return w4;
	}

	public void setW4(String w4) {
		this.w4 = w4;
	}

	public String getW5() {
		return w5;
	}

	public void setW5(String w5) {
		this.w5 = w5;
	}

	public String getW6() {
		return w6;
	}

	public void setW6(String w6) {
		this.w6 = w6;
	}

	public String getW7() {
		return w7;
	}

	public void setW7(String w7) {
		this.w7 = w7;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDep() {
		return dep;
	}

	public void setDep(String dep) {
		this.dep = dep;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
