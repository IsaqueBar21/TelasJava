package classes;

public class Aluno {

	public String nome;
	public float nota1;
	public float nota2;
	public float media;
	private Object statusAluno;
	
	//construtor
	public Aluno(String nome, float nota1, float nota2, float media) {
		super();
		this.nome = nome;
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.media = media;
	}
	
	//metodos
	public String mostrarDados() {
		return "Nome: " + this.nome
				+ "\n1ª nota: " + this.nota1 
				+"\t2ª nota: " + this.nota2
				+"Média: " + this.media;			
	}
	
		
	public void calcularMedia() {
		this.media = (this.nota1 + this.nota2)/2;
	}
	
	public String verificarStatusAluno() {
		this.statusAluno = this.media >= 5 ? "Aprovado":"Reprovado";
		return nome;
	}
	
}

