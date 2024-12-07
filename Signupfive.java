package atm_interface1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Signupfive extends JFrame implements ActionListener
{
    JLabel l1, l2 ,l3, l4, l5;
    JComboBox cb1;
    JCheckBox c1, c2, c3, c4, c5;
    JButton b1 ;
    String formno;
    Signupfive(String formno)
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
        
        
        l4 = new JLabel("Account Type :");
        l4.setFont(new Font("Osward", Font.BOLD, 15));
        l4.setForeground(Color.BLUE);
        l4.setBounds(380, 340, 120, 40);
        l1.add(l4);
        String s1[] = {"Saving Account", "Fixed Deposit Account", "Current Account", "Recurring Deposit Account"};
        cb1 = new JComboBox(s1);
        cb1.setBackground(Color.WHITE);
        cb1.setBounds(380, 375, 180, 30);
        l1.add(cb1);
        
        
        l5 = new JLabel("Services Required :");
        l5.setFont(new Font("Osward", Font.BOLD, 15));
        l5.setForeground(Color.BLUE);
        l5.setBounds(600, 340, 150, 40);
        l1.add(l5);
        c1 = new JCheckBox("ATM Card");
        c1.setBounds(600, 375, 115, 30);
        l1.add(c1);
        c2 = new JCheckBox("Mobile Banking");
        c2.setBounds(600, 415, 115, 30);
        l1.add(c2);
        c3 = new JCheckBox("EMAIL & SMS Alerts");
        c3.setBounds(750, 375, 140, 30);
        l1.add(c3);
        c4 = new JCheckBox("Cheque Book");
        c4.setBounds(750, 415, 140, 30);
        l1.add(c4);
        c5 = new JCheckBox("I herby declares that the above entered details are correct to the best of my knowledge.");
        c5.setFont(new Font("Osward", Font.BOLD, 8));
        c5.setBounds(380, 450, 400, 30);
        l1.add(c5);
        
        
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
            Random ran = new Random();
            String scardno = "" + Math.abs((ran.nextLong() % 90000000L + 5040936000000000L));
            String spinno = "" + Math.abs((ran.nextLong() % 9000L) + 1000L);
            String saccounttype = (String) cb1.getSelectedItem();
            String sservices = "";
            if(c1.isSelected())
            {
                sservices = sservices + " ATM Card";
            }
            else if(c2.isSelected())
            {
                sservices = sservices + " Mobile Banking";
            }
            else if(c3.isSelected())
            {
                sservices = sservices + " EMAIL & SMS Alerts";
            }
            else if(c4.isSelected())
            {
                sservices = sservices + " Cheque Book";
            }
            try
            {
                if(saccounttype.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Account Type Is Required");
                }
                else if(sservices.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Please select the services you want");
                }
                else
                {
                    Connectivity c = new Connectivity();
                    String query = "insert into signupfive values('"+sformno+"', '"+saccounttype+"', '"+sservices+"', '"+scardno+"', '"+spinno+"')";
                    c.s.executeUpdate(query);

                    JOptionPane.showMessageDialog(null,"Card number = "+scardno +"\nPin = "+spinno);

                    setVisible(false);
                    new Login().setVisible(true);
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
        new Signupfive("");
    }
}