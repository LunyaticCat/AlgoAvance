package TDArbre;

public class ArbreMain {
    public static void main(String[] args) {
        Arbre test0 = new Arbre(5);
        Arbre test1 = new Arbre(2, test0, null);
        Arbre test2 = new Arbre(9);
        Arbre test3 = new Arbre(2, test1, test2);
        System.out.println(Arbre.chercheNoeudInterne(test3, 5));
    }
}
