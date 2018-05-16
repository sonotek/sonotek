/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sonotek.controller;

import com.sonotek.entity.User;
import com.sonotek.facade.LogFacade;
import com.sonotek.facade.UserFacade;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.faces.bean.SessionScoped;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
/**
 *
 * @author Oguzhan
 */

@ManagedBean(name = "dbSelectionController")
@SessionScoped
public class ChangeDatabaseSellectionController {
    
   
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    
    private String userName;
    private String password;
    private String ipConfig;
    private String port;
    private List<String> databaseList;
    private String firstDatabase;
    private String selectionDatabase;
    private String selectionTable;
    private List<String> tableList;
    
    @PostConstruct
    public void init(){
         this.databaseList = new ArrayList<String>();
         this.firstDatabase = new String();
         this.tableList = new ArrayList<String>();
         
         
    }
    
 
    
   public void readDataBase() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://"+ ipConfig+":"+port+"/?user=" +userName + "&password=" + password );
            statement = connect.createStatement();
            resultSet = statement.executeQuery("show databases ;");
             while(resultSet.next()){              
                this.firstDatabase= resultSet.getString("Database");
                this.databaseList.add(firstDatabase);
            }
             
            System.out.println(resultSet);
        } catch (Exception e) {
            throw e;
        } 

    }
   
   
   
   
   
   
   
   public void connectionDatabase() throws Exception{
       try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://"+ ipConfig+":"+port+"/?user=" +userName + "&password=" + password );
            statement = connect.createStatement();
          
            
          
        } catch (Exception e) {
            throw e;
        } 
   }
   
   public void readDatabaseTable() throws Exception{
       connectionDatabase();
       resultSet = statement.executeQuery("use "+selectionDatabase+" ;");
       System.out.println(selectionDatabase+"qqqqqqqqqq");
       System.out.println(selectionDatabase+"sssssssssss");
      
   }
   public void databaseSelectionTable() throws Exception{
          resultSet = statement.executeQuery("Show tables ;"); 
          
          while(resultSet.next()){
         this.selectionTable= resultSet.getString("Tables_in_"+selectionDatabase);
          System.out.println(selectionDatabase+"111111");
          this.tableList.add(selectionTable);
          System.out.println(tableList+"Listeee");
          }
        
          
   }
   
   
   
   
   
   
   
    public void onRowSelect(SelectEvent event) {
        this.selectionDatabase = new String();
        this.selectionDatabase = firstDatabase;
        this.selectionDatabase= (String) event.getObject();
    }
 
    public void onRowUnselect(UnselectEvent event) {
         this.selectionDatabase= (String) event.getObject();
    }

    private void writeMetaData(ResultSet resultSet) throws SQLException {
        //  Now get some metadata from the database
        // Result set get the result of the SQL query

        System.out.println("The columns in the table are: ");

        System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
        for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
            System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
        }
    }

    private void writeResultSet(ResultSet resultSet) throws SQLException {
        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
            String user = resultSet.getString("myuser");
            String website = resultSet.getString("webpage");
            String summary = resultSet.getString("summary");
            Date date = resultSet.getDate("datum");
            String comment = resultSet.getString("comments");
            System.out.println("User: " + user);
            System.out.println("Website: " + website);
            System.out.println("summary: " + summary);
            System.out.println("Date: " + date);
            System.out.println("Comment: " + comment);
        }
    }

    // You need to close the resultSet
    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
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

    public String getIpConfig() {
        return ipConfig;
    }

    public void setIpConfig(String ipConfig) {
        this.ipConfig = ipConfig;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public Connection getConnect() {
        return connect;
    }

    public void setConnect(Connection connect) {
        this.connect = connect;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }
    
    

    public PreparedStatement getPreparedStatement() {
        return preparedStatement;
    }

    public void setPreparedStatement(PreparedStatement preparedStatement) {
        this.preparedStatement = preparedStatement;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    public List<String> getDatabaseList() {
        return databaseList;
    }

    public void setDatabaseList(List<String> databaseList) {
        this.databaseList = databaseList;
    }

    public String getFirstDatabase() {
        return firstDatabase;
    }

    public void setFirstDatabase(String firstDatabase) {
        this.firstDatabase = firstDatabase;
    }

    public String getSelectionDatabase() {
        return selectionDatabase;
    }

    public void setSelectionDatabase(String selectionDatabase) {
        this.selectionDatabase = selectionDatabase;
    }

    public String getSelectionTable() {
        return selectionTable;
    }

    public void setSelectionTable(String selectionTable) {
        this.selectionTable = selectionTable;
    }

    public List<String> getTableList() {
        return tableList;
    }

    public void setTableList(List<String> tableList) {
        this.tableList = tableList;
    }
    
    
    
    
    
    
}
