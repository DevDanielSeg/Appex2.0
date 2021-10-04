
package persistencia;

import com.sun.tools.javac.util.Assert;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static javax.swing.UIManager.getString;
import logica.Empresa;


public class EmpresaDAO {
    
    public int guardarNuevaEmpresa(Empresa e) {
        
        ConexionBD con = new ConexionBD();
        
        int idEmpresa = e.getId();
        String nombreEmpresa = e.getNombreEmpresa();
        String nit = e.getNit();
        String nombreRepLegal = e.getNombreRepLegal();
        String noIdentidad = e.getNoIdentidad();
        int tipoEmpresa = e.isTipoEmpresa();
        int codigoCiiu = e.getCodigoCiiu();
        int estadoEmpresa = e.isEstadoEmpresa();
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
     * Envía la sentencia SQL para consutar empresas en todas nuestras bases datos
     * @param e un objeto de tipo Empresa
     * retorna una lista, donde se encuentran las empresas registradas 
     */
    
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
                int tipoEmpresa = Integer.parseInt((rs.getString("tipo_empresa")));
                int codigoCiiu = Integer.parseInt(rs.getString("cod_ciiu"));
                int estadoEmpresa = Integer.parseInt((rs.getString("estado_empresa")));
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
    
     /**
     * Envía la sentencia SQL para consutar empresas que considan con el filtro en todas nuestras bases datos
     * Resive parametro filtro
     * @param e un objeto de tipo Empresa
     * retorna una lista, donde se encuentran las empresas registradas con el filtro ejecutados
     */
    
     public ArrayList<Empresa> consultarEmpresasPorFiltro(String filtro) {
        ArrayList<Empresa> lista = new ArrayList<>();
        ConexionBD con = new ConexionBD();
        String sql = "SELECT e.id_empresa, e.nombre_empresa, e.nit_empresa, e.nombre_representante, e.documento_representante, e.tipo_empresa, e.cod_ciiu, e.estado_empresa, e.departamento, e.ciudad " +
                    "FROM empresa e " +                        
                    "WHERE e.nombre_empresa LIKE '%" + filtro + "%' " +
                    "OR e.nit_empresa LIKE '%" + filtro + "%' " +
                    "OR e.nombre_representante LIKE '%" + filtro + "%' " +
                    "OR e.documento_representante LIKE '%" + filtro + "%' " +
                    "OR e.tipo_empresa LIKE '%" + filtro + "%' " +
                    "OR e.cod_ciiu LIKE '%" + filtro + "%' " +
                    "OR e.estado_empresa LIKE '%" + filtro + "%' " +
                    "OR e.departamento LIKE '%" + filtro + "%' " +
                    "OR e.ciudad LIKE '%" + filtro + "%' ";        
        ResultSet rs = con.ejecutarQuery(sql);
        try {
            while (rs.next()) {
                int id = rs.getInt("id_empresa");
                String nombreEmpresa = rs.getString("nombre_empresa");
                String nit = rs.getString("nit_empresa");
                String nombreRepLegal = rs.getString("nombre_representante");
                String noIdentidad = rs.getString("documento_representante");
                int tipoEmpresa = Integer.parseInt((rs.getString("tipo_empresa")));
                int codigoCiiu = Integer.parseInt(rs.getString("cod_ciiu"));
                int estadoEmpresa = Integer.parseInt((rs.getString("estado_empresa")));
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
        int tipoEmpresa = e.isTipoEmpresa();
        int codigoCiiu = e.getCodigoCiiu();
        int estadoEmpresa = e.isEstadoEmpresa();
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
    
    /**
     * 
     * @param nit_consultar
     * @return
     */
    public ArrayList<Empresa> consultarEmpresaNit(String nit_consultar){
        
        ArrayList<Empresa> lista = new ArrayList<>();
        ConexionBD con = new ConexionBD();
        String sql = "SELECT  id_empresa, nombre_empresa, nit_empresa, nombre_representante, documento_representante, tipo_empresa, cod_ciiu, estado_empresa, departamento, ciudad " +
                     "FROM empresa "+
                     "WHERE nit_empresa = '" + nit_consultar+ "' ";
        
        ResultSet rs = con.ejecutarQuery(sql);
        try {
        while (rs.next()){
            
            Empresa e = new Empresa();
            int id = rs.getInt ("id_empresa");
            String nit = String.valueOf(nit_consultar);
            String nombreEmpresa = rs.getString("nombre_empresa");
            String nombreRepLegal = rs.getString("nombre_representante");
            String noIdentidad = rs.getString("documento_representante");
            int tipoEmpresa = Integer.parseInt((rs.getString("tipo_empresa")));
            int codigoCiiu = Integer.parseInt(rs.getString("cod_ciiu"));
            int estadoEmpresa = Integer.parseInt((rs.getString("estado_empresa")));
            String departamento = rs.getString("departamento");
            String ciudadMunicipio = rs.getString("ciudad");
            
            e = new Empresa (id, nombreEmpresa,nit,nombreRepLegal,noIdentidad, tipoEmpresa,codigoCiiu,estadoEmpresa,departamento,ciudadMunicipio);
            lista.add(e);
        }}
        catch(Exception ex){
            con.desconectar();
            return null;
        }
        con.desconectar();
        return lista;
    }}
    