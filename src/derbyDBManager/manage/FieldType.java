/*
 * NO TENGO TIEMPO FÍSICO SUFICIENTE PARA MIRAR CORRECTAMENTE MI CÓDIGO POR LO QUE ME LIMITO A INSERTAR JAVADOCs y hacer cambios simples
 */
package derbyDBManager.manage;

import java.time.LocalDateTime;

/**
 * Tipos posibles de los campos de una tabla (a expandir próximamente)
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
