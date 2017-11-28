package org.bakara.mapper;

import org.apache.ibatis.annotations.Delete;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.bakara.dto.BasicYearRecordDTO;
import org.bakara.dto.PlayerBasicDTO;
import org.bakara.dto.TeamPlayerDTO;
import org.bakara.dto.TeamRecordDTO;


public interface TeamPlayerMapper {
	

	@Insert("insert into tbl_teamplayer (playerName, playerImg, position, hnW, school, initPayment, salary, pickUpRank, joined,playerNum,birthday,teamName)"
			+ "values(#{playerName}, #{playerImg},#{position}, #{hnW}, #{school}, #{initPayment}, #{salary}, #{pickUpRank}, "
			+ "#{joined},#{playerNum},#{birthday},#{teamName})")
	public void registerTeamPlayer(PlayerBasicDTO dto);
	
	@Update("UPDATE tbl_teamplayer SET playerimg=#{playerImg} WHERE playernum=#{playerNum} AND playerName=#{playerName}")
	public void registerPlayerImg(TeamPlayerDTO dto);
	
	@Delete("delete from tbl_teamplayer")
	public void resetTeamPlayers();
	 
	@Select("select * from tbl_teamplayer")  //���� ������ �ѷ��ֱ����� 
	public List<TeamPlayerDTO> selectTeamPlayer(String teamname) ; 
	
	
	
	
//	
//	//���� �ظ��� ������� 
//	@Insert("insert into tbl_basicyearrecord(teamName,playerName,playerNum,era)"
//			+ "values(#{teamName},#{playerName},#{playerNum},#{era})")
//	public void registerBasicYearRecord(BasicYearRecordDTO basicYearRecordDTO)  ; 	//���� �ظ��� ������� 
	
	@Delete("delete from tbl_basicyearrecord")
	public void resetBasicYearRecord();
	
	
	//Ÿ�� �ظ��� ������� 
	@Insert("insert into tbl_basicyearrecord(teamName,playerName,playerNum,position,avg, g, pa,ab,r,h,twob,threeb,hr,tb,rbi,sb,cs,sac,sf)"
			+ "values(#{teamName},#{playerName},#{playerNum},#{position},#{avg},#{g},#{pa},#{ab},#{r},#{h},#{twob},#{threeb},#{hr},#{tb},"
			+ "#{rbi},#{sb},#{cs},#{sac},#{sf})")
	public void registerBasicYearRecordTaja(BasicYearRecordDTO dto)  ; 	//Ÿ�� �ظ��� ������� - ���̺� 1   
	
	

			
	//���� �ظ��� ������� 
	@Insert("insert into tbl_basicyearrecord(teamName,playerName,playerNum,position , era, g, cg, sho,w,l,sv,hld,wpct,tbf,np,ip,h,"
			+ "twob,threeb,hr)"
			+ "values(#{teamName},#{playerName},#{playerNum},#{position},#{era},#{g},#{cg},#{sho},#{w},#{l},#{sv},#{hld},#{wpct},#{tbf},#{np},#{ip},"
			+ "#{h},#{twob},#{threeb},#{hr})")
	public void registerBasicYearRecordTusu(BasicYearRecordDTO dto)  ; 	//���� �ظ��� ������� - ���̺� 1   
	

//	@Insert("insert into tbl_basicyearrecord(sac)"
//			+ "values(#{sac})")
//	public void registerBasicYearRecord2(BasicYearRecordDTO dto) ;	//���� �ظ��� ������� - ���̺� 2 
//	

		
}
