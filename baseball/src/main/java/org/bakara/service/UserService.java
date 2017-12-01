package org.bakara.service;

import org.bakara.dto.LoginDTO;
import org.bakara.dto.UserDTO;

public interface UserService {
	
	public UserDTO login(LoginDTO dto) throws Exception ;

}
