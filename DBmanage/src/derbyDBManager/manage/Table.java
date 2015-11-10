/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package derbyDBManager.manage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Javier
 */
public class Table {
    private String name;
    private List<TableField> fields;
    private List<String> constraints;
    
    public Table(){
        this( "", new ArrayList(), new ArrayList() );
    }
    
    public Table( String name, List<TableField> fields, String... constraints ){
        this( name, fields, Arrays.asList(constraints) );
    }
    
    public Table( String name, List<TableField> fields, List<String> constraints ){
        this.name = name;
        this.fields = fields;
        this.constraints = constraints;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TableField> getFields() {
        return fields;
    }

    public void setFields(List<TableField> fields) {
        this.fields = fields;
    }

    public List<String> getConstraints() {
        return constraints;
    }

    public void setConstraints(List<String> constraints) {
        this.constraints = constraints;
    }
    
}
