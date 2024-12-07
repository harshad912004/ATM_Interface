package atm_interface1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
public class Withdraw extends JFrame implements ActionListener
{
    JLabel l1, Withdraw;
    JButton b1, b2;
    JTextField t1;
    String scardno, spin;
    Withdraw(String scardno, String spin)
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

        Withdraw = new JLabel("ENTER THE AMOUNT YOU WANT TO WITHDRAW:");
    	Withdraw.setBounds(490, 270, 600, 70);
        Withdraw.setFont(new Font("Osward", Font.BOLD, 17));
    	Withdraw.setBackground(Color.WHITE);
    	Withdraw.setForeground(Color.RED);
    	l1.add(Withdraw);

        t1 = new JTextField();
        t1.setBounds(430, 320, 500, 40);
        l1.add(t1);

        b1 = new JButton("Withdraw");
        b1.setBackground(Color.BLACK);
        b1.setBounds(750, 400, 200, 30);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        l1.add(b1);
        b2 = new JButton("Back");
        b2.setBounds(750, 440, 200, 30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        l1.add(b2);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == b1)
	{
            String wamount = t1.getText();
            String cardno = scardno;
            String pin = spin;
            String type = "Withdraw";
            Date date = new Date();
            if(wamount.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");
            }
            else
            {
                try
                {
                    Connectivity c = new Connectivity();
                    String query = "insert into transactions values('"+cardno+"','"+pin+"', '"+type+"', '"+wamount+"', '"+date+"')";
                    c.s.executeUpdate(query);
                    
                    JOptionPane.showMessageDialog(null, "Rs "+wamount+" withdraw Successfully");
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
            }
	}
        else if(ae.getSource() == b2)
	{
            setVisible(false);
            new Transactions(scardno, spin).setVisible(true);
	}
    }
    public static void main(String args[])
    {
    	new Withdraw("","");
    }
}