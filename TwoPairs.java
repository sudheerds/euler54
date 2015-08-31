package euler54;

import java.util.Arrays;
import java.util.List;

class TwoPairs {
	
	static boolean isTwoPairs(List<String>l){
	 	
int count_ca =0, count_su = 0;
		
		int[] cq = new int[5];
		
		
		for(int i=0,j=0;i<9;i+=2,j++){    	
	    	String s = l.get(i);
	    	if(PokerMain.valueCard.containsKey(s))
	    		cq[j]=PokerMain.valueCard.get(s);
	    		 	else 
	    		cq[j]= Integer.parseInt(s);    	
	    }   	
	    	
	    
	    Arrays.sort(cq);
	    
		for(int m=0,n=4;m<4 && n>0;m++,n--){			
		
			if(cq[m]==cq[m+1]);
				count_ca++;
				
				if(cq[n]==cq[n-1])
				count_su++;
		}
	 
	if(count_ca==2 && count_su==2)	
	 	return true;
	else
		return false;

	}

	 	
	}
	



