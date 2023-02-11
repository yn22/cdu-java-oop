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

import java.io.IOException;

@WebServlet("/")
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDao productDao = new ProductDao(SessionFactoryUtil.getSessionFactory().openSession());
        request.setAttribute("products", productDao.getAll());
        WasteDao wasteDao = new WasteDao(SessionFactoryUtil.getSessionFactory().openSession());
        request.setAttribute("waste", wasteDao.getAll());
        WoodDao woodDao = new WoodDao(SessionFactoryUtil.getSessionFactory().openSession());
        request.setAttribute("woods", woodDao.getAll());
        request.setAttribute("wasteWeight", wasteDao.getTotalWeight());

        request.getRequestDispatcher("/WEB-INF/page/index.jsp").forward(request, response);
    }
}
