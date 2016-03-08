/*
* NO TENGO TIEMPO FÍSICO SUFICIENTE PARA MIRAR CORRECTAMENTE MI CÓDIGO POR LO QUE ME LIMITO A INSERTAR JAVADOCs y hacer cambios simples
 */
package derbyDBManager.manage;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Herramienta de gestión de las tablas de la base de datos, permite crear, eliminar y modificar(proximamente) tablas.
 * @author Javier
 */
public class TableManager {
    
    private final Connection con;
    /**
     * Crea una instancia de TableManager usando la conexión pasada por parámetro
     * @param con 
     */
    public TableManager( Connection con ){
        this.con = con;
    }
    /**
     * Crea una nueva tabla en la base de datos a partir de los parámetros pasados
     * @param name
     * @param fields
     * @param constraints
     * @return
     * @throws SQLException 
     */
    public boolean createTable( String name, List<TableField> fields, String... constraints ) throws SQLException{
        String sql = "CREATE TABLE "+name+" (" + fields.get(0);
        for( int i = 1 ; i<fields.size() ; i++ )
            sql += ","+fields.get(i);
        for( String str : constraints )
            sql += "," + str;
        sql += ")";
        return con.prepareCall(sql).execute();
    }
    /**
     * Crea una nueva tabla en la base de datos a partir del objeto Table pasado por parámetro
     * @param table
     * @return
     * @throws SQLException 
     */
    public boolean createTable( Table table ) throws SQLException{
        return createTable( table.getName(), table.getFields(), table.getConstraints().toArray( new String[0] ) );
    }
    /**
     * Elimina de la base de datos la tabla con el nombre pasado por parámetro
     * @param name
     * @return
     * @throws SQLException 
     */
    public boolean dropTable( String name ) throws SQLException{
        String sql = "DROP TABLE "+name;
        return con.prepareCall(sql).execute();
    }
    /*
    public boolean alterTable( Table table ) {
        // Investigar la posibilidad de usando la clase Table permitir alterar las tablas, el problema está en la necesidad de saber que campos y constraints tiene la tabla
        // Para saber si devemos añadir nuevo o modificar existente
        throw new RuntimeException("Not declarated Method");
    }
    */
    
}
