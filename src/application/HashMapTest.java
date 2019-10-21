/**
 * @author carlostello
 */
package application;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;

import org.junit.Test;

public class HashMapTest {

	@Test
	public void test() {
		
			HashMap <String, Integer> testList = new HashMap <String, Integer>();
			testList.put("apple", 12);
			testList.put("orange", 5);
			testList.put("banana", 2);
			testList.put("roses", 7);
			testList.put("pickles" , 8);
			
			HashMap <String, Integer> correctList = new HashMap <String, Integer>();
			correctList.put("banana", 2);
			correctList.put("orange", 5);
			correctList.put("roses", 7);
			correctList.put("pickles" , 8);
			correctList.put("apple", 12);
			
			
			
			HashMap<String, Integer> resultMap = Reader.sortByValue(testList);
			assertEquals(correctList, resultMap);
			
		
		
		
	}

}
