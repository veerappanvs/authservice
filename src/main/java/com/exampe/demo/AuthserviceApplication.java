package com.exampe.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exampe.demo.entity.Roles;
import com.exampe.demo.entity.User;
import com.exampe.demo.manager.AuthManager;


@Controller
@SpringBootApplication
@RequestMapping("/auth")
public class AuthserviceApplication {
	
	@Autowired
	AuthManager  authmanager;
	
	static Logger log = LogManager.getLogger(AuthserviceApplication.class.getName());

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(AuthserviceApplication.class, args);
	}
	
	
	/**
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	@ResponseBody
	@GetMapping("/gettoken" )
	public ResponseEntity<User>  getOauthToken(@RequestBody User user) {
		
		log.info("username "+user.getUserName());
		String oauthToken = "";
		String userName = user.getUserName();
		String password = user.getPassword();
		
		if(userName !=null && !userName.isEmpty()   && password !=null && !password.isEmpty()  )
			oauthToken = authmanager.getOAuthToken(user.getUserName(), password);
		
		
		if(  (null != oauthToken  && !oauthToken.isEmpty()) ) {
			
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
		}
		
		user.setToken(oauthToken);
		log.info("oauthToken "+oauthToken);
		
		return new ResponseEntity<User>(user, HttpStatus.OK);
		
		
	}
	

	
	/**
	 * 
	 * @param user
	 * @return
	 */
	@ResponseBody
	@PostMapping("/getroles")
	public ResponseEntity<List<Roles>>  getRolesForUser(@RequestBody User user) {
		
		log.debug( "username "+user);
		List<Roles> roles = authmanager.getRolesForUsers(user.getToken());

		
		if(  (null != roles  && roles.size() > 0))  {
			return new ResponseEntity<List<Roles>>(HttpStatus.NO_CONTENT);
		}
		
		log.debug( "roles for user "+user+" :"+roles);
		return new ResponseEntity<List<Roles>>(roles, HttpStatus.OK);
	}
}
