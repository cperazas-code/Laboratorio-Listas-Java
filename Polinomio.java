public class Polinomio {
    static class Termino {
        double coeficiente;
        int exponente;
        Termino sig;
        Termino(double c, int e) {
            this.coeficiente = c;
            this.exponente = e;
            this.sig = null;
        }
    }

    private Termino inicio = null;

    public void agregarTermino(double c, int e) {
        Termino nuevo = new Termino(c, e);
        if (inicio == null) {
            inicio = nuevo;
        } else {
            Termino reco = inicio;
            while (reco.sig != null) reco = reco.sig;
            reco.sig = nuevo;
        }
    }

    public double evaluar(double x) {
        double total = 0;
        Termino reco = inicio;
        while (reco != null) {
            total += reco.coeficiente * Math.pow(x, reco.exponente);
            reco = reco.sig;
        }
        return total;
    }

    public static void main(String[] args) {
        Polinomio p = new Polinomio();
        p.agregarTermino(3, 4);
        p.agregarTermino(-4, 2);
        p.agregarTermino(11, 0);

        System.out.println("Evaluando Polinomio:");
        System.out.println("x\tP(x)");
        for (double x = 0.0; x <= 5.0; x += 0.5) {
            System.out.printf("%.1f\t%.2f\n", x, p.evaluar(x));
        }
    }
}