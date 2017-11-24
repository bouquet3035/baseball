package org.bakara.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.bakara.dto.TeamNewsDTO;

public interface TeamNewsMapper {

	@Select("select * from tbl_news where teamname = #{teamname} order by title desc limit 0,9")
	public List<TeamNewsDTO> getNews(String teamname);
	
}
