package dao;

import java.util.ArrayList;
import model.Flashcard;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class FlashcardDao {

    private final Session sessao;

    public FlashcardDao() {
        sessao = HibernateSessionFactory.getSessao().openSession();
    }

    public int salvar(Flashcard card) {

        try {

            sessao.beginTransaction();

            sessao.save(card);

            sessao.flush();
            sessao.clear();
            sessao.getTransaction().commit();

            sessao.close();

            return 0;
        } catch (HibernateException e) {
            return 1;
        }
    }

    public ArrayList<Flashcard> getByEmail(String email) {
        ArrayList<Flashcard> cards;

        sessao.beginTransaction();
        
        Query consulta = sessao.createQuery("from Flashcard where usuario_email = ?");

        cards = (ArrayList) consulta.setString(0, email).list();

        sessao.flush();
        sessao.clear();
        sessao.getTransaction().commit();

        sessao.close();

        return cards;
    }
}
