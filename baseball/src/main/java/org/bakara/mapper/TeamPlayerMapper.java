package org.bakara.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.bakara.dto.TeamPlayerDTO;
import org.bakara.dto.TeamRecordDTO;


public interface TeamPlayerMapper {
	

	@Insert("insert into tbl_teamplayer (playerNum,playerName,teamName,position,birthday,HnW,school) values(#{playerNum},#{playerName},#{teamName},"
			+ " #{position},#{birthday},#{hnW},#{school})")
	public void registerTeamPlayer(TeamPlayerDTO dto);
	
	@Update("UPDATE tbl_teamplayer SET playerimg=#{playerImg} WHERE playernum=#{playerNum} AND playerName=#{playerName};")
	public void registerPlayerImg(TeamPlayerDTO dto);
	
	@Delete("delete from tbl_teamplayer")
	public void resetTeamPlayers();

	
		
}
