
package logica;

/*
Clase que contiene los atributos, constructores y métodos de Empresas.
*/
public class Empresa {
  
    private int id; //El id es autoincremental, al realizarse la inserción en base de datos es asignado automáticamente.
    private String nombreEmpresa;
    private String nit; //El NIT solo puede registrarse una vez en la base de datos
    private String nombreRepLegal;
    private String noIdentidad;
    private boolean tipoEmpresa; // 1= Natural,  0=Jurídica 
    private int codigoCiiu;
    private boolean estadoEmpresa; //1=Activo, 0= Inactivo
    private String departamento;
    private String ciudadMunicipio;

    /*
    Constructor vacío
    */
    public Empresa() {
    }

    
    /*
    Constructor que inicializa todos los atributos excepto el id 
    */
    public Empresa(String nombreEmpresa, String nit, String nombreRepLegal, String noIdentidad, boolean tipoEmpresa, int codigoCiiu, boolean estadoEmpresa, String departamento, String ciudadMunicipio) {
        this.nombreEmpresa = nombreEmpresa;
        this.nit = nit;
        this.nombreRepLegal = nombreRepLegal;
        this.noIdentidad = noIdentidad;
        this.tipoEmpresa = tipoEmpresa;
        this.codigoCiiu = codigoCiiu;
        this.estadoEmpresa = estadoEmpresa;
        this.departamento = departamento;
        this.ciudadMunicipio = ciudadMunicipio;
    } 
    
    
    /*
    Constructor que inicializa todos los atributos
    */
    public Empresa(int id, String nombreEmpresa, String nit, String nombreRepLegal, String noIdentidad, boolean tipoEmpresa, int codigoCiiu, boolean estadoEmpresa, String departamento, String ciudadMunicipio) {
        this(nombreEmpresa,nit,nombreRepLegal,noIdentidad,tipoEmpresa,codigoCiiu,estadoEmpresa,departamento,ciudadMunicipio);
        this.id = id;
        
    }

 
    /*
    Sobreescritura de método toString adaptado a los atributos de la clase.
    */
    @Override
    public String toString() {
        
        String StringtipoEmpresa;
        String StringestadoEmpresa;
        
        if (tipoEmpresa == true) {
            StringtipoEmpresa = "Natural";
        } else {
            StringtipoEmpresa = "Jurídica";
        }
        
        if (estadoEmpresa == true) {
            StringestadoEmpresa = "Activa";
        } else {
            StringestadoEmpresa = "Inactiva";
        }
        return "empresa{" + "id=" + id + ", nombreEmpresa=" + nombreEmpresa + ", nit=" + nit + ", nombreRepLegal=" + nombreRepLegal + ", noIdentidad=" + noIdentidad + ", tipoEmpresa=" + tipoEmpresa + ", codigoCiiu=" + codigoCiiu + ", estadoEmpresa=" + estadoEmpresa + ", departamento=" + departamento + ", ciudadMunicipio=" + ciudadMunicipio + '}';
    }
    
    
    //Métodos getters y setters de todos los atributos
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombreRepLegal() {
        return nombreRepLegal;
    }

    public void setNombreRepLegal(String nombreRepLegal) {
        this.nombreRepLegal = nombreRepLegal;
    }

    public String getNoIdentidad() {
        return noIdentidad;
    }

    public void setNoIdentidad(String noIdentidad) {
        this.noIdentidad = noIdentidad;
    }

    public boolean isTipoEmpresa() {
        return tipoEmpresa;
    }

    public void setTipoEmpresa(boolean tipoEmpresa) {
        this.tipoEmpresa = tipoEmpresa;
    }

    public int getCodigoCiiu() {
        return codigoCiiu;
    }

    public void setCodigoCiiu(int codigoCiiu) {
        this.codigoCiiu = codigoCiiu;
    }

    public boolean isEstadoEmpresa() {
        return estadoEmpresa;
    }

    public void setEstadoEmpresa(boolean estadoEmpresa) {
        this.estadoEmpresa = estadoEmpresa;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getCiudadMunicipio() {
        return ciudadMunicipio;
    }

    public void setCiudadMunicipio(String ciudadMunicipio) {
        this.ciudadMunicipio = ciudadMunicipio;
    }
    
    public String getEstadoEmpresa() {
        if (tipoEmpresa== true) {
            return "Activa";
        }else{
            return "Inactivo";
        }
    }
    
    
}
    
