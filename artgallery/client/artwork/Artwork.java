/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artgallery.client.artwork;

/**
 *
 * @author tr
 */

import javax.swing.*;

import agSystem.AdminRoot;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Artwork extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8245115661658448861L;

	JButton jb1, jb2, jb3, jb4, jb5;
	JPanel jp1, jp2, jp3 = null;

	public Artwork() {

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

		jb1 = new JButton("æ·»åŠ è‰ºæœ¯å“�");
		jb1.setBackground(Color.WHITE);
		jb1.setFont(font);
		jb2 = new JButton("åˆ é™¤è‰ºæœ¯å“�");
		jb2.setBackground(Color.WHITE);
		jb2.setFont(font);
		jb3 = new JButton("æŸ¥è¯¢è‰ºæœ¯å“�ä¿¡æ�¯");
		jb3.setBackground(Color.WHITE);
		jb3.setFont(font);
		jb4 = new JButton("ä¿®æ”¹è‰ºæœ¯å“�ä¿¡æ�¯");
		jb4.setBackground(Color.WHITE);
		jb4.setFont(font);
		jb5 = new JButton("è¿”å›�");
		jb5.setBackground(Color.WHITE);
		jb5.setFont(font);

		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();

		JLabel jl1 = new JLabel("                 ");
		JPanel jp4 = new JPanel();

		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		jb4.addActionListener(this);
		jb5.addActionListener(this);

		jp1.add(jb1);
		jp1.add(jb2);
		jp2.add(jb3);
		jp2.add(jb4);
		jp3.add(jb5);
		jp4.add(jl1);

		jp1.setOpaque(false);
		jp2.setOpaque(false);
		jp3.setOpaque(false);
		jp4.setOpaque(false);

		this.add(jp4);
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);

		this.setTitle("è‰ºæœ¯ç”»å»Šç®¡ç�†ç³»ç»Ÿ");
		this.setVisible(true);
		this.setLayout(new GridLayout(5, 4));
		this.setBounds(630, 260, 752, 471);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "æ·»åŠ è‰ºæœ¯å“�") {
			// dispose();
			new InsertArtwork();
		} else if (e.getActionCommand() == "åˆ é™¤è‰ºæœ¯å“�") {
			// dispose();
			new DeleteArtwork();
		} else if (e.getActionCommand() == "æŸ¥è¯¢è‰ºæœ¯å“�ä¿¡æ�¯") {
			new SelectArtwork();
		} else if (e.getActionCommand() == "ä¿®æ”¹è‰ºæœ¯å“�ä¿¡æ�¯") {
			// dispose();
			new UpdateArtwork();
		} else if (e.getActionCommand() == "è¿”å›�") {
			new AdminRoot();
			dispose();

		}
	}
}

