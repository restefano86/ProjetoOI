package br.com.projetooi.struts2;


import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import br.com.projetooi.controller.UsuarioController;
import br.com.projetooi.model.usuario.Usuario;

@Namespace(value = "/user")
public class UsuarioAction extends ActionSupport{

	private Usuario usuario;

	@Action(value="salvarUsuarioSite", results = @Result(name = "SUCESSO", location = "/site/cadastro.jsp"))
	public String salvarUsuarioSite() {
		try {
			UsuarioController userController = new UsuarioController();
			userController.saveUsuario(usuario);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "SUCESSO";
	}

	@Action(value="abrirCadUsuarioSite", results = @Result(name = "SUCESSO", location = "/site/cadastro.jsp"))
	public String abrirCadUsuarioSite() {
//		carros = dao.lista();
		return "SUCESSO";
	}

	@Action(value="confirmarUsuario", results = @Result(name = "SUCESSO", location = "/site/cadastro.jsp"))
	public String confirmarUsuario() {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			Integer idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
			UsuarioController usuarioController = new UsuarioController();
			Usuario usuario = usuarioController.confirmarUsuario(idUsuario);
			setUsuario(usuario);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return "SUCESSO";
	}


	@Action(value = "adiciona", results = @Result(name = "ok", type = "redirectAction", params = { "actionName", "lista" }))
	public String adiciona() {
//		dao.adiciona(carro);
		return "ok";
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}