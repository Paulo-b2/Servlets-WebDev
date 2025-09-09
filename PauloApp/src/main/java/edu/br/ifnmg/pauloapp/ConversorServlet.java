package edu.br.ifnmg.pauloapp;

import edu.br.ifnmg.pauloapp.resources.ConversorTemperatura;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/conversor")
public class ConversorServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");

        String sValor = req.getParameter("valor");
        String de = req.getParameter("de");
        String para = req.getParameter("para");

        try (PrintWriter out = resp.getWriter()) {
            out.println("<html><head><meta charset='utf-8'><title>Conversor</title></head><body>");
            if (sValor == null || sValor.isBlank() || de == null || para == null) {
                out.println("<p>Preencha todos os campos.</p>");
            } else if (de.equals(para)) {
                out.println("<p>Origem e destino são iguais — nada a converter.</p>");
            } else {
                try {
                    double v = Double.parseDouble(sValor.replace(",", "."));
                    double resultado;
                    if (de.equals("C") && para.equals("F")) {
                        resultado = ConversorTemperatura.cParaF(v);
                        out.printf("<p>%.2f °C = %.2f °F</p>%n", v, resultado);
                    } else if (de.equals("F") && para.equals("C")) {
                        resultado = ConversorTemperatura.fParaC(v);
                        out.printf("<p>%.2f °F = %.2f °C</p>%n", v, resultado);
                    } else {
                        out.println("<p>Opção inválida.</p>");
                    }
                } catch (NumberFormatException ex) {
                    out.println("<p>Valor inválido: insira um número.</p>");
                }
            }
            out.println("<p><a href='index.html'>Voltar</a></p></body></html>");
        }
    }
}
