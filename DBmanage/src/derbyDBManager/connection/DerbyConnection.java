
package derbyDBManager.connection;

import derbyDBManager.utils.PropertiesReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import org.apache.derby.jdbc.EmbeddedConnectionPoolDataSource;

/**
 * Clase Principal, no puede ser instanciada, devuelve una conexión configurada automáticamente a traves de su método getConnection(). Para cambiar el nombre de la base de datos acceder al fichero config.txt.
 * @author Javier
 */
public class DerbyConnection{
    
    private final static String DRIVER;
    private final static String PROPERTIES_FILE_PATH;
    private final static String DATABASE_NAME;
    private final static PropertiesReader PR;
    private final static EmbeddedConnectionPoolDataSource DS;
    
    static {
        PROPERTIES_FILE_PATH = "config.txt";
        DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
        PR = new PropertiesReader(PROPERTIES_FILE_PATH);
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
     * Devuelve el nombre de la base de datos configurada actualmente en config.txt
     * @return 
     */
    public static String getDataBaseName(){
        String res;
        
        try{
            res = PR.getProperty("DATABASE_NAME");
            if( res == null ){
                res = "DataBase";
                setDefaultDataBaseName();
            }
        }catch( IOException e ){
            throw new RuntimeException(e);
        }
        
        return res;
    }
    
    private static void setDefaultDataBaseName() throws IOException{
        PR.setProperty("DATABASE_NAME", "DataBase");
        PR.saveChanges();
    }
}
