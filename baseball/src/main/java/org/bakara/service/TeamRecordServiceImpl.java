package org.bakara.service;

import javax.inject.Inject;

import org.bakara.dto.TeamRecordDTO;
import org.bakara.mapper.TeamRecordMapper;
import org.springframework.stereotype.Service;
@Service
public class TeamRecordServiceImpl implements TeamRecordService {
	
	@Inject
	private TeamRecordMapper mapper; 

	@Override  
	public void teamRecord(TeamRecordDTO dto) {
		// TODO Auto-generated method stub
		mapper.teamRecord(dto); 
	}
}
