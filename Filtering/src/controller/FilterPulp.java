package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpResponse;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class FilterPulp
 */
@WebFilter("/FilterPulp")
public class FilterPulp implements Filter {

    /**
     * Default constructor. 
     */
    public FilterPulp() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		String message = request.getParameter("message");
		System.out.println("Message before filter: " + message);
		
		message = message.replace("pulp", "no pulp!");
		// pass the request along the filter chain
		request.setAttribute("message", message);
		PrintWriter out = response.getWriter();
		out.write("<br />This was a filtered message. Check your console...");
		chain.doFilter(request, response);
		System.out.println("Message after filter: " + message);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
