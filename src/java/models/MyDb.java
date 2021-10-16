/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class MyDb {
    
    private String name;
    private String email;
    private String phone;
    Connection conn;
    
    public void sauvegarder_booking(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://maracasevent.mysql.database.azure.com:3306/maracas_desktop?","bloodstike@maracasevent", "WAELwael1998@");
            PreparedStatement reqSauvgarder = conn.prepareStatement("insert into maracas_web.maracas_db values(?,?,?)");
            reqSauvgarder.setString(1,this.name);
            reqSauvgarder.setString(2,this.email);
            reqSauvgarder.setString(3,this.phone);
            reqSauvgarder.executeUpdate();
            conn.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MyDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public void SetName(String name){
    this.name = name;}
    
    public void SetEmail(String  email){
    this.email = email;}
    
    public void SetPhone(String phone){
    this.phone = phone;}
    
    public String GetName(){
    return this.name;}
    
    public String GetEmail(){
    return this.email;}
    
    public String GetPhone(){
    return this.phone;}
   
    
}
