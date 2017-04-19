import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Home extends JFrame implements ActionListener
{
	JMenuBar mb;	
	JMenu m1;
	JMenuItem lin,lot,ext;	
	Home()
	{
		Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
		setSize(d.width,d.height);
		mb=new JMenuBar();
		setJMenuBar(mb);
		m1=new JMenu("Shop");
		lin=new JMenuItem("Login");				
		lot=new JMenuItem("Logout");
		ext=new JMenuItem("Exit");
		mb.add(m1);
		m1.add(lin);	
		m1.add(lot);
		lin.addActionListener(this);
		m1.add(ext);
		ext.addActionListener(this);
		setVisible(true);
	
	}	
	public static void main(String a[])
	{
		new Home();
	}
	public void actionPerformed(ActionEvent ee)
	{
		
		if(ee.getSource()==lin)
		{
			new Lin();
		}
		if(ee.getSource()==ext)
		{		
			System.exit(0);
		}

	}
}