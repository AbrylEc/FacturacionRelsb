package sys.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sys.dao.ClienteDAO;
import sys.modelo.Cliente;
import sys.util.HibernateUtil;

public class ClienteDAOImpl implements ClienteDAO {

    @Override
    public List<Cliente> select() {
        List<Cliente> clientes = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        /*Después de FROM colocamos el nombre del objeto de la app*/
        String hql = "FROM Cliente";
        try {
            clientes = session.createQuery(hql).list();
            trans.commit();
            //session.close(); 
        } catch (Exception ex) {
            ex.printStackTrace();
            trans.rollback();
            /*finally se coloca en lugar de session.close para
            que permita ejecutar todas las líneas y únicamente
            si está todo correcto, se terminará la acción.*/
        } finally {
            session.close();
        }
        return clientes;
    }

    @Override
    public void insert(Cliente cliente) {
        /*Se coloca la siguiente línea  */
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(cliente);
            session.getTransaction().commit();
           // session.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Cliente cliente) {
         Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(cliente);
            session.getTransaction().commit();
           // session.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(Cliente cliente) {
          Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(cliente);
            session.getTransaction().commit();
           // session.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }
}
