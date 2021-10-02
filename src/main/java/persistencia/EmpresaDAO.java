
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
    
    
    
}
