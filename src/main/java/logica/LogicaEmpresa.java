
package logica;

import persistencia.EmpresaDAO;

public class LogicaEmpresa {
       
    /**
     * Guarda la información de una capturada desde el formulario
     * @param e un objeto con los datos de una empresa específica
     * @return true si guarda la empresa en la base de datos, o false si no la guarda
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
    
    
}
