package example;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/myservlet")
public class MyServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/plain");
        try (var out = res.getWriter()) {
            var sc = req.getServletConnection();
            out.println("getConnectionId()        : " + sc.getConnectionId());
            out.println("getProtocolConnectionId(): " + sc.getProtocolConnectionId());
            out.println("getProtocol()            : " + sc.getProtocol());
            out.println("isSecure()               : " + sc.isSecure());
            out.println("getRequestId()           : " + req.getRequestId());
            out.println("getProtocolRequestId()   : " + req.getProtocolRequestId());
        }
    }
}
