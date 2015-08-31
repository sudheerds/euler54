package euler54;

import java.util.List;

class FullHouse {
	
	static boolean isFullHouse(List<String>l){
	 	
	 	if(ThreeKind.isThreeKind(l) && OnePair.isOnePair(l))		
		return true;
	 	else
	 		return false;
	 	
	 }
 

}
