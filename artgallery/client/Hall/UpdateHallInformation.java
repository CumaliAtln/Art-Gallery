package client.Hall;

import javax.swing.*;

import function.DatabaseConnection;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateHallInformation extends JFrame implements ActionListener {


    /**
	 * 
	 */
	private static final long serialVersionUID = -6412503574252256714L;
	
	JTextField jt1, jt2, jt3, jt4, jt5, jt6;
    JLabel jl1, jl2, jl3, jl4, jl5, jl6, jl7,jLabel;
    JPanel jp1, jp2, jp3, jp4, jp5, jp6, jp7, jp8;
    JButton jb1, jb2;
    String a, b, c, d, ee, f;


    public UpdateHallInformation() {


        jt1 = new JTextField(8);
        jt2 = new JTextField(8);
        jt3 = new JTextField(8);
        jt4 = new JTextField(8);
        jt5 = new JTextField(8);
        jt6 = new JTextField(8);

        jl1 = new JLabel("å±•å�…ä¿¡æ�¯ä¿®æ”¹ç³»ç»Ÿ");
        jl2 = new JLabel("å±•å�…ç¼–å�·");
        jl3 = new JLabel("å±•å�…å��ç§°");
        jl4 = new JLabel("é�¢ç§¯");
        jl5 = new JLabel("åœ°å�€");
        jl6 = new JLabel("è´Ÿè´£äºº");
        jl7 = new JLabel("å±•ä½�æ•°");
        jLabel = new JLabel(UpdateHall.jt1.getText());

        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();
        jp5 = new JPanel();
        jp6 = new JPanel();
        jp7 = new JPanel();
        jp8 = new JPanel();


        jb1 = new JButton("ç¡®å®š");
        jb2 = new JButton("è¿”å›�");
        jb1.addActionListener(this);
        jb2.addActionListener(this);

        jp1.add(jl1);

        jp2.add(jl2);
        jp2.add(jLabel);
        jp2.add(jl3);
        jp2.add(jt2);

        jp3.add(jl4);
        jp3.add(jt3);
        jp3.add(jl5);
        jp3.add(jt4);

        jp4.add(jl6);
        jp4.add(jt5);
        jp4.add(jl7);
        jp4.add(jt6);

        jp5.add(jb1);
        jp5.add(jb2);

        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        this.add(jp4);
        this.add(jp5);

        this.setVisible(true);
        this.setTitle("è‰ºæœ¯ç”»å»Šç®¡ç�†ç³»ç»Ÿ");
        this.setBounds(200, 200, 640, 450);
        this.setLayout(new GridLayout(6, 4));
    }

    private void update() {
        Connection con = null;
        try {
            if (!jt2.getText().isEmpty() && !jt3.getText().isEmpty() && !jt4.getText().isEmpty() && !jt5.getText().isEmpty() && !jt6.getText().isEmpty()) {
                con = DatabaseConnection.getConnection();
                PreparedStatement ps = con.prepareStatement("update Hall set Hname = ?,Harea = ?, Hadd = ?,Hperson = ?,Hnum = ? where Hno = " + UpdateHall.jt1.getText());
                ps.setString(1, jt2.getText());
                ps.setString(2, jt3.getText());
                ps.setString(3, jt4.getText());
                ps.setString(4, jt5.getText());
                ps.setString(5, jt6.getText());

                ps.executeUpdate();
                System.out.println("ä¿®æ”¹æˆ�åŠŸ");
                JOptionPane.showMessageDialog(null, "ä¿®æ”¹æˆ�åŠŸ", "æ��ç¤ºæ¶ˆæ�¯", JOptionPane.WARNING_MESSAGE);
                jt1.setText("");
                jt2.setText("");
                jt3.setText("");
                jt4.setText("");
                jt5.setText("");
                jt6.setText("");
                con.close();
                System.out.println("æ•°æ�®åº“å…³é—­");
            }else {
                JOptionPane.showMessageDialog(null, "è¯·è¾“å…¥å®Œæ•´ä¿¡æ�¯", "æ��ç¤ºæ¶ˆæ�¯", JOptionPane.WARNING_MESSAGE);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "è¿”å›�") {
            new UpdateHall();
            dispose();

        } else if (e.getActionCommand() == "ç¡®å®š") {
            update();
        } else {
            JOptionPane.showMessageDialog(null, "è¯¥ç¼–å�·ä¸�å­˜åœ¨ï¼Œè¯·é‡�æ–°è¾“å…¥", "æ��ç¤ºæ¶ˆæ�¯", JOptionPane.WARNING_MESSAGE);
            jt1.setText("");
        }
    }
}

