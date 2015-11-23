package br.com.projetooi.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.transaction.Transactional;

import br.com.projetooi.model.usuario.Usuario;
import br.com.projetooi.utils.EmailUtils;


public class UsuarioController extends DefaultController {
    @PersistenceContext(unitName = "ProjetoOiPU", type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;

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
     	EntityManagerFactory emf =  Persistence.createEntityManagerFactory("ProjetoOiPU");
     	EntityManager em = emf.createEntityManager();
     	Usuario usuario = new Usuario();
     	usuario.setIdUsuario(idUsuario);
     	Usuario u = (Usuario)entityManager.find(Usuario.class, idUsuario);
     	
     	entityManager.getTransaction().begin();
     	u.setIsAtivado("S");
//     	em.flush();
     	entityManager.getTransaction().commit();
     	return u;
 	}

}
