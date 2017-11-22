package org.bakara.dto;

import java.util.Date;

import lombok.Data;

@Data
public class TeamPlayerDTO {
	
	private Long playerNum;
	private String playerImg;
	private String playerName;
	private String teamName;
	private String position;
	private String birthday;
	private String hnW;
	private String school;

}
