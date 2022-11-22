import java.util.ArrayList;

import javafx.event.ActionEvent;
//import javafx.event.Event;
import javafx.event.EventHandler;
//import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.scene.input.MouseButton;
//import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class Vue_Grille extends GridPane implements Observateur {
    
    private Jeu jeu;
    private ArrayList<Case_de_grille> list_cases;

    public Vue_Grille (Jeu jeu) {
    super() ;
    this.setPadding(new Insets(30,30,30,30)); 
    this.jeu=jeu;
    this.jeu.ajouterObservateur(this);
    this.list_cases=new ArrayList<Case_de_grille>(jeu.taille*jeu.taille);
    this.creer_cases();
    }
    
    public void creer_cases(){
        this.getChildren().clear();
        list_cases =new ArrayList<Case_de_grille>(jeu.taille*jeu.taille);
        for (int i=0;i<jeu.taille;i++){
            for (int j=0; j<jeu.taille; j++){
                int value=jeu.plateau[i][j];
            //Image image_de_case = new Image("images/2048.png");
            //ImageView view_case = new ImageView(image_de_case);
            //view_case.setFitHeight(70);
            //view_case.setPreserveRatio(true);
            Case_de_grille case_de_grille = new Case_de_grille();
            //case_de_grille.setGraphic(view_case);
            //double case_side = 70/jeu.taille;
            case_de_grille.setPrefSize(70,70);
            case_de_grille.setStyle("-fx-border-color:black");
            case_de_grille.setFont(new Font("Serif",20));
            case_de_grille.setX(i);
            case_de_grille.setY(j);
            case_de_grille.value_case=value;
            case_de_grille.setText(case_de_grille.value_case+"");
        
            case_de_grille.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event){
                    int a = case_de_grille.getX();
                    int b = case_de_grille.getY();
                    jeu.touch_case(a,b);
                    }
                });
            
            list_cases.add(case_de_grille);
            this.add(case_de_grille, i, j);
            }
        }
    }

    
    public void reagir(){
        for (Case_de_grille c:this.list_cases){
            c.value_case=this.jeu.plateau[c.x_val][c.y_val];
            c.setText(""+c.value_case);
            c.setStyle("-fx-border-color:black");
        }
    }
    public void partie_perdue(){
        for (Case_de_grille c:this.list_cases){
            c.setStyle("-fx-background-color: #ff0000;-fx-border-color:black ");
            
            
        } 
    };

    public void partie_gagnee(){
        for (Case_de_grille c:this.list_cases){
            c.setStyle("-fx-background-color: #00ff00;-fx-border-color:black ");
            
            
        } 
    };

   public class Case_de_grille extends Button {
    private int x_val;
    private int y_val;
    public int value_case;
    
    public Case_de_grille(){
        super();
    }
    public Case_de_grille(String a){
        super(a);
    }
    public void setX(int val){
        this.x_val=val;
    }
    public void setY(int val){
        this.y_val=val;
    }
    public int getX(){
        return this.x_val;
    }
    public int getY(){
        return this.y_val;
    }
   }
}