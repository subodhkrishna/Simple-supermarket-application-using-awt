import java.awt.*;
import java.awt.event.*;


class Lin extends Dialog implements ActionListener
{

	GridBagConstraints gc;
	TextField t1,t2;
	Button b1,b2;
	Lin()
	{

		super(new Frame(),"login",true);
		Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
		setSize(d.width/2,d.height/2);
		setLocation(d.width/4,d.height/4);
		setLayout(new GridBagLayout());
		t1=new TextField(10);	
		t2=new TextField(10);
		t2.setEchoChar('*');
		b1=new Button("Submit");
		b2=new Button("Closed");
		gc=new GridBagConstraints();
		addComp(new Label("Username"),1,1,1,1);
		addComp(t1,1,2,1,1);
		addComp(new Label("Password"),2,1,1,1);
		addComp(t2,2,2,1,1);
		addComp(b1,3,1,1,1);
		b1.addActionListener(this);
		addComp(b2,3,2,1,1);		
		b2.addActionListener(this);
		setVisible(true);		
	}
	public void addComp(Component cc,int r,int c,int w ,int h)
	{
		gc.gridx=c;
		gc.gridy=r;
		gc.gridwidth=w;
		gc.gridheight=h;
		gc.fill=gc.BOTH;
		add(cc,gc);
	}	
	public void actionPerformed(ActionEvent ee)
	{
		if(ee.getSource()==b1)
		{
			if(t1.getText().equals("admin") && t2.getText().equals("subodh"))
			{
				
				new MM();
				dispose();
				
				
			}
			else
			{
				t1.setText("");
				t2.setText("");
				t1.requestFocus();
				addComp(new Label("wrong username or password"),4,1,1,1);
				setVisible(true);
			}
		}

		if(ee.getSource()==b2)
			dispose();
	}
}