package com.javarush.shevchenko.dao;

import java.util.List;
import org.hibernate.query.Query;
import org.hibernate.SessionFactory;
import com.javarush.shevchenko.domain.Country;

public class CountryDAO {
    private final SessionFactory sessionFactory;

    public CountryDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Country> getAll() {
        Query<Country> query = sessionFactory.getCurrentSession().createQuery("select c from Country c join fetch c.languages", Country.class);
        return query.list();
    }
}
