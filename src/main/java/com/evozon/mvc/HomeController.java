package com.evozon.mvc;

import com.evozon.dao.AddressDAO;
import com.evozon.dao.UserDAO;
import com.evozon.domain.Address;
import com.evozon.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private AddressDAO addressDAO;

    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        logger.info("Welcome home! The client locale is {}.", locale);

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime", formattedDate);

        userDAO.addDefaultUsers();

        model.addAttribute("users", userDAO.getAllUsers());

        addressDAO.addDefaultAddresses();

        model.addAttribute("addresses", addressDAO.getAllAddresses());

        return "home";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String processRequest(@RequestParam("user") int user, Model model) {
        User requested = new User();
        List<User> users = userDAO.getAllUsers();
        for (User u : users) {
            if (u.getId() == user) {
                requested = u;
            }
        }
        model.addAttribute("addresses2", addressDAO.getOnlyDeliveryAddresses(requested));

        return "home";
    }

    @RequestMapping(value = "/adduser", method = RequestMethod.GET)
    public String processRequestAddG(Model model) {

        return "addUser";
    }

    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    public String processRequestAdd(@RequestParam("firstname") String firstname, @RequestParam("lastname") String lastname, Model model) {
        User requested = new User(firstname, lastname);

        userDAO.addUser(requested);

        model.addAttribute("message", "User " + firstname + " added successfully!");

        return "addUser";
    }

    @RequestMapping(value = "/deleteuser", method = RequestMethod.GET)
    public String processRequestDeleteUser(Model model) {

        return "deleteUser";
    }

    @RequestMapping(value = "/deleteuser", method = RequestMethod.POST)
    public String processRequestDeleteUserPost(@RequestParam("id") Integer id, Model model) {
        userDAO.deleteUser(id);

        model.addAttribute("message", "User " + id + " deleted successfully!");

        return "deleteUser";
    }

}
