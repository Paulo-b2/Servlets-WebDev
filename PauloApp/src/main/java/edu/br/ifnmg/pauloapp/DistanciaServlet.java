package edu.br.ifnmg.pauloapp;

import edu.br.ifnmg.pauloapp.resources.Ponto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/distancia")
public class DistanciaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");

        String sx1 = req.getParameter("x1");
        String sy1 = req.getParameter("y1");
        String sx2 = req.getParameter("x2");
        String sy2 = req.getParameter("y2");

        try (PrintWriter out = resp.getWriter()) {
            out.println("<html><head><meta charset='utf-8'><title>Distância</title></head><body>");
            if (sx1 == null || sy1 == null || sx2 == null || sy2 == null
                    || sx1.isBlank() || sy1.isBlank() || sx2.isBlank() || sy2.isBlank()) {
                out.println("<p>Por favor, preencha todos os campos.</p>");
            } else {
                try {
                    double x1 = Double.parseDouble(sx1.replace(",", "."));
                    double y1 = Double.parseDouble(sy1.replace(",", "."));
                    double x2 = Double.parseDouble(sx2.replace(",", "."));
                    double y2 = Double.parseDouble(sy2.replace(",", "."));
                    Ponto p1 = new Ponto(x1, y1);
                    Ponto p2 = new Ponto(x2, y2);
                    double distancia = p1.distanciaPara(p2);
                    out.printf("<p>Distância entre os pontos: %.6f</p>%n", distancia);
                } catch (NumberFormatException ex) {
                    out.println("<p>Entrada inválida: insira coordenadas numéricas.</p>");
                }
            }
            out.println("<p><a href='index.html'>Voltar</a></p></body></html>");
        }
    }
}
