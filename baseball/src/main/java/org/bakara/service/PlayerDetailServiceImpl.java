package org.bakara.service;

import java.util.List;

import javax.inject.Inject;

import org.bakara.dto.BasicYearRecordDTO;
import org.bakara.dto.TeamPlayerDTO;
import org.bakara.mapper.PlayerDetailMapper;
import org.springframework.stereotype.Service;

@Service
public class PlayerDetailServiceImpl implements PlayerDetailService {

	@Inject
	PlayerDetailMapper mapper ; 
	
	public TeamPlayerDTO playerdetail(String playername) {
		//선수 사진 정보 
		return mapper.playerdetail(playername) ; 
	}

	@Override
	public BasicYearRecordDTO RecordTaza(String playername) {
		// TODO Auto-generated method stub
		return mapper.RecordTaza(playername);
	}

}
