package org.bakara.service;

import javax.inject.Inject;

import org.bakara.dto.LoginDTO;
import org.bakara.dto.UserDTO;
import org.bakara.mapper.UserMapper;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImpl implements UserService {
	
	@Inject
	UserMapper usermapper ;

	@Override
	public UserDTO login(LoginDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return usermapper.login(dto) ; 
	}

}
