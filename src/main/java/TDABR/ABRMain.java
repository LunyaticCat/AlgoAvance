package TDABR;

public class ABRMain {
    public static void main(String[] args) {
        Arbre test0 = new Arbre(2);
        Arbre test1 = new Arbre(3, test0, null);
        Arbre test2 = new Arbre(9);
        Arbre test3 = new Arbre(5, test1, test2);

        System.out.println(Arbre.toStringV2(Arbre.suppr(test3, 2)));
    }
}
