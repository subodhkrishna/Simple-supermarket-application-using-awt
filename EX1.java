import java.awt.*;
import java.awt.even.*;

class EXP1 extends Frame implements ActionListener
{
	TextField t1,t2,t3;
	Button b;
	EX1()
	{
		Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
		setSize(d.width/2,d.height/2);
		setLocation(d.width/4,d.height/4);
		setLayout(new FlowLayout());
		setVisible(true);
		t1=new TextField(3);
		t2=new TextField(3);
		t3=new TextField(3);		
		b=new Button();	
		add(new Label("Enter 2 no.s"));
		add(t1);
		add(t2);
		add(b);
		b.addActionListener(this);
		add(t3);
		tc.setEditable(false);

	}
	public static void main(String a[])
	{
		new EX1();
	}
	public void actionPerformed(ActionEvent ee)
	{
		try
		{
			int x,y,z
			x=Integer.parseInt(t1.getText());
			y=Integer.parseInt(t2.getText());
			z=x/y;
			t3.setText(Integer.toString(z));
		}
		catch(ArithmeticEception ae)
		{
			//new MD("don't enter zeros");
		}
		catch()
		{
			
		}
	}
}