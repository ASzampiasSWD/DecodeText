import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.border.EtchedBorder;

/**
 * GUI of DecodeText project.
 * @author Amanda
 */
public class DecodeTextGUI {

	private JFrame frmDecode;
	private JFrame frmInstructions;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					DecodeTextGUI window = new DecodeTextGUI();
					window.frmDecode.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DecodeTextGUI() 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frmDecode = new JFrame();
		//frmDecode.setIconImage(Toolkit.getDefaultToolkit().getImage(DecodeTextGUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
		try 
		{
			frmDecode.setIconImage(ImageIO.read(new File("images/decodeLock.png")));
		} 
		catch (IOException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		frmDecode.setResizable(false);
		frmDecode.setTitle("Decode Text");
		frmDecode.setBounds(100, 100, 897, 428);
		frmDecode.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDecode.getContentPane().setLayout(null);
		
		JPanel radPanel = new JPanel();
		radPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		radPanel.setBounds(364, 64, 153, 129);
		frmDecode.getContentPane().add(radPanel);
		
		JRadioButton radROT13 = new JRadioButton("ROT 13");
		radROT13.setBounds(16, 7, 93, 23);
		
		JRadioButton radROT47 = new JRadioButton("ROT 47");
		radROT47.setBounds(16, 35, 93, 23);
		
		JRadioButton radCaesarCipher = new JRadioButton("Caesar Cipher");
		radCaesarCipher.setBounds(16, 61, 115, 23);
		
		JRadioButton radBase64 = new JRadioButton("Base64");
		radBase64.setBounds(16, 87, 93, 23);
		
        ButtonGroup group = new ButtonGroup();
	    group.add(radROT47);
	    group.add(radROT13);
	    group.add(radBase64);
	    group.add(radCaesarCipher); 
	    radPanel.setLayout(null);
	    radPanel.add(radROT13);
	    radPanel.add(radROT47);
	    radPanel.add(radCaesarCipher);
	    radPanel.add(radBase64);
	    
	    JTextArea txtEncodedText = new JTextArea();
		txtEncodedText.setLineWrap(true);
		txtEncodedText.setBounds(23, 64, 313, 241);
		frmDecode.getContentPane().add(txtEncodedText);
			
		JLabel lblPlaceEncodedMessage = new JLabel("Place encoded message in textbox below:");
		lblPlaceEncodedMessage.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
		lblPlaceEncodedMessage.setBounds(23, 27, 318, 26);
		frmDecode.getContentPane().add(lblPlaceEncodedMessage);
		
		JTextArea txtAnswer = new JTextArea();
		txtAnswer.setEditable(false);
		txtAnswer.setLineWrap(true);
		txtAnswer.setBounds(527, 64, 313, 241);
		JButton btnDecode = new JButton("Decode");
		JScrollPane scrollPane = new JScrollPane(txtAnswer);
		scrollPane.setBounds(527, 64, 313, 241);
		frmDecode.getContentPane().add(scrollPane);
		frmInstructions = new JFrame();
		
		try 
		{
		  frmInstructions.setIconImage(ImageIO.read(new File("images/decodeLock.png")));
		} 
		catch (IOException e1)
		{
			e1.printStackTrace();
		}
		frmInstructions.setResizable(false);
		frmInstructions.setTitle("Decode Text Instructions");
		frmInstructions.setBounds(100, 100, 600, 400);
		frmInstructions.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmInstructions.getContentPane().setLayout(null);
		
		/*JPanel rad2Panel = new JPanel();
		rad2Panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		rad2Panel.setBounds(364, 64, 134, 129); */ 
		JLabel lblInstructions = new JLabel("<html>How to tell the difference between ciphers?" +"<br /><br />"
				                           +"ROT13 is from A-Z and shifts 13 times. <br /> Example: unvy pnfrne"
				                           + "<br /><br />ROT47 includes everything on the english keyboard. <br /> " +
				                           "Example: %96 C@E`b 4:A96C H2D :?EC@5F465<br /><br />Caesar Cipher is A-Z and will " +
				                           "substitute the highest occurances of letters<br /> with the most popular letters " +
				                           "in english language<br /><br />Base64 is content transfer encoding.<br />Example:" +
				                           "QXV0aG9yOiBBbWFuZGEgU3phbXBpYXM=</html>");
		lblInstructions.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
		lblInstructions.setBounds(23, 27, 1200, 250);
		frmInstructions.getContentPane().add(lblInstructions);
		
		btnDecode.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				ROT ROTRotation = new ROT();
				String strDecipher;
		          
				if (radCaesarCipher.isSelected() == true)
				{
					CaesarCipher CS = new CaesarCipher();
					strDecipher = CS.findCipher(txtEncodedText.getText(), CS.Most(txtEncodedText.getText()), true);
					txtAnswer.setText(strDecipher);
				}
				if (radROT13.isSelected() == true)
				{
					strDecipher = ROTRotation.ROT13Move(txtEncodedText.getText());
					txtAnswer.setText(strDecipher);
				}
				
				if (radROT47.isSelected() == true)
				{
					strDecipher = ROTRotation.ROT47Move(txtEncodedText.getText());
					txtAnswer.setText(strDecipher);
				}
				
				if (radBase64.isSelected() == true)
				{
					Base64Decode b64Decode = new Base64Decode(txtEncodedText.getText());
					String strAnswer = b64Decode.DecodeText();
					txtAnswer.setText(strAnswer);
				}
	      }
		});
		btnDecode.setBounds(384, 204, 89, 23);
		frmDecode.getContentPane().add(btnDecode);
		
		JButton btnInstructions = new JButton("Instructions");
		
		btnInstructions.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				DecodeTextGUI window2 = new DecodeTextGUI();
				window2.frmInstructions.setVisible(true);
			}
		});
		btnInstructions.setBounds(765, 365, 116, 23);
		frmDecode.getContentPane().add(btnInstructions);
	}
}