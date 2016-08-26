<%-- 
    Document   : Acce_Luga
    Created on : Aug 25, 2016, 9:54:44 AM
    Author     : aerc
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <nav class="navbar navbar-default">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar" aria-expanded="true" aria-controls="navbar">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="#">POO2</a>
                    </div>
                    <div id="navbar" class="navbar-collapse collapse in" aria-expanded="true">
                        <ul class="nav navbar-nav">
                            <li class="active"><a href="#">Lugar Acceso</a></li>
                            <li><a href="Tipo_Docu.jsp">Tipo Documento</a></li>
                            <li><a href="tipo_gafe.jsp">Tipo Gafete</a></li>
                        </ul>
                    </div><!--/.nav-collapse -->
                </div><!--/.container-fluid -->
      </nav>
            <div class="row">
                <div class="col-md-5">
                    <form action="acce_lugaServ" method="Post">
                        <div class="form-group">
                            <input type="hidden" class="form-control" name="cod" id="cod" value="${cod}">
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" id="nomb" name="nomb" placeholder="Nombre" value="${nomb}">
                        </div>
                    
                    <input id="send" name="CursBoton" type="submit" value="Guardar" class="btn btn-success" />
                    <input id="send" name="CursBoton" type="submit" value="Consultar" class="btn btn-info" />
                    <input id="send" name="CursBoton" type="submit" value="Modificar" class="btn btn-warning" />
                    <input id="send" name="CursBoton" type="submit" value="Eliminar" class="btn btn-danger" />
                    
                                        

                </div>
                <div class="col-md-7">
                <jsp:useBean id="lugar" class="com.sv.udb.Controlador.acce_lugaCtrl" scope="page"/>
                <div class="col-md-7">
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>Nombre</th>
                                <th>Fecha Alta</th>
                                <th>Seleccione</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${lugar.consTodo()}" var="fila">
                            <tr>
                                <td><c:out value="${fila.nombLugaAcce}"></c:out></td>
                                <td><c:out value="${fila.fechAlta}"></c:out></td>
                                <td> <input type="radio" name="codiRadi" value="${fila.codiLugaAcce}"/></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                </div>
                </form>
            </div>
        </div>
    </body>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="js/bootstrap.js" type="text/javascript"></script>
</html>
