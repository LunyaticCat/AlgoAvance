package TD1;

public class Ex6 {
    public static boolean estPalindrome(char[] palindromePotentiel){
        return estPalindromeAux(palindromePotentiel, 0);
    }
    private static boolean estPalindromeAux(char[] palindromePotentiel, int increment) {
        if (increment >= palindromePotentiel.length) {
            return true;
        } else {
            if (palindromePotentiel[increment] == palindromePotentiel[palindromePotentiel.length - 1 - increment]) {
                return estPalindromeAux(palindromePotentiel, increment + 1);
            } else {
                return false;
            }
        }
    }
}
