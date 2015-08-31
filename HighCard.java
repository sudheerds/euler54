package euler54;

import java.util.Arrays;
import java.util.List;

class HighCard {
	
	static int isHighCard(List<String>l1,List<String>l2){
		
		//System.out.println(PokerMain.p1_hands);
		//System.out.println(PokerMain.p2_hands);
		
		int[] p1 = new int[5];
		int[] p2 = new int[5];
	    for(int i=0,j=0;i<9;i+=2,j++){    	
	    	String s1 = l1.get(i);
	    	String s2 = l2.get(i);
	    	
	    	if(PokerMain.valueCard.containsKey(s1))
	    		p1[j]=PokerMain.valueCard.get(s1);
	    		 	else 
	    		p1[j]= Integer.parseInt(s1); 
	    	
	    	if(PokerMain.valueCard.containsKey(s2))
	    		p2[j]=PokerMain.valueCard.get(s2);
	    		 	else 
	    		p2[j]= Integer.parseInt(s2);    
	    }   
	    
	    Arrays.sort(p1); 
	    Arrays.sort(p2); 
		
	    for(int i=0;i<5;i++){
	    	
	    	if(p1[i] > p2[i] && p2[i]!=1)
	    		return 1;
	    	
	    	else if(p1[i] > p2[i] && p2[i]==1)
	    		return 2;
	    	
	    	else if(p1[i] < p2[i] && p1[i]!=1)
	    		return 2;
	    	
	    	else if(p1[i] < p2[i] && p1[i]==1)
	    		return 1;
	    }
		
	 	return 0;
	 	 	
	 }
 

}
