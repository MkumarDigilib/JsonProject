package yell;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class Memory {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		 BufferedReader br=new BufferedReader(new FileReader(new File("/Users/deepak/Desktop/Testing/Memory.txt")));
		 String line;
		 JSONObject jsonObject = new JSONObject();
		 JSONObject jsonObject2 = new JSONObject();
		 JSONObject jsonObject3 = new JSONObject();
		 JSONObject jsonObject4 = new JSONObject();
		 JSONObject jsonObject5 = new JSONObject();
		 int g=1;
		 int count=1;
		 float max=0;
		 int cons=1024;
		 
		 float total=0;
		 String []a=new String[680];
		 while ((line = br.readLine())!= null){
			
		            if(count%2==0) {
		            String[] data = line.split("\\s+");
		          float in=Float.parseFloat(data[2]);
		          if(in>max)
		          {
		        	  max=in;
		          }
		          total=total+in;
		          float input= (in/cons);
		          String input_st=String.format("%.2f",input);
		          
		          jsonObject.put(g+"s",input_st);
		          
                 // System.out.println(in);
                     g++;
		            }
		            
		            count++;
		          
		           }
		 
		        float avg=total/g;
		        jsonObject2.put("AverageMemory(MB)",(String.format("%.2f",avg/1024)));
		        jsonObject3.put("MaxMemory(MB)",(String.format("%.2f",max/1024)));
		        jsonObject4.put("Usecasename","HomePage");
		        jsonObject5.put("Values",jsonObject);
		        
		        JSONArray ar=new JSONArray();
		        ar.add(jsonObject2);
		        ar.add(jsonObject5);
		        ar.add(jsonObject3);
		        ar.add(jsonObject4);
		        try {
			           FileWriter file2 = new FileWriter("/Users/deepak/Desktop/Testing/output1.json");
			            file2.write(ar.toJSONString());
			            file2.close();
			         } catch (IOException e) {
			            
			            e.printStackTrace();
			         }
		 
		      System.out.println(ar);
		
		 
		
		}
		 
       
	}
