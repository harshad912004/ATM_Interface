package atm_interface1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
public class Signupone extends JFrame implements ActionListener
{
    JLabel l1, l2 ,l3, l4, l5, l6;
    JTextField t1;
    JComboBox cb1;
    JDateChooser d1;
    JButton b1 ;    
    long rand;
    Signupone()
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

        Random ran = new Random();
        rand = Math.abs((ran.nextLong() % 9000L) + 1000L);
        
        l2 = new JLabel("APPLICATION FORM NO. " +rand);
        l2.setFont(new Font("Osward", Font.BOLD, 20));
        l2.setForeground(Color.RED);
        l2.setBounds(500, 255, 300, 100);
        l1.add(l2);
        l3 = new JLabel("Page 1: Personal Details");
        l3.setFont(new Font("Osward", Font.BOLD, 17));
        l3.setForeground(Color.RED);
        l3.setBounds(540, 290, 200, 80);
        l1.add(l3);
        
        
        l4 = new JLabel("Name :");
        l4.setFont(new Font("Osward", Font.BOLD, 15));
        l4.setForeground(Color.BLUE);
        l4.setBounds(380, 340, 60, 40);
        l1.add(l4);
        t1 = new JTextField();
        t1.setBounds(380, 375, 180, 30);
        t1.setBackground(Color.WHITE);
        l1.add(t1);
        
        
        l5 = new JLabel("Date Of Birth :");
        l5.setFont(new Font("Osward", Font.BOLD, 15));
        l5.setForeground(Color.BLUE);
        l5.setBounds(380, 410, 105, 40);
        l1.add(l5);
        d1 = new JDateChooser();
        d1.setForeground(new Color(105, 105, 105));
        d1.setBackground(Color.WHITE);
        d1.setBounds(380, 445, 180, 30);
        l1.add(d1);
        
        
        l6 = new JLabel("Gender :");
        l6.setFont(new Font("Osward", Font.BOLD, 15));
        l6.setForeground(Color.BLUE);
        l6.setBounds(600, 340, 70, 40);
        l1.add(l6);
        String s1[] = {"Male", "Female", "Other"};
        cb1 = new JComboBox(s1);
        cb1.setBackground(Color.WHITE);
        cb1.setBounds(600, 375, 180, 30);
        l1.add(cb1);
        
        
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
            String sformno = "" + rand;
            String sname = t1.getText();
            String sdob = ((JTextField) d1.getDateEditor().getUiComponent()).getText();
            String sgender = (String) cb1.getSelectedItem();
            try
            {
                if(sname.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Please enter the name");
                }
                else if(sdob.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Please enter the date of birth");
                }
                else if(sgender.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Please enter the gender");
                }
                else
                {
                    Connectivity c = new Connectivity();
                    String query = "insert into signupone values('"+sformno+"', '"+sname+"', '"+sdob+"', '"+sgender+"')";
                    c.s.executeUpdate(query);

                    setVisible(false);
                    new Signuptwo(sformno).setVisible(true);
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
        new Signupone();
    }
}