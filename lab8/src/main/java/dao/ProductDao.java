package dao;

import model.AbstractForm;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ProductDao {
    private final Session session;
    public ProductDao(Session session) {
        this.session = session;
    }
    public void save(AbstractForm product) {
        Transaction transaction = session.beginTransaction();
        session.save(product);
        transaction.commit();
    }
    public List<AbstractForm> getAll() {
        return session.createQuery("FROM model.AbstractForm", AbstractForm.class).list();
    }
    public void update(AbstractForm product) {
        Transaction transaction = session.beginTransaction();
        session.update(product);
        transaction.commit();
    }
    public void delete(AbstractForm product) {
        Transaction transaction = session.beginTransaction();
        session.delete(product);
        transaction.commit();
    }
}
