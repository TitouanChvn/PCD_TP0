import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCombination;

//import javafx.application.Application;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.layout.*;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
import javafx.scene.control.*;
//import javafx.stage.Stage;
//import javafx.scene.control.Alert.AlertType;
//import java.time.LocalDate;

public class Vue_Menu extends MenuBar implements Observateur {
    private Jeu jeu;
    public TextInputDialog fenetre_taille;
    public TextInputDialog fenetre_objectif; 
    

    public Vue_Menu (Jeu jeu) {
    super() ;
    this.jeu=jeu;
    this.fenetre_taille = new TextInputDialog(""+jeu.taille);
    fenetre_taille.setHeaderText("Taille du jeu (conseillée entre 3 et 6)");
    this.fenetre_objectif = new TextInputDialog(""+jeu.objectif);
    fenetre_objectif.setHeaderText("Objectif de la partie");
    Menu menu = new Menu("Jeu");
    MenuItem nouveau = new MenuItem("Nouveau");
    nouveau.setAccelerator(KeyCombination("Ctrl+N"));
    nouveau.setOnAction(new EventHandler<ActionEvent>() {

        @Override
        public void handle(ActionEvent event) {
            jeu.nouveau();
        }
    });
    MenuItem changer_taille = new MenuItem("Changer taille");
    changer_taille.setAccelerator(KeyCombination("Ctrl+T"));
    changer_taille.setOnAction(new EventHandler<ActionEvent>() {
        
        @Override
        
        public void handle(ActionEvent event) {
            fenetre_taille.showAndWait();
            System.out.print(fenetre_taille.getEditor().getText());
            try {
                Integer n = Integer.valueOf(fenetre_taille.getEditor().getText());
                jeu.nouvelle_taille(n);}
                catch (NumberFormatException ex) {}
            
        }
    });
    MenuItem changer_objectif = new MenuItem("Changer objectif");
    changer_objectif.setAccelerator(KeyCombination("Ctrl+O"));
    changer_objectif.setOnAction(new EventHandler<ActionEvent>() {
        
        @Override
        
        public void handle(ActionEvent event) {
            fenetre_objectif.showAndWait();
            //System.out.print(fenetre_objectif.getEditor().getText());
            try {
                Integer n = Integer.valueOf(fenetre_objectif.getEditor().getText());
                jeu.nouvel_objectif(n);}
                catch (NumberFormatException ex) {}
            
        }
    });
    MenuItem quitter = new MenuItem("Quitter");
    quitter.setAccelerator(KeyCombination("Ctrl+Q"));
    quitter.setOnAction(new EventHandler<ActionEvent>() {

        @Override
        public void handle(ActionEvent event) {
            System.exit(0);
        }
    });   
    menu.getItems().addAll(nouveau,changer_taille,changer_objectif, quitter);
    this.getMenus().add(menu) ;
    }

    private KeyCombination KeyCombination(String string) {
        return null;
    }

    public void reagir(){
        
    }

    
    public void creer_cases(){};
    public void partie_perdue(){};
    public void partie_gagnee(){};
}