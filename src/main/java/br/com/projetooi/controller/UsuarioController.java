package br.com.projetooi.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transactional;

import br.com.projetooi.model.SimpleEntityManager;
import br.com.projetooi.model.usuario.Usuario;
import br.com.projetooi.model.usuario.UsuarioDAO;
import br.com.projetooi.utils.EmailUtils;
import br.com.projetooi.utils.EntityManagerUtil;


public class UsuarioController extends DefaultController {
	private SimpleEntityManager simpleEntityManager;
	
	private UsuarioDAO usuarioDAO;
    
    public UsuarioController() {
    	simpleEntityManager = new SimpleEntityManager("ProjetoOiPU");
    	usuarioDAO = new UsuarioDAO(simpleEntityManager.getEntityManager());
	}

    @Transactional
 	public void saveUsuario(Usuario usuario) throws Exception{
     	EntityManagerFactory emf =  Persistence.createEntityManagerFactory("ProjetoOiPU");
     	EntityManager em = emf.createEntityManager();
     	Usuario u = (Usuario)em.find(Usuario.class, 1);
     	em.getTransaction().begin();
     	em.persist(usuario);
     	em.flush();
     	em.getTransaction().commit();
     	
     	String assunto = "Confirmação de cadastro";
     	StringBuilder conteudo = new StringBuilder();
     	conteudo.append("<h1>Confirmação de cadastro</h1><br>");
     	conteudo.append("Olá ").append(usuario.getNome()).append(", Por favor, acesse o Link abaixo para confirmar seu cadastro.<br>");
     	conteudo.append("<a href='http://localhost:8080/ProjetoOi/user/confirmarUsuario?idUsuario="+usuario.getIdUsuario()+"'>Clique aqui</a>");
     	
     	EmailUtils.enviaEmail(usuario.getEmail(), conteudo.toString(), assunto);
 	}
    
    @Transactional
 	public Usuario confirmarUsuario(Integer idUsuario) throws Exception{
//     	EntityManagerFactory emf =  Persistence.createEntityManagerFactory("ProjetoOiPU");
//     	EntityManager em = emf.createEntityManager();
//     	Usuario usuario = new Usuario();
//     	usuario.setIdUsuario(idUsuario);
    	Usuario u = usuarioDAO.getById(idUsuario);
    	
    	try {
			
    		
    		simpleEntityManager.beginTransaction();
    		u.setIsAtivado("S");
    		usuarioDAO.save(u);
        } catch(Exception e){
            e.printStackTrace();
            simpleEntityManager.rollBack();
		} finally {
			simpleEntityManager.close();
		}
    	return u;
 	}

}
