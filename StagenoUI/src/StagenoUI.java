
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;

//import com.sun.javafx.property.adapter.ReadOnlyPropertyDescriptor.ReadOnlyListener;
//import com.sun.org.apache.bcel.internal.generic.GOTO;

import javafx.scene.image.Image;

//import javafx.scene.image.Image;

public class StagenoUI{
		private String user="test";
		private String passw="demo123";
		
		private JFrame frame;
		
		private JButton encryption;
		private JButton decryption;
		private JButton logout;
		
		private JButton selectFile;
		private JButton selectImage;
		private JLabel imageLabel;
		private JLabel fileLabel;
		private JLabel keyLabel;
		private JTextField keyField;
		
		private File textFile;
		private File imageFile;
		private BufferedInputStream textStream;
		private BufferedInputStream imageStream;
		private String key;
		public String text;
		
		private JButton encrypt;
		private JButton decrypt;
		private JButton crypto;
		private JButton stageno;
		private JButton cryptoStageno;
		
		private boolean encryptStatus=false;
		private boolean decryptStatus=false;
		private boolean cryptoStatus=false;
		private boolean stagenoStatus=false;
		private boolean cryptoStagenoStatus=false;
		
		public StagenoUI(){
		logIn();
	}
	JFrame makeFrame(){
		frame=new JFrame();
		frame.setBounds(100, 100, 800, 500);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		return frame;
	}
	void setBackGround()
	{
		JLabel background;
		frame.setLayout(new FlowLayout());
		background=new JLabel(new ImageIcon("C:\\Users\\AKASH KUMAR\\workspace\\New folder\\StagenoUI\\src\\img.jpg"));
		frame.setContentPane(background);
		background.setLayout(new FlowLayout());
		frame.setLayout(null);
	}
	public void logIn()
	{
		frame=makeFrame();
		setBackGround();
		JButton logIn;
		JPasswordField password;
	    JTextField uName;
		Image img;
		
		JLabel uNameLabel;
		JLabel passwordLabel;
		JLabel welcome;
		JLabel error;
		
		logIn=new JButton("LOGIN");
		password=new JPasswordField();
		uName=new JTextField();
		uNameLabel=new JLabel("User Name : ");
		passwordLabel=new JLabel("Password : ");
		welcome=new JLabel("CryptoSteg+");
		error=new JLabel();
		
		welcome.setFont(new Font("Lucida Calligraphy", 50, 50));
		welcome.setForeground(new Color(255, 255, 255));
		uNameLabel.setFont(new Font("Lucida Calligraphy", 100, 20));
		uNameLabel.setForeground(new Color(255, 255, 255));
		passwordLabel.setFont(new Font("Lucida Calligraphy", 100, 20));
		passwordLabel.setForeground(new Color(255, 255, 255));
		uName.setFont(new Font("Georgia",50, 20));
		uName.setForeground(new Color(0, 0, 0));
		error.setForeground(new Color(255, 0, 0));
		error.setFont(new Font("Georgia",50, 20));
		
		welcome.setBounds(230, 50, 600, 70);
		uNameLabel.setBounds(200, 150, 150, 30);
		uName.setBounds(350, 150, 200, 30);
		passwordLabel.setBounds(200, 200, 150, 30);
		password.setBounds(350, 200, 200, 30);
		logIn.setBounds(300, 250, 100, 30);
		error.setBounds(350, 300, 300, 30);
		
		logIn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String uname=uName.getText();
				String pass=password.getText();
				if(uname.equals(user) && pass.equals(passw))
				{
					frame.removeAll();
					frame.setVisible(false);
					home();
				}
				else
				{
					error.setText("Wrong UserName or Password");
				}
			}
		});
		frame.add(welcome);
		frame.add(uNameLabel);
		frame.add(uName);
		frame.add(passwordLabel);
		frame.add(password);
		frame.add(logIn);
		frame.setVisible(true);
		frame.add(error);
	}
	
	/*private String readFile(String file) throws IOException {
	    BufferedReader reader = new BufferedReader(new FileReader (file));
	    String         line = null;
	    StringBuilder  stringBuilder = new StringBuilder();
	    String         ls = System.getProperty("line.separator");

	    try {
	        while((line = reader.readLine()) != null) {
	            stringBuilder.append(line);
	            stringBuilder.append(ls);
	        }

	        return stringBuilder.toString();
	    } finally {
	        reader.close();
	    }
	}*/
	
	public void home()
	{
		frame=makeFrame();
		this.setBackGround();
	    encryption=new JButton("Encryption");
		decryption=new JButton("Decryption");
		logout=new JButton("Logout");
		
		crypto=new JButton("CryptoGraphy");
		stageno=new JButton("StagenoGraphy");
		cryptoStageno=new JButton("CryptoGraphy + StagenoGraphy");
		
		selectFile=new JButton("Select File");
		selectImage=new JButton("Select Image");
		fileLabel=new JLabel("");
		imageLabel=new JLabel("");
		keyLabel=new JLabel("Enter Key");
		keyField=new JTextField("");
		
		encrypt=new JButton("Encrypt");
		decrypt=new JButton("decrypt");
		
		encryption.setBounds(50, 50, 200, 50);
		decryption.setBounds(300, 50, 200, 50);
		logout.setBounds(550, 50, 200, 50);
		
		stageno.setBounds(70, 120, 200, 50);
		crypto.setBounds(70,180,200,50);
		cryptoStageno.setBounds(70,240,250,50);
		
		selectImage.setBounds(300,250,150,30);
		selectFile.setBounds(300,300,150,30);
		fileLabel.setBounds(470,300,200,30);
		imageLabel.setBounds(470,250,200,30);
		
		encrypt.setBounds(400,350,150,50);
		decrypt.setBounds(400,300,150,50);
		
		fileLabel.setBackground(Color.WHITE);
		imageLabel.setBackground(Color.WHITE);
		
		logout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.removeAll();
				frame.setVisible(false);
				logIn();
				
			}
		});
		
		encryption.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				encryption();
			}
		});
		
		decryption.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				decryption();
			}
		});
		
		stageno.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				stagenoGraphy();
			}
		});
		
		crypto.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				cryptoGraphy();
				
			}
		});
		
		cryptoStageno.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cryptoStagenoGraphy();
			}
		});
		
		encrypt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				encrypt();
			}
		});
		
		decrypt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				decrypt();
			}
		});
		
		selectFile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc=new JFileChooser();
				fc.setCurrentDirectory(new File(CryptoStegno.outputFolder));
				int i=fc.showOpenDialog(frame);
				if(i==JFileChooser.APPROVE_OPTION)
				{
					textFile=fc.getSelectedFile();
					if(new FileFilter().validateTextFile(textFile))
					{
						text=null;
						/*try
						{
							
							//JOptionPane.showMessageDialog(frame,text,"Alert",JOptionPane.WARNING_MESSAGE);  
						}
						catch(Exception ex)
						{
							JOptionPane.showMessageDialog(frame,ex,"Alert",JOptionPane.WARNING_MESSAGE);  
						}*/
						fileLabel.setText(textFile.getName());
					}
					else
					{
						fileLabel.setText("Invalid Format");
					}
					fileLabel.setVisible(true);
				}
			}
		});
		
		selectImage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				JFileChooser fc=new JFileChooser();
				fc.setCurrentDirectory(new File(CryptoStegno.outputFolder));
				int i=fc.showOpenDialog(frame);
				if(i==JFileChooser.APPROVE_OPTION)
				{
					imageFile=fc.getSelectedFile();
					if(new FileFilter().validateImageFile(imageFile))
					{
						
						/*try{
							//imageStream=new BufferedInputStream(new FileInputStream(imageFile));
						}
						catch(Exception ex)
						{
							
						}*/
						imageLabel.setText(imageFile.getName());
					}
					else
					{
						imageLabel.setText("Invalid Format");
					}
					imageLabel.setVisible(true);
				}
			}
		});

		frame.add(encryption);
		frame.add(decryption);
		frame.add(logout);
		
		frame.add(selectFile);
		frame.add(selectImage);
		frame.add(fileLabel);
		frame.add(imageLabel);
		frame.add(keyField);
		frame.add(keyLabel);
		
		frame.add(crypto);
		frame.add(stageno);
		frame.add(cryptoStageno);
		
		
		frame.add(encrypt);
		frame.add(decrypt);
		
		selectFile.setVisible(false);
		selectImage.setVisible(false);
		imageLabel.setVisible(false);
		fileLabel.setVisible(false);
		keyLabel.setVisible(false);
		keyField.setVisible(false);
		
		crypto.setVisible(false);
		stageno.setVisible(false);
		cryptoStageno.setVisible(false);
		
		encrypt.setVisible(false);
		decrypt.setVisible(false);
		
	}
	public void encrypt()
	{
		if(cryptoStatus)
		{
			if(!fileLabel.getText().isEmpty() && fileLabel.getText()!="Invalid Format" && keyField.getText()!=null && !keyField.getText().isEmpty())
			{
				try
				{
					key=keyField.getText();
					String inname=JOptionPane.showInputDialog("Enter File name");
					CryptoStegno CS=new CryptoStegno();
					int status=CS.encryptCrypto(textFile,key,inname);
					if(status==0)
					{
						JOptionPane.showMessageDialog(frame,"Enter A Valid Key","Alert",JOptionPane.WARNING_MESSAGE);
					}
					else if(status==1)
					{
						 JOptionPane.showMessageDialog(frame,"Message encoded succesfully!!!","Alert",JOptionPane.INFORMATION_MESSAGE);
					}
					else if(status==2)
					{
						JOptionPane.showMessageDialog(frame,"Empty File","Alert",JOptionPane.WARNING_MESSAGE);
					}
					else
					{
						JOptionPane.showMessageDialog(frame,"Invalid Data","Alert",JOptionPane.WARNING_MESSAGE); 
					}
					  
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(frame,"Invalid Data","Alert",JOptionPane.WARNING_MESSAGE); 
				}
				
			}
			else
			{
				JOptionPane.showMessageDialog(frame,"Invalid Data","Alert",JOptionPane.WARNING_MESSAGE);  
			}
		}
		else if(stagenoStatus)
		{
			if(fileLabel.getText()!="" && fileLabel.getText()!="Invalid Format" && imageLabel.getText()!="" && imageLabel.getText()!="Invalid Format")
			{
				try
				{
					String inname=JOptionPane.showInputDialog("Enter File name");
					CryptoStegno CS=new CryptoStegno();
					int status=CS.encryptStagno(imageFile, textFile, inname);
					if(status==0)
					{
						JOptionPane.showMessageDialog(frame, "The Image could not be encoded!", 
								"Error!", JOptionPane.INFORMATION_MESSAGE);
					}
					else if(status==1)
					{
						JOptionPane.showMessageDialog(frame, "The Image was encoded Successfully!", 
								"Success!", JOptionPane.INFORMATION_MESSAGE);
					}
					else if(status==2)
					{
						JOptionPane.showMessageDialog(frame, "Empty File!", 
								"Error!", JOptionPane.INFORMATION_MESSAGE);
					}
					else
					{
						JOptionPane.showMessageDialog(frame,"Invalid Data","Alert",JOptionPane.WARNING_MESSAGE); 
					}
				
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(frame, "The Image could not be encoded!", 
							"Error!", JOptionPane.INFORMATION_MESSAGE);
				}
			}
			else
			{
				JOptionPane.showMessageDialog(frame,"Invalid Data","Alert",JOptionPane.WARNING_MESSAGE);  
			}
		}
		else if(cryptoStagenoStatus)
		{
			if(fileLabel.getText()!="" && fileLabel.getText()!="Invalid Format" && keyField.getText()!="" &&  imageLabel.getText()!="" && imageLabel.getText()!="Invalid Format")
			{
				try
				{
					key=keyField.getText();
					String inname=JOptionPane.showInputDialog("Enter File name");
					CryptoStegno CS=new CryptoStegno();
					int status=CS.encryptCryptoStagno(imageFile, textFile, key, inname);
					if(status==0)
					{
						JOptionPane.showMessageDialog(frame, "The Image could not be encoded!", 
								"Error!", JOptionPane.INFORMATION_MESSAGE);
					}
					else if(status==1)
					{
						JOptionPane.showMessageDialog(frame, "The Image encoded successfully", 
								"Success!", JOptionPane.INFORMATION_MESSAGE);
					}
					else if(status==2)
					{
						JOptionPane.showMessageDialog(frame, "Empty File!", 
								"Error!", JOptionPane.INFORMATION_MESSAGE);
					}
					else
					{
						JOptionPane.showMessageDialog(frame,"Invalid Data","Alert",JOptionPane.WARNING_MESSAGE); 
					}
					
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(frame, "The Image could not be encoded!", 
							"Error!", JOptionPane.INFORMATION_MESSAGE);
				}
			}
			else
			{
				JOptionPane.showMessageDialog(frame,"Invalid Data","Alert",JOptionPane.WARNING_MESSAGE);  
			}
		}
			
	}
	public void decrypt()
	{
		if(cryptoStatus)
		{
			if(fileLabel.getText()!="" && fileLabel.getText()!="Invalid Format" && keyField.getText()!="")
			{
				key=keyField.getText();
				String inname=JOptionPane.showInputDialog("Enter File name");
				CryptoStegno CS=new CryptoStegno();
				int status=CS.decryptCrypto(textFile, key, inname);
				if(status==0)
				{
					JOptionPane.showMessageDialog(frame,"Enter A Valid Key","Alert",JOptionPane.WARNING_MESSAGE);
				}
				else if(status==1)
				{
					JOptionPane.showMessageDialog(frame,"Message decocoded succesfully","Alert",JOptionPane.INFORMATION_MESSAGE);
				}
				else if(status==2)
				{
					JOptionPane.showMessageDialog(frame,"Empty File","Alert",JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					JOptionPane.showMessageDialog(frame,"Invalid Data","Alert",JOptionPane.WARNING_MESSAGE); 
				}
			}
			else
			{
				JOptionPane.showMessageDialog(frame,"Invalid Data","Alert",JOptionPane.WARNING_MESSAGE);  
			}
		}
		else if(stagenoStatus)
		{
			if(imageLabel.getText()!="" && imageLabel.getText()!="Invalid Format")
			{
				key=keyField.getText();
				String inname=JOptionPane.showInputDialog("Enter File name");
				CryptoStegno CS=new CryptoStegno();
				int status=CS.decryptStagno(imageFile, inname);
				if(status==0)
				{
					JOptionPane.showMessageDialog(frame, "The Image could not be decoded!", 
							"Error!", JOptionPane.INFORMATION_MESSAGE);
				}
				else if(status==1)
				{
					 JOptionPane.showMessageDialog(frame, "The Image was decoded Successfully!", 
								"Success!", JOptionPane.INFORMATION_MESSAGE);
				}
				else if(status==2)
				{
					JOptionPane.showMessageDialog(frame, "Empty File!", 
							"Error!", JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					JOptionPane.showMessageDialog(frame,"Invalid Data","Alert",JOptionPane.WARNING_MESSAGE); 
				}
				
			}
			else
			{
				JOptionPane.showMessageDialog(frame,"Invalid Data","Alert",JOptionPane.WARNING_MESSAGE);  
			}
		}
		else if(cryptoStagenoStatus)
		{
			if(keyField.getText()!="" &&  imageLabel.getText()!="" && imageLabel.getText()!="Invalid Format")
			{
				key=keyField.getText();
				String inname=JOptionPane.showInputDialog("Enter File name");
				CryptoStegno CS=new CryptoStegno();
				int status=CS.decryptCryptoStagno(imageFile, key, inname);
				if(status==0)
				{
					JOptionPane.showMessageDialog(frame, "The Image could not be decoded!", 
							"Error!", JOptionPane.INFORMATION_MESSAGE);
				}
				else if(status==1)
				{
					JOptionPane.showMessageDialog(frame, "The Image was decoded Successfully!", 
							"Success!", JOptionPane.INFORMATION_MESSAGE);
				}
				else if(status==2)
				{
					JOptionPane.showMessageDialog(frame, "Empty File!", 
							"Error!", JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					JOptionPane.showMessageDialog(frame,"Invalid Data","Alert",JOptionPane.WARNING_MESSAGE); 
				}
			}
			else
			{
				JOptionPane.showMessageDialog(frame,"Invalid Data","Alert",JOptionPane.WARNING_MESSAGE);  
			}
		}
	}
	public void encryption()
	{
		encryption.setEnabled(false);
		decryption.setEnabled(true);
		encryptStatus=true;
		decryptStatus=false;
		cryptoStatus=false;
		stagenoStatus=false;
		cryptoStagenoStatus=false;
		
		crypto.setVisible(true);
		stageno.setVisible(true);
		cryptoStageno.setVisible(true);
		
		selectFile.setVisible(false);
		selectImage.setVisible(false);
		imageLabel.setVisible(false);
		fileLabel.setVisible(false);
		keyLabel.setVisible(false);
		keyField.setVisible(false);
		
		encrypt.setVisible(false);
		decrypt.setVisible(false);
		
		stageno.setBounds(100, 120, 200, 50);
		crypto.setBounds(100,180,200,50);
		cryptoStageno.setBounds(100,240,250,50);
		
	}
	public void decryption()
	{
		decryption.setEnabled(false);
		encryption.setEnabled(true);
		encryptStatus=false;
		decryptStatus=true;
		cryptoStatus=false;
		stagenoStatus=false;
		cryptoStagenoStatus=false;
		
		crypto.setVisible(true);
		stageno.setVisible(true);
		cryptoStageno.setVisible(true);
		
		selectFile.setVisible(false);
		selectImage.setVisible(false);
		imageLabel.setVisible(false);
		fileLabel.setVisible(false);
		keyLabel.setVisible(false);
		keyField.setVisible(false);
		
		encrypt.setVisible(false);
		decrypt.setVisible(false);
		
		stageno.setBounds(350, 120, 200, 50);
		crypto.setBounds(350,180,200,50);
		cryptoStageno.setBounds(350,240,250,50);
	}
	public void cryptoGraphy()
	{
		encryption.setEnabled(true);
		decryption.setEnabled(true);
		cryptoStatus=true;
		stagenoStatus=false;
		cryptoStagenoStatus=false;
		
		crypto.setVisible(false);
		stageno.setVisible(false);
		cryptoStageno.setVisible(false);
		
		selectFile.setVisible(true);
		fileLabel.setVisible(true);
		selectImage.setVisible(false);
		imageLabel.setVisible(false);
		keyLabel.setVisible(true);
		keyField.setVisible(true);
		
		encrypt.setVisible(false);
		decrypt.setVisible(false);
		
		//selectImage.setBounds(300,250,150,30);
		selectFile.setBounds(300,250,150,30);
		fileLabel.setBounds(470,250,200,30);
		keyLabel.setBounds(470,300,200,30);
		keyField.setBounds(300,300,150,30);
		//imageLabel.setBounds(470,250,200,30);
		if(encryptStatus)
		{
			encrypt.setBounds(370,350,150,50);
			encrypt.setVisible(true);
		}
		else if(decryptStatus)
		{
			decrypt.setBounds(370,350,150,50);
			decrypt.setVisible(true);
		}
		
	}
	public void stagenoGraphy()
	{
		encryption.setEnabled(true);
		decryption.setEnabled(true);
		cryptoStatus=false;
		stagenoStatus=true;
		cryptoStagenoStatus=false;
		
		crypto.setVisible(false);
		stageno.setVisible(false);
		cryptoStageno.setVisible(false);
		
		selectImage.setVisible(true);
		imageLabel.setVisible(true);
		keyLabel.setVisible(false);
		keyField.setVisible(false);
		
		encrypt.setVisible(false);
		decrypt.setVisible(false);
		
		
		if(encryptStatus)
		{
			selectFile.setVisible(true);
			fileLabel.setVisible(true);
			
			selectFile.setBounds(300,250,150,30);
			fileLabel.setBounds(470,250,200,30);
			selectImage.setBounds(300,300,150,30);
			imageLabel.setBounds(470,300,200,30);
			
			encrypt.setBounds(370,350,150,50);
			encrypt.setVisible(true);
		}
		else if(decryptStatus)
		{
			selectFile.setVisible(false);
			fileLabel.setVisible(false);
			
			selectImage.setBounds(300,250,150,30);
			imageLabel.setBounds(470,250,200,30);
			
			decrypt.setBounds(370,300,150,50);
			decrypt.setVisible(true);
		}
	}
	public void cryptoStagenoGraphy()
	{
		encryption.setEnabled(true);
		decryption.setEnabled(true);
		cryptoStatus=false;
		stagenoStatus=false;
		cryptoStagenoStatus=true;
		
		crypto.setVisible(false);
		stageno.setVisible(false);
		cryptoStageno.setVisible(false);
		
		//selectFile.setVisible(true);
		//fileLabel.setVisible(true);
		selectImage.setVisible(true);
		imageLabel.setVisible(true);
		keyLabel.setVisible(true);
		keyField.setVisible(true);
		
		encrypt.setVisible(false);
		decrypt.setVisible(false);
		
		if(encryptStatus)
		{
			selectFile.setVisible(true);
			fileLabel.setVisible(true);
			encrypt.setVisible(true);
			
			selectImage.setBounds(300,200,150,30);
			imageLabel.setBounds(470,200,200,30);
			selectFile.setBounds(300,250,150,30);
			fileLabel.setBounds(470,250,200,30);
			keyField.setBounds(300,300,150,30);
			keyLabel.setBounds(470,300,200,30);
			encrypt.setBounds(370,350,150,50);
			
		}
		else if(decryptStatus)
		{
			selectFile.setVisible(false);
			fileLabel.setVisible(false);
			decrypt.setVisible(true);
			
			selectImage.setBounds(300,250,150,30);
			imageLabel.setBounds(470,250,200,30);
			keyField.setBounds(300,300,150,30);
			keyLabel.setBounds(470,300,200,30);
			
			decrypt.setBounds(370,350,150,50);
		}
	}
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassw() {
		return passw;
	}
	public void setPassw(String passw) {
		this.passw = passw;
	}
	public JFrame getFrame() {
		return frame;
	}
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	public JButton getEncryption() {
		return encryption;
	}
	public void setEncryption(JButton encryption) {
		this.encryption = encryption;
	}
	public JButton getDecryption() {
		return decryption;
	}
	public void setDecryption(JButton decryption) {
		this.decryption = decryption;
	}
	public JButton getLogout() {
		return logout;
	}
	public void setLogout(JButton logout) {
		this.logout = logout;
	}
	public JButton getSelectFile() {
		return selectFile;
	}
	public void setSelectFile(JButton selectFile) {
		this.selectFile = selectFile;
	}
	public JButton getSelectImage() {
		return selectImage;
	}
	public void setSelectImage(JButton selectImage) {
		this.selectImage = selectImage;
	}
	public JLabel getImageLabel() {
		return imageLabel;
	}
	public void setImageLabel(JLabel imageLabel) {
		this.imageLabel = imageLabel;
	}
	public JLabel getFileLabel() {
		return fileLabel;
	}
	public void setFileLabel(JLabel fileLabel) {
		this.fileLabel = fileLabel;
	}
	public JLabel getKeyLabel() {
		return keyLabel;
	}
	public void setKeyLabel(JLabel keyLabel) {
		this.keyLabel = keyLabel;
	}
	public JTextField getKeyField() {
		return keyField;
	}
	public void setKeyField(JTextField keyField) {
		this.keyField = keyField;
	}
	public File getTextFile() {
		return textFile;
	}
	public void setTextFile(File textFile) {
		this.textFile = textFile;
	}
	public File getImageFile() {
		return imageFile;
	}
	public void setImageFile(File imageFile) {
		this.imageFile = imageFile;
	}
	public BufferedInputStream getTextStream() {
		return textStream;
	}
	public void setTextStream(BufferedInputStream textStream) {
		this.textStream = textStream;
	}
	public BufferedInputStream getImageStream() {
		return imageStream;
	}
	public void setImageStream(BufferedInputStream imageStream) {
		this.imageStream = imageStream;
	}
	public JButton getEncrypt() {
		return encrypt;
	}
	public void setEncrypt(JButton encrypt) {
		this.encrypt = encrypt;
	}
	public JButton getDecrypt() {
		return decrypt;
	}
	public void setDecrypt(JButton decrypt) {
		this.decrypt = decrypt;
	}
	public JButton getCrypto() {
		return crypto;
	}
	public void setCrypto(JButton crypto) {
		this.crypto = crypto;
	}
	public JButton getStageno() {
		return stageno;
	}
	public void setStageno(JButton stageno) {
		this.stageno = stageno;
	}
	public JButton getCryptoStageno() {
		return cryptoStageno;
	}
	public void setCryptoStageno(JButton cryptoStageno) {
		this.cryptoStageno = cryptoStageno;
	}
	public boolean isEncryptStatus() {
		return encryptStatus;
	}
	public void setEncryptStatus(boolean encryptStatus) {
		this.encryptStatus = encryptStatus;
	}
	public boolean isDecryptStatus() {
		return decryptStatus;
	}
	public void setDecryptStatus(boolean decryptStatus) {
		this.decryptStatus = decryptStatus;
	}
	public boolean isCryptoStatus() {
		return cryptoStatus;
	}
	public void setCryptoStatus(boolean cryptoStatus) {
		this.cryptoStatus = cryptoStatus;
	}
	public boolean isStagenoStatus() {
		return stagenoStatus;
	}
	public void setStagenoStatus(boolean stagenoStatus) {
		this.stagenoStatus = stagenoStatus;
	}
	public boolean isCryptoStagenoStatus() {
		return cryptoStagenoStatus;
	}
	public void setCryptoStagenoStatus(boolean cryptoStagenoStatus) {
		this.cryptoStagenoStatus = cryptoStagenoStatus;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
		
}
