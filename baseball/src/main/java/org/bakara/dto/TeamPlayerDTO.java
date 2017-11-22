package org.bakara.dto;

import java.util.Date;

import lombok.Data;

@Data
public class TeamPlayerDTO {
	  
	private Long playerNum; 		//등번호 
	private String playerImg;		//프로필 이미지
	private String playerName;		//선수명
	private String teamName;		//팀명 
	private String position;		//포지션 
	private String birthday;		//생년월일
	private String hnW;				//체격
	private String school;			//출신교 

}
