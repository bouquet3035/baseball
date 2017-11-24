package org.bakara.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.bakara.dto.TeamRankDTO;

public interface TeamRankMapper {
	
	@Select("select * from tbl_teamrank order by rank")
	public List<TeamRankDTO> teamRank();   //ÆÀ¼øÀ§ 
 	

}
