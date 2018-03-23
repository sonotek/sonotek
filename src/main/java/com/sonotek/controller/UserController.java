/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sonotek.controller;

import com.sonotek.entity.User;
import com.sonotek.facade.UserFacade;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Oguzhan
 */

@ManagedBean(name = "userController")
@RequestScoped
public class UserController {
    
    @EJB
    UserFacade userFacade;
    
    private List<User> users;
    private User user;
    
    @PostConstruct
    public void init(){
        setUsers(userFacade.findAll());
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
    
    
    
    
    
}
