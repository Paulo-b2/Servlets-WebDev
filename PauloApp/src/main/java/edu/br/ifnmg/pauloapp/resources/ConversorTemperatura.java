package edu.br.ifnmg.pauloapp.resources;

public class ConversorTemperatura {
    public static double cParaF(double c) {
        return (c * 9.0/5.0) + 32.0;
    }
    public static double fParaC(double f) {
        return (f - 32.0) * 5.0/9.0;
    }
}