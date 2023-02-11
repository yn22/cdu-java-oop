package dao;

import model.Waste;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class WasteDao {
    private final Session session;
    public WasteDao(Session session) {
        this.session = session;
    }
    public List<Waste> getAll() {
        return session.createQuery("FROM model.Waste", Waste.class).list();
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
    public void delete(Waste waste) {
        Transaction transaction = session.beginTransaction();
        session.delete(waste);
        transaction.commit();
    }
}
