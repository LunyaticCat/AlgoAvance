package TDFractale;

class DessinFractale {
    private final Turtle bob;

    private final static int LARGEUR = 800;
    private final static int HAUTEUR = 600;
    //taille de la fenetre graphique

    public DessinFractale() {
        bob = new Turtle();
        Turtle.setCanvasSize(LARGEUR, HAUTEUR);//à appeler APRES création de la tortue
    }

    public DessinFractale(int v) {
        //attention, plus v est grand, plus bob va lentement !
        this();
        bob.speed(v);
    }


    public void reset() {
        bob.clear();
        bob.up();
        bob.setPosition(0, 0);
        bob.setDirection(0);
        bob.down();

    }

    public void close() {
        bob.exit();
    }


    public void carre(double l) {
        carreAux(l, 0);
    }

    public void carreAux(double l, int times) {
        if (times < 4) {
            bob.forward(l);
            bob.left(90);
            carreAux(l, times + 1);
        }
    }

    public void vonKoch(double l, int n) {
        if(n == 0){
            bob.forward(l);
        }
        else {
            vonKoch(l/3, n-1);
            bob.left(60);
            vonKoch(l/3, n-1);
            bob.right(120);
            vonKoch(l/3, n-1);
            bob.left(60);
            vonKoch(l/3, n-1);
        }
    }

    public void arbre(double l, int n) {
        if(n == 0){
            bob.forward(l);
        }
        else {
            arbre(l, n-1);
            bob.left(40);
            arbre(l/3, n-1);
            bob.backward(l/3);
            bob.right(80);
            arbre(l/3, n-1);
            bob.backward(l/3);
            bob.left(40);
            arbre(l/3, n-1);
            bob.backward(l/3);
        }
    }

    public void triforce(double l, int n){
        if(n == 0) {
            bob.forward(l);
            bob.left(120);
            bob.forward(l);
            bob.left(120);
            bob.forward(l);
            bob.left(120);
            bob.forward(l);
        }
        else {
            triforce(l/2, n - 1);
            triforce(l/2, n - 1);
            bob.backward(l/2);
            bob.left(120);
            bob.forward(l/2);
            bob.right(120);
            triforce(l/2, n - 1);
            bob.right(60);
            bob.forward(l/2);
            bob.left(60);
        }
    }

    public void dragon(double l, int n, boolean endroit){
        if(n == 0){
            bob.forward(l);
        }
        else {
            if (endroit) {
                dragon(l, n - 1, true);
                bob.left(90);
                dragon(l, n - 1, false);
            } else {
                dragon(l, n - 1, true);
                bob.right(90);
                dragon(l, n - 1, false);
            }
        }
    }

    public static void main(String[] args) {
        DessinFractale d = new DessinFractale(0);
        d.dragon(200, 20, true);
    }

}