package pl.edu.wszib.magazyn.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.magazyn.dao.IUserDAO;
import pl.edu.wszib.magazyn.model.User;

import javax.persistence.NoResultException;

@Repository
public class HibernateUserDAOImpl implements IUserDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public User getUserByLogin(String login) {
        Session session = sessionFactory.openSession();
        Query<User> query = session.createQuery("FROM pl.edu.wszib.magazyn.model.User WHERE login = :login ");
        query.setParameter("login", login);
        User result =null;
        try {
            result = query.getSingleResult();
        } catch (NoResultException e){
            System.out.println("User not found");
        }
        session.close();
        return result;
    }

    @Override
    public boolean persistUser(User user) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(user);
            tx.commit();
        } catch (Exception e){
            if(tx != null){
                tx.rollback();
            }
            return false;
        }
        finally {
            session.close();
        }
        return true;
    }
}
