package jsoft;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class JI18nFilter implements JHttpFilter
{

	@Override
	public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		String lang= req.getParameter("lang");
		if(lang!=null)
		{
			
			req.getSession().setAttribute("lang", lang);
		}
		String url = req.getServletPath();
		System.out.println(url);
//		if(url.endsWith(".jsp") && !url.contains("index.jsp")) {
//			resp.sendRedirect("/home/");
//		}
		// TODO Auto-generated method stub
		chain.doFilter(req, resp);
	}
	
}
	


