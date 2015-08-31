package euler54;


import java.util.List;


class StraightFlush {
	
static boolean isStraightFlush(List<String>l){
	
	if (Flush.isFlush(l) && Straight.isStraight(l))
		return true;
	else
		return false;
	}    	
    
}
