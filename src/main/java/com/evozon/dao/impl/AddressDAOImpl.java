package com.evozon.dao.impl;

import com.evozon.dao.AddressDAO;
import com.evozon.domain.Address;
import com.evozon.domain.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dianamohanu on 11/07/2016.
 */
@Repository("addressDAO")
@Transactional
public class AddressDAOImpl implements AddressDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public void addAddress(Address address) {
        Session session = sessionFactory.getCurrentSession();
        session.save(address);
    }

    public List<Address> getAllAddresses() {
        Session session = sessionFactory.getCurrentSession();
        List<Address> addresses = session.createQuery("FROM Address as A").list();
        return addresses;
    }

    public List<Address> getUserAddresses(User user) {
        Session session = sessionFactory.getCurrentSession();

        String hql = "FROM Address A WHERE A.user = " + user.getId();
        Query query = session.createQuery(hql);
        List results = query.list();

        return results;
    }

    public List<Address> getOnlyDeliveryAddresses(User user) {
        List<Address> addressesForThisUser = this.getUserAddresses(user);
        List<Address> addresses = new ArrayList<Address>();

        for (Address a : addressesForThisUser) {
            if (a.getType().equals("delivery")) {
                addresses.add(a);
            }
        }

        return addresses;
    }

    public void addDefaultAddresses() {
        Address address1 = new Address("Dumbravii", 24, "building");
        Address address2 = new Address("Cetatii", 8, "building");
        Address address3 = new Address("Bucuresti", 102, "delivery");

        List<Address> addresses = getAllAddresses();
        if (CollectionUtils.isEmpty(addresses)) {
            addAddress(address1);
            addAddress(address2);
            addAddress(address3);
        }
    }

//    public void addUserToAddress(Address address, User user) {
//        address.setUser(user);
//    }
}
