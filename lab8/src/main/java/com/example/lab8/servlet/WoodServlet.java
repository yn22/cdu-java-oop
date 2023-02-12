package com.example.lab8.servlet;

import com.example.lab8.dao.WoodDao;
import com.example.lab8.model.Wood;
import com.example.lab8.util.SessionFactoryUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.persistence.PersistenceException;
import java.io.IOException;

@WebServlet("/wood")
public class WoodServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("action").equals("delete")) {
            deleteWood(req);
        }
        else if (req.getParameter("action").equals("save")) {
            saveWood(req);
        }
        resp.sendRedirect(req.getContextPath() + "/");
    }

    protected void deleteWood(HttpServletRequest req) throws ServletException, IOException {
        try {
        WoodDao woodDao = new WoodDao(SessionFactoryUtil.getSessionFactory().openSession());
        woodDao.delete(Integer.parseInt(req.getParameter("id")));
        } catch (PersistenceException e) {
            throw new ServletException("Cannot delete wood because it is used in products");
        }
    }

    private void saveWood(HttpServletRequest req) {
        try {
            Wood wood = createWood(req);
            WoodDao woodDao = new WoodDao(SessionFactoryUtil.getSessionFactory().openSession());
            woodDao.save(wood);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Wood createWood(HttpServletRequest req) throws Exception {
        String name = req.getParameter("name");
        String density = req.getParameter("density");
        return new Wood(name, Float.parseFloat(density));
    }
}
