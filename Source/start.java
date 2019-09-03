package test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class start {

	public static void main(String[] args){

		login log = new login();
		
	}

}

class login {
	static ArrayList<String> Name = new ArrayList<>();
	static ArrayList<String> Password = new ArrayList<>();
	static ArrayList<String> Role = new ArrayList<>();
	static int length2;

	public login() {
		try {
			DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document document = documentBuilder.parse("./Accounts.xml");
			NodeList Users = document.getDocumentElement().getElementsByTagName("User");
			NodeList nameElements = document.getDocumentElement().getElementsByTagName("Name");
			NodeList passwordElements = document.getDocumentElement().getElementsByTagName("Password");
			NodeList roleElements = document.getDocumentElement().getElementsByTagName("Role");
			for (int i = 0; i < nameElements.getLength(); i++) {
				Node name1 = nameElements.item(i);
				Name.add(name1.getTextContent());

			}
			for (int i = 0; i < passwordElements.getLength(); i++) {
				Node password1 = passwordElements.item(i);
				Password.add(password1.getTextContent());

			}
			for (int i = 0; i < roleElements.getLength(); i++) {
				Node role1 = roleElements.item(i);
				Role.add(role1.getTextContent());

			}
			length2 = Users.getLength();

		} catch (ParserConfigurationException ex) {
			ex.printStackTrace(System.out);
		} catch (SAXException ex) {
			ex.printStackTrace(System.out);
		} catch (IOException ex) {
			ex.printStackTrace(System.out);
		}
		okno1 nf = new okno1();
	}

}

class okno1 extends JFrame {
	private JPasswordField passw;
	private JLabel lab;
	private JLabel lab1;
	private JTextField field;
	String passText;
	static String NAME;

	public okno1() {
		Container cont = getContentPane();
		JPanel pan = new JPanel();
		pan.setLayout(null);
		Font textFont = new Font("arial", 2, 30);
		passw = new JPasswordField();
		passw.setFont(textFont);
		passw.setBounds(7, 250, 300, 50);
		passw.setForeground(new Color(0, 0, 100));
		passw.setBackground(Color.WHITE);
		pan.add(passw);
		lab = new JLabel();
		lab.setFont(textFont);
		lab.setBounds(7, 200, 300, 50);
		lab.setForeground(new Color(0, 0, 100));
		lab.setBackground(Color.WHITE);
		lab.setText("Пароль:");
		pan.add(lab);
		lab1 = new JLabel();
		lab1.setFont(textFont);
		lab1.setBounds(7, 50, 300, 50);
		lab1.setForeground(new Color(0, 0, 100));
		lab1.setBackground(Color.WHITE);
		lab1.setText("Имя:");
		pan.add(lab1);
		field = new JTextField();
		field.setFont(textFont);
		field.setBounds(7, 100, 300, 50);
		field.setForeground(new Color(0, 0, 100));
		field.setBackground(Color.WHITE);
		pan.add(field);
		JButton[] btn = new JButton[1];
		btn[0] = new JButton();
		btn[0].setBounds(57, 320, 200, 50);
		btn[0].setFont(textFont);
		btn[0].setText("Войти");
		btn[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnClick((JButton) e.getSource());
			}
		});
		pan.add(btn[0]);
		cont.add(pan);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(0, 0, 320, 500);
		setTitle("Вход");
		setVisible(true);
	}

	private void btnClick(JButton btn) {
		String str = btn.getText();
		if (str == "Войти") {
			passText = new String(passw.getPassword());
			for (int i = 0; i < login.length2; i++) {
				if (field.getText().contentEquals(login.Name.get(i)) == true) {
					if (passText.contentEquals(login.Password.get(i)) == true) {
						xmlread xread = new xmlread();
						xread.getClass();
						setVisible(false);
						NAME = field.getText();
					} else {
						JOptionPane.showMessageDialog(null, "Неверное имя или пароль");
					}
				}

			}
		}
	}
}
