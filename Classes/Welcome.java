package Classes;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Welcome extends JFrame implements ActionListener {
    JLabel accountLabel, l1, imagelb,logolb;
    MyButton exitBtn, backBtn, loginBtn;
   JPanel thisPanel;

    public Welcome() {
       
		this.setBounds(0, 0, 1100, 685);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout(0, 0));
		this.setResizable(false);
		this.setVisible(true);

		thisPanel = new JPanel();
		thisPanel.setBackground(Color.decode("#FAFAFA"));
		Color background = new Color(255, 255, 255);
		thisPanel.setLayout(null);

		imagelb = new JLabel("");
		imagelb.setBounds(0, 0, 530, 680);
		imagelb.setIcon(new ImageIcon("imageBG/wL.png"));
		thisPanel.add(imagelb);
		
		logolb = new JLabel("");
		logolb.setBounds(712, 85, 176, 176);
		logolb.setIcon(new ImageIcon("imageBG/Use.png"));
		thisPanel.add(logolb);
			
		/*l1 = new JLabel("Soukhin Recipe");
		l1.setFont(new Font("Monospace", Font.BOLD, 20));
		l1.setForeground(Color.BLACK);
		l1.setBounds(200, 50, 350, 50);
		background.add(l1);*/

        backBtn = new MyButton("Registration");
		backBtn.setText("Registration");
        backBtn.setFont(new Font("Monospace", Font.BOLD, 15));
       
        backBtn.setBounds(732, 300, 120, 30);
       // backBtn.addActionListener(this);
      backBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		((MyButton) backBtn).setRadius(10);
		backBtn.setBorder(null);;
		thisPanel.add(backBtn);
		backBtn.addActionListener(this);
		backBtn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                backBtn.setBackground(new Color(25, 118, 211));
                backBtn.setForeground(new Color(255, 255, 255));
            }
            public void mouseExited(MouseEvent e) {
                backBtn.setForeground(new Color(25, 118, 211));
                backBtn.setBackground(new Color(255, 255, 255));
            }
        });
		//background.add(backBtn);
        loginBtn = new MyButton("Log in");
        loginBtn.setFont(new Font("Monospace", Font.BOLD, 15));
		
		loginBtn.setFocusPainted(false);
        loginBtn.setBounds(732, 360, 120, 30);
        //loginBtn.addActionListener(this);
         loginBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		((MyButton) loginBtn).setRadius(10);
		loginBtn.setBorder(null);;
		thisPanel.add(loginBtn);
		loginBtn.addActionListener(this);
		loginBtn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                loginBtn.setBackground(new Color(25, 118, 211));
                loginBtn.setForeground(new Color(255, 255, 255));
            }
            public void mouseExited(MouseEvent e) {
                loginBtn.setForeground(new Color(25, 118, 211));
                loginBtn.setBackground(new Color(255, 255, 255));
            }
        });
		//background.add(loginBtn);

        exitBtn = new MyButton("Exit");
		exitBtn.setText("Exit");
        exitBtn.setFont(new Font("Monospace", Font.BOLD, 15));
        
        exitBtn.setBounds(732, 420, 120, 30);
       // exitBtn.addActionListener(this);
        exitBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		((MyButton) exitBtn).setRadius(10);
		exitBtn.setBorder(null);;
		thisPanel.add(exitBtn);
		exitBtn.addActionListener(this);
		exitBtn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                exitBtn.setBackground(new Color(25, 118, 211));
                exitBtn.setForeground(new Color(255, 255, 255));
            }
            public void mouseExited(MouseEvent e) {
                exitBtn.setForeground(new Color(25, 118, 211));
                exitBtn.setBackground(new Color(255, 255, 255));
            }
        });
		//background.add(exitBtn);

       this.add(thisPanel);
       this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exitBtn) {
            System.exit(0);
        }
        if (e.getSource() == backBtn) {
            Register reg = new Register();
            this.setVisible(false);
            reg.setVisible(true);
        }
        if (e.getSource() == loginBtn) {
            Login lg = new Login();
            this.setVisible(false);
            lg.setVisible(true);
        }
    }
}
