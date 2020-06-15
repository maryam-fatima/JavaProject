package final_TT;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Records
{
	private static File myfile = new File("scores.txt");
	private static ArrayList<Integer> scores = new ArrayList<Integer>(10);
	private static boolean create;
	private static int i=0;
	
	
	//return arrayList score
	public ArrayList<Integer> getScores()
	{

		return scores;
	}
	
	//creating file// 
	private static void creatingFile() throws IOException {
	  
		try {
		    
		    create = myfile.createNewFile();
		  	if(create){
					System.out.println("File is created");
					System.out.println("No previous records to show");
			}
		  	else{
					System.out.println("File has already been created");
			}
		}
		catch(IOException e){
				
			e.printStackTrace();
			
		}//end try-catch block
	}//end method creatingFile
	
	//writing to file// 
	public  void writingFile() throws IOException{
		
		try {
			creatingFile();
			FileWriter mywriter = new FileWriter(myfile,true);
			BufferedWriter bw = new BufferedWriter(mywriter);
			bw.write(" " + Gui.getScore());
			updateList();
			
			bw.newLine();
			
			//closing BuffereWriter and FileWriter
			bw.close();
		    mywriter.close();
		}
		catch(IOException ioe){
			
		    System.out.println("Exception occurred:");
			 ioe.printStackTrace();
		}//end try-catch block
	}//end method writingFile

	
	//to update score Array List
	private void updateList() {
		
        scores.add(Gui.getScore());
        i++;
        if(i > 10){
           	scores.remove(0);
        } 
	}//end method update List
	
	//reading from file// 
	public  void readingFile() throws IOException,NumberFormatException{   
		
		 creatingFile();
	     FileReader filereader = new FileReader(myfile);
	     BufferedReader myreader = new BufferedReader(filereader);

	    int marks;
	 	int b=0;
	 	
		 try {
			
			while((b=myreader.read())!=-1)	{
			
				do{
					marks = Integer.parseInt(myreader.readLine());
			        scores.add(marks);
			        i++;
			        if(i > 10){
			           	scores.remove(0);
			        }     
	            }
	            while((char)b=='\n');
				
		    }//end while
		 }catch(IOException ioe){
			
				 ioe.printStackTrace();		 
		 }catch(NumberFormatException e){
			 
				System.out.println("String is invalid");
		 }//end try-catch block		
		 
		 
		//closing BuffereReader and FileReader
		 myreader.close();	
		 filereader.close();

		 
	 }//end method readingFile
	
	
}//end class Records

