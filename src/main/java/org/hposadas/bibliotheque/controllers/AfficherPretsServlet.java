package org.hposadas.bibliotheque.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hposadas.bibliotheque.models.ItemPret;
import org.hposadas.bibliotheque.models.Pret;

import java.io.IOException;

@WebServlet("/afficher-prets")
public class AfficherPretsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/prets.jsp").forward(req,resp);
    }
}
