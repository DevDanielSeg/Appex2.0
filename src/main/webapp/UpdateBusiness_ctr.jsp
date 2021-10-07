<%-- 
    Document   : UpdateBusiness_ctr
    Created on : 5/10/2021, 6:19:10 a. m.
    Author     : turme
--%>

<%@page import="logica.LogicaEmpresa"%>
<%@page import="logica.Empresa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizacion de datos</title>
    </head>
    <body>
        <%
            String nitEmpresaPredeterminada = request.getParameter(("nitEmpresaPredeterminada"));
            String nombreEmpresa = request.getParameter("nombreEmpresa");
            String nombreRepLegal = request.getParameter("nombreRepLegal");
            String noIdentidad = request.getParameter("noIdentidad");
            int tipoEmpresa = Integer.parseInt(request.getParameter("tipoEmpresa"));
            int codigoCiiu = Integer.parseInt(request.getParameter("codigoCiiu"));
            int estadoEmpresa = Integer.parseInt(request.getParameter("estadoEmpresa"));
            String departamento = request.getParameter("departamento");
            String ciudadMunicipio = request.getParameter("ciudadMunicipio");
            Empresa e = new Empresa(nombreEmpresa, nitEmpresaPredeterminada, nombreRepLegal, noIdentidad, tipoEmpresa, codigoCiiu, estadoEmpresa, departamento, ciudadMunicipio);
            LogicaEmpresa LogicaEmpresa = new LogicaEmpresa();
            boolean datos = LogicaEmpresa.actualizarDatosEmpresas(e);
            if (datos == true) { %> se actualizaron exitosamente los datos<%} else {%> no se pudieron actualizar los datos<%}
        %>       
        <a href="dashboard.jsp?nitEmpresaPredeterminada=<%=nitEmpresaPredeterminada%>"><button type="submit" class="btn btn-primary" id="btnSubmit">Volver al inicio</button></a>

    </body>
</html>
