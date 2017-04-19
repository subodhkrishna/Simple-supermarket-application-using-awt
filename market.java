import java.awt.*;
import java.awt.event.*;

class Market extends Dialog implements ItemListener,ActionListener
{
	
	Choice ch,qty;
	List pro,pri,spro,spri,sqty,tot;
	TextField gtot;	
	Panel lst,sls;
	GridBagConstraints gc,gc1;
	Button rmv,ext;
	Market()
	{
		super(new Frame(),"",true);
		Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
		setSize(d);
		setLocation(10,500);
		gc=new GridBagConstraints();
		gc1=new GridBagConstraints();
		setLayout(new GridBagLayout());	

		ch=new Choice();
		ch.add("soaps");
		ch.add("pastes");
		ch.addItemListener(this);

		qty=new Choice();
		for(int i=1;i<21;i++)
			qty.add(Integer.toString(i));
		qty.setEnabled(false);
	
		pro=new List();
		pri=new List();
		pri.setEnabled(false);
		
		
		spro=new List();
		spri=new List();
		spri.setEnabled(false);
		sqty=new List();
		sqty.setEnabled(false);
		tot=new List();
		tot.setEnabled(false);

		
		gtot=new TextField();
		gtot.setEnabled(false);
		rmv=new Button("Remove");
		ext=new Button("Exit");

		lst=new Panel();
		lst.setBackground(Color.red);
		lst.setLayout(new GridBagLayout());
		addPan(lst,1,1,1,1);
		addComp(lst,new Label("Items List"),1,1,1,1);
		addComp(lst,new Label("Items"),2,1,1,1);
		addComp(lst,ch,2,2,1,1);
		addComp(lst,new Label("Products"),2,3,1,1);
		addComp(lst,pro,2,4,1,1);
		pro.addItemListener(this);
		addComp(lst,new Label("Price"),2,5,1,1);
		addComp(lst,pri,2,6,1,1);
		addComp(lst,new Label("Quantity"),2,7,1,1);
		addComp(lst,qty,2,8,1,1);
		qty.addItemListener(this);
				
		addPan(new Label("   "),2,1,1,1);
	
		sls=new Panel();
		sls.setBackground(Color.blue);	
		sls.setLayout(new GridBagLayout());	
		addPan(sls,3,1,1,1);
		addComp(sls,new Label("selected Items"),1,1,1,1);
		addComp(sls,new Label("product"),2,1,1,1);
		addComp(sls,spro,2,2,1,1);
		spro.addItemListener(this);
		addComp(sls,new Label("price"),2,3,1,1);
		addComp(sls,spri,2,4,1,1);
		addComp(sls,new Label("quantity"),2,5,1,1);
		addComp(sls,sqty,2,6,1,1);
		addComp(sls,new Label("total"),2,7,1,1);
		addComp(sls,tot,2,8,1,1);		
		addComp(sls,new Label(""),3,7,1,1);
		addComp(sls,new Label("Grand Total"),4,7,1,1);
		addComp(sls,gtot,4,8,1,1);
		addComp(sls,rmv,5,2,1,1);
		rmv.addActionListener(this);	
		addComp(sls,ext,5,6,1,1);
		ext.addActionListener(this);	
		setVisible(true);
	}



	public static void main(String a[])
	{
		new Market();
	}



	public void addComp(Container con,Component cc,int r,int c,int w,int h)
	{
		gc.gridx=c;
		gc.gridy=r;
		gc.gridwidth=w;
		gc.gridheight=h;
		gc.fill=gc.BOTH;
		con.add(cc,gc);
	}



	public void addPan(Panel p,int r,int c,int w,int h)
	{
		gc.gridx=c;
		gc.gridy=r;
		gc.gridwidth=w;
		gc.gridheight=h;
		gc.fill=gc.BOTH;
		add(p,gc);
	}


	public void itemStateChanged(ItemEvent ee)
	{
		if(ee.getSource()==ch)
		{
			pro.removeAll();
			pri.removeAll();
			if(ch.getSelectedItem().equals("soaps"))
			{
				
				pro.add("Hammam");pri.add("15");
				pro.add("Cinthol");pri.add("20");
				pro.add("Santoor");pri.add("20");
				pro.add("Lifebuoy");pri.add("25");
				pro.add("Dove");pri.add("30");
				setVisible(true);				
			}
			if(ch.getSelectedIndex()==1)
			{
				
				pro.add("Close Up");pri.add("40");
				pro.add("Colgate");pri.add("40");
				pro.add("Dabur Red");pri.add("30");
				pro.add("Pepsodent");pri.add("30");
				pro.add("Sensodyne");pri.add("50");		
				setVisible(true);
			}
		}
		if(ee.getSource()==pro)
		{
			qty.setEnabled(true);
			pri.select(pro.getSelectedIndex());
		}	
		if(ee.getSource()==qty)
		{
			
			spro.add(pro.getSelectedItem());
			spri.add(pri.getSelectedItem());
			sqty.add(qty.getSelectedItem());
			int x,y,z;	
			x=Integer.parseInt(pri.getSelectedItem());
			y=Integer.parseInt(qty.getSelectedItem());
			z=x*y;
			tot.add(Integer.toString(z));
			int gt=0;
			for(int j=0;j<tot.getItemCount();j++)
				gt+=Integer.parseInt(tot.getItem(j));
				
			gtot.setText(Integer.toString(gt));
			qty.setEnabled(false);		
		}
		if(ee.getSource()==spro)
		{
			rmv.setEnabled(true);
			spri.select(spro.getSelectedIndex());
			sqty.select(spro.getSelectedIndex());
			tot.select(spro.getSelectedIndex());
		}
	
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==rmv)
		{
			spri.remove(spro.getSelectedIndex());
			sqty.remove(spro.getSelectedIndex());
			tot.remove(spro.getSelectedIndex());
			spro.remove(spro.getSelectedIndex());
			int gt=0;
			for(int j=0;j<tot.getItemCount();j++)
				gt+=Integer.parseInt(tot.getItem(j));
				
			gtot.setText(Integer.toString(gt));
			rmv.setEnabled(false);
		}
		if(ae.getSource()==ext)
			System.exit(0);
	}

}