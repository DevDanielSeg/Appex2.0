
package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    
    public ArrayList<Empresa> consultarEmpresas() {
        ArrayList<Empresa> lista = new ArrayList<>();
        ConexionBD con = new ConexionBD();
        String sql = "SELECT id_empresa, nombre_empresa, nit_empresa, nombre_representante, documento_representante, tipo_empresa, cod_ciiu, estado_empresa, departamento, ciudad "+ 
                     "FROM dbappex2.empresa ";
        ResultSet rs = con.ejecutarQuery(sql);
        try {
            while (rs.next()) {
                int id = rs.getInt("id_empresa");
                String nombreEmpresa = rs.getString("nombre_empresa");
                String nit = rs.getString("nit_empresa");
                String nombreRepLegal = rs.getString("nombre_representante");
                String noIdentidad = rs.getString("documento_representante");
                boolean tipoEmpresa = Boolean.parseBoolean(rs.getString("tipo_empresa"));
                int codigoCiiu = rs.getInt("cod_ciiu");
                boolean estadoEmpresa = Boolean.parseBoolean(rs.getString("estado_empresa"));
                String departamento = rs.getString("departamento");
                String ciudadMunicipio = rs.getString("ciudad");
                Empresa e = new Empresa(id, nombreEmpresa, nit, nombreRepLegal, noIdentidad, tipoEmpresa, codigoCiiu, estadoEmpresa, departamento, ciudadMunicipio);
                lista.add(e);
            }
        } catch (SQLException ex) {
            con.desconectar();
            return null;
        }
        con.desconectar();
        return lista;
    }
    
     public ArrayList<Empresa> consultarEmpresasPorFiltro(String filtro) {
        ArrayList<Empresa> lista = new ArrayList<>();
        ConexionBD con = new ConexionBD();
        String sql = "SELECT j.id, j.nombre, j.tipojuguete_id, t.tipo, j.fechacompra, j.estadojuguete_id, e.estado, j.disponibilidad " +
                     "FROM juguetes j " +
                     "JOIN tipos_juguetes t ON (j.tipojuguete_id = t.id) " +
                     "JOIN estados_juguetes e ON (j.estadojuguete_id = e.id) " +
                     "WHERE j.nombre LIKE '%" + filtro + "%' " +
                     "OR t.tipo LIKE '%" + filtro + "%' " +
                     "OR e.estado LIKE '%" + filtro + "%' " +
                     "OR j.disponibilidad LIKE '%" + filtro + "%' ";
        ResultSet rs = con.ejecutarQuery(sql);
        try {
            while (rs.next()) {
                int id = rs.getInt("id_empresa");
                String nombreEmpresa = rs.getString("nombre_empresa");
                String nit = rs.getString("nit_empresa");
                String nombreRepLegal = rs.getString("nombre_representante");
                String noIdentidad = rs.getString("documento_representante");
                boolean tipoEmpresa = Boolean.parseBoolean(rs.getString("tipo_empresa"));
                int codigoCiiu = rs.getInt("cod_ciiu");
                boolean estadoEmpresa = Boolean.parseBoolean(rs.getString("estado_empresa"));;
                String departamento = rs.getString("departamento");
                String ciudadMunicipio = rs.getString("ciudad");
                Empresa e = new Empresa(nombreEmpresa, nit, nombreRepLegal, noIdentidad, tipoEmpresa, codigoCiiu, estadoEmpresa, departamento, ciudadMunicipio);
                lista.add(e);
            }
        } catch (SQLException ex) {
            con.desconectar();
            return null;
        }
        con.desconectar();
        return lista;
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
    
        public ArrayList<Empresa> consultarEmpresaNit(int nit_consultar)  {
        Empresa e = null;
        ArrayList<Empresa> lista = new ArrayList<>();

        ConexionBD con = new ConexionBD();
        String sql = "SELECT  id_empresa, nombre_empresa, nit_empresa, nombre_representante, documento_representante, tipo_empresa, cod_ciiu, estado_empresa, departamento, ciudad" +
                     "FROM dbappex2.empresa"+
                     "WHERE nit_empresa = '" + nit_consultar + "' ";
        
        ResultSet rs = con.ejecutarQuery(sql);
        try{
        if (rs.next()){
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
        
        e = new Empresa (idEmpresa,nombreEmpresa,nit,nombreRepLegal,noIdentidad, tipoEmpresa,codigoCiiu,estadoEmpresa,departamento,ciudadMunicipio);
        lista.add(e);
        }}
        
        catch (SQLException ex){
            con.desconectar();
            return null;
        }
              

        con.desconectar();
        return lista;
    }
    
    
}
