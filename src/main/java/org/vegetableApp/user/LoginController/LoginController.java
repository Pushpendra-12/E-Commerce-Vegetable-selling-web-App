package org.vegetableApp.user.LoginController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.vegetableApp.address.model.Address;
import org.vegetableApp.dto.LoginToken;
import org.vegetableApp.user.model.User;
import org.vegetableApp.user.srevice.LoginServiceImpl;
import org.vegetableApp.user.srevice.UserService;



@Controller
@RequestMapping("/login")
@SessionAttributes("userid")
public class LoginController {
	
	
	@Autowired
	private LoginServiceImpl loginService;
	
	@Autowired
	private UserService userservice;
	
	@GetMapping
	public String login(Model model) {
		LoginToken token = new LoginToken();
		model.addAttribute("logintoken", token);
		return "login/login";
	}
	
	@PostMapping
	public String checkLogin(@ModelAttribute("logintoken") LoginToken token,Model model) {
		User user = loginService.checkLogin(token);
		if(user != null) {
			model.addAttribute("userid", user.getUserId());
			return "login/loginsuccess";
		}else {
			return "login/loginunsuccess";
		}
	}
	
	@GetMapping("/checkloggedin")
	public String checkloggedin(Model model) {
		Integer userid = (Integer) model.getAttribute("userid");
		User user = loginService.getUserByUserId(userid);
		model.addAttribute("user",user);
		return "login/displayuser";
	}
	
	
	
	@GetMapping("/adduser")
	public String addUser(Model model) {
		User user = new User();
		user.setAddress(new Address());
		model.addAttribute("user",user);
		return "login/adduser";
		
	}

	
	@PostMapping("/adduserprocess")
	public String addUserProcess(@ModelAttribute("user") User user) {
		User use = userservice.addUser(user);
		if(use == null ) {
			return "login/useraddedunsuccess";
		}else {
			return "login/useraddedsuccess";
		}
	}
	
	
	@GetMapping("/updateuser")
	public String updateUser(Model model) {
		User user = new User();
		model.addAttribute("user",user);
		return "login/updateuser";
	}
	
	@GetMapping("/usersearchforupdate")
	public String searchForUpdate(@ModelAttribute("user") User user,Model model) {
		User use = userservice.findByUserName(user.getName());
		if(use == null) {
			return "login/usernotfound";
		}else {
			model.addAttribute("user",use);
			return "login/userupdatesearch";
		}
	}
	
	
	@PostMapping("/updateuserprocess")
	public String updateVegetableProcess(@ModelAttribute("user") User user){
		user = userservice.updateUser(user);
		if(user == null) {
			return "login/userupdateunsuccess";
		}else {
			return "login/userupdatesuccess";
		}
	}
	

}
