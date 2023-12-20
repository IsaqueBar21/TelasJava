package telas;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import classes.Aluno;

//atributos
public class TelaAluno extends JFrame {
	private JLabel jlNome, jlNota1, jlNota2;
	private JTextField jtfNome, jtfNota1, jtfNota2;
	private JButton jbCadastrar, jbMostrar;
	private Aluno aluno = null;

	public TelaAluno(String titulo) throws HeadlessException {
		super(titulo);
		setSize(400, 400);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		iniciarComponentes();
		criarEventos();
	
	
	}

	private void iniciarComponentes() {
		// objeto
		jlNome = new JLabel("Nome");
		jtfNome = new JTextField();
		
		jlNota1 = new JLabel("Nota 1");
		jtfNota1 = new JTextField();
		
		jlNota2 = new JLabel("Nota 2");
		jtfNota2 = new JTextField();
		
		jbCadastrar = new JButton("Cadastrar");
		jbMostrar = new JButton("Mostrar");
		
		
		
		//adicionar
		add(jlNome);
		add(jtfNome);
		
		add(jlNota1);
		add(jtfNota1);
		
		add(jlNota2);
		add(jtfNota2);
		
		add(jbCadastrar);
		add(jbMostrar);
		
		
		
		//dimensionamento
		jlNome.setBounds(10, 20, 50, 20); //coluna, linha, comprimento e largura
		jtfNome.setBounds(10, 40, 200, 20);
		
		jlNota1.setBounds(10, 70, 50, 20);
		jtfNota1.setBounds(10, 90, 50, 20);
		
		jlNota2.setBounds(160, 70, 50, 20);
		jtfNota2.setBounds(160, 90, 50, 20);
		
		jbCadastrar.setBounds(60, 120, 100, 20);
		jbMostrar.setBounds(60, 150, 100, 20);
	}

	private void criarEventos() {
		jbCadastrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				//declarar as variaveis
				String nome;
				float nota1, nota2;
				
				//entradas
				nome = jtfNome.getText();
				nota1 = Float.parseFloat(jtfNota1.getText());
				nota2 = Float.parseFloat(jtfNota2.getText());
				
				//objeto
				aluno = new Aluno(nome, nota1, nota2, nota2);
				
				//processamento
				aluno.calcularMedia();
				
				//apagar os campos
				jtfNome.setText("");
				jtfNota1.setText("");
				jtfNota2.setText("");
			
			}
		});//fim evento
		
		
		//criar evento do botao mostrar
		jbMostrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, aluno.mostrarDados() + "\n" + aluno.verificarStatusAluno());
				
			}
		});
	}

}
