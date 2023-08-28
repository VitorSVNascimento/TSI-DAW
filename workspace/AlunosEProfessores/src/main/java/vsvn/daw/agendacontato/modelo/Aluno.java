package vsvn.daw.agendacontato.modelo;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Aluno {

	private Long id;
	private String nome;
	private String email;
	private String endereco;
	private Calendar datanascimento;
	public Aluno() {

	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Calendar getDatanascimento() {
		return datanascimento;
	}
	public void setDatanascimento(Calendar datanascimento) {
		this.datanascimento = datanascimento;
	}
	@Override
	public String toString() {
		  StringBuilder aluno = new StringBuilder();
		  			aluno.append(String.format("\nID: %d |Nome: %s", id,nome));
		  			aluno.append(String.format("\nEmail: %s",email));
		  			aluno.append(String.format("\nEndere�o: %s",endereco));
		  			 DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		  			 
		  			aluno.append(String.format("\nData de Nascimento: %s",df.format(datanascimento.getTime())));
		  			aluno.append(String.format("\n---------------------------------------------------------\n"));
		  			return aluno.toString();
	}
	
	
	
}
