package Utility_Module;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyFile_Reader {

    String folderPath = System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator;
    FileInputStream file;
    public PropertyFile_Reader(String fileName){
        try {
            file = new FileInputStream(folderPath+fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    PropertyFile_Reader(FileInputStream file){
        this.file=file;
    }

    public String getValueFromDefaultPropertyFile(String key) {
        try {
            Properties p=new Properties();
            p.load(file);
            return p.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public HashMap<String, String> getValuesFromPropertyFile() {
        HashMap<String,String> propMap = new HashMap<String,String>();
        try {
            Properties p=new Properties();
            p.load(file);
            for(Object key:p.keySet()) {
                propMap.put(key.toString(), p.get(key).toString());
            }
            return propMap;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setProperty(FileOutputStream file, Map<String, String> conf) {
        try {

            Properties prop = new Properties();
            // set the properties value
            prop.putAll(conf);
            // save properties to project root folder
            prop.store(file, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
