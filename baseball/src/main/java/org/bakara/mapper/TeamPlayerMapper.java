package org.bakara.mapper;

import org.apache.ibatis.annotations.Delete;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.bakara.dto.BasicYearRecordDTO;
import org.bakara.dto.Criteria;
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
	 
	@Select("select * from tbl_teamplayer where teamname = #{teamname}  limit 10")  //���� ������ �ѷ��ֱ����� 
	public List<TeamPlayerDTO> selectTeamPlayer(String teamname) ; 
	
	@Select("select * from tbl_basicyearrecord  where teamname=#{teamname}")  //���� ������ �ѷ��ֱ����� 
	public List<BasicYearRecordDTO> selectBasicYearRecord(String teamname) ; 
	
	
	//������ ó�� 
	
	@Select("select * from tbl_basicyearrecord where bno > 0 order by bno desc limit #{page} , 10 " )
	public List<BasicYearRecordDTO> listpage (int page) ;
	
	@Select("select * from tbl_basicyearrecord where bno > 0 order by bno desc limit #{pageStart} , #{perPageNum} " )
	public List<BasicYearRecordDTO> listCriteria (Criteria cri) ; 
//	
//	//���� �ظ��� ������� 
//	@Insert("insert into tbl_basicyearrecord(teamName,playerName,playerNum,era)"
//			+ "values(#{teamName},#{playerName},#{playerNum},#{era})")
//	public void registerBasicYearRecord(BasicYearRecordDTO basicYearRecordDTO)  ; 	//���� �ظ��� ������� 
	
	@Delete("delete from tbl_basicyearrecord")
	public void resetBasicYearRecord();
	
	
	//Ÿ�� �ظ��� ������� 
	@Insert("insert into tbl_basicyearrecord(teamname,playerName,playerNum,position,avg, g, pa,ab,r,h,twob,threeb,hr,tb,rbi,sb,cs,sac,sf)"
			+ "values(#{teamname},#{playerName},#{playerNum},#{position},#{avg},#{g},#{pa},#{ab},#{r},#{h},#{twob},#{threeb},#{hr},#{tb},"
			+ "#{rbi},#{sb},#{cs},#{sac},#{sf})")
	public void registerBasicYearRecordTaja(BasicYearRecordDTO dto)  ; 	//Ÿ�� �ظ��� ������� - ���̺� 1   
	
	

			
	//���� �ظ��� ������� 
	@Insert("insert into tbl_basicyearrecord(teamname,playerName,playerNum,position , era, g, cg, sho,w,l,sv,hld,wpct,tbf,np,ip,h,"
			+ "twob,threeb,hr)"
			+ "values(#{teamname},#{playerName},#{playerNum},#{position},#{era},#{g},#{cg},#{sho},#{w},#{l},#{sv},#{hld},#{wpct},#{tbf},#{np},#{ip},"
			+ "#{h},#{twob},#{threeb},#{hr})")
	public void registerBasicYearRecordTusu(BasicYearRecordDTO dto)  ; 	//���� �ظ��� ������� - ���̺� 1   
	

//	@Insert("insert into tbl_basicyearrecord(sac)"
//			+ "values(#{sac})")
//	public void registerBasicYearRecord2(BasicYearRecordDTO dto) ;	//���� �ظ��� ������� - ���̺� 2 
//	

		
}
