package training;

import java.util.HashSet;
import java.util.Set;

public class Arithmatic {
	
	public Set<Integer> findIndexes(int[] array) {
		Set<Integer> response = new HashSet<Integer>();
		
		int sum =array[0];
		int product = 0;
		int arrayLength = array.length;
		//logic if the length of array is 3
		if(arrayLength==3) {
			if(array[0]<array[1] && array[2]>array[1]) {
				response.add(1);
			}
		}else if(arrayLength>3) {
			//skip first and last indexes
			for(int i=1; i<arrayLength-1; i++) {
				product =array[i+1];
				if(i!=1) {
				sum+=array[i-1];
				}
				for(int j=i+1; j<array.length-1; j++) {
						product= product*array[j+1];
				}
				if(sum<array[i] && product>array[i]) {
					response.add(i);
				}
				
			}
		}
		return response;
	}
}