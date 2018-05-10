/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Usuario;
import org.hibernate.Session;

/**
 *
 * @author Bruno
 */
public class UsuarioDao {
    private Session sessao;
    private HibernateSessionFactory factory;
    
    public UsuarioDao() {
    }
    
    public int salvar (Usuario us){
        
        try{
            sessao = factory.getSessao().openSession();
            
            sessao.beginTransaction();

            sessao.save(us);

            sessao.getTransaction().commit();

            sessao.close();
            
            return 0;
        }catch(Exception e){
            return 1;
        }
    }
    
    public Usuario procuraEmail (String email){
        Usuario usuario = new Usuario();
        
        try{
            sessao = factory.getSessao().openSession();
            
            sessao.beginTransaction();
            usuario = (Usuario) sessao.createQuery("from tbUsuario where email = '" + email +"'");
            
        }catch(Exception sqlException) {
            sqlException.printStackTrace();
        } finally {
            if(sessao != null) {
                sessao.close();
            }
        }
        return usuario;

    }
    
}
