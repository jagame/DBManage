/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package derbyDBManager.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

/**
 *
 * @author Javier
 */
public class PropertiesReader {
    private final File file;
    private final Properties properties;
    
    public PropertiesReader( String file ) throws RuntimeException{
        try{
            this.file = new File(file);
            this.file.createNewFile();
            properties = new Properties();
            properties.load( new FileInputStream(this.file) );
        }catch( IOException e ){
            throw new RuntimeException(e);
        }
    }
    
    public String getProperty( String key ){
        return properties.getProperty(key);
    }
    
    public void setProperty( String key, String value ){
        properties.setProperty(key, value);
    }
    
    public void saveChanges() throws IOException{
        properties.store( new FileOutputStream(file) , "");
    }
    
    public Enumeration<?> propertyNames(){
        return properties.propertyNames();
    }
    
    public String getPropertyFilePath(){
        return file.getAbsolutePath();
    }
    
}
