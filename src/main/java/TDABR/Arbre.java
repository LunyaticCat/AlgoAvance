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

    public static String toStringTrie(Arbre a){
        if (estVide(a)) return "";
        else return toStringTrie(a.filsG) + " " + a.val + toStringTrie(a.filsD);
    }

    public static Arbre insert(Arbre a, int x){
        if(estVide(a)){
            return new Arbre(x);
        }
        if(x <= a.val){
            a.filsG = insert(a.filsG, x);
        }
        else{
            a.filsD = insert(a.filsD, x);
        }
        return a;
    }

    public static Arbre suppr(Arbre a,int x){
        if(estVide(a)){
            return null;
        }
        if(a.val > x){
            a.filsG = suppr(a.filsG, x);
        }
        else if (a.val < x){
            a.filsD = suppr(a.filsD, x);
        }
        else {
            if(estVide(a.filsG)){
                return a.filsD;
            }
            if(estVide(a.filsD)){
                return a.filsG;
            }
            int maxTemp = max(a.filsG);
            a.filsG = suppr(a.filsG, maxTemp);
            a.val = maxTemp;
        }
        return a;
    }

    public static int max(Arbre a){

    }
}
