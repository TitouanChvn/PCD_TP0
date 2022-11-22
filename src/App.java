import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.scene.control.Menu;
//import javafx.scene.control.MenuBar;
//import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.GridPane;
//import javafx.scene.layout.TilePane;
//import javafx.geometry.Pos;
public class App extends Application {
public static void main(String[] args) {
    Application.launch(args);
}
@Override
    public void start(Stage primaryStage) throws Exception {

        Jeu jeu = new Jeu();
        // LE MENU HAUT
        Vue_Menu Menu_haut = new Vue_Menu(jeu);

        // LA GRILLE CENTRALE
        Vue_Grille Grille_jeu = new Vue_Grille(jeu);
        
        
        //LE MENU BAS
        Vue_Stats Menu_bas = new Vue_Stats(jeu);
        
        



        BorderPane layout = new BorderPane();
        layout.setTop(Menu_haut);
        layout.setCenter(Grille_jeu);
        layout.setBottom(Menu_bas);

        Scene primaryScene = new Scene(layout);
        primaryStage.setScene(primaryScene);
        //primaryStage.setResizable(false);
        //primaryStage.setHeight(400);
        primaryStage.setWidth(1.5*primaryScene.getHeight());
        primaryStage.show();
    }
}




