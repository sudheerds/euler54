package euler54;

import java.util.Arrays;
import java.util.List;

class FourKind {
	
	static boolean isFourKind(List<String> l){
		
		int count = 0;
				
		int[] cq = new int[5];
	    for(int i=0,j=0;i<9;i+=2,j++){    	
	    	String s = l.get(i);
	    	if(PokerMain.valueCard.containsKey(s))
	    		cq[j]=PokerMain.valueCard.get(s);
	    		 	else 
	    		cq[j]= Integer.parseInt(s);    	
	    }   
	    
	    Arrays.sort(cq);  
		
		
		for(int j=0;j<4;j++)
			if(cq[j]==cq[j+1])
				count++;	
	 
	if(count>=3)	 	
	 	return true;
	else
		return false;

	}
}

