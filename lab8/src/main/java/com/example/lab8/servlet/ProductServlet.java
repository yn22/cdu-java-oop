package com.example.lab8.servlet;

import com.example.lab8.dao.ProductDao;
import com.example.lab8.dao.WoodDao;
import com.example.lab8.model.AbstractForm;
import com.example.lab8.model.Cylinder;
import com.example.lab8.model.Timber;
import com.example.lab8.model.Wood;
import com.example.lab8.util.SessionFactoryUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("action").equals("delete")) {
            deleteProduct(request);
        } else if (request.getParameter("action").equals("save")) {
            saveProduct(request);
        }
        response.sendRedirect(request.getContextPath() + "/");
    }

    protected void deleteProduct(HttpServletRequest request) {
        ProductDao productDao = new ProductDao(SessionFactoryUtil.getSessionFactory().openSession());
        productDao.delete(Long.parseLong(request.getParameter("id")));
    }

    private void saveProduct(HttpServletRequest request) throws ServletException {
        try {
            AbstractForm product = createProduct(request);
            ProductDao productDao = new ProductDao(SessionFactoryUtil.getSessionFactory().openSession());
            productDao.save(product);
        } catch (Exception e) {
            throw new ServletException("Cannot save product");
        }
    }

    private AbstractForm createProduct(HttpServletRequest req) throws Exception {
        String type = req.getParameter("type");
        String woodId = req.getParameter("woodId");
        String length = req.getParameter("length");
        String diameter = req.getParameter("diameter");
        String width = req.getParameter("width");
        String height = req.getParameter("height");
        WoodDao woodDao = new WoodDao(SessionFactoryUtil.getSessionFactory().openSession());
        Wood wood = woodDao.getById(Integer.parseInt(woodId));

        switch (type) {
            case "TIMBER":
                return new Timber(wood, Float.parseFloat(length), Float.parseFloat(width), Float.parseFloat(height));
            case "CYLINDER":
                return new Cylinder(wood, Float.parseFloat(length), Float.parseFloat(diameter));
            default:
                throw new Exception("Unknown product type.");
        }
    }
}
