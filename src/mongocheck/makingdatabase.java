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
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class makingdatabase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try{  
			
			PrintWriter file2 = new PrintWriter("phraseFile.txt");
			PrintWriter file3 = new PrintWriter("entityFile.txt");
			
	         // To connect to mongodb server
	         MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
	         // Now connect to your databases
	         DB db = mongoClient.getDB( "mongopocnew" );
	         System.out.println("Connect to database successfully");
			 BufferedReader br = new BufferedReader(new FileReader("final.txt"));	
			 DBCollection col=db.getCollection("phrase");
			 DBCollection col1 = db.getCollection("entity");
			 DBCollection col2 = db.getCollection("concept");
			 
			 
			 
			 int e=2;
			 for(int i=1;i<=450000;i++){
				 if(i<=200000){
	                
					 String str = br.readLine()+" "+br.readLine()+" "+br.readLine();
					 i+=3;
					 BasicDBObject document = new BasicDBObject();
					 Random randomGenerator = new Random();
					 int ran = randomGenerator.nextInt(20);
					 if(ran==0)ran++;
					 document.put("name", str);
					 document.put("conceptID", Integer.toString(ran));
					 col.insert(document);
					 file2.println(str);
				 }
				 if(i>15000){
					 
					 
					 ArrayList<String>list = new ArrayList();
					 list.add(br.readLine());list.add(br.readLine());
					 i+=2;
					 BasicDBObject document = new BasicDBObject().append("name",list );
					 //document.put("name", str);
					 document.put("entityID", Integer.toString(e));
					 e++;
					 col1.insert(document);
					 file3.println(e);
				 }
			 }
			 file2.close();
			 file3.close();
			 
			 BufferedReader br1 = new BufferedReader(new FileReader("phraseFile.txt"));	
			 BufferedReader br2 = new BufferedReader(new FileReader("entityFile.txt"));	
			 String current = "";
			 ArrayList<String> phraselist= new ArrayList();
			 while((current=br1.readLine())!=null){
				 phraselist.add(current);
			 }
			 ArrayList<String> entitylist= new ArrayList();
			 while((current=br2.readLine())!=null){
				 entitylist.add(current);
			 }
			 for(int i=2;i<=20;i++){
				 
				 ArrayList<String> list= new ArrayList();
				 ArrayList<String> list1= new ArrayList();
				 ArrayList<String> list2=new ArrayList();
				 Random randomGenerator = new Random();
				 int rancon = randomGenerator.nextInt(20);
				 int ranphr = randomGenerator.nextInt(phraselist.size()-1);
				 int ranent = randomGenerator.nextInt(entitylist.size()-1);
				 list.add(Integer.toString(rancon));
				 list1.add(phraselist.get(ranphr));
				 list2.add(entitylist.get(ranent));
				 BasicDBObject document = new BasicDBObject().append("concept", list).append("entitesID", list2).append("phrase", list1);
				 String str = ""+"a"+i;
				 
				 document.put("name", str);
				 document.put("conceptID", Integer.toString(i));
				 col2.insert(document);
				 
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
	          
	         BasicDBObject query = new BasicDBObject();
	         query.put("entityID","2");
	         DBCursor cursor = col1.find(query);
	         //System.out.println(cursor);
	   	  while (cursor.hasNext()) {
	   		System.out.println(cursor.next());
	   	  }
	         System.out.println("Collection created successfully");
	        // System.out.println(col1.find());
	      }catch(Exception e){
	         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      }	}

}
