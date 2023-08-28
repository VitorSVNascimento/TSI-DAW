package vsvn.daw.agendacontato.teste;

import java.util.Scanner;

import vsvn.daw.agendacontato.dao.ProfessorDAO;
import vsvn.daw.agendacontato.modelo.Professor;

public class ProfessorTeste {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Professor professor = new Professor();
		ProfessorDAO profDAO = new ProfessorDAO();
		
	while(true) {	
		System.out.printf("\nO que deseja fazer\n1-Cadastrar Professor\n2-Alterar Professor\n3-Remover Professor\n4-Listar Professor\n5-Sair");
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
			professor.setNome(sc.nextLine()); 
			
			System.out.println("Forneca o email:");
			professor.setEmail(sc.nextLine());
			
			System.out.println("Forneca o grau de forma��o:");
			professor.setGrau_formacao(sc.nextLine()); 			
			
			profDAO.adiciona(professor);
			
			break;
			
		case 2:
			
			System.out.println("Forneca o id do professor que deseja alterar:");
			professor.setId(sc.nextLong()); 
			sc.nextLine();
			System.out.println("Forneca o novo nome:");
			professor.setNome(sc.nextLine()); 
			
			System.out.println("Forneca o novo email:");
			professor.setEmail(sc.nextLine());
			
			System.out.println("Forneca o novo Grau de Forma��o:");
			professor.setGrau_formacao(sc.nextLine()); 	 
			 
			
			
			profDAO.altera(professor);
			break;
			
		case 3:
			
			System.out.println("Forneca o id do professor que deseja remover:");
			professor.setId(sc.nextLong()); 
			sc.nextLine();
			profDAO.remove(professor);
			break;
			
		case 4:
			
			System.out.println("------------------------LISTA DE PROFESSORES--------------------------");
			for(Professor professores: profDAO.listaTodos()) {
			System.out.println(professores.toString());
				
			}
			System.out.println("------------------------FIM DA LISTA--------------------------");
			break;
		}
	}
		
		
	}

}
