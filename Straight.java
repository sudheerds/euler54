package euler54;

import java.util.Arrays;
import java.util.List;

class Straight {
	
	static boolean isStraight(List<String> l){
	 	
		int[] cq = new int[5];
	    int k=1;
	    for(int i=0,j=0;i<9;i+=2,j++){    	
	    	String s = l.get(i);
	    	if(PokerMain.valueCard.containsKey(s))
	    		cq[j]=PokerMain.valueCard.get(s);
	    		 	else 
	    		cq[j]= Integer.parseInt(s);    	
	    }   
	    
	    Arrays.sort(cq);  
	   
	    if(cq[k+1]-cq[k]==1 && cq[k+2]-cq[k+1]==1 && cq[k+3]-cq[k+2]==1) 
	    			
	    	{ 
	    		if( 13-cq[0]==12 || cq[1]-cq[0]==1 )
	    			return true;   			
	    		
	    	}
		
		
	    
		return false;
	    	
	    }

	 	
	 }

