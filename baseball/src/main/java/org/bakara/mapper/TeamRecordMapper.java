package org.bakara.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.bakara.dto.TeamRecordDTO;

public interface TeamRecordMapper {
	
	@Select("select * from tbl_teamrecord")    // ÆÀ ±â·Ï  
	public List<TeamRecordDTO> teamRecord()  ;
		

}
