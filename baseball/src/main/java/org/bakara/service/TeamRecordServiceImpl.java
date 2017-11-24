package org.bakara.service;

import java.util.List;

import javax.inject.Inject;

import org.bakara.dto.TeamRecordDTO;
import org.bakara.mapper.TeamRecordMapper;
import org.springframework.stereotype.Service;
@Service
public class TeamRecordServiceImpl implements TeamRecordService {
	
	@Inject
	private TeamRecordMapper mapper; 

	@Override  
	public TeamRecordDTO teamRecord (String teamname) {
		// TODO Auto-generated method stub
		return mapper.teamRecord(teamname); 
	}


}
