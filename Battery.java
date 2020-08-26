package yell;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Battery {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new FileReader(new File("/Users/deepak/Desktop/Testing/Battery.txt")));
		BufferedReader br2=new BufferedReader(new FileReader(new File("/Users/deepak/Desktop/Testing/Battery.txt")));
		String line;
		//int flag=0;
		JSONObject jsonObject = new JSONObject();
		JSONObject jsonObject2 = new JSONObject();
		JSONObject jsonObject3 = new JSONObject();

		 while ((line = br.readLine())!= null){
				
	             
					if(line.contains("Foreground"))
	             {
	        	   String[] data = line.split("\\s+");
	       
	        	   String time=data[3]+" "+data[4]+" "+data[5]+" "+data[6]+" "+data[7]+" "+data[8];
	        	   jsonObject.put("Foreground_time",time);
	        	   //System.out.println(time);
                    //flag++; 
	        	   
	             }
	            
			}
		 
		 while ((line = br2.readLine())!= null){
				
             
				if(line.contains("Uid u0a202"))
          {
     	   String[] data = line.split("\\s+");
    
     	   String time=data[3];
     	   //System.out.println(time);
     	  jsonObject2.put("Battery_drain",time);
             //flag++; 
     	   double drain_number=Double.parseDouble(time);
     	   Double percentage=drain_number/1000;
     	   
     	  jsonObject3.put("Battery_percentage",(String.format("%.3f",percentage)));
     	   
          }
         
		}
		 
		 JSONArray ar=new JSONArray();
		 ar.add(jsonObject);
		 ar.add(jsonObject3);
		 ar.add(jsonObject2);
		 
		 try {
	           FileWriter file2 = new FileWriter("/Users/deepak/Desktop/Testing/output2.json");
	            file2.write(ar.toJSONString());
	            file2.close();
	         } catch (IOException e) {
	            
	            e.printStackTrace();
	         }
		 
		 System.out.println(ar);

   }
}
