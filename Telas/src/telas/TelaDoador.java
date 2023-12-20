package telas;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import classes.Doador;

public class TelaDoador extends JFrame {
	private JLabel jlNome, jlPeso, jlIdade, jlGenero;
	private JTextField jtfNome, jtfPeso, jtfIdade;
	private JButton jbCadastrar, jbMostrar;
	private JRadioButton jrbMasculino, jrbFeminino;
	private ButtonGroup bgGenero; //agrupa os radios buttons para que somente um seja selecionado
	private Doador doador = null;

	public TelaDoador(String title) throws HeadlessException {
		super(title);
		setSize(400, 400);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		iniciarComponentes();
		criarEventos();
	}

	private void iniciarComponentes() {
		// TODO Auto-generated method stub
		jlNome = new JLabel("Nome");
		jtfNome = new JTextField();
		
		jlPeso = new JLabel("Peso");
		jtfPeso = new JTextField();
		
		jlIdade = new JLabel("Idade");
		jtfIdade = new JTextField();
		
		jbCadastrar = new JButton("Cadastrar");
		jbMostrar = new JButton("Mostrar");
		
		jlGenero = new JLabel("G�nero");		
		jrbMasculino = new JRadioButton("Masculino");
		jrbFeminino = new JRadioButton("Feminino");
		bgGenero = new ButtonGroup();
		
		
		//adicionar
		add(jlNome);
		add(jtfNome);
		
		
		add(jlPeso);
		add(jtfPeso);
		
		add(jlIdade);
		add(jtfIdade);		
		
		add(jbCadastrar);
		add(jbMostrar);
		
		add(jlGenero);
		add(jrbMasculino);
		add(jrbFeminino);
		
		bgGenero.add(jrbMasculino);
		bgGenero.add(jrbFeminino);
		
		//dimensionamento
		jlNome.setBounds(10, 20, 50, 20); //coluna, linha, comprimento e largura
		jtfNome.setBounds(10, 40, 200, 20);
		
		jlPeso.setBounds(10, 90, 50, 20);
		jtfPeso.setBounds(10, 110, 50, 20);
		
		jlIdade.setBounds(160, 90, 50, 20);
		jtfIdade.setBounds(160, 110, 50, 20);
		
		jbCadastrar.setBounds(10, 140, 100, 20);
		jbMostrar.setBounds(130, 140, 80, 20);
		
		jlGenero.setBounds(250, 90, 100, 20);
		jrbMasculino.setBounds(250, 110, 100, 20);
		jrbFeminino.setBounds(250, 130, 100, 20);			
	
}
	

	private void criarEventos() {
		
		// criar evento bot�o cadastrar
		jbCadastrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//declara��o vari�veis
				String nome, genero;
				float peso;
				int idade;							
				
				if (!jtfNome.getText().isEmpty() && !jtfPeso.getText().isEmpty() && !jtfIdade.getText().isEmpty()) {
					
					//entradas
					nome = jtfNome.getText();
					peso = Float.parseFloat(jtfPeso.getText());
					idade = Integer.parseInt(jtfIdade.getText());
					
					if (jrbMasculino.isSelected()){
						genero = "Masculino";
					} else {
						genero = "Feminino";
					}
					/* decisao em ternario
					 genero = jrbMasculino.isSelected()? "Masculino":"Feminino";
					 */
					
					//objeto
					doador = new Doador(nome, genero, peso, idade);
					
					//apagar campos apos cadastrar
					jtfNome.setText("");
					jtfPeso.setText("");
					jtfIdade.setText("");
					
				} else {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos", "AVISO", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		
		
		//evento botao mostrar
		jbMostrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {				
				
				if (doador != null) {
					JOptionPane.showMessageDialog(null,	doador.mostrarDados() + "\n" + doador.mostrarQuantidadeSangue());
				} else {
					JOptionPane.showMessageDialog(null, "N�o possuem doadores cadastrados", "AVISO", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		
	}

}