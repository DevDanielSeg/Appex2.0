<%@page import="logica.Empresa"%>
<%@page import="logica.LogicaEmpresa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Public+Sans:wght@200&family=Roboto&display=swap" rel="stylesheet">

        <link rel="stylesheet" href="estilos/estilo.css">

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

        <title>Consultar Empresas</title>
    </head>
    <body>
        <div class="container mt-5"> 
            <h1 class="mb-3">Busqueda de empresas</h1>

            <%
                String filtro = (request.getParameter("txtFiltro") == null) ? "" : request.getParameter("txtFiltro");
            %>
            <div class="">
                <form method="GET" class="">
                    <div class="form-group">
                        <label for="txt1" class="">Filtrar</label>
                        <input type="text" class="" id="txtFiltro" name="txtFiltro" value="<%= filtro %>" placeholder="Por palabra clave">
                    </div>
                        <button type="submit" class="">Consultar</button>                    
                </form>
                    <h2>Resultado de la consulta</h2>
                    <%
                        LogicaEmpresa LogicaEmpresa = new LogicaEmpresa();
                        boolean hayDatos;
                        if (filtro.equals("") ) {
                            hayDatos = LogicaEmpresa.cargarTodasLasEmpresas();
                        }
                        else {
                            hayDatos = LogicaEmpresa.cargarEmpresasPorFiltro(filtro);
                        }
                    %>
                    <div class="cajaPadre">
                    <%  if (hayDatos) { %>
                     <% for (Empresa e : LogicaEmpresa.getLista()) { %>
                        <div class="cards">
                            <img src="src" alt="alt" width="500px" height="500px"/>
                            <div>
                                <h3><%= e.getNombreEmpresa() %></h3>
                                <p><%= e.getCodigoCiiu() %></p>
                                <p><%= e.getDepartamento() %> - <%= e.getCiudadMunicipio() %></p>
                                <p><%= e.getEstadoEmpresa() %></p>
                            </div> 
                        </div> 
                            
                        <% } %>
                        <% } else { %>
                        <div class="cards">
                            <img src="src/nohaydatos.png" alt="alt" width="500px" height="500px"/>
                            <h3 class="text-center">Lo sentimos, no tenemos datos que concidan con la busqueda</h3>
                        </div>
                        <% } %>
                    </div>
            </div>
    </body>
</html>

