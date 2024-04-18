package example;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    Cookie cookie(String name, String val, String sameSite) {
        Cookie c = new Cookie(name, val);
        c.setAttribute("SameSite", sameSite);
        c.setSecure(true);
        return c;
    }

    @RequestMapping(path = "/mycontroller", produces = "text/plain")
    public String hello(HttpServletRequest req, HttpServletResponse res) {

        res.addCookie(cookie("Name1", "123", "Strict"));
        res.addCookie(cookie("Name2", "456", "Lax"));
        res.addCookie(cookie("Name3", "789", "None"));

        return "cookies: " + req.getHeader("Cookie")
                + "\nsession id: " + req.getSession().getId();
    }
}
