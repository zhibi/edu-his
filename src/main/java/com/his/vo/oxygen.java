package com.his.vo;

public class oxygen {
	private int pid;
	private String pname;
	private String cjtime;
	private String sfzId;
	private String Bloodoxygen;
	
	
	public int getPid() {
		return pid;
	}


	public void setPid(int pid) {
		this.pid = pid;
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


	public String getSfzId() {
		return sfzId;
	}


	public void setSfzId(String sfzId) {
		this.sfzId = sfzId;
	}


	public String getBloodoxygen() {
		return Bloodoxygen;
	}


	public void setBloodoxygen(String bloodoxygen) {
		Bloodoxygen = bloodoxygen;
	}


	@Override
	public String toString() {
		return "oxygen [pid=" + pid + ", pname=" + pname + ", cjtime=" + cjtime + ", sfzId=" + sfzId + ", Bloodoxygen="
				+ Bloodoxygen + "]";
	}


	public oxygen() {
		super();
		// TODO Auto-generated constructor stub
	}
}
