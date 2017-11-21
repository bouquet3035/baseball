package org.bakara.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.bakara.dto.TeamPlayerDTO;
import org.bakara.dto.TeamPlayerRecordDTO;


public interface TeamPlayerMapper {
	

	@Insert("insert into tbl_teamplayer (playerNum,playerName,teamName,position,birthday,HnW,school) values(#{playerNum},#{playerName},#{teamName},"
			+ " #{position},#{birthday},#{hnW},#{school})")
	public void registerTeamPlayer(TeamPlayerDTO dto);
	
	@Select("select * from tbl_teamrecord")
	public void teamPlayerRecord(TeamPlayerRecordDTO dto)  ;
	

	
}
