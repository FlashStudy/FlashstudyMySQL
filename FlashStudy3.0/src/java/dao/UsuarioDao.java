package dao;

import model.Usuario;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class UsuarioDao {

    private final Session sessao;
    private HibernateSessionFactory factory;

    public UsuarioDao() {
        sessao = factory.getSessao().openSession();
    }

    public int salvar(Usuario us) {

        try {
            sessao.beginTransaction();

            sessao.save(us);

            sessao.flush();
            sessao.clear();
            sessao.getTransaction().commit();

            sessao.close();

            return 0;
        } catch (HibernateException e) {
            return 1;
        }
    }

    public Usuario procuraEmail(String email) {
        Usuario usuario;

        sessao.beginTransaction();

        usuario = (Usuario) sessao.get(Usuario.class, email);

        sessao.flush();
        sessao.clear();
        sessao.getTransaction().commit();

        sessao.close();

        return usuario;

    }

}