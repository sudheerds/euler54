package euler54;

import java.util.List;

class RoyalFlush {
	
	static boolean isRoyalFlush(List<String>l){
		
		if (Flush.isFlush(l)){		
					
		int[] a= new int[5];  
	    			
	    	for(int i=0;i<9;i+=2){
	    	
	    	switch (l.get(i)){
	    	
	    	case "T":{
	    		a[0]=1;
	    	    break;
	    	}
	    	
	    	case "J":{
	    		a[1]=1;
	    	    break;
	    	}
	    	
	    	case "Q":{
	    		a[2]=1;
	    	    break;
	    	}
	    	
	    	case "K":{
	    		a[3]=1;
	    	    break;
	    	}
	    	
	    	case "A":{
	    		a[4]=1;
	    		break;
	    	}  		
	    		
	        
	        }
	    	
	    	
	    	}
	    	
	    	if(a[0]+a[1]+a[2]+a[3]+a[4]== 5){
	    		return true;	
	    	
	    	} 
		}
	   
	    return false;
	     
	    	
	    }

}
