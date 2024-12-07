package atm_interface1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener
{
    JLabel l1, l2, l3, l4, l5;
    JButton b1, b2, b3, b4;
    JTextField t1;
    JPasswordField t2;
    Login()
    {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("AUTOMATED TELLER MACHINE SYSTEM");
        setLayout(null);
        setSize(1450, 700);        
        setLocation(50, 50);
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm_interface1/atm.jpg"));
	Image i2 = i1.getImage().getScaledInstance(1540, 800, Image.SCALE_DEFAULT);
	ImageIcon i3 = new ImageIcon(i2);
	l1 = new JLabel(i3);
	l1.setBounds(0, 0, 1540, 800);
	add(l1);
        
        l2 = new JLabel("WELCOME TO THE ATM SYSTEM");
	l2.setBounds(490, 255, 370, 100);
        l2.setFont(new Font("Osward", Font.BOLD, 20));
	l2.setBackground(Color.WHITE);
	l2.setForeground(Color.RED);
	l1.add(l2);
        l3 = new JLabel("Card Number : ");
	l3.setBounds(380, 330, 200, 50);
        l3.setFont(new Font("Osward", Font.BOLD, 15));
	l3.setBackground(Color.WHITE);
	l3.setForeground(Color.BLUE);
	l1.add(l3);
        l4 = new JLabel("Pin Number : ");
	l4.setBounds(380, 370, 200, 50);
        l4.setFont(new Font("Osward", Font.BOLD, 15));
	l4.setBackground(Color.WHITE);
	l4.setForeground(Color.BLUE);
	l1.add(l4);
        
        t1 =  new JTextField();        
        t1.setBounds(500, 342, 300, 30);
        l1.add(t1);
        t2 =  new JPasswordField();
        t2.setBounds(500, 382, 300, 30);        		
        l1.add(t2);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("atm_interface1/logo.jpg"));
        Image i5 = i4.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        l5 = new JLabel(i6);
        l5.setBounds(600, 100, 120, 150);
        l1.add(l5);
        
        b1 = new JButton("Sign In");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        b1.setBounds(380, 420, 75, 30);
        l1.add(b1);
        b2 = new JButton("Clear");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        l1.add(b2);
        b2.setBounds(380, 455, 75, 30);
        b3 = new JButton("Sign Up");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.addActionListener(this);
        b3.setBounds(500, 420, 80, 30);
        l1.add(b3);
        b4 = new JButton("Cancel");
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        b4.addActionListener(this);
        b4.setBounds(500, 455, 80, 30);
        l1.add(b4);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == b1)
        {
            String scardno = t1.getText();
            String spinno = t2.getText();
            Connectivity c = new Connectivity();
            String query = "select * from signupfive where Card_Number = '" +scardno+ "' and Pin_Number = '" +spinno+"'";
            try
            {
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next())
                {
                    setVisible(false);
                    new Transactions(scardno, spinno).setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Incorrect Cardnumber and Pin");
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(ae.getSource() == b2)
        {
            t1.setText("");
            t2.setText("");
        }
        else if(ae.getSource() == b3)
        {
            setVisible(false);
            new Signupone().setVisible(true);
        }
        else if(ae.getSource() == b4)
        {
            System.exit(0);
        }
    }
    public static void main(String args[])
    {
        new Login();
    }    
}