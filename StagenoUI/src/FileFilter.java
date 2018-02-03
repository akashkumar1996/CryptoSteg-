import java.io.*;

public class FileFilter {
	public boolean validateImageFile(File file)
	{
		String ext=getExtension(file);
		return compareImageFile(ext);
	}
	public boolean validateTextFile(File file)
	{
		String ext=getExtension(file);
		return compareTextFile(ext);
	}
	public String getExtension(File file)
	{
		String name=file.getName();
		try
		{
			return name.substring(name.lastIndexOf('.')+1);
		}
		catch(Exception e)
		{
			return "";
		}
	}
	public boolean compareTextFile(String str)
	{
		if(str.compareTo("text")==0)
		{
			return true;
		}
		else if(str.compareTo("txt")==0)
		{
			return true;
		}
		else
				return false;
	}
	public boolean compareImageFile(String str)
	{
		if(str.compareTo("png")==0)
		{
			return true;
		}
		else if(str.compareTo("jpg")==0)
		{
			return true;
		}
		else
				return false;
	}
}
