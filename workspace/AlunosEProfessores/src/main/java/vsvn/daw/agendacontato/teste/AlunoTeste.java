package vsvn.daw.agendacontato.teste;

import java.util.Calendar;
import java.util.Scanner;

import vsvn.daw.agendacontato.dao.AlunoDAO;
import vsvn.daw.agendacontato.modelo.Aluno;

public class AlunoTeste {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Aluno aluno = new Aluno();
		AlunoDAO aldao = new AlunoDAO();
		
	while(true) {	
		System.out.printf("\nO que deseja fazer\n1-Cadastrar Aluno\n2-Alterar Aluno\n3-Remover Aluno\n4-Listar Alunos\n5-Sair");
		int opcao = sc.nextInt();
		
		if(opcao == 5 ) {
			System.out.println("Finalizando aplica��o");
			sc.close();
			return;
		}
	
		switch(opcao) {
		
		case 1:
			

			sc.nextLine();
			System.out.println("Forneca o nome:");
			aluno.setNome(sc.nextLine()); 
			
			System.out.println("Forneca o email:");
			aluno.setEmail(sc.nextLine());
			
			System.out.println("Forneca o endere�o:");
			aluno.setEndereco(sc.nextLine()); 
			
			aluno.setDatanascimento(Calendar.getInstance());
			
			
			aldao.adiciona(aluno);
			
			break;
			
		case 2:
			
			System.out.println("Forneca o id do aluno que deseja alterar:");
			aluno.setId(sc.nextLong()); 
			sc.nextLine();
			System.out.println("Forneca o novo nome:");
			aluno.setNome(sc.nextLine()); 
			
			System.out.println("Forneca o novo email:");
			aluno.setEmail(sc.nextLine());
			
			System.out.println("Forneca o novo endere�o:");
			aluno.setEndereco(sc.nextLine()); 
			
			aluno.setDatanascimento(Calendar.getInstance());
			
			
			aldao.altera(aluno);
			break;
			
		case 3:
			
			System.out.println("Forneca o id do aluno que deseja remover:");
			aluno.setId(sc.nextLong()); 
			sc.nextLine();
			aldao.remove(aluno);
			break;
			
		case 4:
			
			System.out.println("------------------------LISTA DE ALUNOS--------------------------");
			for(Aluno alunos: aldao.getListaAluno()) {
			System.out.println(alunos.toString());
				
			}
			System.out.println("------------------------FIM DA LISTA--------------------------");
			break;
		}
	}
		

	}

}
