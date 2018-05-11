/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Flashcard;
import org.hibernate.Session;

/**
 *
 * @author Bruno
 */
public class FlashcardDao {
    private Session sessao;
    private HibernateSessionFactory factory;
    
    public FlashcardDao() {
    }
    
    public int salvar (Flashcard card){
        
        try{
            sessao = factory.getSessao().openSession();
            
            sessao.beginTransaction();

            sessao.save(card);

            sessao.getTransaction().commit();

            sessao.close();
            
            return 0;
        }catch(Exception e){
            return 1;
        }
    }
}
