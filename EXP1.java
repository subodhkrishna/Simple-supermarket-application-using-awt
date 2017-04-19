import java.awt.*;
import java.awt.event.*;

class EXP1 extends Frame implements ActionListener
{
	TextField t1,t2,t3;
	Button b;
	EXP1()
	{
		Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
		setSize(d.width/2,d.height/2);
		setLocation(d.width/4,d.height/4);
		setLayout(new FlowLayout());
		t1=new TextField(3);
		t2=new TextField(3);
		t3=new TextField(3);		
		b=new Button("DIV");	
		add(new Label("Enter 2 no.s"));
		add(t1);
		add(t2);
		add(b);
		b.addActionListener(this);
		add(t3);
		t3.setEditable(false);
		setVisible(true);

	}
	public static void main(String a[])
	{
		new EXP1();
	}
	public void actionPerformed(ActionEvent ee)
	{
		try
		{
			int x,y,z;
			x=Integer.parseInt(t1.getText());
			y=Integer.parseInt(t2.getText());
			z=x/y;
			t3.setText(Integer.toString(z));
			
		}
		catch(ArithmeticException ae)
		{
			new MD("don't enter zeros");
		}
		catch(NumberFormatException ne)
		{
			new MD("don't enter letters");

		}
	}
}