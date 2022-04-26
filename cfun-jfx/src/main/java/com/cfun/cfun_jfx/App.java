package com.cfun.cfun_jfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent; 
import javafx.scene.Scene; 
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 * Résumé de la Classe App.java
 */

/**
 * @author Nathan, Dorian, Guillaume B.
 *
 */
public class App extends Application {
	
	/**
     * La méthode "start" est le point d'entrée de toute application JavaFX
     * @param stage, est la fenêtre principale de l'interface
     * L'objet "scene" permet d'assembler les composants décrit dans le programme.
     */
	@Override
    public void start(Stage stage) throws IOException {
		Parent root = FXMLLoader.load(getClass () .getResource("FXMLDocument.fxml"));
		
		Scene scene = new Scene (root);
		stage.setScene(scene);
		stage.show();
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	  /**
     * @param fxml, la valeur à traiter
     * @throws IOException Si jamais l'interface ne s'affiche pas.
     */
	 static void setRoot(String fxml) throws IOException {
	        Scene scene = new Scene(null);
			scene.setRoot((Parent) loadFXML(fxml));
	    }


	private static Object loadFXML(String fxml) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

   