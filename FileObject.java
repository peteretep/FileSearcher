import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class FileObject 
{
	String fileLocation;
	String fileContents="";
	int numberOfWords=0;
	public FileObject(String location) throws IOException
	{
		fileLocation=location;
		
		FileInputStream file= new FileInputStream(fileLocation);
		
		BufferedReader in=new BufferedReader(new InputStreamReader(file));
		String str;
		// reads the whole contents of a file into a string
		while ((str=in.readLine())!=null)
		{
			fileContents=fileContents+ " "+ str;				
		}
		
		
	}
	
	public String getContent()
	{	
		return fileContents;
	}
		
	public void checkWord(String word)
	{
		if(fileContents.contains(word))
		{
			numberOfWords++;
		}
	}
	
	
}
