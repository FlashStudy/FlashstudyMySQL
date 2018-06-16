package dao;

import java.util.List;
import model.Cronograma;
import model.Disciplina;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class CronogramaDao {

    private final Session sessao;

    public CronogramaDao() {
        sessao = HibernateSessionFactory.getSessao().openSession();
    }

    public int salvar(Cronograma cronograma) {

        try {

            sessao.beginTransaction();

            sessao.save(cronograma);
            for (Disciplina d : cronograma.getDisciplinas()) {
                sessao.save(d);
            }
            sessao.flush();
            sessao.clear();
            sessao.getTransaction().commit();

            sessao.close();

            return 0;
        } catch (HibernateException e) {
            e.printStackTrace();
            return 1;
        }
    }

    public Cronograma getByEmail(String email) {
        Cronograma cronograma;

        sessao.beginTransaction();

        Query consulta = sessao.createQuery("from Cronograma where usuario_email = ?");
        consulta.setParameter(0, email);

        List<Cronograma> cronogramas = consulta.list();

        if (!cronogramas.isEmpty()) {
            cronograma = cronogramas.get(0);
        } else {
            cronograma = new Cronograma();
        }

        sessao.flush();
        sessao.clear();
        sessao.getTransaction().commit();

        sessao.close();

        return cronograma;

    }
}
