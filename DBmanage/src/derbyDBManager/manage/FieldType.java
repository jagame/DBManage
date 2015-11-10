/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package derbyDBManager.manage;

import java.time.LocalDateTime;

/**
 * Tipos posibles de los campos de una tabla
 * @author Javier
 */
public enum FieldType {
    VARCHAR(String.class), INTEGER(Integer.class), FLOAT(Float.class), DATE(LocalDateTime.class);
    private final Class cls;
    
    FieldType(Class cls){
        this.cls = cls;
    }
    
    public Class getValue(){
        return cls;
    }
}
