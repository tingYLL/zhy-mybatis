package com.jdjm.controller;

import com.jdjm.exceptionn.MoneyNoEnoughException;
import com.jdjm.exceptionn.TransferException;
import com.jdjm.service.AccountService;
import com.jdjm.service.impl.AccountServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @version v1.0
 * @Author zhy
 * Description 默认
 * @Date 2023-08-23-17:36:59
 */
@WebServlet("/transfer")
public class AccountController extends HttpServlet {
    // 为了让这个对象在其他方法中也可以用。声明为实例变量。
    private AccountService accountService = new AccountServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 获取表单数据
        String fromActno = request.getParameter("fromActno");
        String toActno = request.getParameter("toActno");
        double money = Double.parseDouble(request.getParameter("money"));
        try {
            // 调用service的转账方法完成转账。（调业务层）
            accountService.transfer(fromActno, toActno, money);
            // 程序能够走到这里，表示转账一定成功了。
            // 调用View完成展示结果。
            response.sendRedirect(request.getContextPath() + "/success.html");
        } catch (MoneyNoEnoughException e) {
            response.sendRedirect(request.getContextPath() + "/error1.html");
        } catch (TransferException e) {
            response.sendRedirect(request.getContextPath() + "/error2.html");
        } catch (Exception e){
            response.sendRedirect(request.getContextPath() + "/error2.html");
        }

    }
}
