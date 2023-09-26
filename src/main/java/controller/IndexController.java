package controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class IndexController implements Serializable {

	private static final long serialVersionUID = -3176307559028924604L;

	public String goToClientPage() {
	    return "/cliente/list.xhtml";
	}
	
	public String goToProdutoPage() {
	    return "/produto/list.xhtml";
	}
	
	public String goToHomePage() {
	    return "/index.xhtml";
	}
}
