package TDListe;

public class main {
    public static void main(String[] args) {
        Liste l1 = new Liste(2);
        Liste l2 = new Liste(1, l1);
        Liste l3 = new Liste(0, l2);
        l3.ajoutFinV2(l3, 8);

        System.out.println(Liste.toString(l3));
    }
}
