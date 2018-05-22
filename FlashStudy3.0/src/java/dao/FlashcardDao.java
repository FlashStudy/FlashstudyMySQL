package dao;

import java.util.List;
import model.Flashcard;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class FlashcardDao {

    private final Session sessao;
    private HibernateSessionFactory factory;

    public FlashcardDao() {
        sessao = factory.getSessao().openSession();
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

    public List<Flashcard> getByEmail(String email) {
        List<Flashcard> cards = null;

        Query consulta = sessao.createQuery("from Flashcard where usuario_email = ?");

        cards = consulta.setString(0, email).list();

        sessao.flush();
        sessao.clear();
        sessao.getTransaction().commit();

        sessao.close();

        return cards;
    }
}
