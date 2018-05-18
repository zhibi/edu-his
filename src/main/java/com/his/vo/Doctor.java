package com.his.vo;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * ҽ��
 */
@Table(name = "doctor")
public class Doctor implements Serializable {
	@Id
	private Integer id;		    //id
	private String name;		//����
	private String card;		//֤����
	private String phone;	    //�ֻ�
	private String gender;		//�Ա�
	private Integer age;		//����
	private String email;		//��������
	private String dep;		//����
	private String major;       //
	private String remark;		//��ע


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
