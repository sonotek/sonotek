/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sonotek.controller;

import com.sonotek.entity.User;
import com.sonotek.facade.LogFacade;
import com.sonotek.facade.UserFacade;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Oguzhan
 */

@ManagedBean(name = "userController")
@RequestScoped
public class UserController {
    
    @EJB
    UserFacade userFacade;
    
    @EJB
    LogFacade logFacade;
    
    private EntityManager em;
    private List<User> users;
    private User user;
    private String userQuery;
    private List<String> userQueryList;
    
    @PostConstruct
    public void init(){
        setUsers(userFacade.findAll());
        userQuery = new String();
    }
    
    public void queryExample()
    {
        Query query = em.createQuery(this.userQuery);
        this.userQueryList = new ArrayList<>();
        this.userQueryList.add(this.userQuery);
      
        System.out.println(this.userQuery);
        System.out.println(this.userQueryList);

      
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

    public String getUserQuery() {
        return userQuery;
    }

    public void setUserQuery(String userQuery) {
        this.userQuery = userQuery;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public List<String> getUserQueryList() {
        return userQueryList;
    }

    public void setUserQueryList(List<String> userQueryList) {
        this.userQueryList = userQueryList;
    }
    
    
    
    
    
    
    
}
