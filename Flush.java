package euler54;

import java.util.List;

class Flush {	
	 	
		static boolean isFlush(List<String>l){
			if (l.get(1).equals(l.get(3)) && l.get(1).equals(l.get(5)) && 
		    		l.get(1).equals(l.get(7)) && l.get(1).equals(l.get(9)))			
				return true;				
			else
				return false;
			
		}
	 	
	 }


