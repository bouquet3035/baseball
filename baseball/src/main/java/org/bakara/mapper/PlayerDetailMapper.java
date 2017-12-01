package org.bakara.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.bakara.dto.BasicYearRecordDTO;
import org.bakara.dto.TeamNewsDTO;
import org.bakara.dto.TeamPlayerDTO;

public interface PlayerDetailMapper {
	
	@Select("select *  from tbl_teamplayer where playerName = #{playerName}")  
	public TeamPlayerDTO playerdetail (String playerName);
	
	@Select("select * "
			+ "from tbl_basicyearrecord "
			+ "where playername = #{playername}")
	public BasicYearRecordDTO RecordTaza (String playername) ;  //Å¸ÀÚ 
	
	
	
	
}
