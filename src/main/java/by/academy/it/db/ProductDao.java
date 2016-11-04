package by.academy.it.db;

import by.academy.it.db.exceptions.DaoException;
import by.academy.it.pojos.Product;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import static by.academy.it.loader.PersonLoader.util;

/**
 * Created by Dmitry on 11/3/2016.
 */
public class ProductDao extends BaseDao<Product> {

    private static Logger log = Logger.getLogger(ProductDao.class);

    public void flush(Integer id, String newNameProduct) throws DaoException {
        try {
            Session session = util.getSession();
            setTransaction(session.beginTransaction());
            Product p = (Product)session.get(Product.class, id);
            System.out.println(p);
            System.out.println("isDirty = " + session.isDirty());
            p.setNameProduct(newNameProduct);
            System.out.println(p);
            System.out.println("isDirty = " + session.isDirty());
            session.flush();
            System.out.println(p);
            System.out.println("isDirty = " + session.isDirty());
            getTransaction().commit();
        } catch (HibernateException e) {
            log.error("Error Flush person" + e);
            throw new DaoException(e);
        }

    }

    public void refresh(Integer id, String newNameProduct) throws DaoException {
        try {
            Session session = util.getSession();
            Product p = (Product)session.get(Product.class, id);
            System.out.println(p);
            System.out.println("isDirty = " + session.isDirty());
            p.setNameProduct(newNameProduct);
            System.out.println(p);
            System.out.println("isDirty = " + session.isDirty());
            session.refresh(p);
            System.out.println(p);
            System.out.println("isDirty = " + session.isDirty());
        } catch (HibernateException e) {
            log.error("Error Refresh person" + e);
            throw new DaoException(e);
        }

    }

}
