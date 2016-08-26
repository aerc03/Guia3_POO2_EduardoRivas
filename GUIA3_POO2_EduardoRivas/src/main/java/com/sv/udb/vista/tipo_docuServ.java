/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.vista;

import com.sv.udb.Controlador.tipo_docuCtrl;
import com.sv.udb.Modelo.TipoDocu;
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
@WebServlet(name = "tipo_docuServ", urlPatterns = {"/tipo_docuServ"})
public class tipo_docuServ extends HttpServlet {

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
                TipoDocu obje = new TipoDocu();
                obje.setNombTipoDocu(request.getParameter("nomb"));
                obje.setFechAlta(new Date());
                obje.setEsta(1);
                mens = new tipo_docuCtrl().guar(obje) ? "Datos guardados exitosamente" : "Datos NO guardados";
                request.getRequestDispatcher("/Tipo_Docu.jsp").forward(request, response);
            }
            if(CRUD.equals("Eliminar"))
            {
                TipoDocu obje = new TipoDocu();
                obje.setCodiTipoDocu(Long.parseLong(request.getParameter("cod")));
                obje.setFechBaja(new Date());
                obje.setEsta(0);
                mens = new tipo_docuCtrl().elim(obje) ? "Datos guardados exitosamente" : "Datos NO guardados";
                request.getRequestDispatcher("/Tipo_Docu.jsp").forward(request, response);
            }
            if(CRUD.equals("Modificar"))
            {
                TipoDocu obje = new TipoDocu();
                obje.setCodiTipoDocu(Long.parseLong(request.getParameter("cod")));
                obje.setNombTipoDocu(request.getParameter("nomb"));
                mens = new tipo_docuCtrl().modi(obje) ? "Datos guardados exitosamente" : "Datos NO guardados";
                request.getRequestDispatcher("/Tipo_Docu.jsp").forward(request, response);
            }
            if(CRUD.equals("Consultar"))
            {
                Long codi = Long.parseLong(request.getParameter("codiRadi"));
                TipoDocu lugar = new tipo_docuCtrl().cons(codi);
                request.setAttribute("cod", lugar.getCodiTipoDocu());
                request.setAttribute("nomb", lugar.getNombTipoDocu());
                request.getRequestDispatcher("/Tipo_Docu.jsp").forward(request, response);
            }
        }
        else
        {
            response.sendRedirect(request.getContextPath() + "/Tipo_Docu.jsp");
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
