package TP_jeux_recursifs;

public class Hanoï {
    public static void main(String[] args) {
        resoudre(8);
    }

    public static void resoudre(int n){
        resoudreAux(n, 1, 3, 0);
    }

    public static void resoudreAux(int n, int i, int j, int un){
        int k = 6 - i - j;
        if(n == 1){
            System.out.println(i + " -> " + j);
            un++;
        }
        if(n>1) {
            resoudreAux(n-1, i, k, un+1);
            System.out.println(i + " -> " + j);
            un++;
            resoudreAux(n-1, k, j, un+1);
        }
    }
}
