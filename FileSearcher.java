import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


public class FileSearcher 
{
	// list of words to search for
	ArrayList <String> words=new ArrayList<String>();  		
	ArrayList <FileObject> files;	// list of FileObjects

	public FileSearcher() throws IOException		// Constructor for filesearcher - puts files into it
	{
		files=new ArrayList<FileObject>();
		FileObject file=new FileObject("file1.txt");
		files.add(file);
		file=new FileObject("file2.txt");
		files.add(file);
		file=new FileObject("file3.txt");
		files.add(file);
	}
	
	
	private void addWords(String word) 						// Adds words to the words arrayList
	{
		words.add(word);
	}

	public static void main(String[] args) throws IOException 
	{
		FileSearcher fileSearch1=new FileSearcher();	// Initialises new FileSearcher
		
		for(String word: args)
		{
			
			// Runs the add words method
			fileSearch1.addWords(word);
		}	
			
		for (int j=0;j<fileSearch1.files.size();j++)	// calls the checkIfWordIsInFiles method for each file
		{
			fileSearch1.checkIfWordIsInFiles(j);
		}
		
		fileSearch1.sortFileObjects();
		fileSearch1.printResults();
		
	}

	
	
	private void checkIfWordIsInFiles(int j)
	{
		for (int i=0;i<words.size();i++)
		{
			files.get(j).checkWord(words.get(i));		// Checks if the word is in this file
		}
		
		
	}

	private void sortFileObjects()
	{
		// modified mergesort O(nlog(n))
		Collections.sort(files);  
		// reverse runs in linear time
		Collections.reverse(files);
	}
	
	private void printResults()
	{
		for (int j=0;j<files.size();j++)
		{
			// Prints out file name and number of words
			System.out.println (files.get(j).fileLocation +" has "+ files.get(j).numberOfWords + " words" );
		}
	}
	
}
