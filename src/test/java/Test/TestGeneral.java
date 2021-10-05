package Test;

import java.sql.SQLException;
import logica.LogicaEmpresa;
import org.testng.Assert;
import org.testng.annotations.Test;
import persistencia.ConexionBD;

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
    public void verificarActualizacionEmpresa (){ 
        String nit_consultar = "10";
        LogicaEmpresa LogicaEmpresa = new LogicaEmpresa ();
        boolean actualizacion = LogicaEmpresa.consultarEmpresaPorNit(nit_consultar);
        Assert.assertTrue(actualizacion == true, "el valor de actualizacion es True");
        Assert.assertFalse(actualizacion == false, "el Valor de actualizacion es False");
    }}  
     
    

