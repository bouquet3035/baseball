package org.bakara.dto;

import lombok.Data;

@Data
public class BasicYearRecordDTO {
	
	//������ ��Ī�� ���� �ʿ��� ����
	private String teamname, playerName;
	private String playerNum ,position;
	
	//Ÿ�ڿ� ���� + �Ϻ� ������ ���� ���� ����
	private String avg, g, pa, ab, r, h, twob, threeb, hr, tb, rbi, sb, cs, sac, sf;
	private String bb, ibb, hbp, so, gdp, slg, obp, e, sbpercent, mh, ops, risp, phba;
	
	//������ ����
	private String era, cg, sho, w, l, sv, hld, wpct, tbf, np;
	//9 1/3 ���� ������ ���� String���� �� �ʿ䰡 �ִ� ����
	private String ip;
	private String wp, bk, er, bsv, whip, qs;

	
}
