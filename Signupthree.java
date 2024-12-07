package atm_interface1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Signupthree extends JFrame implements ActionListener
{
    JLabel l1, l2 ,l3, l4, l5, l6, l7;
    JTextField t1, t2, t3, t4;
    JButton b1 ;
    String formno;
    Signupthree(String formno)
    {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Account Application Form");
        setLayout(null);
	setSize(1450, 700);
    	setVisible(true);
	setLocation(50, 50);
	getContentPane().setBackground(Color.WHITE);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm_interface1/atm.jpg"));
	Image i2 = i1.getImage().getScaledInstance(1540, 800, Image.SCALE_DEFAULT);
	ImageIcon i3 = new ImageIcon(i2);
	l1 = new JLabel(i3);
	l1.setBounds(0, 0, 1540, 800);
	add(l1);

        this.formno = formno;
        
        l2 = new JLabel("APPLICATION FORM NO. " +formno);
        l2.setFont(new Font("Osward", Font.BOLD, 20));
        l2.setForeground(Color.RED);
        l2.setBounds(500, 255, 300, 100);
        l1.add(l2);
        l3 = new JLabel("Page 1: Personal Details");
        l3.setFont(new Font("Osward", Font.BOLD, 17));
        l3.setForeground(Color.RED);
        l3.setBounds(540, 290, 200, 80);
        l1.add(l3);
        
        
        l4 = new JLabel("Address :");
        l4.setFont(new Font("Osward", Font.BOLD, 15));
        l4.setForeground(Color.BLUE);
        l4.setBounds(380, 340, 120, 40);
        l1.add(l4);
        t1 = new JTextField();
        t1.setBounds(380, 375, 180, 30);
        t1.setBackground(Color.WHITE);
        l1.add(t1);
        
        
        l5 = new JLabel("City :");
        l5.setFont(new Font("Osward", Font.BOLD, 15));
        l5.setForeground(Color.BLUE);
        l5.setBounds(380, 410, 120, 40);
        l1.add(l5);
        t2 = new JTextField();
        t2.setBounds(380, 445, 180, 30);
        t2.setBackground(Color.WHITE);
        l1.add(t2);
        
        
        l6 = new JLabel("State :");
        l6.setFont(new Font("Osward", Font.BOLD, 15));
        l6.setForeground(Color.BLUE);
        l6.setBounds(600, 340, 120, 40);
        l1.add(l6);
        t3 = new JTextField();
        t3.setBounds(600, 375, 180, 30);
        t3.setBackground(Color.WHITE);
        l1.add(t3);
        
        l7 = new JLabel("Pin Code :");
        l7.setFont(new Font("Osward", Font.BOLD, 15));
        l7.setForeground(Color.BLUE);
        l7.setBounds(600, 410,110, 40);
        l1.add(l7);
        t4 = new JTextField();
        t4.setBounds(600, 445, 180, 30);
        t4.setBackground(Color.WHITE);
        l1.add(t4);
        
        
        b1 = new JButton("Next");
        b1.setBackground(Color.BLACK);
	b1.setForeground(Color.WHITE);
        b1.setBounds(830, 450, 100, 30);
        b1.addActionListener(this);
        l1.add(b1);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == b1)
        {
            String sformno = formno;
            String saddress = t1.getText();
            String scity = t2.getText();
            String sstate = t3.getText();
            String spin = t4.getText();
            try
            {
                if(saddress.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Please enter the address");
                }
                else if(scity.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Please enter the city name");
                }
                else if(sstate.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Please enter the state name");
                }
                else if(spin.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Please enter the pin code of city");
                }
                else
                {
                    Connectivity c = new Connectivity();
                    String query = "insert into signupthree values('"+sformno+"','"+saddress+"', '"+scity+"', '"+sstate+"', '"+spin+"')";
                    c.s.executeUpdate(query);

                    setVisible(false);
                    new Signupfour(sformno).setVisible(true);
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
    }
    public static void main(String args[])
    {
        new Signupthree("");
    }
}