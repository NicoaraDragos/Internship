package com.evozon.dao;

import com.evozon.domain.Address;
import com.evozon.domain.User;

import java.util.List;

/**
 * Created by dianamohanu on 11/07/2016.
 */
public interface AddressDAO {
    void addAddress(Address address);

    void addDefaultAddresses();

    List<Address> getAllAddresses();

    List<Address> getUserAddresses(User user);

    List<Address> getOnlyDeliveryAddresses(User user);
}
