package org.bakara.service;

import java.util.List;

import javax.inject.Inject;

import org.bakara.dto.PlayScheduleDTO;
import org.bakara.mapper.PlayScheduleMapper;
import org.springframework.stereotype.Service;

@Service
public class PlayScheduleServiceImpl implements PlayScheduleService {

	@Inject
	PlayScheduleMapper mapper;
	
	@Override
	public List<PlayScheduleDTO> playschedule() {
		// TODO Auto-generated method stub
		return mapper.playschedule();
	}

}
