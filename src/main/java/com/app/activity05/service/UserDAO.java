package com.app.activity05.service;

import com.app.activity05.entity.User;
import com.app.activity05.utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.mindrot.jbcrypt.BCrypt;

public class UserDAO {

    public User authenticate(String username, String password) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        String hql = "from User where username= ?1";
        Query<User> query = session.createQuery(hql, User.class);
        query.setParameter(1, username);
        User user = query.getSingleResultOrNull();

        if (user != null && BCrypt.checkpw(password, user.getPassword())) {
            return user;
        } else {
            return null;
        }
    }
    
    
}