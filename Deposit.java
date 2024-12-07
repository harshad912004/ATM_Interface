package atm_interface1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
public class Deposit extends JFrame implements ActionListener
{
    JLabel l1, Deposit;
    JButton b1, b2;
    JTextField t1;
    String scardno, spin;
    Deposit(String scardno, String spin)
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

        Deposit = new JLabel("ENTER THE AMOUNT YOU WANT TO DEPOSIT:");
    	Deposit.setBounds(520, 270, 600, 70);
        Deposit.setFont(new Font("Osward", Font.BOLD, 17));
    	Deposit.setBackground(Color.WHITE);
    	Deposit.setForeground(Color.RED);
    	l1.add(Deposit);

        t1 = new JTextField();
        t1.setBounds(430, 320, 500, 40);
        l1.add(t1);

        b1 = new JButton("Deposit");
        b1.setBounds(750, 400, 200, 30);
        b1.setBackground(Color.BLACK);
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
            String damount = t1.getText();
            if(damount.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
            }
            else
            {
                String cardno = scardno;
                String pin = spin;
                String type = "Deposit";
                Date date = new Date();
                try
                {
                    Connectivity c = new Connectivity();
                    String query = "insert into transactions values('"+cardno+"','"+pin+"', '"+type+"', '"+damount+"', '"+date+"')";
                    c.s.executeUpdate(query);

                    JOptionPane.showMessageDialog(null, "Rs "+damount+" Deposited Successfully");
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
            }
        }
        if(ae.getSource() == b2)
	{
            setVisible(false);
            new Transactions(scardno, spin).setVisible(true);
        }
    }
    public static void main(String args[])
    {
    	new Deposit("","");
    }
}