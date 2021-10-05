package TDListe;

class Liste {
    private int val;
    private Liste suiv;

    public Liste(int x) {//construit la liste avec un entier x
        this.val = x;
        this.suiv = null;
    }

    public Liste(int x, Liste l) {
        this.val = x;
        this.suiv = l;
    }

    public static boolean estVide(Liste l) {
        return l == null;
    }

    Liste copie(Liste l) {
//action : retourne une copie de l (en recopiant tous les maillons)
        if (estVide(l)) {
            return null;
        } else {
            return new Liste(l.val, copie(l.suiv));
        }
    }

    public static String toString(Liste l) {
        if (estVide(l))
            return "";
        else
            return l.val + " " + toString(l.suiv);
    }

    public static int longueur(Liste l) {
        if (estVide(l)) {
            return 0;
        } else {
            return longueur(l.suiv) + 1;
        }
    }

    public static boolean croissant(Liste l) {
        if (estVide(l.suiv)) {
            return true;
        }
        if (l.val <= l.suiv.val) {
            return croissant(l.suiv);
        }
        return false;
    }

    Liste ajoutFinV1(Liste l, int x){
        if(l != null){
            Liste tmp = ajoutFinV1(l.suiv, x);
            l.suiv = tmp;
        }
        else{
            l = new Liste(x);
        }
        return l;
    }

    void ajoutFinV2(Liste l, int x){
        if(l != null){
            ajoutFinV1(l.suiv, x);
        }
        else{
            l = new Liste(x);
        }
    }
}