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

import artgallery.function.Verify;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
ç™»å½•ä¸»ç•Œé�¢
 */

public class SystemMain extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6498329542920525856L;

	private ButtonGroup group;
	// é—¨é�¢æ¨¡å¼�å¯¹è±¡
	Verify fcd = new Verify();

	// å®šä¹‰ç™»å½•ç•Œé�¢çš„ç»„ä»¶
	JButton jb1, jb2, jb3 = null;
	JRadioButton jrb1, jrb2 = null;
	JPanel jp1, jp2, jp3, jp4, jp5 = null;
	JTextField jtf = null;
	JLabel jlb1, jlb2, jlb3 = null;
	JPasswordField jpf = null;

	String managername = "\\w{3,6}";
	String username = "\\w{7,11}";

	public static void main(String[] args) {
		// InitGloalFont.InitglobalFont(new Font("alias", Font.PLAIN, 22));
		@SuppressWarnings("unused")
		SystemMain systemMain = new SystemMain();
	}

	public SystemMain() {

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
		label.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
//
//        //è�·å�–çª—å�£çš„ç¬¬äºŒå±‚ï¼Œå°†labelæ”¾å…¥
		this.getLayeredPane().add(label, Integer.valueOf(Integer.MIN_VALUE));
//
//        //è�·å�–frameçš„é¡¶å±‚å®¹å™¨,å¹¶è®¾ç½®ä¸ºé€�æ˜�
		JPanel j = (JPanel) this.getContentPane();
		j.setOpaque(false);

		// åˆ›å»ºç»„ä»¶
		jb1 = new JButton("ç™»å½•");
		jb1.setFont(font);
		// jb1.setBounds(150,230,70,22);
		jb1.setBackground(Color.WHITE);
		jb2 = new JButton("æ³¨å†Œ");
		jb2.setFont(font);
		// jb1.setBounds(150,230,70,22);
		jb2.setBackground(Color.white);
		jb3 = new JButton("é€€å‡º");
		jb3.setFont(font);
		// jb1.setBounds(150,230,70,22);
		jb3.setBackground(Color.white);

		// è®¾ç½®ç›‘å�¬
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);

		Font font3 = new Font("å��æ–‡å½©äº‘", Font.PLAIN, 28);
		jlb3 = new JLabel("æ¬¢è¿�ä½¿ç”¨è‰ºæœ¯ç”»å»Šç®¡ç�†ç³»ç»Ÿ");
		jlb3.setFont(font3);
		jlb3.setForeground(new Color(255, 255, 100));

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

		jlb1 = new JLabel("ç”¨æˆ·å��ï¼š");
		// jlb1.setBounds(100,120,200,30);
		jtf = new JTextField(10);
		// jtf.setBounds(150,120,150,30);
		jlb1.setFont(font3);
		jlb1.setForeground(new Color(255, 255, 0));
		jtf.setFont(font);

		jlb2 = new JLabel("å¯†    ç �ï¼š");
		// jlb2.setBounds(100,180,200,30);
		jlb2.setFont(font3);
		jlb2.setForeground(new Color(255, 255, 0));
		jpf = new JPasswordField(10);
		// jpf.setBounds(150,180,150,30);
		jpf.setFont(font);

		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		jp4 = new JPanel();
		jp5 = new JPanel();

		jp4.add(jlb3);
		jp1.add(jlb1);
		jp1.add(jtf);

		jp2.add(jlb2);
		jp2.add(jpf);

		jp3.add(jp4);
		jp3.add(jb1);
		jp3.add(jb2);
		jp3.add(jb3);

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

		this.setVisible(true);
		this.setTitle("è‰ºæœ¯ç”»å»Šç®¡ç�†ç³»ç»Ÿ");
		this.setLayout(new GridLayout(5, 1));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(600, 280, icon.getIconWidth(), icon.getIconHeight());
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {

		// ç›‘å�¬å�„ä¸ªæŒ‰é’®
		if (e.getActionCommand() == "é€€å‡º") {
			System.exit(0);
		} else if (e.getActionCommand() == "ç™»å½•") {
			// è¿›è¡Œåˆ¤æ–­ï¼Œä¸ºç©ºåˆ™ä¸�è¿›è¡Œç™»å½•æ“�ä½œã€‚
			if (jtf.getText().isEmpty() || jpf.getText().isEmpty())
				JOptionPane.showMessageDialog(null, "è¯·è¾“å…¥ç”¨æˆ·å��å’Œå¯†ç �", "æ��ç¤ºä¿¡æ�¯", JOptionPane.WARNING_MESSAGE);
			else {
				// è°ƒç”¨ç™»å½•æ–¹æ³•
				if (jrb1.isSelected()) {
					boolean name = jtf.getText().matches(managername);
					if (name == true) {
						rootLogin();
					} else {
						JOptionPane.showMessageDialog(null, "ç”¨æˆ·å��é•¿åº¦åœ¨3-6ä½�ä¹‹é—´", "æ��ç¤ºæ¶ˆæ�¯", JOptionPane.WARNING_MESSAGE);
					}
				} else if (jrb2.isSelected()) {
					boolean name = jtf.getText().matches(username);
					if (name == true) {
						userLogin();
					} else {
						JOptionPane.showMessageDialog(null, "ç”¨æˆ·å��é•¿åº¦åœ¨7-11ä½�ä¹‹é—´", "æ��ç¤ºæ¶ˆæ�¯", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		} else if (e.getActionCommand() == "æ³¨å†Œ") {
			// è°ƒç”¨æ³¨å†Œæ–¹æ³•
			this.Regis();
		}

	}

	// æ³¨å†Œæ–¹æ³•
	public void Regis() {
		new RegistRoot(); // æ‰“å¼€æ–°ç•Œé�¢
		this.dispose(); // å…³é—­å½“å‰�ç•Œé�¢

	}

	// ç®¡ç�†å‘˜ç™»å½•æ–¹æ³•
	@SuppressWarnings("deprecation")
	public void rootLogin() {// DatabaseConnection.getConnection();
		fcd.verifyRoot(jtf.getText(), jpf.getText());
		jtf.setText("");
		jpf.setText("");
		// this.dispose();
	}

	// å®¢æˆ·ç™»å½•æ–¹æ³•
	@SuppressWarnings("deprecation")
	public void userLogin() {

		fcd.verifyUser(jtf.getText(), jpf.getText());
		jtf.setText("");
		jpf.setText("");
		// this.dispose();
	}
}