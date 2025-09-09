package edu.br.ifnmg.pauloapp.resources;

public class Calculadora {
    private final double a;
    private final double b;

    public Calculadora(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double soma() { return a + b; }
    public double subtracao() { return a - b; }
    public double multiplicacao() { return a * b; }
    public Double divisao() {
        if (b == 0) return null;
        return a / b;
    }
}