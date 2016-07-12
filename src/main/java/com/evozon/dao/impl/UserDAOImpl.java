package com.evozon.dao.impl;

import com.evozon.dao.UserDAO;
import com.evozon.domain.Address;
import com.evozon.domain.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;


@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void addUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    public List<User> getAllUsers() {
        Session session = sessionFactory.getCurrentSession();
        List<User> users = session.createQuery("FROM User as U").list();
        return users;
    }

    public void addDefaultUsers() {
        User user1 = new User("Mark", "Rivers");
        User user2 = new User("John", "Doe");
        User user3 = new User("Alan", "Turing");

        List<User> users = getAllUsers();
        if (CollectionUtils.isEmpty(users)) {
            addUser(user1);
            addUser(user2);
            addUser(user3);
        }
    }

    public void deleteUser(int id) {
        Session session = sessionFactory.getCurrentSession();

        String hql = "delete from User where id = :id";
        Query query = session.createQuery(hql);
        query.setInteger("id", id);

        int rowCount = query.executeUpdate();
        System.out.println("Rows affected: " + rowCount);
    }

}
