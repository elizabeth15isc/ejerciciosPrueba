package objetosGeometricos;

public class Cuadrado {

    private double lado;

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }

    public Cuadrado() {
    }
    public Cuadrado(double longLado){
        this.lado = longLado;
    }

    public double calcularArea() {
        double area = Math.pow(lado, 2);
        System.out.println("area del cuadro:"+area);
        return area;
    }

    public double calcularPerimetro() {
        double perimetro = lado * 4;
                System.out.println("perimetro del cuadro:"+perimetro);
        return perimetro;
    }
}
