package dao;

import model.Wood;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
        return session.createQuery("FROM model.Wood", Wood.class).list();
    }
    public void update(Wood wood) {
        Transaction transaction = session.beginTransaction();
        session.update(wood);
        transaction.commit();
    }
    public void delete(Wood wood) {
        Transaction transaction = session.beginTransaction();
        session.delete(wood);
        transaction.commit();
    }
}
