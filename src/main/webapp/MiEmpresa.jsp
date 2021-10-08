<%-- 
    Document   : MiEmpresa
    Created on : 5/10/2021, 4:40:33 p. m.
    Author     : turme
--%>

<%@page import="logica.Empresa"%>
<%@page import="logica.LogicaEmpresa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
        <%//este se modifico %>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Public+Sans:wght@200&family=Roboto&display=swap" rel="stylesheet">

        <link rel="stylesheet" href="estilos/estilo.css">
        <link rel="stylesheet" href="estilos/cajas.css">
        <link rel="stylesheet" href="estilos/estilosMenu.css">

        <link rel="apple-touch-icon" sizes="57x57" href="src/apple-icon-57x57.png">
        <link rel="apple-touch-icon" sizes="60x60" href="src/apple-icon-60x60.png">
        <link rel="apple-touch-icon" sizes="72x72" href="src/apple-icon-72x72.png">
        <link rel="apple-touch-icon" sizes="76x76" href="src/apple-icon-76x76.png">
        <link rel="apple-touch-icon" sizes="114x114" href="src/apple-icon-114x114.png">
        <link rel="apple-touch-icon" sizes="120x120" href="src/apple-icon-120x120.png">
        <link rel="apple-touch-icon" sizes="144x144" href="src/apple-icon-144x144.png">
        <link rel="apple-touch-icon" sizes="152x152" href="src/apple-icon-152x152.png">
        <link rel="apple-touch-icon" sizes="180x180" href="src/apple-icon-180x180.png">
        <link rel="icon" type="image/png" sizes="192x192"  href="src/android-icon-192x192.png">
        <link rel="icon" type="image/png" sizes="32x32" href="src/favicon-32x32.png">
        <link rel="icon" type="image/png" sizes="96x96" href="src/favicon-96x96.png">
        <link rel="icon" type="image/png" sizes="16x16" href="src/favicon-16x16.png">

        <meta name="theme-color" content="#f5af19">
        <meta name="msapplication-TileColor" content="#f5af19">
        <meta name="msapplication-TileImage" content="src/ms-icon-144x144.png">

        <link rel="manifest" href="src/manifest.json">

        <title>Mi empresa</title>
    </head
    <body>
        <%String nitEmpresaPredeterminada = request.getParameter("nitEmpresaPredeterminada");
        
        LogicaEmpresa LogicaEmpresa = new LogicaEmpresa();
        LogicaEmpresa.consultarEmpresaPorNit(nitEmpresaPredeterminada);
            for (Empresa e : LogicaEmpresa.getLista()) {
                String nombreEmpresa = e.getNombreEmpresa();
                String nombreRepLegal = e.getNombreRepLegal();
                String noIdentidad = e.getNoIdentidad();
                int tipoEmpresa = e.isTipoEmpresa();
                int codigoCiiu = e.getCodigoCiiu();
                int estadoEmpresa = e.isEstadoEmpresa();
                String departamento = e.getDepartamento();
                String ciudadMunicipio = e.getCiudadMunicipio();
                %>
                
        <menu class="menu backgroundDeg">
            <div class="displayFlexCenter">

                <label for="botonMenu" class="botonMenu" id="marginImg">
                    <img src="src/assets/menu.svg" alt="" class="marginImg">
                    <img src="src/assets/cerrar.svg" alt="" class="botonCerrar">
                </label>

                <a href="dashboard.jsp?nitEmpresaPredeterminada=<%=nitEmpresaPredeterminada%>" class="logoMenu menuBrillo"></a>
            </div>
            <input type="checkbox" id="botonMenu" class="menuInputCheckbox">        
            <div class="desplegableMenu displayFlexCenterRes">
                <a href="dashboard.jsp?nitEmpresaPredeterminada=<%=nitEmpresaPredeterminada%>">Inicio</a>
                <a href="MiEmpresa.jsp?nitEmpresaPredeterminada=<%=nitEmpresaPredeterminada%>">Mis Datos</a>
                <a href="ConsultaEmpresa.jsp?nitEmpresaPredeterminada=<%=nitEmpresaPredeterminada%>">Catalogo</a>
                <a href="">Productos</a>
                <a href="Login.jsp" >Salir</a>
            </div>
        </menu>
                
                
        <h1>Mi empresa</h1>             
        
        <div class="text-center">
            <p>nombre:  <%=nombreEmpresa %> </p>
            <p>nit:  <%=nitEmpresaPredeterminada %> </p>
            <p>nombre representante legal:  <%=nombreRepLegal %> </p>
            <p>numero de documento:  <%=noIdentidad %> </p>
            <p>tipo de empresa:  <%=tipoEmpresa %> </p>
            <p>codigo ciiu:  <%=codigoCiiu %> </p>
            <p>estado de la empresa:  <%=estadoEmpresa %> </p>
            <p>departamento:  <%=departamento %></p>
            <p>ciudad/municipio:  <%=ciudadMunicipio%></p>
            <div><br>
                <a href="UpdateBusiness.jsp?nitEmpresaPredeterminada=<%=nitEmpresaPredeterminada %>" ><button>editar</button> </a>
                <a href="dashboard.jsp?nitEmpresaPredeterminada=<%=nitEmpresaPredeterminada %>" ><button>inicio</button> </a>

            </div>
        </div>
                <%}%>
    </body>
</html>
