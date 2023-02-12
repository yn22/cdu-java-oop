package com.example.lab8.servlet;

import com.example.lab8.dao.ProductDao;
import com.example.lab8.dao.WasteDao;
import com.example.lab8.dao.WoodDao;
import com.example.lab8.util.SessionFactoryUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;

import java.io.IOException;
import java.util.List;

@WebServlet("/")
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        ProductDao productDao = new ProductDao(session);
        WasteDao wasteDao = new WasteDao(session);
        WoodDao woodDao = new WoodDao(session);
        request.setAttribute(
                "data",
                new DataWrapper(productDao.getAll(), wasteDao.getAll(), woodDao.getAll(), wasteDao.getTotalWeight())
        );
        request.getRequestDispatcher("/WEB-INF/page/index.jsp").forward(request, response);
    }

    public static class DataWrapper {
        private final List products;
        private final List waste;
        private final List woods;
        private final double wasteWeight;

        public DataWrapper(List products, List waste, List woods, double wasteWeight) {
            this.products = products;
            this.waste = waste;
            this.woods = woods;
            this.wasteWeight = wasteWeight;
        }
        public List getProducts() {
            return products;
        }
        public List getWaste() {
            return waste;
        }
        public List getWoods() {
            return woods;
        }
        public double getWasteWeight() {
            return wasteWeight;
        }
    }
}
