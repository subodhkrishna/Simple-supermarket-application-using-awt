import java.awt.*;
import java.awt.event.*;

class MD extends Dialog implements ActionListener
{	
	Button b1;
	MD(String s)
	{
		super(new Frame(),"",true);
		setSize(300,200);
		setLocation(500,400);
		setLayout(new FlowLayout());
		add(new Label(s));
		b1=new Button("OK");
		add(b1);
		b1.addActionListener(this);
		setVisible(true);
		
	}
	public void actionPerformed(ActionEvent ab)
	{
		dispose();
	}

}
