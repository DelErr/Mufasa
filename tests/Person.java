import static org.junit.Assert.*;

import org.junit.Test;

public class Person {

	private Owner owner= new Owner();

	@Test
	public void testUsername() {
		String username = "ABC_123";
		owner.setUsername(username);
		
		assertEquals(username, owner.getUsername());
		
	}
	
	@Test
	public void testCountry() {
		owner.setCountry(2);
		
		assertNotNull(owner.getCountry());
	}
	
	@Test
	public void testEmail() {
		String email = "test.email@tester.com";
		owner.setEmail(email, "tets.email@tester.com"); //are not the same
		
		assertNull(owner.getEmail());
	}
	
	@Test
	public void testDoB() {
		owner.setDob("01/01/1999");
		
		assertNotNull(owner.getDob());
	}
	
}