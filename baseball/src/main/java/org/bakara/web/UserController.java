package org.bakara.web;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.bakara.dto.LoginDTO;
import org.bakara.dto.UserDTO;
import org.bakara.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/*")
public class UserController {
	
	
	@Inject
	private UserService service  ; 
	
	@GetMapping("/login")
	public void login() {
		
	}
	
	@PostMapping("/login")
	public String loginGET(@ModelAttribute("dto") LoginDTO dto) throws Exception {
		System.out.println("usercontrol /loginGet/  로그인 화면창 ");
		if (service.login(dto) != null) {
			return "baseball/teaminfo";
		} else {
			return "redirect:/login";
		}
	}
	
//	@PostMapping("/loginPost")
//	public void loginPOST (LoginDTO dto ,HttpSession session ,Model model) throws Exception{
//		UserDTO user = service.login(dto); 
//		
//		if(user == null) {
//			
//			System.out.println("usercontrol / loginPost/-로그인 실패");
//			return ; 
//		
//		}
//		
//		model.addAttribute("userVO", user) ; 
//	}
	

}
