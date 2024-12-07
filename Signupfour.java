package atm_interface1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Signupfour extends JFrame implements ActionListener
{
    JLabel l1, l2 ,l3, l4, l5, l6;
    JComboBox cb1, cb2, cb3;
    JButton b1 ;
    String formno;
    Signupfour(String formno)
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
        
        
        l4 = new JLabel("Income :");
        l4.setFont(new Font("Osward", Font.BOLD, 15));
        l4.setForeground(Color.BLUE);
        l4.setBounds(380, 340, 120, 40);
        l1.add(l4);
        String s1[] = {"NULL", "<1,50,000", "<2,50,000", "<5,00,000", "Up to 10,00,000"};
        cb1 = new JComboBox(s1);
        cb1.setBackground(Color.WHITE);
        cb1.setBounds(380, 375, 180, 30);
        l1.add(cb1);
        
        
        l5 = new JLabel("Qualification :");
        l5.setFont(new Font("Osward", Font.BOLD, 15));
        l5.setForeground(Color.BLUE);
        l5.setBounds(380, 410, 120, 40);
        l1.add(l5);
        String s2[] = {"Non-Graduation", "Graduate", "Post-Graduation", "Doctrate", "Other"};
        cb2 = new JComboBox(s2);
        cb2.setBackground(Color.WHITE);
        cb2.setBounds(380, 445, 180, 30);
        l1.add(cb2);
        
        
        l6 = new JLabel("Occupation :");
        l6.setFont(new Font("Osward", Font.BOLD, 15));
        l6.setForeground(Color.BLUE);
        l6.setBounds(600, 340, 120, 40);
        l1.add(l6);
        String s3[] = {"Salaried", "Self-Employeed", "Business", "Student", "Other"};
        cb3 = new JComboBox(s3);
        cb3.setBackground(Color.WHITE);
        cb3.setBounds(600, 375, 180, 30);
        l1.add(cb3);
        
        
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
            String sincome = (String) cb1.getSelectedItem();
            String squalification = (String) cb2.getSelectedItem();
            String soccupation = (String) cb3.getSelectedItem();
            try
            {
                if(sincome.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Please select the income");
                }
                else if(squalification.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Please select the qualification");
                }
                else if(soccupation.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Please select the occupation");
                }
                else
                {
                    Connectivity c = new Connectivity();
                    String query = "insert into signupfour values('"+sformno+"', '"+sincome+"', '"+squalification+"', '"+soccupation+"')";
                    c.s.executeUpdate(query);

                    setVisible(false);
                    new Signupfive(sformno).setVisible(true);
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
        new Signupfour("");
    }
}