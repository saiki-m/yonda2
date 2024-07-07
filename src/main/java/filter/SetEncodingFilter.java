package filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;


/**
 * 	サーブレットクラスの文字エンコードを指定するフィルター
 */
@WebFilter( "/*" )
public class SetEncodingFilter implements Filter {
	
	public void init(FilterConfig fConfig) throws ServletException { }
		
		public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)  throws IOException, ServletException {
			
			request.setCharacterEncoding("UTF-8");	//ここの引数に指定する。
			
			chain.doFilter(request, response);
		}
		
	public void destroy() { }
}