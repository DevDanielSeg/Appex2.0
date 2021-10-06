package Test;

import java.sql.SQLException;
import logica.Empresa;
import logica.LogicaEmpresa;
import org.testng.Assert;
import org.testng.annotations.Test;
import persistencia.ConexionBD;
import persistencia.EmpresaDAO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author turme
 */
public class TestGeneral {
    @Test
    public void verificarConexion() {
        ConexionBD con = new ConexionBD();
        Assert.assertTrue(con.isConectado(), "No hay conexión creada. ");
        con.desconectar();
        Assert.assertFalse(con.isConectado(), "No se cerró conexión. ");
    }
   @Test
    public void verificarGuardarNuevaEmpresa() {
        EmpresaDAO dao = new EmpresaDAO();
        Empresa e = new Empresa ("Empresa de prueba","4234224","Maximiliano","877887",1,2393,0,"Santander","Barrancabermeja");
        int id = dao.guardarNuevaEmpresa(e);
        Assert.assertTrue(id > 0, "La empresa no fue guardada");
        String sql = "DELETE FROM empresa WHERE id_empresa = " + id;
        ConexionBD con = new ConexionBD();
        int cant = con.ejecutarUpdate(sql);
        Assert.assertTrue(cant == 1, "El dato de prueba no pudo ser eliminado ");
        con.desconectar();
    }


}
    
    
    
    
    
     
    

