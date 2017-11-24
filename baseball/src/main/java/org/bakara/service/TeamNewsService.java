package org.bakara.service;

import java.util.List;

import org.bakara.dto.TeamNewsDTO;

public interface TeamNewsService {

	public List<TeamNewsDTO> getNews(String teamname);
	
}
