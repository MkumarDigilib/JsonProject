package yell;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.simple.JSONObject;
//import org.json.simple.JSONObject;

public class Cname {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		 BufferedReader br=new BufferedReader(new FileReader(new File("/Users/deepak/Desktop/Testing/CPU.txt")));
		 String line;
		 JSONObject jsonObject = new JSONObject();
		 int g=0;
		 int j=1;
		 int count=0;
		 double max=0.0;
		 String []a=new String[680];
		 while ((line = br.readLine())!= null){
		       // if(line.isEmpty() || line.trim().equals("") || line.trim().equals("\n")){
		         //   continue;
		        //}else{
		            //bw.write(line + "\n");
		            String[] data = line.split(" ");
		           // String[]data2=new String[680];
		            
		          // System.out.println(data[14] + "\n");
		            //data2[g]=data[14];
		           String in=data[14];
		           
		           String string = "";
		           
		           boolean numeric = true;
                  
		           try {
		               Integer num = Integer.parseInt(data[15]);
		           } catch (NumberFormatException e) {
		               numeric = false;
		           }
                   
		           if(numeric)
		           {
		        	   in=data[15];
		           }
		           //System.out.println(data[8]);
		            //g++;
		            
		            a[g++]=(in);	
		            		
		            jsonObject.put(j,in);
		            j++;
		            	
		            
		          
		        
		        try {
		            FileWriter file = new FileWriter("/Users/deepak/Desktop/Testing/output.json");
		            file.write(jsonObject.toJSONString());
		            file.close();
		         } catch (IOException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		         }
		       }
		 
		 
		/* for(int i=0;i<680;i++)
		 {
			 Double z=Double.parseDouble(a[i]);
			// System.out.println(z);
			 
		 } */
		 
		// System.out.println(max);
             
				 
		    }
		 
		 //jsonObject.put(data[j]);
       
	}


