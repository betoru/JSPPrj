package com.betoru.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hi")
public class Betoru extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //내가 사용하는 문자열의 인코딩방식을 설정하고
        resp.setCharacterEncoding("UTF-8");
        //이 문자열을 받을 브라우저가 내가 어떤 인코딩방식으로 세팅했는지 알려주는 것
        resp.setContentType("text/html; charSet=UTF-8");
        PrintWriter out = resp.getWriter();
        //파라미터는 무조건 문자열로 반환하기 때문에 사용에 필요한 올바른 형변환을 해줘야함.
        int cnt = 10;
        String temp = req.getParameter("cnt");
        if(temp != null && !temp.equals("")){
            cnt = Integer.parseInt(temp);
        }
        for (int i = 0; i <cnt ; i++) {
            out.println((i+1)+" : 안녕<br>");
        }
    }
}