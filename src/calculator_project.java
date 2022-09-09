import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class calculator_project extends JFrame implements ActionListener {
    JPanel p1, p2, p3, p4, p5, p6,p7,p8;
    JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21, b22,b23,ok;
    JTextField t1,user;
    JPasswordField pass;
    JLabel userL,passL;
    double a,b,c,temp;
    JFrame jf;
    public calculator_project() {
        jf=new JFrame();
        jf.setLayout(new GridLayout(8, 1));
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        p5 = new JPanel();
        p6 = new JPanel();
        p7 = new JPanel();
        p8 = new JPanel();

        p1.setLayout(new GridLayout(1, 1));
        p2.setLayout(new GridLayout(1, 5));
        p3.setLayout(new GridLayout(1, 5));
        p4.setLayout(new GridLayout(1, 5));
        p5.setLayout(new GridLayout(1, 5));
        p6.setLayout(new GridLayout(1, 3));
        p7.setLayout(new GridLayout(1, 4));
        p8.setLayout(new GridLayout(1, 1));


        Font so =(new Font("black Times New Roman",Font.BOLD,20));


        //Calculator buttons,textFields and their characteristics
        t1 = new JTextField(100);
        t1.setFont(so);
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("+");
        b4.setBackground(Color.lightGray);
        b4.setForeground(Color.black);
        b5 = new JButton("SIN");
        b5.setBackground(Color.blue);
        b5.setForeground(Color.green);
        b6 = new JButton("4");
        b7 = new JButton("5");
        b8 = new JButton("6");
        b9 = new JButton("-");
        b9.setBackground(Color.lightGray);
        b9.setForeground(Color.black);
        b10 = new JButton("COS");
        b10.setBackground(Color.blue);
        b10.setForeground(Color.green);
        b11 = new JButton("7");
        b12 = new JButton("8");
        b13 = new JButton("9");
        b14 = new JButton("*");
        b14.setBackground(Color.lightGray);
        b14.setForeground(Color.black);
        b15 = new JButton("TAN");
        b15.setBackground(Color.blue);
        b15.setForeground(Color.green);
        b16 = new JButton(".");
        b17 = new JButton("0");
        b18 = new JButton("00");
        b19 = new JButton("/");
        b19.setBackground(Color.lightGray);
        b19.setForeground(Color.black);
        b20 = new JButton("SQR");
        b20.setBackground(Color.blue);
        b20.setForeground(Color.green);
        b21 = new JButton("EXIT");
        b21.setBackground(Color.red);
        b21.setForeground(Color.white);
        b22 = new JButton("=");
        b22.setBackground(Color.red);
        b22.setForeground(Color.white);
        b23 = new JButton("AC");

        //For User Login
        userL=new JLabel("Username");
        userL.setFont(so);

        user=new JTextField(20);
        user.setFont(so);

        passL=new JLabel("Password");
        passL.setFont(so);

        pass=new JPasswordField(20);
        pass.setFont(so);

        //Enter button for login
        ok=new JButton("Enter");
        ok.setFont(so);
        ok.setBackground(Color.lightGray);
        ok.setForeground(Color.black);


        p1.add(t1);
        p2.add(b1);
        p2.add(b2);
        p2.add(b3);
        p2.add(b4);
        p2.add(b5);
        p3.add(b6);
        p3.add(b7);
        p3.add(b8);
        p3.add(b9);
        p3.add(b10);
        p4.add(b11);
        p4.add(b12);
        p4.add(b13);
        p4.add(b14);
        p4.add(b15);
        p5.add(b16);
        p5.add(b17);
        p5.add(b18);
        p5.add(b19);
        p5.add(b20);
        p6.add(b21);
        p6.add(b23);
        p6.add(b22);

        p7.add(userL);
        p7.add(user);
        p7.add(passL);
        p7.add(pass);
        p8.add(ok);

       jf.add(p7);
        jf.add(p8);
        jf.add(p1);
        jf.add(p2);
        jf.add(p3);
        jf.add(p4);
        jf.add(p5);
        jf.add(p6);


        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        b10.addActionListener(this);
        b11.addActionListener(this);
        b12.addActionListener(this);
        b13.addActionListener(this);
        b14.addActionListener(this);
        b15.addActionListener(this);
        b16.addActionListener(this);
        b17.addActionListener(this);
        b18.addActionListener(this);
        b19.addActionListener(this);
        b20.addActionListener(this);
        b21.addActionListener(this);
        b22.addActionListener(this);
        b23.addActionListener(this);
        ok.addActionListener(this);

        //put visibility false cuz it will show when user put password in fields
        p1.setVisible(false);
        p2.setVisible(false);
        p3.setVisible(false);
        p4.setVisible(false);
        p5.setVisible(false);
        p6.setVisible(false);
        jf.setSize(600,400);
        jf.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==ok)
        {
            Statement st;
            Connection conn;
            ResultSet rs;
            String na,pa;
            String dk,bs;

            try{
                //Used MySQLWorkbench backend tool for storing and using password of user
                conn= DriverManager.getConnection("JDBC:mysql://localhost:3306/live", "root", "AfnanBaig@123"); //syntax for connecting to MySQLWorkbench
                st=conn.createStatement();
                rs = st.executeQuery("select * from login");
                rs.next();

                bs = rs.getString("userName");
                dk = rs.getString("passWord");

                na = user.getText();
                pa = String.valueOf(pass.getPassword());

                //user and password compared here
                if ((na.equals(bs)) && (pa.equals(dk))) {

                    //If password is correct then calculator will be shown to the user
                    p1.setVisible(true);
                    p2.setVisible(true);
                    p3.setVisible(true);
                    p4.setVisible(true);
                    p5.setVisible(true);
                    p6.setVisible(true);

                    //login,password panel goes false
                    p7.setVisible(false);
                    p8.setVisible(false);

                }
                else {
                    JOptionPane.showMessageDialog(null,"Invalid!Try again."); //For invalid password
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (e.getSource() == b1) {
            t1.setText(t1.getText() + "1");
        } else if (e.getSource() == b2) {
            t1.setText(t1.getText() + "2");

        } else if (e.getSource() == b3) {
            t1.setText(t1.getText() + "3");
        } else if (e.getSource() == b4) {
            temp = 1;
            a = Double.parseDouble(t1.getText());
            t1.setText("");
        } else if (e.getSource() == b5) {
            double pi;
            pi = 22.0 / 7;
            a = Double.parseDouble(t1.getText());
            b = a * pi / 180;
            c = Math.sin(b);
            t1.setText(String.valueOf(c));
        } else if (e.getSource() == b6) {
            t1.setText(t1.getText() + "4");
        } else if (e.getSource() == b7) {
            t1.setText(t1.getText() + "5");
        } else if (e.getSource() == b8) {
            t1.setText(t1.getText() + "6");
        } else if (e.getSource() == b9) {
            temp = 2;
            a = Double.parseDouble(t1.getText());
            t1.setText("");
        } else if (e.getSource() == b10) {
            a = Double.parseDouble(t1.getText());
            b = Math.toRadians(a);
            c = Math.cos(b);
            t1.setText(String.valueOf(c));
        } else if (e.getSource() == b11) {
            t1.setText(t1.getText() + "7");
        } else if (e.getSource() == b12) {
            t1.setText(t1.getText() + "8");
        } else if (e.getSource() == b13) {
            t1.setText(t1.getText() + "9");
        } else if (e.getSource() == b14) {
            temp = 3;
            a = Double.parseDouble(t1.getText());
            t1.setText("");
        } else if (e.getSource() == b15) {
            a = Double.parseDouble(t1.getText());
            b = a * 3.14 / 180;
            c = Math.tan(b);
            t1.setText(String.valueOf(c));
        } else if (e.getSource() == b16) {
            t1.setText(t1.getText() + ".");

        } else if (e.getSource() == b17) {
            t1.setText(t1.getText() + "0");
        } else if (e.getSource() == b18) {
            t1.setText(t1.getText() + "00");
        } else if (e.getSource() == b19) {
            temp = 4;
            a = Double.parseDouble(t1.getText());
            t1.setText("");
        } else if (e.getSource() == b20) {
            a = Double.parseDouble(t1.getText());
            b = a * a;
            t1.setText(String.valueOf(b));
        } else if (e.getSource() == b21) {
            System. exit(0);
        } else if (e.getSource() == b22) {
            b = Double.parseDouble(t1.getText());
            if (temp == 1) {
                c = a + b;
            } else if (temp == 2) {
                c = a - b;
            } else if (temp == 3) {
                c = a * b;
            } else if (temp == 4) {
                c = a / b;
            }
            t1.setText(String.valueOf(c));

        } else if (e.getSource() == b23) {
            a = 0;
            b = 0;
            t1.setText("");
        }
    }

    public static void main(String[] args) {
        new calculator_project();

    }
}
