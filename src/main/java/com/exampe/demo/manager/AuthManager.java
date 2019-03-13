/**
 * 
 */
package com.exampe.demo.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.exampe.demo.entity.Roles;

/**
 * @author veera
 *
 */
@Service
public class AuthManager {
	
	
	/**
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public String getOAuthToken(String username, String password) {
		
		//TODO   get the getOauthToken(username, password)  from AuthenticatorService;
		return "123";
	}
	
	
	/**
	 * 
	 * @param oauthToken
	 * @return
	 */
	public List<Roles>   getRolesForUsers(String oauthToken){
		
		//TODO invoke service to get the userid
		List<Roles>   roles = new ArrayList<Roles>();
		roles.add(new Roles(1, "Admin"));
		
		//TODO get roles getRoles(username, oauthToken) from DAO
		return roles;
	}

}

