import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//import javax.swing.JOptionPane;

public class CryptoStegno {
	public CryptoStegno()
	{
		
	}
	public static String outputFolder="C:\\Users\\AKASH KUMAR\\Desktop\\testing\\";
	public static String encryptFolder=outputFolder+"encryptFolder\\";
	public static String decryptFolder=outputFolder+"decryptFolder\\";
	public static String encryptCryptoFolder=encryptFolder+"encryptCryptoFolder\\";
	public static String encryptStagenoFolder=encryptFolder+"encryptStagenoFolder\\";
	public static String encryptCryptoStagenoFolder=encryptFolder+"encryptCryptoStagenoFolder\\";
	public static String decryptCryptoFolder=decryptFolder+"decryptCryptoFolder\\";
	public static String decryptStagenoFolder=decryptFolder+"decryptStagenoFolder\\";
	public static String decryptCryptoStagenoFolder=decryptFolder+="decryptCryptoStagenoFolder\\";
	
	private String imageFolder=outputFolder+"imageFolder\\";
	private String textFolder=outputFolder+"textFolder\\";
	
	private File textFile;
	private File imageFile;
	private BufferedInputStream textStream;
	private BufferedInputStream imageStream;
	private String key;
	public String text;
	private int status;
	public int encryptCrypto(File textFile,String key,String output)
	{
		try
		{
			File file = new File(textFile.getAbsolutePath());
			BufferedReader br = new BufferedReader(new FileReader(file));
			String st,temp;
			st=br.readLine();
			if(st==null){
				status=2;
			}
			else
			{
				st+="\n";
				  while(true)
				  {
					  temp=br.readLine();
					  if(temp!=null)
					  {
						  st=st+temp;
						  st+="\n";
					  }
						
					  else
						  break;
				  }
				 // System.out.println(st);
				AES encryption = new AES();
				String encmsg = encryption.encrypt(st, key);
				//System.out.println(encmsg);
				BufferedWriter outputFile = null;
		        try {
		        	output=output+".txt";
		            file = new File(encryptCryptoFolder+output);
		            outputFile = new BufferedWriter(new FileWriter(file));
		            outputFile.write(encmsg);
		            status=1;
		        } 
		        catch ( IOException f ) 
		        {
		            f.printStackTrace();
		            status=0;
		        } finally 
		        {
		          if ( outputFile != null )
		          {
		            try 
		            {
						outputFile.close();
					} 
		            catch (IOException e1) 
		            {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		          }
		        }
			}
		}
		catch(Exception e)
		{
			status=0;
			e.printStackTrace();
		}
		return status;
	}
	public int encryptStagno(File imageFile,File textFile,String output)
	{
		try
		{
			Steganography model = new Steganography();
			File file = new File(textFile.getAbsolutePath());
			BufferedReader br = new BufferedReader(new FileReader(file));
			String text = br.readLine();
			if(text!=null)
			{
				text+="\n";
				  while(true)
				  {
					  String temp=br.readLine();
					  if(temp!=null)
					  {
						  text=text+temp;
						  text+="\n";
					  }
						
					  else
						  break;
				  }
				String ext  = Image_Filter.getExtension(imageFile);
				String name = imageFile.getName();
				String path = imageFile.getPath();
				path = path.substring(0,path.length()-name.length()-1);
				name = name.substring(0, name.length()-4);
				
				if(model.encodesteg(path,name,ext,output,text))
				{
					status=1;
				}
				else
				{
					status=0;
				}
			}
			else
			{
				status=2;
			}
		}
		catch (Exception e) 
		{
			status=0;
			e.printStackTrace();
		}
		return status;
	}
	public int encryptCryptoStagno(File imageFile,File textFile,String key,String output)
	{
		try
		{
			Steganography model = new Steganography();
			File file = new File(textFile.getAbsolutePath());
			BufferedReader br = new BufferedReader(new FileReader(file));
			String text = br.readLine();
			if(text!=null)
			{
				text+="\n";
				  while(true)
				  {
					  String temp=br.readLine();
					  if(temp!=null)
					  {
						  text=text+temp;
						  text+="\n";
					  }
						
					  else
						  break;
				  }
				String ext  = Image_Filter.getExtension(imageFile);
				String name = imageFile.getName();
				String path = imageFile.getPath();
				path = path.substring(0,path.length()-name.length()-1);
				name = name.substring(0, name.length()-4);
				
				String stegan = output;
				
				if(model.encode(path,name,ext,stegan,text,key))
				{
					status=1;
				}
				else
				{
					status=0;
					
				}
			}
			else{
				status=2;
			}
		}
		catch (Exception e) 
		{
			status=0;
			e.printStackTrace();
		}
		return status;
		
	}
	public int decryptCrypto(File textFile,String key,String outname)
	{
		try
		{
			File file = new File(textFile.getAbsolutePath());

			  BufferedReader br = new BufferedReader(new FileReader(file));

			  String st;
			  st = br.readLine();
			AES decryption = new AES();
			String decmsg = decryption.decrypt(st, key);
			//System.out.println(decmsg);
			BufferedWriter output = null;
	        try {
	        	outname=outname+".txt";
	            file = new File(decryptCryptoFolder+outname);
	            output = new BufferedWriter(new FileWriter(file));
	            output.write(decmsg);
	           // System.out.println(decmsg);
	            status=1;
	            
	        } 
	        catch ( IOException f ) {
	        	status=3;
	            f.printStackTrace();
	        } finally 
	        {
	          if ( output != null ) {
	            try {
					output.close();
				} catch (IOException e1) {
					status=3;
					e1.printStackTrace();
				}
	          }
	        }
			
		}
		catch(Exception ex)
		{
			status=0;
			ex.printStackTrace();
		}
		return status;
	}
	public int decryptStagno(File imageFile,String outname)
	{
		try
		{
			Steganography model = new Steganography();
			String image = imageFile.getPath();
			String stat_name = imageFile.getName();
			String stat_path = imageFile.getPath();
			stat_path = stat_path.substring(0,stat_path.length()-stat_name.length()-1);
			stat_name = stat_name.substring(0, stat_name.length()-4);
			String message = model.decodesteg(stat_path, stat_name);
			if(message != "")
			{
				
				//System.out.println(message);
				//input.setText(message);
				BufferedWriter output = null;
		        try {
		        	//outname = JOptionPane.showInputDialog("Enter output File name");
		        	outname=outname+".txt";
		            File file = new File(decryptStagenoFolder+outname);
		            output = new BufferedWriter(new FileWriter(file));
		            output.write(message);
		            status=1;
		           
		        } 
		        catch ( IOException f ) {
		        	status=0;
		            f.printStackTrace();
		        } 
		        finally
		        {
		          if ( output != null ) {
		            try {
						output.close();
					} catch (IOException e1) {
						status=3;
						e1.printStackTrace();
					}
		          }
		        }
			}
			else
			{
				status=0;
			}
		}

		catch(Exception ex)
		{
			status=3;
		}
		return status;
	}
	public int decryptCryptoStagno(File imageFile,String key,String outname)
	{
		try
		{
			Steganography model = new Steganography();
			String image = imageFile.getPath();
			String stat_name = imageFile.getName();
			String stat_path = imageFile.getPath();
			stat_path = stat_path.substring(0,stat_path.length()-stat_name.length()-1);
			stat_name = stat_name.substring(0, stat_name.length()-4);
			String message = model.decode(stat_path, stat_name,key);
			if(message != "")
			{
				
				//System.out.println(message);
				//input.setText(message);
				BufferedWriter output = null;
		        try {
		        	outname=outname+".txt";
		            File file = new File(decryptCryptoStagenoFolder+outname);
		            output = new BufferedWriter(new FileWriter(file));
		            output.write(message);
		            status=1;
		            
		        } catch ( IOException f ) {
		        	status=0;
		            f.printStackTrace();
		        } finally {
		          if ( output != null ) {
		            try {
		            	status=3;
						output.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						status=3;
						e1.printStackTrace();
					}
		          }
		        }
			}
			else
			{
				status=0;
			}
		}

		catch(Exception ex)
		{
			status=3;
		}
		return status;
	}
	
	public static void main(String args[])
	{
		StagenoUI st=new StagenoUI();
	}
}
