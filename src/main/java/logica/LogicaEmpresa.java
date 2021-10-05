package logica;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TreeMap;
import org.testng.Assert;
import persistencia.EmpresaDAO;

public class LogicaEmpresa {

    private ArrayList<Empresa> lista;

    public ArrayList<Empresa> getLista() {
        return lista;
    }

    /**
     * Guarda la información de una capturada desde el formulario
     *
     * @param e un objeto con los datos de una empresa específica
     * @return true si guarda la empresa en la base de datos, o false si no la
     * guarda
     */
    public boolean guardarEmpresa(Empresa e) {
        EmpresaDAO dao = new EmpresaDAO();
        if (e.getId() == 0) {
            int id = dao.guardarNuevaEmpresa(e);
            if (id > 0) {
                return true;
            } else {
                return false;
            }
        }
        /*
        else {
            int filas = dao.guardarEmpresaExistente();
            if (filas == 1) {
                return true;
            } else {
                return false;
            }
        }
         */
        return false;
    }

    public boolean cargarTodasLasEmpresas() {
        EmpresaDAO dao = new EmpresaDAO();
        lista = dao.consultarEmpresas();
        if (lista.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean cargarEmpresasPorFiltro(String filtro) {
        EmpresaDAO dao = new EmpresaDAO();
        lista = dao.consultarEmpresasPorFiltro(filtro);
        if (lista.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean consultarEmpresaPorNit(String nit_consultar) {
        EmpresaDAO dao = new EmpresaDAO();
        lista = dao.consultarEmpresaNit(nit_consultar);
        Assert.assertNotNull(lista, "lista esta devolviendo nulo");
        if (lista.size() > 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean actualizarDatosEmpresas(Empresa e){
        EmpresaDAO dao = new EmpresaDAO();
        boolean datos = dao.actualizarEmpresa(e);
        String comprobante;
        if (datos==true){comprobante = "1";}
        else {comprobante = "0";}
        Assert.assertEquals(comprobante,"1");
        return datos;
    }
}
