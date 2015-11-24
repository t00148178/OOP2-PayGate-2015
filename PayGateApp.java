import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.Container;
import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;




public class PayGateApp extends JFrame implements ActionListener {
	
	JMenuBar jMenuBar;
	JMenu fileMenu,accountMenu;
	JMenuItem quit,save,open,sendMoney,requestMoney;
	Container cp;

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
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	public void actionPerformed(ActionEvent e) {
		
		
	}
	
	private void fileMenu() {	
		fileMenu = new JMenu("File");
		
		quit = new JMenuItem("Quit");
		open = new JMenuItem("Open");
		save = new JMenuItem("save");
		
		fileMenu.add(open);
		fileMenu.add(save);
		fileMenu.add(quit);				
	}
	
	private void accountMenu() {		
		accountMenu = new JMenu("Account");
		
		sendMoney = new JMenuItem("Send Money");
		requestMoney = new JMenuItem("Send Money");
		
		accountMenu.add(sendMoney);
		accountMenu.add(requestMoney);		
	}
}
