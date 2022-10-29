package frame;

import java.awt.Color;
import java.awt.Cursor;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import thread.JThread;

public class Tela extends JFrame{

	private ArrayList<JThread> threads = new ArrayList();
	
	public Tela() {
		setTitle("Threads");
		setResizable(false);
		setLayout(null);
		setSize(700,500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		addDivisores();
		addButtons();
		addThreads();
		addInfo();
		
		setVisible(true);
	}
	
	private void addInfo() {
		
		String[] tipos = {"NEW", "WAITING", "RUNNABLE", "TIMED_WAITING", "TERMINATED"};
		Color[] cores = {Color.cyan, Color.yellow, Color.green, Color.orange, Color.gray};
		int x = 10;
		
		for(int i = 0; i < tipos.length; i++) {
			
			JPanel status = new JPanel();
			status.setLayout(null);
			status.setBounds(x, 10, 150, 15);
			
			JPanel cor = new JPanel();
			cor.setBounds(0, 0, 30, 15);
			cor.setBackground(cores[i]);
			
			JLabel nome = new JLabel(tipos[i]);
			nome.setBounds(35, 0, 100, 15);
			
			status.add(cor);
			status.add(nome);
			x += 140; 
			add(status);
		}
		
	}

	private void addThreads() {
		
		int y = 50;
		
		for(int i = 0; i < threads.size(); i++) {
			JPanel status = new JPanel();
			
			status.setLayout(null);
			status.setBounds(380, y, 200, 15);
			
			JLabel nome = new JLabel(threads.get(i).getNome());
			nome.setBounds(35, 0, 50, 15);
			JPanel cor = status(threads.get(i));
			
			JButton edit = new JButton("Editar");
			edit.setBackground(Color.BLACK);
			edit.setBorder(null);
			edit.setForeground(Color.white);
			
			edit.setBounds(132, 0, 68, 15);
			
			status.add(cor);
			status.add(nome);
			status.add(edit);
			this.add(status);
			y += 20;
		}
	}

	private void addButtons() {
		
		String[] bts = {"Nova Thread", "Recarregar"};
		int x = 70;
		int y = 50;
		
		for(int i = 0; i < bts.length; i++) {
			JButton bt = new JButton(bts[i]); 
			bt.setBackground(Color.black);
			bt.setForeground(Color.white);
			bt.setBorder(null);
			bt.setBounds(x, y, 200, 40);
			bt.setCursor(new Cursor(Cursor.HAND_CURSOR));
			this.add(bt);
			y += 60;
		}
		
	}

	private void addDivisores() {
		
		JPanel d1 = new JPanel();
		
		d1.setBounds(347, 25, 2, 400);
		d1.setBackground(Color.black);
		
		this.add(d1);
		
	}
	
	private JPanel status (JThread status) {
		JPanel cor = new JPanel();
		cor.setBounds(0, 0, 30, 15);
		
		String estado = String.valueOf(status.getState());
		
		if(estado.equals("NEW"))
			cor.setBackground(Color.cyan);
		else if(estado.equals("WAITING"))
			cor.setBackground(Color.yellow);
		else if(estado.equals("RUNNABLE"))
			cor.setBackground(Color.green);
		else if(estado.equals("TIMED_WAITING"))
			cor.setBackground(Color.orange);
		else if(estado.equals("TERMINATED"))
			cor.setBackground(Color.gray);
		
		return cor;
	}
	
}
