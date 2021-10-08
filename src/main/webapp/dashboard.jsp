<%-- 
    Document   : dashboard
    Created on : 4/10/2021, 1:01:22 p. m.
    Author     : turme
--%>

<%@page import="logica.Empresa"%>
<%@page import="java.util.ArrayList"%>
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

        <link rel="stylesheet" href="estilos/estilos2.css">

        <title>AppEx</title>
    </head>
    <body>
        <%String nitEmpresaPredeterminada = "11111" ;//request.getParameter("nitEmpresaPredeterminada");
            LogicaEmpresa LogicaEmpresa = new LogicaEmpresa();
            LogicaEmpresa.consultarEmpresaPorNit(nitEmpresaPredeterminada);
            for (Empresa e : LogicaEmpresa.getLista()) {
                String nombreEmpresa = e.getNombreEmpresa();
<<<<<<< HEAD
=======
                String nombreRepLegal = e.getNombreRepLegal();
                String noIdentidad = e.getNoIdentidad();
                int tipoEmpresa = e.isTipoEmpresa();
>>>>>>> parent of f9288ee (dashboard 3.0)
                int codigoCiiu = e.getCodigoCiiu();
                int estadoEmpresa = e.isEstadoEmpresa();
                String departamento = e.getDepartamento();
                String ciudadMunicipio = e.getCiudadMunicipio();
        %>

<<<<<<< HEAD
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
        <div class="body">
            <h1 class="titulo">Tu menu - AppEx</h1>
            <div class="cards">
                <h2 class="titulo">Mis datos</h2>
                <div>
                    <p class="form-group">Mi empresa:</p>
                    <h3 class="text-center"><%=nombreEmpresa%></h3>
                </div>

                <div class="form-group">
                    <h4>Descripción:</h4><br>
                    <p class="text-center">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ante arcu, vestibulum vitae leo egestas, viverra pretium quam. Praesent tempor efficitur metus, luctus fermentum ex finibus vel. Curabitur dapibus porta eros, et commodo felis porta sit amet. Nunc a eros non odio molestie laoreet. Aenean hendrerit quis lacus dignissim semper. Sed ut leo laoreet nunc vehicula imperdiet.</p>
                </div>
                <br>
                <div class="displayFlexCenterRes">
                    <div>
                        <h4>Codigo ciiu: <%=codigoCiiu%></h4>
                        <p>Fabricación de otros productos de cerámica y porcelana </p>
                    </div>
                    <br>    
                    <div class="form-group text-left">
                        <h4>Ubicacion:</h4>
                        <p class="text-center">Departamento: <strong><%=departamento%></strong> Municipio: <strong><%=ciudadMunicipio%></strong></p>
                    </div>
                </div>
            </div> 
            <div class="cards">
                <h3>Opciones</h3><br>
                <div class="displayFlexCenterRes">
                    <a><button>Agregar Productos</button></a>
                    <a href="FormularioEmpresas.jsp?nitEmpresaPredeterminada=<%=nitEmpresaPredeterminada%>"> <button>Registrar Empresa</button></a>
                    <a href="FormularioComercial.jsp?nitEmpresaPredeterminada=<%=nitEmpresaPredeterminada%>"><button>Datos Comerciales</button></a>
                </div>
=======
        <div class="display">
            <div>
                <img src="src/apple-icon-180x180.png" width="50px" alt="alt"/>
            </div>
            <div class="">
                <a href="dashboard.jsp?nitEmpresaPredeterminada=<%=nitEmpresaPredeterminada%>" ><button>inicio</button></a>
                <a href="FormularioEmpresas.jsp?nitEmpresaPredeterminada=<%=nitEmpresaPredeterminada%>" > <button>Registro</button></a>
                <a href="MiEmpresa.jsp?nitEmpresaPredeterminada=<%=nitEmpresaPredeterminada%>"><button>mis datos</button></a>
                <a href="FormularioComercial.jsp?nitEmpresaPredeterminada=<%=nitEmpresaPredeterminada%>"><button>descripcion</button></a>
                <a href="ConsultaEmpresa.jsp?nitEmpresaPredeterminada=<%=nitEmpresaPredeterminada%>"><button>catalogo</button></a>
                <a href=""><button>Productos</button></a>
                <a href="login.jsp" > <button>salir</button></a>
            </div>
        </div>
        <h3>Mis datos</h3>

        <table>
            <div>
                <div><tr><hr>
                    <p>
                        Mi empresa:<%=nombreEmpresa%><br>
                        descripcion de la empresa
                        <br> hasta el momento no la hemos conectado a 
                        <br> la base de datos asi que no hay descripcion
                    </p>
                </div></tr><hr>
                <div><tr>
                        Ubicacion de <%=nombreEmpresa%><br>
                    Departamento: <%=departamento%><br>
                    Municipio: <%=ciudadMunicipio%>

                </div></tr><hr>
                <div><tr> 
                    <p>
                        Codigo ciiu: <%=codigoCiiu%><br>
                        Descripcion: <br>
                        Fabricación de otros productos de cerámica y
                        porcelana 
                    </p>
                </div></tr><hr>
            </div>
        </table>

        <div>
            <h3>Funciones</h3>
            <div>
                Funciones Principales
            </div>
            <div>
                Funciones Secundarias
            </div>
            <div>
                Funciones Terciarias
>>>>>>> parent of f9288ee (dashboard 3.0)
            </div>

<<<<<<< HEAD
            <div class="cards">
                <h3>Configuraciones</h3><br>
                <div class="displayFlexCenterRes">
                    <a><button>Editar Perfil</button></a>
                    <a href="MiEmpresa.jsp?nitEmpresaPredeterminada=<%=nitEmpresaPredeterminada%>"><button>Editar Empresa</button></a>
                </div>
            </div>

        </div>
=======
>>>>>>> parent of f9288ee (dashboard 3.0)
    </body><%}%>
</html>
