/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.vista;

import com.sv.udb.Controlador.tipo_gafeCtrl;
import com.sv.udb.Modelo.TipoGafe;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aerc
 */
@WebServlet(name = "tipo_gafeServ", urlPatterns = {"/tipo_gafeServ"})
public class tipo_gafeServ extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean esValido = request.getMethod().equals("POST");
        if(esValido)
        {
            String mens = "";
            String CRUD = request.getParameter("CursBoton");
            if(CRUD.equals("Guardar"))
            {
                TipoGafe obje = new TipoGafe();
                obje.setNombTipoGafe(request.getParameter("nomb"));
                obje.setFechAlta(new Date());
                obje.setEsta(1);
                mens = new tipo_gafeCtrl().guar(obje) ? "Datos guardados exitosamente" : "Datos NO guardados";
                request.getRequestDispatcher("/tipo_gafe.jsp").forward(request, response);
            }
            if(CRUD.equals("Eliminar"))
            {
                TipoGafe obje = new TipoGafe();
                obje.setCodiTipoGafe(Long.parseLong(request.getParameter("cod")));
                obje.setFechBaja(new Date());
                obje.setEsta(0);
                mens = new tipo_gafeCtrl().elim(obje) ? "Datos guardados exitosamente" : "Datos NO guardados";
                request.getRequestDispatcher("/tipo_gafe.jsp").forward(request, response);
            }
            if(CRUD.equals("Modificar"))
            {
                TipoGafe obje = new TipoGafe();
                obje.setCodiTipoGafe(Long.parseLong(request.getParameter("cod")));
                obje.setNombTipoGafe(request.getParameter("nomb"));
                mens = new tipo_gafeCtrl().modi(obje) ? "Datos guardados exitosamente" : "Datos NO guardados";
                request.getRequestDispatcher("/tipo_gafe.jsp").forward(request, response);
            }
            if(CRUD.equals("Consultar"))
            {
                Long codi = Long.parseLong(request.getParameter("codiRadi"));
                TipoGafe lugar = new tipo_gafeCtrl().cons(codi);
                request.setAttribute("cod", lugar.getCodiTipoGafe());
                request.setAttribute("nomb", lugar.getNombTipoGafe());
                request.getRequestDispatcher("/tipo_gafe.jsp").forward(request, response);
            }
        }
        else
        {
            response.sendRedirect(request.getContextPath() + "/tipo_gafe.jsp");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
