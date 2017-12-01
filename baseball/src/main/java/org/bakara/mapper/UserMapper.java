package org.bakara.mapper;

import org.apache.ibatis.annotations.Select;
import org.bakara.dto.LoginDTO;
import org.bakara.dto.UserDTO;

public interface UserMapper {
	
	@Select("select uid, upw, uname from tbl_user where uid =#{uid} and upw =#{upw}")
	public UserDTO login (LoginDTO dto) throws Exception ; 

}
