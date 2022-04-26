package com.cfun.cfun_jfx;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;
import com.cfun.cfun.Complexe;


import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


/**
 * @author Dorian , Guillaume B et Nathan.
 *
 */

public class CPanelController implements Initializable {
	//private static int numeroActuel = 0;

	@FXML
	private Button btn_logout;
	
	@FXML
	private AnchorPane pane_MCFT_entree;
	
	@FXML
	private AnchorPane pane_billet_Entree_Muscu;
	
	@FXML
	 private AnchorPane pane_Billet_Entree_Fitness;
	
	@FXML
	private AnchorPane pane_ticket_Sortie_Muscu;
	 
	 @FXML
	 private AnchorPane pane_ticket_Sortie_Fitness;
	
	@FXML
	private AnchorPane pane_ES;
	
	@FXML
	private AnchorPane pane_MCFT_sortie;
	
	@FXML
	private TextField dateFitness;
	
	/*---- Entrees ----*/
	@FXML
	private TextField DateEntreeMuscu;
	
	@FXML
	 private TextField HeureEntreeMuscu;
	
	@FXML
	private TextField DateEntreeFitness;
	
	@FXML
	 private TextField HeureEntreeFitness;
	
	
	/*---- Sorties ----*/

	@FXML
	private TextField DateSortieMuscu;
	
	@FXML
	 private TextField HeureSortieMuscu;
	
	@FXML
	private TextField DateSortieFitness;
	
	@FXML
	 private TextField HeureSortieFitness;
	
	Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
	String dateEntreeMuscu = com.cfun.cfun_jfx.Billet.currentday; /* package - nom de la classe "Billet"*/
	String heureEntreeMuscu = com.cfun.cfun_jfx.Billet.currentHour;
	String dateEntreeFitness = com.cfun.cfun_jfx.Billet.currentday; 
	String heureEntreeFitness = com.cfun.cfun_jfx.Billet.currentHour;
	
