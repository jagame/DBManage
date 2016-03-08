/*
* NO TENGO TIEMPO FÍSICO SUFICIENTE PARA MIRAR CORRECTAMENTE MI CÓDIGO POR LO QUE ME LIMITO A INSERTAR JAVADOCs y hacer cambios simples
 */
package derbyDBManager.manage;

import java.util.Arrays;
import java.util.List;

/**
 * Representa un campo de una tabla
 * @author Javier
 */
public class TableField {
    private String name;
    private FieldType tipo;
    private Integer longitud;
    private List<String> caracteristicas;
    /**
     * Crea un TableField completamente vacío
     */
    public TableField(){
        this(null,null,null);
    }
    /**
     * Crea un TableField con los datos pasados como parámetro
     * @param name
     * @param tipo
     * @param longitud
     * @param caracteristicas 
     */
    public TableField( String name, FieldType tipo, Integer longitud, String... caracteristicas ){
        this.name = name;
        this.tipo = tipo;
        this.longitud = longitud;
        this.caracteristicas = Arrays.asList(caracteristicas);
    }
    /**
     * Devuelve el nombre del campo
     * @return 
     */
    public String getName() {
        return name;
    }
    /**
     * Asigna un nuevo nombre al campo
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Devuelve el tipo del campo como un FieldType
     * @return 
     */
    public FieldType getTipo() {
        return tipo;
    }
    /**
     * Asigna un nuevo tipo al campo
     * @param tipo 
     */
    public void setTipo(FieldType tipo) {
        this.tipo = tipo;
    }
    /**
     * Devuelve una lista con las características adicionales de este campo
     * @return 
     */
    public List<String> getCaracteristicas() {
        return caracteristicas;
    }
    /**
     * Asigna unas nuevas características adicionales al campo
     * @param caracteristicas 
     */
    public void setCaracteristicas(String... caracteristicas) {
        this.caracteristicas = Arrays.asList(caracteristicas);
    }
    /**
     * Añade una nueva característica adicional al campo
     * @param caracteristica 
     */
    public void addCaracteristica(String caracteristica) {
        this.caracteristicas.add(caracteristica);
    }

    @Override
    public String toString() {
        String res = name==null?"none":name + " " + tipo.name()==null?"none":tipo.name() + ( longitud==null?"":"("+longitud+")" );
        for (String caracteristica : caracteristicas) { // Podría usar Streams, pero aunque sean más "elegantes"
            res += " " + caracteristica;                // ya que tienen peor rendimiento mejor lo hago así
        }
        
        return res;
    }
    
    
}
