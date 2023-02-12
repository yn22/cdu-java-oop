package com.example.lab8.dao;

import com.example.lab8.model.Wood;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.PersistenceException;
import java.util.List;

public class WoodDao {
    private final Session session;

    public WoodDao(Session session) {
        this.session = session;
    }

    public void save(Wood wood) {
        Transaction transaction = session.beginTransaction();
        session.save(wood);
        transaction.commit();
    }

    public List<Wood> getAll() {
        return session.createQuery("FROM com.example.lab8.model.Wood", Wood.class).list();
    }

    public Wood getById(int id) {
        return session.get(Wood.class, id);
    }

    public void update(Wood wood) {
        Transaction transaction = session.beginTransaction();
        session.update(wood);
        transaction.commit();
    }

    public void delete(Integer woodId) {
            Transaction transaction = session.beginTransaction();
            Wood wood = session.get(Wood.class, woodId);
            session.delete(wood);
            transaction.commit();
    }
}
