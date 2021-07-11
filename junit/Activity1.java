import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Activity1 {

	//Test Fixtures
	static ArrayList<String> list;
	
	// Initialize test fixtures before each test method
    @BeforeEach
    void setUp() throws Exception {
	
	// Initialize a new ArrayList 
	list = new ArrayList<String>();

	// Add values to the list
	list.add("alpha"); // at index 0
	list.add("beta"); // at index 1
    }
    
	@Test
	// Test method to test the insert operation
   
    public void insertTest() {
        // Assertion for size
        assertEquals(2, list.size(), "Wrong size");
        // Add new element
        list.add(2, "charlie");
        // Assert with new elements
        assertEquals(3, list.size(), "Wrong size");
 
        // Assert individual elements
        assertEquals("alpha", list.get(0), "Wrong element");
        assertEquals("beta", list.get(1), "Wrong element");
        assertEquals("charlie", list.get(2), "Wrong element");
    }
 
	// Test method to test the replace operation
    @Test
    public void replaceTest() {
        // Replace new element
        list.set(1, "charlie");
 
        // Assert size of list
        assertEquals(2, list.size(), "Wrong size");
        // Assert individual elements
        assertEquals("alpha", list.get(0), "Wrong element");
        assertEquals("charlie", list.get(1), "Wrong element");
    }

}
