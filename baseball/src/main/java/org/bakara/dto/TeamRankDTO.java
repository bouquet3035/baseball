package org.bakara.dto;

import lombok.Data;

@Data
public class TeamRankDTO {
	
	int rank ;				//순위 	  
	String teamname;		//팀이름  
	int game; 				//총 게임한 횟수
	int victory ; 			//승리한 횟수 
	int lose; 				//패 한 횟수
	int draw; 				// 무승부 한 횟수
	Long gameodds; 			// 승률
	String gamecar ; 		// 게임차 
	String recentgames;		// 최근 10경기 
	String continuity;		//연속 
	String home ; 			// 홈 
	String visiting; 		// 방문 
	

}
