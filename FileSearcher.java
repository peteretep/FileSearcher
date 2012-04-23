import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;


public class FileSearcher 
{
	
	
	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	ArrayList <String> words;
	ArrayList <String> files;
	
	public static void main(String[] args) throws IOException 
	{
		FileSearcher filesearch1=new FileSearcher();
		filesearch1.addFiles("file1.txt");
		filesearch1.addFiles("file2.txt");
		filesearch1.addWords();
		for (int j=0;j<filesearch1.files.size();j++)
		{
			int times = filesearch1.checkIfWordIsInFiles(j);
			System.out.println(times);
		}

	}

	private FileSearcher() throws FileNotFoundException
	{
		files= new ArrayList<String>();		
		words= new  ArrayList<String>();
	}
	
	private void addFiles(String filelocationstring) throws IOException
	{
		FileInputStream file= new FileInputStream(filelocationstring);
	
		BufferedReader in=new BufferedReader(new InputStreamReader(file));
		String str;
		String fileString="";
		while ((str=in.readLine())!=null)
		{
			fileString=fileString+ " "+ str;				
		}
		
		files.add(fileString);
	}
	
	private void addWords() 
	{
		words.add("thanks");
		words.add("you");
		words.add("Im");
	}
	
	private int checkIfWordIsInFiles(int j)
	{
		int times=0;
		for(int i=0; i<words.size();i++)
		{
			
			if (files.get(j).contains(words.get(i)))
			{
				times++;
			}
		}
		
		return times;
	}
	
	
	
	
}
