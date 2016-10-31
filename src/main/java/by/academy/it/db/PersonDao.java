/*
 * Copyright (c) 2012 by VeriFone, Inc.
 * All Rights Reserved.
 *
 * THIS FILE CONTAINS PROPRIETARY AND CONFIDENTIAL INFORMATION
 * AND REMAINS THE UNPUBLISHED PROPERTY OF VERIFONE, INC.
 *
 * Use, disclosure, or reproduction is prohibited
 * without prior written approval from VeriFone, Inc.
 */
package by.academy.it.db;

import by.academy.it.db.exceptions.DaoException;
import by.academy.it.loader.PersonLoader;
import by.academy.it.pojos.Person;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import static by.academy.it.loader.PersonLoader.util;

/**
 * User: yslabko
 * Date: 14.04.14
 * Time: 13:05
 */
public class PersonDao extends BaseDao<Person> {

    private static Logger log = Logger.getLogger(PersonDao.class);

    public void flush(Integer id, String newName) throws DaoException {
        try {
            Session session = util.getSession();
            Person p = (Person)session.get(Person.class, id);
            System.out.println(p);
            p.setName(newName);
            System.out.println(p);
            session.flush();
            System.out.println(p);
        } catch (HibernateException e) {
            log.error("Error Flush person" + e);
            throw new DaoException(e);
        }

    }

}
