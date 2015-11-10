/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
    
    public TableManager( Connection con ){
        this.con = con;
    }
    
    public boolean createTable( String name, List<TableField> fields, String... constraints ) throws SQLException{
        String sql = "CREATE TABLE "+name+" (" + fields.get(0);
        for( int i = 1 ; i<fields.size() ; i++ )
            sql += ","+fields.get(i);
        for( String str : constraints )
            sql += "," + str;
        sql += ")";
        return con.prepareCall(sql).execute();
    }
    
    public boolean createTable( Table table ) throws SQLException{
        return createTable( table.getName(), table.getFields(), table.getConstraints().toArray( new String[0] ) );
    }
    
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
