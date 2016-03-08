/*
* NO TENGO TIEMPO FÍSICO SUFICIENTE PARA MIRAR CORRECTAMENTE MI CÓDIGO POR LO QUE ME LIMITO A INSERTAR JAVADOCs y hacer cambios simples
 */
package derbyDBManager.manage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Representa una tabla de una base de datos
 * @author Javier
 */
public class Table {
    private String name;
    private List<TableField> fields;
    private List<String> constraints;
    
    /**
     * Crea una instancia de la clase Table sin nombre de tabla y con los campos y las constraints vacías
     */
    public Table(){
        this( "", new ArrayList(), new ArrayList() );
    }
    
    /**
     * Crea una instancia de la clase Table con los campos y las constraints pasados por parámetro
     * @param name
     * @param fields
     * @param constraints 
     */
    public Table( String name, List<TableField> fields, String... constraints ){
        this( name, fields, Arrays.asList(constraints) );
    }
    /**
     * Crea una instancia de la clase Table con los campos y las constraints pasados por parámetro
     * @param name
     * @param fields
     * @param constraints 
     */
    public Table( String name, List<TableField> fields, List<String> constraints ){
        this.name = name;
        this.fields = fields;
        this.constraints = constraints;
    }
    /**
     * Devuelve el nombre de la tabla
     * @return 
     */
    public String getName() {
        return name;
    }
    /**
     * Asigna un nuevo nombre a la tabla
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Obtiene todos los campos de la tabla como una lista de TableField's
     * @return 
     */
    public List<TableField> getFields() {
        return fields;
    }
    /**
     * Asigna una nueva lista de campos (TableField's) a la tabla
     * @param fields 
     */
    public void setFields(List<TableField> fields) {
        this.fields = fields;
    }
    /**
     * Añade un nuevo campo (TableField) a la tabla
     * @param field 
     */
    public void addField(TableField field){
        this.fields.add(field);
    }
    /**
     * Obtiene una lista con todas las constraints de la tabla
     * @return 
     */
    public List<String> getConstraints() {
        return constraints;
    }
    /**
     * Asigna una nueva lista de constraints a la tabla
     * @param constraints 
     */
    public void setConstraints(List<String> constraints) {
        this.constraints = constraints;
    }
    /**
     * Asigna una nueva constraint a la tabla
     * @param constraint
     */
    public void addContraint(String constraint){
        this.constraints.add(constraint);
    }
    
}
