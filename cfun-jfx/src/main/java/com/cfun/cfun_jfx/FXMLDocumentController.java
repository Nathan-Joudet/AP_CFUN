package com.cfun.cfun_jfx;

import java.net.URL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * @author Nathan, Dorian, Guillaume B.
 *
 */
public class FXMLDocumentController implements Initializable {
	
	@FXML
    private AnchorPane pane_login;

    @FXML
    private TextField txt_username;

    @FXML
    private PasswordField txt_password;

    @FXML
    private ComboBox<String> type;

    @FXML
    private Button btn_login;

    @FXML
    private AnchorPane pane_signup;

    @FXML
    private TextField txt_username_up;

    @FXML
    private TextField email_up;

    @FXML
    private TextField txt_password_up;

    @FXML
    private ComboBox<String> type_up;
    
    @FXML
    private AnchorPane pane_welcome;
    
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    /**
     * Permet d'afficher la page "WelcomepaneShow" de l'interface JavaFX.
     * 
     */
    public void WelcomepaneShow() {
    	pane_welcome.setVisible(true);
    	pane_login.setVisible(false);
    	pane_signup.setVisible(false);
    }
    
    /**
     * Permet d'afficher la page de connexion ( Login )  de l'interface JavaFX.
     */
    public void LoginpaneShow() {
    	pane_welcome.setVisible(false);
    	pane_login.setVisible(true);
    	pane_signup.setVisible(false);
    }
    
    /**
     * Permet d'afficher la page d'inscription ( Signup ) de l'interface JavaFX.
     * 
     */
    public void SignuppaneShow() {
    	pane_welcome.setVisible(false);
    	pane_login.setVisible(false);
    	pane_signup.setVisible(true);
    }

    
    /**
     * 
     * @param event
     * 			   Se connecte à la Database
     * @throws Exception
     * 					Met une erreur si la conexion à la bdd n'est pas bonne
     */
    
    @FXML
    private void Login (ActionEvent event) throws Exception {
    	conn = mysqlconnect.ConnectDb();
    	String sql = "Select * from users where username = ? and password = ? and type = ?"; 
    	
    	try {
    		pst = conn.prepareStatement(sql);
    		pst.setString(1, txt_username.getText());
    		pst.setString(2, txt_password.getText());
    		pst.setString(3, type.getValue().toString());

    		rs = pst.executeQuery(); 
    		
    		if(rs.next()) {
    			JOptionPane.showMessageDialog(null, "Username and Password is Correct");  
    			
    			btn_login.getScene().getWindow().hide();
    			Parent root = FXMLLoader.load(getClass().getResource("CPanel1.fxml"));
    			Stage mainStage = new Stage();
    			Scene scene = new Scene(root);
    			mainStage.setScene(scene);
    			mainStage.show();
    			
    		} else
    			JOptionPane.showMessageDialog(null, "Invalide Username Or Password");
    	} catch (Exception e) {
    		JOptionPane.showMessageDialog(null, e);
    	}
    } 

    
    /**
     * @param event
     * 			   Ajoute un utilisateur à la Database
     */
    public void add_users(ActionEvent event) {
    	conn = mysqlconnect.ConnectDb();
    	String sql = "insert into users (username,password,type,email) values (?,?,?,?)";
    	try {
    		pst = conn.prepareStatement(sql);
    		pst.setString(1, txt_username_up.getText());
    		pst.setString(2, txt_password_up.getText());
    		pst.setString(3, type_up.getValue() .toString());
    		pst.setString(4, email_up.getText());
    		pst.execute();
    		
    		JOptionPane.showMessageDialog(null, "Saved");
    	} catch (Exception e) {
    		JOptionPane.showMessageDialog(null, e);
    	}
    }
    
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		type_up.getItems().addAll("Admin","client","gestionnaire");		
		type.getItems().addAll("Admin","client","gestionnaire");	

	}

    
}
