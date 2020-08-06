package org.dibyendu.jsfspring.view;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.dibyendu.jsfspring.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ManagedBean
@SessionScoped
public class User {
	
	 private String name;
	 private String surname;   
	 private String password;
	 private String email;
	   
	
	@Autowired
	UserRegistrationService userRegistrationService;
	
		
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String login() {
        
		String userId = null;
		//UserRegistrationService userRegistrationService = new UserRegistrationService();
		userId = userRegistrationService.validateUser(name,password);
        if (userId != null) {
        	HttpSession session = SessionUtils.getSession();
			session.setAttribute("username", name);
            return "home";
        } else
        	FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Incorrect Username and Passowrd",
							"Please enter correct username and Password"));
			return "error";
           
    }
	
public String add() {
        
		//String userId = null;
		//UserRegistrationService userRegistrationService = new UserRegistrationService();
		org.dibyendu.jsfspring.entity.User userId = userRegistrationService.registerUser(email,password);
        if (userId != null) {
            return "home";
        } else
            return "unsuccess";
    }


public String logout() {
	HttpSession session = SessionUtils.getSession();
	session.invalidate();
	return "login";
}
	
	
	
	
}
