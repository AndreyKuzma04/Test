package test;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.*;

public class total extends JFrame {
	private JLabel tot;
	 String sCurrentLine;
	public total() throws Exception {
		Container cont = getContentPane();
		JPanel pan = new JPanel();
		pan.setLayout(null);
		Font textFont = new Font("arial", 2, 30);
		tot = new JLabel();
		tot.setFont(textFont);
		tot.setBounds(10, 200, 300, 50);
		tot.setForeground(new Color(0, 0, 100));
		tot.setBackground(Color.WHITE);
		tot.setText("Итого:" + okno.res + " из " + okno.length1);
		pan.add(tot);
		cont.add(pan);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(0, 0, 320, 500);
		setTitle("Итог");
		setVisible(true);
		BufferedReader fr = new BufferedReader(new FileReader("C:\\Users\\User\\Desktop\\Программирование\\Test3\\Results.txt"));
		Scanner scan = new Scanner(fr);
		FileWriter File = new FileWriter("C:\\Users\\User\\Desktop\\Программирование\\Test3\\Results.txt", true);
		 while ((sCurrentLine = fr.readLine()) != null) {
		        System.out.println(sCurrentLine);
		    }
		
		File.append( okno1.NAME + " - " + okno.res+"\r\n" );
		fr.close();
		File.close();
		System.out.println(okno1.NAME + " - " + okno.res);
	}
}
