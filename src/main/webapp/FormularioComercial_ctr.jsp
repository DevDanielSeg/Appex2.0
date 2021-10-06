<%-- 
    Document   : juguetes_ctrl
    Created on : 14/09/2021, 7:13:43 a. m.
    Author     : Cielo Juliana
--%>


<%@page import="logica.LogicaEmpresa"%>
<%@page import="logica.Empresa"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    </head>
    <body>
        <%
            String nitEmpresaPredeterminada = request.getParameter("nitEmpresaPredeterminada");
            String nombreEmpresa = request.getParameter("nombreEmpresa");
            String nit = request.getParameter("nit");
            String nombreRepLegal = request.getParameter("nombreRepLegal");
            String noIdentidad = request.getParameter("noIdentidad");
            int tipoEmpresa = Integer.parseInt(request.getParameter("tipoEmpresa"));
            int codigoCiiu = Integer.parseInt(request.getParameter("codigoCiiu"));
            int estadoEmpresa = Integer.parseInt(request.getParameter("estadoEmpresa"));
            String departamento = request.getParameter("departamento");
            String ciudadMunicipio = request.getParameter("ciudadMunicipio");
            Empresa e = null;
            e = new Empresa(nombreEmpresa, nit, nombreRepLegal, noIdentidad, tipoEmpresa, codigoCiiu, estadoEmpresa, departamento, ciudadMunicipio);
            LogicaEmpresa LogicaEmpresa = new LogicaEmpresa();
            boolean guardado = LogicaEmpresa.guardarEmpresa(e);
            if (guardado == true) {
                out.println("Empresa guardada exitosamente");
            } else {
                out.println("Información de Empresa no se guardó.");
            }
        %>
        <a href="FormularioEmpresas.jsp?nitEmpresaPredeterminada=<%=nitEmpresaPredeterminada%>"><button type="submit" class="btn btn-primary" id="btnSubmit">Volver a la lista</button></a>
    </body>
</html>

