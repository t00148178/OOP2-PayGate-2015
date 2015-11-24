import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;




public class PayGateApp extends JFrame implements ActionListener {
	
	private JMenuBar jMenuBar;
	private JMenu fileMenu,accountMenu;
	private JMenuItem quit,save,open,sendMoney,requestMoney;
	
	private JLabel initMessage; 
	
	private Container cp;
	
	

	public static void main(String[] args)  {
		
		PayGateApp app = new PayGateApp();
		app.setVisible(true);
		
	}
	
	public PayGateApp() {		
		super("PayGate");
		setSize(450,550);
		setResizable(false);
		setLocation(600,300);
		
		cp = getContentPane();
		cp.setLayout(new FlowLayout());
		
		fileMenu();
		accountMenu();
		
		jMenuBar = new JMenuBar();
		setJMenuBar(jMenuBar);
		
		jMenuBar.add(fileMenu);
		jMenuBar.add(accountMenu);
		
		initScreen();
		
		
		cp.add(initMessage);
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	private void initScreen() {
		
		//if account < 0 then display
		
		initMessage = new JLabel("Your account is empty" +
								"Deposit money or " + 
								"request Money");
		
		
		// else display account summary
		
	}

	private void open() {
		
	}
	
	private void save() {
		
	}
	
	private void depositMoney() {
		
	}	
	
	private void requestMoney() {
		
	}	
	
	private void sendMoney() {
		
	}
	

	

	

	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("Quit")) {
			JOptionPane.showMessageDialog(null, "System exits");
			System.exit(0);
		} else if(e.getActionCommand().equals("Open")) {
			
		} else if(e.getActionCommand().equals("Save")) {
			
		} else if(e.getActionCommand().equals("Send Money")) {
			
		} else if(e.getActionCommand().equals("Request Money")) {
			
		} else if(e.getActionCommand().equals("Send Money")) {
			
		} else {
			JOptionPane.showMessageDialog(null, "start by selecting menu");
		}
		
	}
	
	private void fileMenu() {	
		fileMenu = new JMenu("File");
		
		quit = new JMenuItem("Quit");
		quit.addActionListener(this);
		open = new JMenuItem("Open");
		open.addActionListener(this);
		save = new JMenuItem("save");
		save.addActionListener(this);
		
		fileMenu.add(open);
		fileMenu.add(save);
		fileMenu.add(quit);				
	}
	
	private void accountMenu() {		
		accountMenu = new JMenu("Account");
		
		sendMoney = new JMenuItem("Send Money");
		sendMoney.addActionListener(this);
		requestMoney = new JMenuItem("Request Money");
		requestMoney.addActionListener(this);
		
		accountMenu.add(sendMoney);
		accountMenu.add(requestMoney);		
	}
}
