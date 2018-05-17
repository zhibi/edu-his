package com.his.vo;

public class pulse {
	private int id;
	private String pname;
	private String cjtime;
	private String sfzid;
	private String pulse;
	
	
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


	public String getPulse() {
		return pulse;
	}


	public void setPulse(String pulse) {
		this.pulse = pulse;
	}


	@Override
	public String toString() {
		return "pulse [id=" + id + ", pname=" + pname + ", cjtime=" + cjtime + ", sfzid=" + sfzid + ", pulse=" + pulse
				+ "]";
	}


	public pulse() {
		super();
		// TODO Auto-generated constructor stub
	}
}
