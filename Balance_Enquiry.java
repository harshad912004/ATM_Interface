package atm_interface1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Balance_Enquiry extends JFrame implements ActionListener
{
    JLabel l1, l2;
    JButton b1;
    String scardno, spin;
    Balance_Enquiry(String scardno, String spin)
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

        b1 = new JButton("Back");
        b1.setBounds(750, 440, 200, 30);
	b1.setBackground(Color.BLACK);
	b1.setForeground(Color.WHITE);
	b1.addActionListener(this);
	l1.add(b1);
        
        Connectivity c = new Connectivity();
        int balance = 0;
        try
        {
            String cardno = scardno;
            String pin = spin;
            ResultSet rs = c.s.executeQuery("select * from transactions where Card_Number = '"+cardno+"' and Pin_Number = '"+pin+"'");
            while(rs.next())
            {
                if(rs.getString("Amount_Type").equals("Deposit"))
                {
                    balance += Integer.parseInt(rs.getString("Amount"));
                }
                else
                {
                    balance -= Integer.parseInt(rs.getString("Amount"));
                }
            }
            l2 = new JLabel("YOUR CURRENT BALANCE IS : "+balance);
            l2.setBounds(450, 300, 600, 70);
            l2.setFont(new Font("Osward", Font.BOLD, 17));
            l2.setBackground(Color.WHITE);
            l2.setForeground(Color.RED);
            l1.add(l2);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public void actionPerformed(ActionEvent ae)
    {
    	if(ae.getSource() == b1)
	{
            setVisible(false);
            new Transactions(scardno, spin).setVisible(true);
	}
    }
    public static void main(String args[]) throws Exception
    {
	new Balance_Enquiry("","");
    }
}