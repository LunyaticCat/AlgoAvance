package TDArbre;

public class main {
    public static void main(String[] args) {
        Arbre test0 = new Arbre(6);
        Arbre test1 = new Arbre(69, test0, null);
        Arbre test2 = new Arbre(42);
        Arbre test3 = new Arbre(69, test1, test2);
        System.out.println(Arbre.toStringV2(Arbre.symetrise(test3)));
    }
}
