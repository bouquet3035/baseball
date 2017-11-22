package org.bakara.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.bakara.dto.TeamPlayerDTO;
import org.bakara.dto.TeamRecordDTO;


public interface TeamPlayerMapper {
	

	@Insert("insert into tbl_teamplayer (playerNum,playerName,teamName,position,birthday,HnW,school) values(#{playerNum},#{playerName},#{teamName},"
			+ " #{position},#{birthday},#{hnW},#{school})")
	public void registerTeamPlayer(TeamPlayerDTO dto);
	 
	@Select("select * from tbl_teamplayer")  //선수 정보를 뿌려주기위한 
	public List<TeamPlayerDTO> selectTeamPlayer() ; 

		
}
