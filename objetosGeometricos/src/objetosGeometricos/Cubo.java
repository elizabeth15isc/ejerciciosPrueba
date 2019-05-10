package objetosGeometricos;

public class Cubo extends Cuadrado {

    public Cubo() {
    }

    public Cubo(double longLado) {
        setLado(longLado);
    }

    public double calcularVolumen() {
        double volumen = Math.pow(getLado(), 3);
        System.out.println("volumen del cubo:" + volumen);
        return volumen;
    }

    @Override
    public double calcularPerimetro() {
        double perimetro = 12 * getLado();
        System.out.println("perimetro del cubo:" + perimetro);
        return perimetro;
    }

}
