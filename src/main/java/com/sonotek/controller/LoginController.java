/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sonotek.controller;


import com.sonotek.entity.User;
import com.sonotek.facade.UserFacade;
import java.io.IOException;
import java.io.Serializable;
import java.security.Principal;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Oguzhan
 */

@ManagedBean(name = "loginController") 
@SessionScoped
public class LoginController implements Serializable{

    private static final long serialVersionUID = 1L;
    
       private static Logger log = Logger.getLogger(LoginController.class.getName());  
       
       
       
      @EJB
      private UserFacade userFacade;
      
      
       
      private String userName;
      private String password;
      private User sessionUser;
      
      public String login(){
            sessionUser=userFacade.userLoginCre(userName, password);

            if(sessionUser!=null){
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("userName", userName);
                return "index.xhtml?faces-redirect=true";
            }else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Username or Password is invalid"));
            }

            return "error.xhtml";
        }

        public String logout(){
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("userName");
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
            sessionUser=null;
            return "login.xhtml";
        }
      
   
      
      
      public void loginss() {
          User user = new User();
          user.setUserName(userName);
          user.setPassword(password);
          user = userFacade.userLoginCre(userName, password);
          System.out.println(user.getUserName() + user.getPassword());
          ///Admin/admin?faces-redirect=true
      }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getSessionUser() {
        return sessionUser;
    }

    public void setSessionUser(User sessionUser) {
        this.sessionUser = sessionUser;
    }
        
     
    
   
}
