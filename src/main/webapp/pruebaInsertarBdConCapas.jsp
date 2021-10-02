
<%@page import ="logica.Empresa"%>
<%@page import ="logica.LogicaEmpresa"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Probando inserción en BD</h1>
        <div>
            <%
    
            Empresa e = new Empresa ("manualidades","9999","Max","21",true,2393,false,"Santander","Barrancabermeja");
            
            out.println("Se guardará en base de datos el siguiente objeto empresas: "+e.toString());
            
            
            LogicaEmpresa logicaEmpresa = new LogicaEmpresa();
            boolean guardado = logicaEmpresa.guardarEmpresa(e);
            if (guardado == true) {
                out.println("Empresa guardada exitosamente. Verifique manualmente en la base de datos");
            } else {
                out.println("La información de la empresa no se guardó.");
            }
            
            
            %>
        </div>
            
    </body>
</html>
