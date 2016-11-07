package by.academy.it.db;

import by.academy.it.db.exceptions.DaoException;
import by.academy.it.pojos.Worker;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import static by.academy.it.loader.PersonLoader.util;

/**
 * Created by Dmitry on 11/7/2016.
 */
public class WorkerDao extends BaseDao<Worker> {

    private static Logger log = Logger.getLogger(WorkerDao.class);

    public void flush(Integer id, String newName) throws DaoException {
        try {
            Session session = util.getSession();
            setTransaction(session.beginTransaction());
            Worker worker = (Worker)session.get(Worker.class, id);
            System.out.println(worker);
            System.out.println("isDirty = " + session.isDirty());
            worker.setName(newName);
            System.out.println(worker);
            System.out.println("isDirty = " + session.isDirty());
            session.flush();
            System.out.println(worker);
            System.out.println("isDirty = " + session.isDirty());
            getTransaction().commit();
        } catch (HibernateException e) {
            log.error("Error Flush worker" + e);
            throw new DaoException(e);
        }

    }

    public void refresh(Integer id, String newName) throws DaoException {
        try {
            Session session = util.getSession();
            Worker worker = (Worker)session.get(Worker.class, id);
            System.out.println(worker);
            System.out.println("isDirty = " + session.isDirty());
            worker.setName(newName);
            System.out.println(worker);
            System.out.println("isDirty = " + session.isDirty());
            session.refresh(worker);
            System.out.println(worker);
            System.out.println("isDirty = " + session.isDirty());
        } catch (HibernateException e) {
            log.error("Error Refresh worker" + e);
            throw new DaoException(e);
        }

    }

}
