/*
* NO TENGO TIEMPO FÍSICO SUFICIENTE PARA MIRAR CORRECTAMENTE MI CÓDIGO POR LO QUE ME LIMITO A INSERTAR JAVADOCs y hacer cambios simples
 */
package derbyDBManager.connection;

import derbyDBManager.utils.PropertiesManager;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import org.apache.derby.jdbc.EmbeddedConnectionPoolDataSource;

/**
 * Clase Principal con contenedora de métodos static, devuelve una conexión configurada automáticamente a traves de su método getConnection(). Para cambiar el nombre de la base de datos acceder al fichero DerbyConnection.properties.
 * @author Javier
 */
public class DerbyConnection{
 // Podría ser abstracta para así asegurar la no creación de instancias...pero crear una clase abstract que no tenga métodos abstract me parece feo y
 // un error de diseño
    
    private final static String DEFAULT_DB_NAME = "DataBase";
    private final static String PROPERTIES_FILE_PATH = "DerbyConnection.properties";
    private final static String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private final static String DATABASE_NAME;
    private final static PropertiesManager PR;
    private final static EmbeddedConnectionPoolDataSource DS;
    
    static {
        PR = new PropertiesManager(PROPERTIES_FILE_PATH);
        DATABASE_NAME = getDataBaseName();
        
        try{
            Class.forName(DRIVER).newInstance();
        }catch( ReflectiveOperationException e ){
            throw new RuntimeException(e);
        }
        
        DS = new EmbeddedConnectionPoolDataSource();
        DS.setDatabaseName(DATABASE_NAME);
        DS.setCreateDatabase("create");
    }
    
    private DerbyConnection(){
        
    }
    
    /**
     * Devuelve una conexión desde el pool de conexiones sin usuario ni contraseña (suficiente normalmente)
     * @return
     * @throws SQLException 
     */
    public static Connection getConnection() throws SQLException{
        return DS.getConnection();
    }
    /**
     * Devuelve una conexión desde el pool de conexiones con el usuario y la contraseña especificados 
     * @param user
     * @param pass
     * @return
     * @throws SQLException 
     */
    public static Connection getConnection(String user, String pass) throws SQLException{
        return DS.getConnection(user,pass);
    }
    /**
     * Devuelve el nombre de la base de datos almacenado en memoria o en su excepción el configurado actualmente en DerbyConnection.properties
     * @return 
     */
    public static String getDataBaseName(){
        String res;
        try{
            if( (res=DATABASE_NAME) == null ){
                res = PR.getProperty("DATABASE_NAME");
                if( res == null )
                    res = setDefaultDataBaseName();
            }
        }catch( IOException e ){
            throw new RuntimeException(e);
        }
        return res;
    }
    /**
     * Asigna y devuelve el nombre de base de datos por defecto
     * @return
     * @throws IOException 
     */
    private static String setDefaultDataBaseName() throws IOException{
        PR.setProperty("DATABASE_NAME", DEFAULT_DB_NAME);
        PR.saveChanges();
        return DEFAULT_DB_NAME;
    }
}
