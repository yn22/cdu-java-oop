package com.example.lab8.servlet;

import com.example.lab8.dao.WasteDao;
import com.example.lab8.model.Waste;
import com.example.lab8.util.SessionFactoryUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/waste")
public class WasteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("action").equals("delete")) {
            doDelete(req, resp);
        }
        else if (req.getParameter("action").equals("save")) {
            saveWaste(req);
        }
        resp.sendRedirect(req.getContextPath() + "/");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WasteDao wasteDao = new WasteDao(SessionFactoryUtil.getSessionFactory().openSession());
        wasteDao.delete(Long.parseLong(req.getParameter("id")));
    }

    private void saveWaste(HttpServletRequest req) {
        try {
            Waste waste = createWaste(req);
            WasteDao wasteDao = new WasteDao(SessionFactoryUtil.getSessionFactory().openSession());
            wasteDao.save(waste);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Waste createWaste(HttpServletRequest req) throws Exception {
        String weight = req.getParameter("weight");
        return new Waste(Float.parseFloat(weight));
    }
}
