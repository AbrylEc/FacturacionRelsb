package sys.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sys.dao.ProductoDAO;
import sys.modelo.Producto;
import sys.util.HibernateUtil;

public class ProductoDAOImpl implements ProductoDAO {

    @Override
    public List<Producto> select() {
        List<Producto> productos = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        /*Después de FROM colocamos el nombre del objeto de la app*/
        String hql = "FROM Producto";
        try {
            productos = session.createQuery(hql).list();
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
        return productos;
    }

    @Override
    public void insert(Producto producto) {
        /*Se coloca la siguiente línea  */
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(producto);
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
    public void update(Producto producto) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(producto);
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
    public void delete(Producto producto) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(producto);
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
