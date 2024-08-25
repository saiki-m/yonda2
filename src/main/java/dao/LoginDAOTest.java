package dao;

import static org.junit.Assert.*;

import org.junit.Test;

import beans.AccountBean;

public class LoginDAOTest {

	@Test
	public void testFindAccount() {
		
//		try {
//			
//			doSql("INSERT INTO アカウント()");
//		}catch(SQLException e){
//			e.printStackTrace();
//		}
		
		String name = "";
		String password = "anna";
		
		AccountBean account = new LoginDAO().findAccount(name, password);
		
		assertEquals(name, account.getName());
		assertEquals(password, account.getPassword());
		
	}

}
