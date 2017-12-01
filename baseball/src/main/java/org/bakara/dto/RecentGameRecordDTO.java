package org.bakara.dto;

import lombok.Data;

@Data
public class RecentGameRecordDTO {

	// 선수와 매칭을 위해 필요한 변수
	private String playerName;
	private String playerNum;

	private String gameDate, versus;
	
	private String avg, ab, r, h, twob, threeb, hr, rbi, sb, cs, bb, hbp, so, gdp;
	
	private String result;
	private String era, tbf;
	private String ip;
	private String er;
	
}
