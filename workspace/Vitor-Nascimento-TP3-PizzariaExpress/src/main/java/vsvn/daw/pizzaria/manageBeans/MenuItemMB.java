package vsvn.daw.pizzaria.manageBeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import vsvn.daw.pizzaria.dao.DAO;
import vsvn.daw.pizzaria.dao.MenuItemDAO;
import vsvn.daw.pizzaria.models.MenuItem;

@ViewScoped
@ManagedBean
public class MenuItemMB {

	private MenuItem menuItem = new MenuItem();
	private List<MenuItem> menuItens;
	
	public void save() {
		DAO<MenuItem> dao = new DAO<>(MenuItem.class);
		menuItem.setAvailability(true);
		dao.adiciona(menuItem);
		
		this.menuItem = new MenuItem();
		this.menuItens = dao.listaTodos();
	}
	
	public void update() {
		DAO<MenuItem> dao = new DAO<>(MenuItem.class);
		dao.altera(menuItem);
		
		this.menuItem = new MenuItem();
		this.menuItens = dao.listaTodos();
	}
	
	public void cancel() {
		this.menuItem = new MenuItem();
	}
	
	
	public MenuItem getMenuItem() {
		return menuItem;
	}
	
	public void setMenuItem(MenuItem menuItem) {
		this.menuItem = menuItem;
	}
	
	public List<MenuItem> getMenuItens() {
		MenuItemDAO dao = new MenuItemDAO(MenuItem.class);
		this.menuItens = dao.getAllByCategory();
		for(MenuItem item : menuItens)
			System.out.println("ID = "+item.getId());
		return menuItens;
	}
	
	public List<MenuItem> getMenuItensAvailability() {
		MenuItemDAO dao = new MenuItemDAO(MenuItem.class);
		this.menuItens = dao.getAllIfAvaliability();
		for(MenuItem item : menuItens)
			System.out.println("ID = "+item.getId());
		return menuItens;
	}
	
	public void setMenuItens(List<MenuItem> menuItens) {
		this.menuItens = menuItens;
	}
	
	
}
