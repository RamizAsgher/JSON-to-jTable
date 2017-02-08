/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ramiz_transport_system;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author RamizAsgher
 */
public class JSONtoTABLE {
     
   public DefaultTableModel JSONtoTABLE(String JsonString)
    {
        try {
           
            
              JSONObject job=new JSONObject(JsonString);
      
              ArrayList<String> list = new ArrayList<String>();     
               

        
           int len = job.names().length();
           for (int i=0;i<len;i++){ 
            list.add(job.names().get(i).toString()); 
            } 
             
           
            Object columnNames[]=list.toArray();
             int rowcount = job.getJSONArray(columnNames[0].toString()).length();
            
             DefaultTableModel model = new DefaultTableModel(columnNames,rowcount-1);
            JSONArray rowsarray;
            ArrayList<String> rowlist = new ArrayList<String>();   
            for(int f=0;f<rowcount;f++)
            {
                rowlist.clear();
                for (int i=0;i<len;i++)
                { 
                    rowsarray = job.getJSONArray(list.get(i));
                    rowlist.add(rowsarray.getString(f));
                } 
                model.addRow(rowlist.toArray());
                
            }
           
            model.removeRow(0);
         
           return model;
          
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
     return null;  
    }
}