	String dateSortieMuscu = com.cfun.cfun_jfx.Ticket.currentday; /* package - nom de la classe "Ticket"*/
	String heureSortieMuscu = com.cfun.cfun_jfx.Ticket.currentHour;
	String dateSortieFitness = com.cfun.cfun_jfx.Ticket.currentday; 
	String heureSortieFitness = com.cfun.cfun_jfx.Ticket.currentHour;
	//String dateArriveeFitness = com.cfun.cfun_jfx.Ticket.currentday; /* package - nom de la classe "Billet"*/
	//String ArriveeFitness = com.cfun.cfun_jfx.Ticket.currentHour;
	//int leComplexe = Complexe.getNumeroActuel();

	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO Auto-generated method stub
		
	}

	
	//Date  = new Date();
		//DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.Full, locale);
		//String 
	
	 /**
     * Permet d'afficher la page "Choixpaneshow" de l'interface JavaFX.
     */
	public void Choixpaneshow() {
		pane_ES.setVisible(true);
		pane_MCFT_entree.setVisible(false);
		pane_billet_Entree_Muscu.setVisible(false);
		pane_Billet_Entree_Fitness.setVisible(false);
		pane_MCFT_sortie.setVisible(false);
		pane_ticket_Sortie_Muscu.setVisible(false);
		pane_ticket_Sortie_Fitness.setVisible(false);
	}
	
	 /**
     * Permet d'afficher la page "Entreepaneshow" de l'interface JavaFX.
     * 
     */	
	public void Entreepaneshow() {
		pane_ES.setVisible(false);
		pane_MCFT_entree.setVisible(true);
		pane_billet_Entree_Muscu.setVisible(false);
		pane_Billet_Entree_Fitness.setVisible(false);
		pane_MCFT_sortie.setVisible(false);
		pane_ticket_Sortie_Muscu.setVisible(false);
		pane_ticket_Sortie_Fitness.setVisible(false);
	}
	
	  /**
     * Permet d'afficher la page "Sortiepaneshow" de l'interface JavaFX.
     * 
     */	
	public void Sortiepaneshow() {
		pane_ES.setVisible(false);
		pane_MCFT_entree.setVisible(false);
		pane_billet_Entree_Muscu.setVisible(false);
		pane_Billet_Entree_Fitness.setVisible(false);
		pane_MCFT_sortie.setVisible(true);
		pane_ticket_Sortie_Muscu.setVisible(false);
		pane_ticket_Sortie_Fitness.setVisible(false);

	}
	
	
	  /**
     * Permet d'afficher la page "BilletpaneShow" de l'interface JavaFX.
     * */
     
	public void BilletEntreeMuscupaneShow() {		
		pane_ES.setVisible(false);
		pane_MCFT_entree.setVisible(false);
		pane_billet_Entree_Muscu.setVisible(true);
		pane_Billet_Entree_Fitness.setVisible(false);
		pane_MCFT_sortie.setVisible(false);
		pane_ticket_Sortie_Muscu.setVisible(false);
		pane_ticket_Sortie_Fitness.setVisible(false);
		
		String BilletMuscu = com.cfun.cfun_jfx.Billet.currentDay; /* package - nom de la classe "Billet"*/
		System.out.println(BilletMuscu);
		DateEntreeMuscu.setText(dateEntreeMuscu);
		HeureEntreeMuscu.setText(heureEntreeMuscu);
	}
	
	  /**
     * Permet d'afficher la page "TicketpaneShow" de l'interface JavaFX.
     * */
     	
	public void BilletEntreeFitnesspaneShow() {
		pane_ES.setVisible(false);
		pane_MCFT_entree.setVisible(false);
		pane_billet_Entree_Muscu.setVisible(false);
		pane_Billet_Entree_Fitness.setVisible(true);
		pane_MCFT_sortie.setVisible(false);
		pane_ticket_Sortie_Muscu.setVisible(false);
		pane_ticket_Sortie_Fitness.setVisible(false);
		
		String BilletFitness = com.cfun.cfun_jfx.Billet.currentDay; /* package - nom de la classe "Billet"*/
		System.out.println(BilletFitness);
		DateEntreeFitness.setText(dateEntreeFitness);
		HeureEntreeFitness.setText(heureEntreeFitness);
	}
	
	public void TicketSortieMuscupaneShow() {
		pane_ES.setVisible(false);
		pane_MCFT_entree.setVisible(false);
		pane_billet_Entree_Muscu.setVisible(false);
		pane_Billet_Entree_Fitness.setVisible(false);
		pane_MCFT_sortie.setVisible(false);
		pane_ticket_Sortie_Muscu.setVisible(true);
		pane_ticket_Sortie_Fitness.setVisible(false);
		
		String TicketMuscu = com.cfun.cfun_jfx.Ticket.currentDay; /* package - nom de la classe "Billet"*/
		System.out.println(TicketMuscu);
		DateSortieMuscu.setText(dateSortieMuscu);
		HeureSortieMuscu.setText(heureSortieMuscu);
		
	}
	
	public void TicketSortieFitnesspaneShow() {
		pane_ES.setVisible(false);
		pane_MCFT_entree.setVisible(false);
		pane_billet_Entree_Muscu.setVisible(false);
		pane_Billet_Entree_Fitness.setVisible(false);
		pane_MCFT_sortie.setVisible(false);
		pane_ticket_Sortie_Muscu.setVisible(false);
		pane_ticket_Sortie_Fitness.setVisible(true);
		
		String TicketFitness = com.cfun.cfun_jfx.Ticket.currentDay; /* package - nom de la classe "Billet"*/
		System.out.println(TicketFitness);
		DateSortieFitness.setText(dateSortieFitness);
		HeureSortieFitness.setText(heureSortieFitness);
		
	}
	
	
	/**
	 * @throws Exception
	 * 					Affiche la date du jour sur l'interface JavaFX
	 */
	public void AfficheDate() throws Exception {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		System.out.println(dateFormat.format(cal.getTime()));
	}
	
	
	
	/**
	 * @param event
	 * 			   Se déconnecte de la BDD
	 * @throws Exception
	 * 					Créer une Exception s'il y a une erreur
	 */
	public void Logout (ActionEvent event) throws Exception{
		try {
				btn_logout.getScene().getWindow().hide();
				Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
    			Stage mainStage = new Stage();
    			Scene scene = new Scene(root);
    			mainStage.setScene(scene);
    			mainStage.show();
		} catch (Exception e) {
    		JOptionPane.showMessageDialog(null, e);
		}
	}
}
