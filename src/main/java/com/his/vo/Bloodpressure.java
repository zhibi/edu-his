package com.his.vo;
/**
 * ÑªÑ¹ÐÅÏ¢
 * @author zuoan
 *
 */

public class Bloodpressure {
	private int id;
	private String pname;
	private String cjtime;
	private String sfzid;
	private String Pulses;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getCjtime() {
		return cjtime;
	}
	public void setCjtime(String cjtime) {
		this.cjtime = cjtime;
	}
	public String getSfzid() {
		return sfzid;
	}
	public void setSfzid(String sfzid) {
		this.sfzid = sfzid;
	}
	public String getPulses() {
		return Pulses;
	}
	public void setPulses(String pulses) {
		Pulses = pulses;
	}
	@Override
	public String toString() {
		return "bloodpressure [id=" + id + ", pname=" + pname + ", cjtime=" + cjtime + ", sfzid=" + sfzid + ", Pulses="
				+ Pulses + "]";
	} 
	
	public Bloodpressure() {
		super();
		// TODO Auto-generated constructor stub
	}

}
