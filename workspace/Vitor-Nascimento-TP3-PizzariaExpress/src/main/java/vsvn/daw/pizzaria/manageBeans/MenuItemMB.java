package vsvn.daw.pizzaria.manageBeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import vsvn.daw.pizzaria.dao.DAO;
import vsvn.daw.pizzaria.models.MenuItem;

@ViewScoped
@ManagedBean
public class MenuItemMB {

	private MenuItem menuItem = new MenuItem();
	private List<MenuItem> menuItens;
	
	public MenuItem getMenuItem() {
		return menuItem;
	}
	public void setMenuItem(MenuItem menuItem) {
		this.menuItem = menuItem;
	}
	public List<MenuItem> getMenuItens() {
		DAO<MenuItem> dao = new DAO<>(MenuItem.class);
		this.menuItens = dao.listaTodos();
		for(MenuItem item : menuItens)
			System.out.println("ID = "+item.getId());
		return menuItens;
	}
	public void setMenuItens(List<MenuItem> menuItens) {
		this.menuItens = menuItens;
	}
	
	
}
