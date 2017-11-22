package org.bakara.dto;

import lombok.Data;

@Data
public class BasicYearRecordDTO {
	
	//선수와 매칭을 위해 필요한 변수
	private String teamName, playerName;
	private Double playerNum;
	
	//타자용 변수 + 일부 투수도 쓰는 변수 있음
	private Double avg, g, pa, ab, r, h, twob, threeb, hr, tb, rbi, sb, cs, sac, sf;
	private Double bb, ibb, hbp, so, gdp, slg, obp, e, sbpercent, mh, ops, risp, phba;
	
	//투수용 변수
	private Double era, cg, sho, w, l, sv, hld, wpct, tbf, np;
	//9 1/3 같은 식으로 들어가서 String으로 할 필요가 있는 변수
	private String ip;
	private Double wp, bk, er, bsv, whip, qs;

}
