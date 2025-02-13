import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {
    public HelloServlet(){
        System.out.println("Hello Servlet Object");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.print("doGet() Method Call");
        PrintWriter out = response.getWriter();

        out.println("1ilsang.blog.me");
    }
}

