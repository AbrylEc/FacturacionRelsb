/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sys.dao.VendedorDAO;
import sys.modelo.Vendedor;
import sys.util.HibernateUtil;

public class VendedorDAOImpl implements VendedorDAO {

    @Override
    public List<Vendedor> select() {
        List<Vendedor> vendedores = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        /*Después de FROM colocamos el nombre del objeto de la app*/
        String hql = "FROM Vendedor";
        try {
            vendedores = session.createQuery(hql).list();
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
        return vendedores;
    }

    @Override
    public void insert(Vendedor vendedor) {
        /*Se coloca la siguiente línea  */
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(vendedor);
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
    public void update(Vendedor vendedor) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(vendedor);
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
    public void delete(Vendedor vendedor) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(vendedor);
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
