//package web.filter;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//@WebFilter("/*")
//public class Filter implements javax.servlet.Filter {
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        String string = request.getRequestURL().toString();
//        String [] strings ={"/login.html","/index.html","/register.html","forget.html","/index.html","/managerSelect","/managerRegister","/userCheckCode","/loginCheckCode","managerExist","userFindCode","/css/","/img/","/element-ui/","/js/"};
//        for (String s : strings) {
//            if (string.contains(s)){
//                filterChain.doFilter(request,servletResponse);
//                return;
//            }
//        }
//        HttpSession session = request.getSession();
//        if (session.getAttribute("manager")==null){
//            request.getRequestDispatcher("/login.html").forward(request,servletResponse);
//        }
//        if (session.getAttribute("manager")!=null){
//            filterChain.doFilter(servletRequest,servletResponse);
//        }
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//}
