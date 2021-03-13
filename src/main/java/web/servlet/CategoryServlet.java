package web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Category;
import service.CategoryService;
import service.impl.CategoryServicempl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/categoryServlet/*")
public class CategoryServlet extends BaseServlet {
    private CategoryService service = new CategoryServicempl();

    public void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用service查询所有
        List<Category> cs = service.findAll();
        //序列化json返回
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),cs);
    }
    public void findByFlag(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用service查询所有
        List<Category> cs = service.findByFlag(request.getParameter("flag"));
        //序列化json返回
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),cs);
    }


}
