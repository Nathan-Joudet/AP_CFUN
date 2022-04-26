package com.cfun.cfun_jfx;

import java.sql.Connection;
import java.sql.DriverManager;


import javax.swing.JOptionPane;

/**
 * @author Nathan, Dorian, Guillaume B.
 *
 */
public class mysqlconnect {
	Connection conn = null;
	
	/**
	 * @return se connecte avec la Database
	 */
	
	public static Connection ConnectDb( ){
		
	      try{
	    	  Class.forName("org.sqlite.JDBC");
		         Connection conn = DriverManager.getConnection("jdbc:sqlite:Nathan.db");
		         JOptionPane.showMessageDialog(null, "Connection Etablished");
		         
		         return conn;
	      }
	      catch ( Exception e ) {
		         JOptionPane.showMessageDialog(null, "e");
		 		return null;
		 		
	      }
	   }
	 
	}


