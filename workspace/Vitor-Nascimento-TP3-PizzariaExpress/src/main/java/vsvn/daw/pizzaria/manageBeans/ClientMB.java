package vsvn.daw.pizzaria.manageBeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import vsvn.daw.pizzaria.dao.AddressDAO;
import vsvn.daw.pizzaria.dao.ClientDAO;
import vsvn.daw.pizzaria.email.PizzariaEmail;
import vsvn.daw.pizzaria.models.Address;
import vsvn.daw.pizzaria.models.Client;
import vsvn.daw.pizzaria.utilities.TokenGenerator;

@SessionScoped
@ManagedBean
public class ClientMB {
	private Client client = new Client();
	private Address address = new Address();

	public String loga() {
		ClientDAO clientDAO = new ClientDAO(Client.class);
		Client logedClient = clientDAO.findClientByEmail(client);
		
		if (logedClient == null) 
			newClient(clientDAO);
		else {
			client = logedClient;
			oldClient(clientDAO);
		}
			
		PizzariaEmail.sendConfirmationLinkToUser(client.getEmail(), client.getToken());
		client.setToken("");
		return "client-confirmation-token-page?faces-redirect=true";
		
	}
	
	private void newClient(ClientDAO clientDAO) {
		
		setNewToken(clientDAO);
		clientDAO.adiciona(client);
		
	}
	
	private void oldClient(ClientDAO clientDAO) {
		setNewToken(clientDAO);
		clientDAO.altera(client);
	}
	
	private void setNewToken(ClientDAO clientDAO) {
		do{
			client.setToken(TokenGenerator.generateToken());
			
		}while(clientDAO.tokenExists(client.getToken()));
	}
	
	public String validateToken() {
		ClientDAO clientDAO = new ClientDAO(Client.class);
		client = clientDAO.findClientByEmailAndToken(client);
		
		if(client == null) 
			return logout();
			
		if(isNewClient())
			return "client-register?faces-redirect=true";
		address = client.getAddress();
		return "client-order-page?faces-redirect=true";
		
	}
	
	public boolean isLogado() {
		return client.getEmail() != null;
	}
	
	public boolean isNewClient() {
		return client.getFullName() == null || client.getFullName().isBlank();
	}
	
	public String logout() {
		client = new Client();
		return "login-client?faces-redirect=true";
	}
	
	public String register() {
		ClientDAO clientDAO = new ClientDAO(Client.class);
		AddressDAO addressDAO = new AddressDAO(Address.class);
		Long idClient = clientDAO.findClientByEmail(client).getId();
		client.setId(idClient);
		
		addressDAO.adiciona(address);
		address.setId(addressDAO.findAddress(address).getId());
		client.setAddress(address);
		
		clientDAO.altera(client);
		return "client-order-page?faces-redirect=true";
		
	}
	
	public void updateData() {
		ClientDAO clientDAO = new ClientDAO(Client.class);
		AddressDAO addressDAO = new AddressDAO(Address.class);
		
		addressDAO.altera(address);
		clientDAO.altera(client);
	}
	
	
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address addres) {
		this.address = addres;
	}

	
	
}
