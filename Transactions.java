package atm_interface1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Transactions extends JFrame implements ActionListener
{
    JLabel l1, l2;
    JButton b1, b2, b3, b4, b5;
    String scardno, spin;
    
    Transactions(String scardno, String spin)
    {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	setLayout(null);
	setSize(1450, 700);
	setVisible(true);
	setLocation(50, 50);
	getContentPane().setBackground(Color.WHITE);

        this.scardno = scardno;
        this.spin = spin;
        
        
	ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm_interface1/atm.jpg"));
	Image i2 = i1.getImage().getScaledInstance(1600, 800, Image.SCALE_DEFAULT);
	ImageIcon i3 = new ImageIcon(i2);
	l1 = new JLabel(i3);
	l1.setBounds(0, 0, 1600, 800);
	add(l1);

        
        l2 = new JLabel("PLEASE ENTER YOUR TRANSACTION");
	l2.setBounds(490, 255, 370, 100);
        l2.setFont(new Font("Osward", Font.BOLD, 20));
	l2.setBackground(Color.WHITE);
	l2.setForeground(Color.RED);
	l1.add(l2);

        b1 = new JButton("Deposit");
        b1.setBounds(400, 330, 200, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        l1.add(b1);
        b2 = new JButton("Withdraw");
        b2.setBounds(750, 330, 200, 30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        l1.add(b2);
        b3 = new JButton("Balance Enquiry");
        b3.setBounds(400, 370, 200, 30);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.addActionListener(this);
        l1.add(b3);
        b4 = new JButton("PIN Change");
        b4.setBounds(750, 370, 200, 30);
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        b4.addActionListener(this);
        l1.add(b4);
        b5 = new JButton("Exit");
	b5.setBounds(750, 410, 200, 30);
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.WHITE);
        b5.addActionListener(this);
	l1.add(b5);
    }
    public void actionPerformed(ActionEvent ae)
    {
        String cardno = scardno;
        String pin = spin;
	if(ae.getSource() == b1)
	{
            setVisible(false);
            new Deposit(scardno, spin).setVisible(true);
	}
	else if(ae.getSource() == b2)
	{
            setVisible(false);
            new Withdraw(scardno, spin).setVisible(true);
	}
        else if(ae.getSource() == b3)
	{
            setVisible(false);
            new Balance_Enquiry(scardno, spin).setVisible(true);
	}
	else if(ae.getSource() == b4)
	{
            setVisible(false);
            new Pin_Change(scardno, spin).setVisible(true);
	}
        else if(ae.getSource() == b5)
	{
           System.exit(0);
	}
    }
    public static void main(String args[])
    {
	new Transactions("","");
    }
}