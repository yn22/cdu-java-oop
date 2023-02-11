import com.example.lab8.dao.ProductDao;
import com.example.lab8.dao.WasteDao;
import com.example.lab8.dao.WoodDao;
import com.example.lab8.model.*;
import com.example.lab8.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class Main {
    SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .buildSessionFactory();
    public static void main(String[] args) throws Exception {
       Main main = new Main();
         main.run();
    }

    private void run() {
        try {
//            this.test1();
//            this.test2();
//            this.test3();
            this.test4();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            factory.close();
        }
    }

    private void test1() throws Exception {
        Session session = factory.openSession();
        session.beginTransaction();
        List<Wood> wood = new ArrayList<>() {{
            add(new Wood("Oak", 0.7f));
            add(new Wood("Beech", 0.5f));
            add(new Wood("Pine", 0.3f));
        }};
        List<IWeight> products = new ArrayList<>() {{
            add(new Timber(wood.get(0), 2, 0.5f, 0.2f));
            add(new Timber(wood.get(1), 1, 0.5f, 0.2f));
            add(new Timber(wood.get(2), 3, 0.5f, 0.2f));
            add(new Cylinder(wood.get(0), 2, 0.5f));
            add(new Cylinder(wood.get(1), 1, 0.5f));
            add(new Cylinder(wood.get(2), 3, 0.5f));
            add(new Waste(0.02f));
            add(new Waste(0.05f));
            add(new Waste(0.1f));
        }};

        wood.forEach(session::save);
        products.forEach(session::save);

        String productQuery = "FROM com.example.lab8.model.AbstractForm";
        String wasteQuery = "FROM com.example.lab8.model.Waste";
        Query query = session.createQuery(productQuery);
        query.getResultList().forEach(System.out::println);
        query = session.createQuery(wasteQuery);
        query.getResultList().forEach(System.out::println);

        session.getTransaction().commit();
        session.close();
    }

    private void test2() throws Exception {
        WasteDao wasteDao = new WasteDao(factory.openSession());
        wasteDao.getAll().forEach(System.out::println);
        wasteDao.save(new Waste(0.02f));
        wasteDao.getAll().forEach(System.out::println);
    }

    private void test3() {
        WoodDao woodDao = new WoodDao(factory.openSession());
        woodDao.getAll().forEach(System.out::println);
        woodDao.save(new Wood("Cherry", 0.7f));
        woodDao.getAll().forEach(System.out::println);
    }

    private void test4() throws Exception {
        ProductDao productDao = new ProductDao(factory.openSession());
        productDao.getAll().forEach(System.out::println);
        List<Wood> wood =new WoodDao(factory.openSession()).getAll();

        productDao.save(new Timber(wood.get(0), 2, 0.5f, 0.2f));
        productDao.save(new Timber(wood.get(1), 1, 0.5f, 0.2f));
        productDao.save(new Cylinder(wood.get(2), 2, 0.5f));
        productDao.save(new Cylinder(wood.get(3), 1, 0.5f));

        productDao.getAll().forEach(System.out::println);
    }
}