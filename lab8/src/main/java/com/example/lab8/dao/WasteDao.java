package com.example.lab8.dao;

import com.example.lab8.model.Waste;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class WasteDao {
    private final Session session;

    public WasteDao(Session session) {
        this.session = session;
    }

    public List<Waste> getAll() {
        return session.createQuery("FROM com.example.lab8.model.Waste", Waste.class).list();
    }

    public void save(Waste waste) {
        Transaction transaction = session.beginTransaction();
        session.save(waste);
        transaction.commit();
    }

    public void update(Waste waste) {
        Transaction transaction = session.beginTransaction();
        session.update(waste);
        transaction.commit();
    }

    public void delete(Long wasteId) {
        Transaction transaction = session.beginTransaction();
        Waste waste = session.get(Waste.class, wasteId);
        session.delete(waste);
        transaction.commit();
    }

    public double getTotalWeight() {
        Query q = session.createQuery("SELECT SUM(weight) FROM com.example.lab8.model.Waste", Double.class);
        Double res = (Double) q.getSingleResult();
        return res == null ? 0 : res;
    }
}
