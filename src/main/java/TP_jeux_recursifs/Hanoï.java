package TP_jeux_recursifs;

public class Hanoï {
    public static void main(String[] args) {
        System.out.println(calculerUn(3));
    }

    public static void resoudre(int n){
        resoudreAux(n, 1, 3);
    }

    public static void resoudreAux(int n, int i, int j){
        int k = 6 - i - j;
        if(n == 1){
            System.out.println(i + " -> " + j);
        }
        if(n>1) {
            resoudreAux(n-1, i, k);
            System.out.println(i + " -> " + j);
            resoudreAux(n-1, k, j);
        }
    }

    public static int calculerUn(int n){
        if(n == 1){
            return 1;
        }
        else {
            int x = calculerUn(n-1);
            return 2*x+1;
        }
    }
}
