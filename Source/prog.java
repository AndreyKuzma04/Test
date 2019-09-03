package test;

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

class xmlread{
	static int length;
	static ArrayList<String> textq = new ArrayList<>();
	static ArrayList<String> text = new ArrayList<>();
	static ArrayList<String> corr = new ArrayList<>();
	static String num;

	public xmlread() {

		try {
			DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document document = documentBuilder.parse("./Questions.xml");
			NodeList Questions = document.getDocumentElement().getElementsByTagName("Question");
			NodeList textqElements = document.getDocumentElement().getElementsByTagName("textq");
			NodeList textElements = document.getDocumentElement().getElementsByTagName("text");
			NodeList corrElements = document.getDocumentElement().getElementsByTagName("corr");
			for (int i = 0; i < textqElements.getLength(); i++) {
				Node texts = textqElements.item(i);
				textq.add(texts.getTextContent());

			}
			for (int i = 0; i < textElements.getLength(); i++) {
				Node texts = textElements.item(i);
				text.add(texts.getTextContent());

			}
			for (int i = 0; i < corrElements.getLength(); i++) {
				Node corrs = corrElements.item(i);
				corr.add(corrs.getTextContent());

			}
			length = Questions.getLength();

		} catch (ParserConfigurationException ex) {
			ex.printStackTrace(System.out);
		} catch (SAXException ex) {
			ex.printStackTrace(System.out);
		} catch (IOException ex) {
			ex.printStackTrace(System.out);
		}
		okno nf = new okno();

	}
}
class okno extends JFrame {
	int QuestNumb = 0;
	private JTextArea area;
	private JTextArea fieldA;
	private JTextArea fieldB;
	private JTextArea fieldC;
	private JTextArea fieldD;
	private JLabel tot;
	total totl;
	int ans;
	Double answer;
	static int res;
	static int length1=xmlread.length;
	public okno() {
	
		Container cont = getContentPane();
		JPanel pan = new JPanel();
		pan.setLayout(null);
		Font btnFont = new Font("arial", 0, 30);
		Font answerFont = new Font("arial", 1, 25);
		Font textFont = new Font("arial", 2, 30);
		JButton[] btn = new JButton[5];
		for (int i = 0; i < 5; i++) {
			btn[i] = new JButton();
			btn[i].setSize(100, 100);
			btn[i].setFont(btnFont);
			btn[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						btnClick((JButton) e.getSource());
					
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			pan.add(btn[i]);
		}
		btn[0].setLocation(910, 100);
		btn[1].setLocation(910, 350);
		btn[2].setLocation(910, 600);
		btn[3].setLocation(910, 850);
		btn[4].setSize(200, 50);
		btn[4].setLocation(50, 900);
		btn[0].setText("A");
		btn[1].setText("B");
		btn[2].setText("C");
		btn[3].setText("D");
		btn[4].setText("Ответить");
		area = new JTextArea();
		area.setFont(textFont);
		area.setBounds(10, 50, 800, 600);
		area.setForeground(new Color(0, 0, 100));
		area.setBackground(Color.WHITE);
		area.setLineWrap(true);
		area.setWrapStyleWord(true);
		area.setText(xmlread.textq.get(QuestNumb));
		tot = new JLabel();
		tot.setFont(textFont);
		tot.setBounds(50, 800, 200, 50);
		tot.setForeground(new Color(0, 0, 100));
		tot.setBackground(Color.WHITE);
		tot.setText("Ответ:");
		pan.add(tot);
		fieldA = new JTextArea();
		fieldA.setFont(answerFont);
		fieldA.setBounds(1110, 50, 790, 200);
		fieldA.setBackground(Color.WHITE);
		fieldA.setForeground(new Color(0, 0, 100));
		fieldA.setLineWrap(true);
		fieldA.setWrapStyleWord(true);
		fieldA.setText(xmlread.text.get(QuestNumb * 4));
		pan.add(fieldA);
		fieldB = new JTextArea();
		fieldB.setFont(answerFont);
		fieldB.setBounds(1110, 300, 790, 200);
		fieldB.setBackground(Color.WHITE);
		fieldB.setForeground(new Color(0, 0, 100));
		fieldB.setLineWrap(true);
		fieldB.setWrapStyleWord(true);
		fieldB.setText(xmlread.text.get(QuestNumb * 4 + 1));
		pan.add(fieldB);
		fieldC = new JTextArea();
		fieldC.setFont(answerFont);
		fieldC.setBounds(1110, 550, 790, 200);
		fieldC.setBackground(Color.WHITE);
		fieldC.setForeground(new Color(0, 0, 100));
		fieldC.setLineWrap(true);
		fieldC.setWrapStyleWord(true);
		fieldC.setText(xmlread.text.get(QuestNumb * 4 + 2));
		pan.add(fieldC);
		fieldD = new JTextArea();
		fieldD.setFont(answerFont);
		fieldD.setBounds(1110, 800, 790, 200);
		fieldD.setBackground(Color.WHITE);
		fieldD.setForeground(new Color(0, 0, 100));
		fieldD.setLineWrap(true);
		fieldD.setWrapStyleWord(true);
		fieldD.setText(xmlread.text.get(QuestNumb * 4 + 3));
		pan.add(fieldD);
		pan.add(area);
		cont.add(pan);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setExtendedState(MAXIMIZED_BOTH);

		setSize(1920, 1080);

		setTitle("Тест");
		setVisible(true);
		
	}

	private void btnClick(JButton btn) throws Exception {
		String str = btn.getText();
		if (str == "A") {
			ans = QuestNumb * 4;
			tot.setText("Ответ: A");
		} else if (str == "B") {
			ans = QuestNumb * 4 + 1;
			tot.setText("Ответ: B");
		} else if (str == "C") {
			ans = QuestNumb * 4 + 2;
			tot.setText("Ответ: C");
		} else if (str == "D") {
			ans = QuestNumb * 4 + 3;
			tot.setText("Ответ: D");
		} else if (str == "Ответить") {
			tot.setText("Ответ:");
			QuestNumb++;
			answer=Double.parseDouble(xmlread.corr.get(ans));
			if (answer==1) {
				res++;
				
				
			}else {
				
			}
			if (QuestNumb >= xmlread.length) {
				setVisible(false);
				totl=new total();
				
			} else if(QuestNumb<xmlread.length) {
				
				area.setText(xmlread.textq.get(QuestNumb));
				fieldA.setText(xmlread.text.get(QuestNumb * 4));
				fieldB.setText(xmlread.text.get(QuestNumb * 4 + 1));
				fieldC.setText(xmlread.text.get(QuestNumb * 4 + 2));
				fieldD.setText(xmlread.text.get(QuestNumb * 4 + 3));
			}
		}
	}
}
