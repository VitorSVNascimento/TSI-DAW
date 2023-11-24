package vsvn.daw.petshop.test;

import vsvn.daw.petshop.dao.DAO;
import vsvn.daw.petshop.models.Account;

public class JPATest {
	
	public static void main(String[] args) {
		jpaTeste();
	}

	public static void jpaTeste() {
		Account client = new Account();
		DAO<Account> dao = new DAO<>(Account.class);
		client.setName("Juvenal");
		dao.insert(client);
		
	}
	

}
