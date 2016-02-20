package mongocheck;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.DBCursor;

import com.mongodb.ServerAddress;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class makingdatabase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try{   
			
	         // To connect to mongodb server
	         MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
				
	         // Now connect to your databases
	         DB db = mongoClient.getDB( "nikipoc" );
	         System.out.println("Connect to database successfully");
			 BufferedReader br = new BufferedReader(new FileReader("final.txt"));	
			 DBCollection col=db.getCollection("phrase");
			 //DBCollection col1 = db.getCollection("entities");
//			 for(int i=2;i<=20;i++){
//				 BasicDBObject document = new BasicDBObject();
//				 String str = ""+"a"+i;
//				 
//				 document.put(Integer.toString(i), str);
//				 col.insert(document);
//			 }
			 int e=2;
			 for(int i=1;i<=450000;i++){
				 if(i<=15000 && i>=4134){
					 String str = br.readLine()+br.readLine()+br.readLine();
					 i+=3;
					 BasicDBObject document = new BasicDBObject();
					 Random randomGenerator = new Random();
					 int ran = randomGenerator.nextInt(20);
					 if(ran==0)ran++;
					 document.put(str,Integer.toString(ran));
					 col.insert(document);
				 }
//				 if(i>15000){
//					 String str = br.readLine()+br.readLine()+br.readLine();
//					 i+=3;
//					 BasicDBObject document = new BasicDBObject();
//					 document.put(Integer.toString(e),str);
//					 e++;
//					 col1.insert(document);
//				 }
			 }
	     	
//	         BasicDBObject document = new BasicDBObject();
//	         document.put("_id", 34543);
//	         document.put("title", "mongo is god");
//	         document.put("by", "god himself");
//	         ArrayList<String> list = new ArrayList();
//	         list.add("lalaall");
//	         list.add("lall");
//	         document.put("tags", list);
//	         document.put("likes", 5000);
	          
	         
	          
	        
	         
	        

//	     	DBCollection col=db.getCollection("mycol");
//	     	col.insert(document);
	     	
	         System.out.println("Collection created successfully");
	        // System.out.println(col1.find());
	      }catch(Exception e){
	         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      }	}

}
