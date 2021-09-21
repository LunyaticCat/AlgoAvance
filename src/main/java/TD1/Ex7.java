package TD1;

public class Ex7 {
    public static boolean croissants(int[] tableauCroissantPotentiel){
        return croissantsAux(tableauCroissantPotentiel, 0);
    }

    private static boolean croissantsAux(int[] tableauCroissantPotentiel, int increment) {
        if (increment+1 >= tableauCroissantPotentiel.length) {
            return true;
        } else {
            if (tableauCroissantPotentiel[increment] <= tableauCroissantPotentiel[increment + 1]) {
                return croissantsAux(tableauCroissantPotentiel, increment + 1);
            } else {
                return false;
            }
        }
    }
}
