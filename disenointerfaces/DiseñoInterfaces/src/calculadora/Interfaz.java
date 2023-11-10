package calculadora;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Interfaz {

	private JFrame frame;
	private JTextField mostrado;

	private double num1;
	private double num2;

	double result = 0;
	private int sel=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz window = new Interfaz();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interfaz() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 392, 464);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(4, 5, 2, 2));
		
		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pulsado("7");
			}
		});
		panel.add(btn7);
		
		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pulsado("8");
			}
		});
		panel.add(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pulsado("9");
			}
		});
		panel.add(btn9);
		
		JButton btnDel = new JButton("DEL");
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pulsado("DEL");
			}
		});
		panel.add(btnDel);
		
		JButton btnAC = new JButton("AC");
		btnAC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pulsado("AC");
			}
		});
		panel.add(btnAC);
		
		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pulsado("4");
			}
		});
		panel.add(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pulsado("5");
			}
		});
		panel.add(btn5);
		
		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pulsado("6");
			}
		});
		panel.add(btn6);
		
		JButton btnX = new JButton("x");
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pulsado("x");
			}
		});
		panel.add(btnX);
		
		JButton btnDiv = new JButton("/");
		btnDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pulsado("/");
			}
		});
		panel.add(btnDiv);
		
		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pulsado("1");
			}
		});
		panel.add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pulsado("2");
			}
		});
		panel.add(btn2);
		
		JButton btn3 = new JButton("3");
		panel.add(btn3);
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pulsado("3");
			}
		});
		
		JButton btnPlus = new JButton("+");
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pulsado("+");
			}
		});
		panel.add(btnPlus);
		
		JButton btnMenos = new JButton("-");
		btnMenos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pulsado("-");
			}
		});
		panel.add(btnMenos);
		
		JButton btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pulsado("0");
			}
		});
		panel.add(btn0);
		
		JButton btnPunto = new JButton(".");
		btnPunto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pulsado(".");
			}
		});
		panel.add(btnPunto);
		
		JButton btnExp = new JButton("EXP");
		btnExp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pulsado("EXP");
			}
		});
		panel.add(btnExp);
		
		JButton btnAns = new JButton("Ans");
		btnAns.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pulsado("Ans");
			}
		});
		panel.add(btnAns);
		
		JButton btnIgual = new JButton("=");
		btnIgual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pulsado("=");
			}
		});
		panel.add(btnIgual);
		
		mostrado = new JTextField();
		mostrado.setEditable(false);
		frame.getContentPane().add(mostrado, BorderLayout.NORTH);
		mostrado.setColumns(10);
	}
	public void pulsado(String i) {
		String aux=mostrado.getText();
		
		switch (i) {
		case "=":result=operate(aux);
			aux=String.valueOf(result);
			break;
		case "Ans":
			if(aux.isEmpty() || aux.length()<=0) {
				aux=String.valueOf(result);
			}else {
				aux+=String.valueOf(result);
			}
			break;
		case "AC":aux="";result=0;
			
			break;
		case "DEL":aux="";
			
			break;


		default:
			if(aux.isEmpty() || aux.length()<=0) {
				aux=i;
			}else {
				aux+=i;
			}
			break;
		}
		
		
		mostrado.setText(aux);
		
	}
	private double operate(String aux ) {
		char[] arr=aux.toCharArray();
		String num1aux="";
		String num2aux="";
		boolean signo=false;
		char signoL = 0;
		
		for(int i=0;i<arr.length;i++) {
		
			if(String.valueOf(arr[i]).equals("+") ||String.valueOf(arr[i]).equals("-")  ||String.valueOf(arr[i]).equals("/") ||String.valueOf(arr[i]).equals("x") ) {
				signo=true;
				signoL=arr[i];
				System.out.println("eee- "+signoL);
			}else {
				if(signo) {
					num2aux+=arr[i];
				}else
					num1aux+=arr[i];
			}
		}
		
		num1=Double.valueOf(num1aux);
		num2=Double.valueOf(num2aux);
		
		switch(signoL) {
			case '+':return num1+num2;
			case '-':return num1-num2;
			case 'x':return num1*num2;
			case '/':return num1/num2;
		}
		return 0;
	}
}
