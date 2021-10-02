
<%@page import="java.sql.*"%>
<%@page import="com.mysql.jdbc.Driver"%>
<%@page import="persistencia.ConexionBD"%>
<%@page import ="logica.Empresa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Tabla empresas</h1>
        <div>
         <%   
            /*Código para crear objeto empresas asignando manualmente ID, sin separar responsabilidades en capas. 
            El id debe ser al menos una unidad superior al último id que asignó la bd
            El NIT no puede existir previamente en la bd
            */
            Empresa e = new Empresa (38,"ArteSanas","3243275","Lucas","354543",true,2393,false,"Norte de Santander","Hacarí");
            out.println("Objeto 1 que se insertará en la BD"+e.toString());
            
             ConexionBD con = new ConexionBD(); 
                     
             int idEmpresa = e.getId();
             String nombreEmpresa = e.getNombreEmpresa();
             String nit = e.getNit();
             String nombreRepLegal = e.getNombreRepLegal();
             String noIdentidad = e.getNoIdentidad();
             boolean tipoEmpresa = e.isTipoEmpresa();
             int codigoCiiu = e.getCodigoCiiu();
             boolean estadoEmpresa = e.isEstadoEmpresa();
             String departamento = e.getDepartamento();
             String ciudadMunicipio = e.getCiudadMunicipio();
             
             String sql = "INSERT INTO empresa(id_empresa,nombre_empresa,nit_empresa,nombre_representante,documento_representante,tipo_empresa,cod_ciiu,estado_empresa,departamento,ciudad) "+
            "VALUES ("+idEmpresa+",'"+nombreEmpresa+"','"+nit+"','"+nombreRepLegal+"','"+noIdentidad+"',"+tipoEmpresa+","+codigoCiiu+","+estadoEmpresa+",'"+departamento+"','"+ciudadMunicipio+"')";
              
            ResultSet rs = con.ejecutarInsert(sql);
             

            //Código para crear objeto empresas, el id es asignado automáticamente durante la inserción,sin separar responsabilidades en capas 
            Empresa e2 = new Empresa ("La mano negra","8453","Shelly","43534",true,2393,true,"Santander","Florida Blanca");
            out.println("Objeto 2 que se insertará en la BD"+e2.toString());
                   
             
             String nombreEmpresa2 = e2.getNombreEmpresa();
             String nit2 = e2.getNit();
             String nombreRepLegal2 = e2.getNombreRepLegal();
             String noIdentidad2 = e2.getNoIdentidad();
             boolean tipoEmpresa2 = e2.isTipoEmpresa();
             int codigoCiiu2 = e2.getCodigoCiiu();
             boolean estadoEmpresa2 = e2.isEstadoEmpresa();
             String departamento2 = e2.getDepartamento();
             String ciudadMunicipio2 = e2.getCiudadMunicipio();
             
            String sql2 = "INSERT INTO empresa(nombre_empresa,nit_empresa,nombre_representante,documento_representante,tipo_empresa,cod_ciiu,estado_empresa,departamento,ciudad) "+
            "VALUES ('"+nombreEmpresa2+"','"+nit2+"','"+nombreRepLegal2+"','"+noIdentidad2+"',"+tipoEmpresa2+","+codigoCiiu2+","+estadoEmpresa2+",'"+departamento2+"','"+ciudadMunicipio2+"')";
                 
            ResultSet rs2 = con.ejecutarInsert(sql2);
                        
            ResultSet rs3=null;
            String sentencia;
            sentencia="SELECT * FROM empresa;";
            rs3 = con.ejecutarQuery(sentencia);
            while (rs3.next()) {
         %>
                <div><%= rs3.getInt(1)%></div>
                <div><%= rs3.getString(2)%></div>
                <div><%= rs3.getString(3)%></div>
                <div><%= rs3.getString(4)%></div>
                <div><%= rs3.getString(5)%></div>
                <div><%= rs3.getBoolean(6)%></div>
                <div><%= rs3.getInt(7)%></div>
                <div><%= rs3.getBoolean(8)%></div>
                <div><%= rs3.getString(9)%></div>
                <div><%= rs3.getString(10)%></div>
                           
        <%
            }
        %>  
            
            
        </div>
        
    </body>
</html>
