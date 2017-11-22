package org.bakara.dto;

import java.sql.Date;

public class TeamNewsDTO {

	private int tno;
	
	private String teamname,url,title;
	private Date regdate;
	public int getTno() {
		return tno;
	}
	public void setTno(int tno) {
		this.tno = tno;
	}
	public String getTeamname() {
		return teamname;
	}
	public void setTeamname(String teamname) {
		this.teamname = teamname;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "TeamNewsDTO [tno=" + tno + ", teamname=" + teamname + ", url=" + url + ", title=" + title + ", regdate="
				+ regdate + "]";
	}


	
	
	
}
