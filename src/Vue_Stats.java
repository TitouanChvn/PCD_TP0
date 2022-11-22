import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;

public class Vue_Stats extends TilePane implements Observateur {
    private Jeu jeu;
    private Label label_jouer;
    private Label label_gagner;

    public Vue_Stats(Jeu jeu){
    super();
    this.setPadding(new Insets(10,10,10,10));        
    this.setHgap(20);
    this.jeu=jeu;
    this.jeu.ajouterObservateur(this);
    this.label_jouer = new Label("Nombre de parties jouées : "+jeu.parties_joues);
    this.label_gagner = new Label("Nombre de parties gagnées : "+jeu.parties_gagnes);
    this.getChildren().setAll(label_jouer,label_gagner);
    }

    public void reagir(){
        this.label_jouer.setText("Nombre de parties jouées : "+jeu.parties_joues);
        this.label_gagner.setText("Nombre de parties gagnées : "+jeu.parties_gagnes);
        }
    public void partie_perdue(){};
    public void partie_gagnee(){};
    public void creer_cases(){};
}
