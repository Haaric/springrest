package training;

import java.util.Set;

import junit.framework.Assert;
import junit.framework.TestCase;

public class ArithmaticTest extends TestCase {
	Arithmatic arithmatic = new Arithmatic();
	
	public void testFindIndexes() {
		int[] array = {1,1,1,5,6};
		Set<Integer> res = arithmatic.findIndexes(array);
		Assert.assertTrue(res.contains(3));
	}

}