package edu.br.ifnmg.pauloapp;

import edu.br.ifnmg.pauloapp.resources.Calculadora;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calculadora")
public class CalculadoraServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String sNum1 = req.getParameter("num1");
        String sNum2 = req.getParameter("num2");

        try (PrintWriter out = resp.getWriter()) {
            out.println("<html><head><meta charset='utf-8'><title>Resultado</title></head><body>");
            if (sNum1 == null || sNum2 == null || sNum1.isBlank() || sNum2.isBlank()) {
                out.println("<p>Por favor, forneça ambos os números.</p>");
            } else {
                try {
                    double n1 = Double.parseDouble(sNum1.replace(",", "."));
                    double n2 = Double.parseDouble(sNum2.replace(",", "."));
                    Calculadora calc = new Calculadora(n1, n2);
                    out.printf("<p>Soma: %s</p>%n", calc.soma());
                    out.printf("<p>Subtração: %s</p>%n", calc.subtracao());
                    out.printf("<p>Multiplicação: %s</p>%n", calc.multiplicacao());
                    Double div = calc.divisao();
                    if (div == null) {
                        out.println("<p>Divisão: ERRO (divisão por zero)</p>");
                    } else {
                        out.printf("<p>Divisão: %s</p>%n", div);
                    }
                } catch (NumberFormatException ex) {
                    out.println("<p>Entrada inválida: insira valores numéricos válidos.</p>");
                }
            }
            out.println("<p><a href='index.html'>Voltar</a></p></body></html>");
        }
    }
}
