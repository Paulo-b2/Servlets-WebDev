package edu.br.ifnmg.pauloapp.resources;

public class Ponto {
    private final double x;
    private final double y;

    public Ponto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distanciaPara(Ponto outro) {
        double dx = outro.x - this.x;
        double dy = outro.y - this.y;
        return Math.hypot(dx, dy);
    }
}