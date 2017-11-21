package org.bakara.mapper;

import org.apache.ibatis.annotations.Insert;
import org.bakara.dto.TeamPlayerDTO;


public interface TeamPlayerMapper {
	

	@Insert("insert into tbl_teamplayer (playerNum,playerName,teamName,position,birthday,HnW,school) values(#{playerNum},#{playerName},#{teamName},"
			+ " #{position},#{birthday},#{hnW},#{school})")
	public void registerTeamPlayer( TeamPlayerDTO dto);


}
