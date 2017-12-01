package org.bakara.service;

import java.util.List;

import org.bakara.dto.BasicYearRecordDTO;
import org.bakara.dto.TeamPlayerDTO;

public interface PlayerDetailService {
	public TeamPlayerDTO playerdetail (String playername);
	
	public BasicYearRecordDTO RecordTaza (String playername) ;  //Å¸ÀÚ 
}
