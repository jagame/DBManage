/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package derbyDBManager.manage;

/**
 * Representa un campo de una tabla
 * @author Javier
 */
public class TableField {
    private String name;
    private FieldType tipo;
    private Integer longitud;
    private String[] caracteristicas;
    
    public TableField(){
        
    }
    
    public TableField( String name, FieldType tipo, Integer longitud, String... caracteristicas ){
        this.name = name;
        this.tipo = tipo;
        this.longitud = longitud;
        this.caracteristicas = caracteristicas;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FieldType getTipo() {
        return tipo;
    }

    public void setTipo(FieldType tipo) {
        this.tipo = tipo;
    }

    public String[] getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String[] caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    @Override
    public String toString() {
        String res = name + " " + tipo.name() + ( longitud==null?"":"("+longitud+")" );
        for (String caracteristica : caracteristicas) {
            res += " " + caracteristica;
        }
        
        return res;
    }
    
    
}
