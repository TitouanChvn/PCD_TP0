import java.util.ArrayList;

public class Jeu {
    public int taille;
    public int[][] plateau;
    public int parties_joues ;
    public int parties_gagnes;
    public ArrayList<Observateur> obs = new ArrayList<>(10);
    public int objectif;

    public Jeu() {
    this.taille=4;
    this.objectif=2048;
    this.obs=new ArrayList<>(10);
    this.parties_joues =-1;
    this.parties_gagnes=0;
    this.plateau= new int[taille][taille];
    this.nouveau();
    }
    
    public int getCase(int i, int j){
        return this.plateau[i][j];
    }
    public int get_parties_gagnes(){
        return this.parties_gagnes;
    }
    public int get_parties_joues(){
        return this.parties_joues;
    }
    
    
    public void nouveau() {
        //System.out.print("NOUVEAU");
        this.parties_joues++;
        for (int i=0;i<this.taille;i++){
            for (int j=0; j<this.taille ;j++){
                reset_case(i, j);
                //this.plateau[i][j]=0;
            }
        }
        this.Mettre_a_jour_Vues();
    }
    
    public void nouvelle_taille(int t){
        this.taille = t;
        this.plateau = new int[taille][taille];
        
        for (Observateur o : this.obs){
            o.creer_cases();
        }
        this.nouveau();
    }
    public void nouvel_objectif(int n){
        this.objectif=n;
        if (this.partie_est_gagnee()){
            System.out.println("PARTIE GAGNEE");
            this.parties_gagnes++;
            for (Observateur o : this.obs){
                o.partie_gagnee();
            }
    
        }
    }

    public void touch_case(int x,int y){
        //System.out.println(""+x+";"+y);
        //this.plateau[x][y]++;
        int count=1;
        for (int i=0;i<this.taille;i++){
            
            if(this.plateau[i][y]==this.plateau[x][y]){
                if (i!=x){
                count ++;
                reset_case(i, y);
                }
            }
            if(this.plateau[x][i]==this.plateau[x][y]){
                if (i!=y){
                count ++;
                reset_case(x, i);
                }
            }   
        }
        this.plateau[x][y]=this.plateau[x][y]*count;
    this.Mettre_a_jour_Vues();
    if (this.partie_est_perdue()){
        System.out.println("PARTIE PERDUE");
        for (Observateur o : this.obs){
            o.partie_perdue();
        }

    }
    if (this.partie_est_gagnee()){
        System.out.println("PARTIE GAGNEE");
        this.parties_gagnes++;
        for (Observateur o : this.obs){
            o.partie_gagnee();
        }

    }
    }

    public boolean partie_est_perdue(){
        boolean perdu=true;
        for (int i=0;i<this.taille;i++){
            for (int j=0;j<this.taille;j++){
                for (int k=0;k<this.taille;k++){
                    if((this.plateau[i][j]==this.plateau[i][k] && k!=j)||(this.plateau[i][j]==this.plateau[k][j] && k!=i)){
                        perdu=false;
                    }
                }
            }
        }
        return perdu;
    }

    public boolean partie_est_gagnee(){
        boolean gagne=false;
        for (int i=0;i<this.taille;i++){
            for (int j=0;j<this.taille;j++){
                if (this.plateau[i][j]>=this.objectif){
                        gagne=true;
                    }
                }
            }
        
        return gagne;
    }

    public void reset_case(int i, int j){
        this.plateau[i][j]=2;
        double proba=  Math.random();
        //System.out.println(proba);
        if (proba>0.75){
            this.plateau[i][j]=4;
        }
    }
    public void ajouterObservateur(Observateur o){
        this.obs.add(o);
    }

    public void Mettre_a_jour_Vues(){
        for (Observateur o : this.obs){
            o.reagir();
        }
    }


}
    