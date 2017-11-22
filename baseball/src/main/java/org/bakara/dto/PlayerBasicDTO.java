package org.bakara.dto;

import lombok.Data;

@Data
public class PlayerBasicDTO {
	
	private String playerName, position, hnW, school, initPayment, salary, pickUpRank, joined;
	private Long playerNum;
	private String birthday;

}
