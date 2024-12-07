package atm_interface1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Pin_Change extends JFrame implements ActionListener
{
    JLabel l1, l2, l3, l4;
    JButton b1, b2;
    JPasswordField t1, t2;
    String scardno, spin;
    Pin_Change(String scardno, String spin)
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

        l2 = new JLabel("CHANGE YOUR PIN");
        l2.setFont(new Font("Osward", Font.BOLD, 17));
        l2.setBounds(600, 260, 500, 90);
        l2.setBackground(Color.WHITE);
        l2.setForeground(Color.RED);
        l1.add(l2);
        l3 = new JLabel("Set New Pin:");
        l3.setBounds(450, 300, 500, 70);
        l3.setBackground(Color.WHITE);
        l3.setForeground(Color.BLACK);
        l1.add(l3);
        l4 = new JLabel("Re-Enter New Pin:");
        l4.setBounds(450, 340, 500, 70);
        l4.setBackground(Color.WHITE);
        l4.setForeground(Color.BLACK);
        l1.add(l4);

        t1 = new JPasswordField();
        t2 = new JPasswordField();
        t1.setBounds(600, 320, 350, 30);
        t2.setBounds(600, 360, 350, 30);
        l1.add(t1);
        l1.add(t2);

        b1 = new JButton("Change");
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
        if(ae.getSource() == b2)
	{
            setVisible(false);
            new Transactions(scardno, spin).setVisible(true);
	}
        else if(ae.getSource() == b1)
	{
            try
            {
                String cardno = scardno;
                String pinno = spin;
                String pin = t1.getText();
                String npin = t2.getText();
                if(!pin.equals(npin))
                {
                    JOptionPane.showMessageDialog(null, "Entered pin does not matched");
                    return;
                }
                else if(pin.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Please enter the new pin");
                    return;
                }
                else if(npin.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Please re-enter the new pin");
                    return;
                }
                Connectivity c = new Connectivity();
                String query1 = "update transactions set Pin_Number = '"+npin+"' where Pin_Number = '"+pinno+"'";
                String query2 = "update signupfive set Pin_Number = '"+npin+"' where Pin_Number = '"+pinno+"'";
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null, "Pin Changed Successfully");
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
	}
    }
    public static void main(String args[]) throws Exception
    {
    	new Pin_Change("","");
    }
}