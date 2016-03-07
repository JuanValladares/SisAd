/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisad.daos;

import com.sisad.entities.User;
import java.sql.*;
import java.util.ArrayList;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import org.apache.log4j.Logger;

/**
 *
 * @author juan
 */
public class GenericDAO {

    protected Connection objDB;
    protected User user;
    protected Logger log = Logger.getLogger(GenericDAO.class);
    
    private void getConnection(){
        try {
            InitialContext ctx  = new InitialContext();
            Context xmlContext = (Context) ctx.lookup("java:comp/env");
            DataSource ds = (DataSource) xmlContext.lookup("jdbc/UsersDB");
            objDB = ds.getConnection();
        } catch (NamingException ex) {
            log.error("Exeption getting context "+ex.getMessage());
        } catch (SQLException ex) {
            log.error("Excpetion getting connection "+ex.getMessage());
        }
    }

    public GenericDAO(User user) {
        this.user = user;
    }
    
    public void OpenDB(){
        getConnection();
    }
    
    public ArrayList getData(){
        ArrayList users = new ArrayList();
        StringBuilder query = new StringBuilder();
        query.append(" SELECT * ");
        query.append(" FROM profile ");
        try {
            OpenDB();
            PreparedStatement ps = objDB.prepareStatement(query.toString());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                User u = new User();
                u.setName(rs.getString("dsc"));
               users.add(u);
            }
        } catch (Exception e) {
        }
        return users;
    }

}
