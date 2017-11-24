package org.bakara.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.bakara.dto.PlayScheduleDTO;


public interface PlayScheduleMapper {

	@Select("select * from tbl_playschedule")
	public List<PlayScheduleDTO> playschedule()  ; //��ü ��� ����
	
}
