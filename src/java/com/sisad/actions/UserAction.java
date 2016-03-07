/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisad.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.sisad.daos.GenericDAO;
import com.sisad.entities.User;
import java.util.ArrayList;

/**
 *
 * @author juan
 */
public class UserAction extends ActionSupport {
    
    public ArrayList child;
    
    public String getData (){
    User user = new User();
    GenericDAO gDAO = new GenericDAO(user);
    child = gDAO.getData();
    return SUCCESS;
    }

    public ArrayList getChild() {
        return child;
    }
    
}
