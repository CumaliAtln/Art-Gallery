/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artgallery.agSystem;

/**
 *
 * @author tr
 */

import javax.swing.*;

import artgallery.function.DatabaseConnection;
import artgallery.function.Verify;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
æ³¨å†Œç•Œé�¢
 */

public class RegistRoot extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6395739873845291346L;

	// é—¨é�¢ç±»å¯¹è±¡
	Verify fcd = new Verify();

	// å®šä¹‰ç»„ä»¶
	JFrame jf;
	JPanel jp1, jp2, jp3, jp4, jp5;
	JLabel jl1, jl2, jl3;
	static JTextField jtf1, jtf2;
	JButton jb1, jb2;
	ButtonGroup group;
	JRadioButton jrb1 = null, jrb2 = null;

	public RegistRoot() {
		Font font = new Font("alias", Font.PLAIN, 22);

		// åŠ è½½å›¾ç‰‡
		ImageIcon icon = new ImageIcon("lfg_main.jpg");
		Image icon2 =  Toolkit.getDefaultToolkit().getImage("huabi.jpg");
		this.setIconImage(icon2);
//
//        //å°†å›¾ç‰‡æ”¾å…¥labelä¸­
		JLabel label = new JLabel(icon);
//
//        //è®¾ç½®labelçš„å¤§å°�
		label.setBounds(0,0,icon.getIconWidth(),icon.getIconHeight());
//
//        //è�·å�–çª—å�£çš„ç¬¬äºŒå±‚ï¼Œå°†labelæ”¾å…¥
		this.getLayeredPane().add(label, Integer.valueOf(Integer.MIN_VALUE));
//
//        //è�·å�–frameçš„é¡¶å±‚å®¹å™¨,å¹¶è®¾ç½®ä¸ºé€�æ˜�
		JPanel j = (JPanel) this.getContentPane();
		j.setOpaque(false);

		// åˆ�å§‹åŒ–ç»„ä»¶
		jf = new JFrame();
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		jp4 = new JPanel();
		jp5 = new JPanel();

		jl1 = new JLabel("è¯·è¾“å…¥ç”¨æˆ·å��ï¼š");
		jtf1 = new JTextField(10);
		jl1.setFont(font);
		jtf1.setFont(font);
		jl1.setForeground(new Color(255, 255, 0));
		jtf1.setToolTipText("ç”¨æˆ·å��å¿…é¡»ä¸º3-11ä½�å­—æ¯�_æˆ–è€…æ•°å­—");
		jl2 = new JLabel("è¯·è¾“å…¥å¯†ç �ï¼š");
		jtf2 = new JPasswordField(10);
		jl2.setFont(font);
		jtf2.setFont(font);
		jl2.setForeground(new Color(255, 255, 0));
		jtf2.setToolTipText("å¯†ç �å¿…é¡»ä¸º6ä½�å­—æ¯�_æˆ–è€…æ•°å­—");

		jl3 = new JLabel("æ³¨å†Œç•Œé�¢");
		jl3.setFont(font);
		jl3.setForeground(new Color(255, 255, 0));

		jb1 = new JButton("è¿”å›�");
		jb1.setBackground(Color.WHITE);
		jb1.setFont(font);
		jb1.setToolTipText("ç‚¹æˆ‘è¿”å›�ç™»å½•ç•Œé�¢å“¦");
		jb2 = new JButton("æ³¨å†Œ");
		jb2.setBackground(Color.WHITE);
		jb2.setFont(font);
		jb1.addActionListener(this);
		jb2.addActionListener(this);

		Font font2 = new Font("æ¥·ä½“", Font.PLAIN, 20);
		jrb1 = new JRadioButton("ç®¡ç�†å‘˜");
		jrb1.setFont(font2);
		jrb1.setForeground(new Color(160, 0, 0));
		jrb2 = new JRadioButton("å®¢æˆ·");
		jrb2.setFont(font2);
		jrb2.setForeground(new Color(160, 0, 0));
		group = new ButtonGroup();
		group.add(jrb1);
		group.add(jrb2);

		jp1.add(jl1);
		jp1.add(jtf1);

		jp2.add(jl2);
		jp2.add(jtf2);

		jp3.add(jb1);
		jp3.add(jb2);

		jp4.add(jl3);

		jp5.add(jrb1);
		jp5.add(jrb2);

		// å¿…é¡»è®¾ç½®ä¸ºé€�æ˜�çš„ã€‚å�¦åˆ™çœ‹ä¸�åˆ°å›¾ç‰‡
		jp1.setOpaque(false);
		jp2.setOpaque(false);
		jp3.setOpaque(false);
		jp4.setOpaque(false);
		jp5.setOpaque(false);

		this.add(jp4);
		this.add(jp1);
		this.add(jp2);
		this.add(jp5);
		this.add(jp3);
		this.setTitle("è‰ºæœ¯ç”»å»Šç®¡ç�†ç³»ç»Ÿ");
		this.setLayout(new GridLayout(5, 2));
		this.setBounds(400, 150, icon.getIconWidth(), icon.getIconHeight());
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand() == "è¿”å›�") {
			this.dispose();
			new SystemMain();

		} else if (e.getActionCommand() == "æ³¨å†Œ") {
			// è°ƒç”¨æ³¨å†Œæ–¹æ³•
			if (jrb1.isSelected()) {
				this.zhuce1();
			} else if (jrb2.isSelected()) {
				this.zhuce2();
			}
		}

	}

	// ç®¡ç�†å‘˜æ³¨å†Œæ–¹æ³•
	@SuppressWarnings("static-access")
	public void zhuce1() {
		String account = "\\w{3,6}"; // ç®¡ç�†å‘˜ç”¨æˆ·å��å¿…é¡»æ˜¯3-6ä½�
		boolean flag1 = jtf1.getText().matches(account);

		String password = "\\w{6}"; // å¯†ç �å¿…é¡»æ˜¯6ä½�
		boolean flag2 = jtf2.getText().matches(password);

		if (flag1 == false) {
			JOptionPane.showMessageDialog(null, "ç”¨æˆ·å��å¡«å†™é”™è¯¯,å¿…é¡»ä¸º3-6ä½�å­—æ¯�_æˆ–è€…æ•°å­—", "æ��ç¤ºä¿¡æ�¯", JOptionPane.WARNING_MESSAGE);
			jtf1.setText("");
			jtf2.setText("");
		} else if (flag2 == false) {
			JOptionPane.showMessageDialog(null, "å¯†ç �å¡«å†™é”™è¯¯,å¿…é¡»ä¸º6ä½�å­—æ¯�_æˆ–è€…æ•°å­—", "æ��ç¤ºä¿¡æ�¯", JOptionPane.WARNING_MESSAGE);
			jtf1.setText("");
			jtf2.setText("");
		} else {
			DatabaseConnection.getConnection();
			fcd.verifyRegister(jtf1.getText());

			this.jtf1.setText("");
			this.jtf2.setText("");
		}
	}

	// ç”¨æˆ·æ³¨å†Œæ–¹æ³•
	public void zhuce2() {
		String account = "\\w{7,11}"; // å®¢æˆ·ç”¨æˆ·å��å¿…é¡»æ˜¯7-11ä½�
		boolean flag1 = jtf1.getText().matches(account);

		String password = "\\w{6}"; // å¯†ç �å¿…é¡»æ˜¯6ä½�
		boolean flag2 = jtf2.getText().matches(password);

		if (flag1 == false) {
			JOptionPane.showMessageDialog(null, "ç”¨æˆ·å��å¡«å†™é”™è¯¯,å¿…é¡»ä¸º7-11ä½�å­—æ¯�_æˆ–è€…æ•°å­—", "æ��ç¤ºä¿¡æ�¯", JOptionPane.WARNING_MESSAGE);
			jtf1.setText("");
		} else if (flag2 == false) {
			JOptionPane.showMessageDialog(null, "å¯†ç �å¡«å†™é”™è¯¯,å¿…é¡»ä¸º6ä½�å­—æ¯�_æˆ–è€…æ•°å­—", "æ��ç¤ºä¿¡æ�¯", JOptionPane.WARNING_MESSAGE);
			jtf2.setText("");
		} else {
			DatabaseConnection.getConnection();
			fcd.verifyRegister(jtf1.getText());
			RegistRoot.jtf1.setText("");
			this.jrb2.setText("");
		}
	}
}

