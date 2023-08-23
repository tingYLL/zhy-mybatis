package com.jdjm.controller;


import com.jdjm.service.AccountService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/transfer")
public class AccountController extends HttpServlet {

    private AccountService accountService;

    /**
     *
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String from  = req.getParameter("fromActno");
        String to = req.getParameter("toActno");
        Double money = Double.parseDouble(req.getParameter("money"));
        accountService.transfer(from,to,money);
    }
}
