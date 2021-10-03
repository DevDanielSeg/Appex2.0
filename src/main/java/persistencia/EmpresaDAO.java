
package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import logica.Empresa;
public class EmpresaDAO {
    
    public int guardarNuevaEmpresa(Empresa e) {
        
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
        int id = 0;
        try {
            if (rs.next()){
                id = rs.getInt(1);
            }
        } catch (SQLException ex) {
            con.desconectar();
            return 0; 
        }
        con.desconectar();
        return id;
    }
    
    
    
    /**
     * Envía la sentencia SQL para actualizar el dato de una empresa existente
     * @param e un objeto de tipo Empresa
     * retorna un booleano, donde TRUE es que modifico SOLO UNA EMPRESA y FALSE es que no afecto ninguna fila de la 
     * base de datos 
     */
    public boolean actualizarEmpresa(Empresa e) {
        ConexionBD con = new ConexionBD();
        //recogemos los datos de la empresa y los guardamos 
        //en unas variables para poder usarlos mas adelante
        String nombreEmpresa = e.getNombreEmpresa();
        String nit = e.getNit();
        String nombreRepLegal = e.getNombreRepLegal();
        String noIdentidad = e.getNoIdentidad();
        boolean tipoEmpresa = e.isTipoEmpresa();
        int codigoCiiu = e.getCodigoCiiu();
        boolean estadoEmpresa = e.isEstadoEmpresa();
        String departamento = e.getDepartamento();
        String ciudadMunicipio = e.getCiudadMunicipio();
        
        //sentencia sql que se va a ejecutar en la base de datos
        //donde vamos a especificar que dato quiero que se actualice 
        String sql = "UPDATE dbappex2.empresa" +   //base de datos y tabla que queremos alterar
                     "SET nombre_empresa ='"+ nombreEmpresa + "' ,nombre_representante = '" + nombreRepLegal + "', documento_representante = '" + noIdentidad +
                                          "', tipo_empresa = '" +  tipoEmpresa + "',cod_ciiu = '" + codigoCiiu + "', estado_empresa = '" + estadoEmpresa + "', departamento = '" + departamento + 
                                          "', ciudad = '" + ciudadMunicipio + "' " +     // datos que queremos alterar
                     "WHERE nit_empresa = " + nit + " ";   //que empresa en especifico vamos a alterar
              
        int filas = con.ejecutarUpdate(sql);
        con.desconectar();
        if (filas == 1){
            return true;
        }
        return false; 
    }
    
    
    
}
