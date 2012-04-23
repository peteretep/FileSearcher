import java.io.IOException;
import java.util.ArrayList;


public class FileSearcher 
{
	ArrayList <String> words;  		// list of words to search for
	ArrayList <FileObject> files;	// list of FileObjects

	public FileSearcher() throws IOException		// Constructor for filesearcher - puts files into it
	{
		files=new ArrayList<FileObject>();
		FileObject file=new FileObject("file1.txt");
		files.add(file);
		file=new FileObject("file2.txt");
		files.add(file);
	}
	
	
	private void addWords() 						// Adds words to the words arrayList
	{
		words=new ArrayList<String>();
		words.add("thanks");
		words.add("you");
		words.add("Im");
		words.add("how");
	}

	public static void main(String[] args) throws IOException 
	{
		FileSearcher fileSearch1=new FileSearcher();	// Initialises new FileSearcher
		
		fileSearch1.addWords();							// Runs the add words method
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
		if(files.get(0).numberOfWords < files.get(1).numberOfWords)
		{	
			FileObject spare=files.get(0);
			files.set(0, files.get(1));
			files.set(1, spare);
		}
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
