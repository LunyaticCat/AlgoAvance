package TDABR;

public class Arbre {
    private int val;
    private Arbre filsG;
    private Arbre filsD;

    public Arbre(int v) {
        val = v;
        filsG = null;
        filsD = null;
    }

    public Arbre(int v, Arbre fg, Arbre fd) {
        val = v;
        filsG = fg;
        filsD = fd;
    }

    public static boolean estVide(Arbre a) {
        return a == null;
    }

    public static String toStringV2(Arbre a){
        return  toStringV2aux(a,"");
    }

    private static String toStringV2aux(Arbre a, String s) {
        if (estVide(a)) return "";
        else return toStringV2aux(a.filsD, s + "   ") + s + a.val + "\n" + toStringV2aux(a.filsG, s + "   ");
    }

    public static String toStringTrie(Arbre a){
        return  toStringTrieAux(a,"");
    }

    public static String toStringTrieAux(Arbre a, String s){
        if (estVide(a)) return "";
        else return toStringTrieAux(a.filsG, s + "   ") + s + a.val + "\n" + toStringV2aux(a.filsD, s + "   ");
    }

    public static int nbEntiers(Arbre a){
        if(estVide(a)){
            return 0;
        }
        else{
           return 1 + nbEntiers(a.filsD) + nbEntiers(a.filsG);
        }
    }

    public static int nbFeuilles(Arbre a){
        if(estVide(a)){
            return 0;
        }
        else{
            if(estVide(a.filsG) && estVide(a.filsD)){
                return 1;
            }
            return nbFeuilles(a.filsD) + nbFeuilles(a.filsG);
        }
    }

    public static boolean recherche(Arbre a, int x){
        if(estVide(a)){
            return false;
        }
        if(a.val == x){
            return true;
        }
        if(x< a.val){
            return recherche(a.filsG, x);
        }
        else{
            return recherche(a.filsD, x);
        }
    }

    public static boolean pereFilsEgaux(Arbre a){
        if(estVide(a)){
            return false;
        }
        if(!estVide(a.filsG)) {
            if (a.val == a.filsG.val) {
                return true;
            }
        }
        if(!estVide(a.filsD)) {
            if (a.val == a.filsD.val) {
                return true;
            }
        }
            return pereFilsEgaux(a.filsG) || pereFilsEgaux(a.filsD);
    }

    public static Arbre symetrise(Arbre a){
        if(estVide(a)){
            return null;
        }
        Arbre result = new Arbre(a.val, null, null);
        result.filsG = symetrise(a.filsD);
        result.filsD = symetrise(a.filsG);
        return result;
    }

    public static int meilleurChemin(Arbre a){
        int result0 = Integer.MAX_VALUE, result1 = Integer.MAX_VALUE;
        if(estVide(a)){
            return Integer.MAX_VALUE;
        }
        if(estVide(a.filsG) && estVide(a.filsD)){
            return a.val;
        }
        if(!estVide(a.filsG)) {
            result0 = a.val + meilleurChemin(a.filsG);
        }
        if(!estVide(a.filsD)) {
            result1 = a.val + meilleurChemin(a.filsD);
        }
        return Math.min(result0, result1);
    }

    public static boolean chercheFeuille(Arbre a, int x){
        if(estVide(a)){
            return false;
        }
        if(estVide(a.filsG) && estVide(a.filsD)) {
            return a.val == x;
        }
        return chercheFeuille(a.filsG, x) || chercheFeuille(a.filsD, x);
    }

    public static boolean chercheNoeudInterne(Arbre a, int x){
        if(estVide(a)){
            return false;
        }
        if(estVide(a.filsG) && estVide(a.filsD)) {
            return false;
        }
        return a.val == x || chercheNoeudInterne(a.filsG, x) || chercheNoeudInterne(a.filsD, x);
    }
}
