//https://www.sejuku.net/blog/24926
//https://magazine.techacademy.jp/magazine/9246

package model;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;


/**
 * 
 * 
 * 戻り値； JSPで入力した情報が入ったマップ
 */
public class GetParameterFromJSP extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static Map<String, String> get(HttpServletRequest request, String... get) throws ServletException, IOException  {
		
		Map<String, String> info = new HashMap<>();
		
		for(int i = 0; i < get.length; i++) {
			info.put(get[i], request.getParameter(get[i]));
		}    
		
		return info; 
	}
}