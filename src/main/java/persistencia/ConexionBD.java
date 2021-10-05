package persistencia;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
/*
Clase para realizar conexión a base de datos dbappex2
*/
public class ConexionBD {
    private String conectorInstalado = "jdbc:mysql:";
    private String host = "localhost:3306";
    private String baseDatos = "dbappex2"; //nombre de la base de datos dbappex2
    private String username = "root"; //usuario de mysql
    private String password = "briam"; //password de mysql
    private Connection conexion;
    private Statement ejecutor;

    
    public ConexionBD() {
        conectar();
    }
    
    /*
    Método para determinar si la conexión se encuentra activa o no.
    @return true = conexión activa ; false = conexión inactiva
    */
    public boolean isConectado() {
        return (this.conexion != null);
    }
    
    /* 
    Método para realizar conexion a la base de datos
    */
    public void conectar() {
        try
        {
            String cadenaConexion = conectorInstalado + "//" + host + "/" + baseDatos;
            Class.forName("com.mysql.jdbc.Driver"); //registra el driver de conexion para la base de datos
            conexion = DriverManager.getConnection(cadenaConexion, username, password);//crea la conexion
            ejecutor = conexion.createStatement(); //crea un ejecutor
            ejecutor.setQueryTimeout(30);  // set timeout to 30 sec. Establece el tiempo de ejecución máximo en 30s
           
        }
        //si no se establece la conexión se muestra la excepcion generada
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    /*
    Método que ejecuta sentencias sql select. 
    @param sql = contiene la consulta sql que se va a ejecutar.
    @return rs = resultset que contiene todos los registros que retorna la consulta.
    */
    public ResultSet ejecutarQuery(String sql)
    {
        ResultSet rs = null;
        try
        {
            rs = ejecutor.executeQuery(sql);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return rs;
    }
    
    /*
    Método que ejecuta sentencias sql de update y delete.
    @param sql = contiene la consulta sql que se va a ejecutar.
    @return cant = entero que indica el numero de registros afectados por la operación.
     */    
    public int ejecutarUpdate(String sql) {
        int cant = 0;
        try
        {
            cant = ejecutor.executeUpdate(sql);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return cant;
    }
    
    /*
    Método que ejecuta sentencias sql de inserción
    @param sql = contiene la consulta sql que se va a ejecutar.
    @return rs = resultset que contiene el id (llaves generadas) del registro insertado.
    */
     public ResultSet ejecutarInsert(String sql) {
        ResultSet rs = null;
        try
        {
            int cant = ejecutor.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (cant > 0) {
                rs = ejecutor.getGeneratedKeys();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return rs;
    }
    
    /*
    Método para realizar desconexión de la base de datos
    */
    public void desconectar()
    {
        try {
            conexion.close();
            conexion = null;
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
}

    
    
