package org.bakara.dto;

import lombok.Data;

@Data
public class RecentGameRecordDTO {

	// ������ ��Ī�� ���� �ʿ��� ����
	private String playerName;
	private String playerNum;

	private String gameDate, versus;
	
	private String avg, ab, r, h, twob, threeb, hr, rbi, sb, cs, bb, hbp, so, gdp;
	
	private String result;
	private String era, tbf;
	private String ip;
	private String er;
	
}
