package org.bakara.service;

import java.util.List;

import org.bakara.dto.TeamNewsDTO;
import org.bakara.mapper.TeamNewsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamNewsServiceImpl implements TeamNewsService {

	@Autowired TeamNewsMapper mapper;

	@Override
	public List<TeamNewsDTO> getNews(String teamname) {
		
		return mapper.getNews(teamname);
	}


	
}
