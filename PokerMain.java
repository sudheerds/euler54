package euler54;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PokerMain {
	
	static String filename = "/home/sudheerds/Desktop/Java/poker.txt" ;	
	static List<String> p1 = new ArrayList<String>();
	static List<String> p2 = new ArrayList<String>();
	static Map<String,Integer> p1_hands = new LinkedHashMap<String,Integer>();
	static Map<String,Integer> p2_hands = new LinkedHashMap<String,Integer>();
	static Map<String,Integer> valueCard = new HashMap<String,Integer>();
	static int p1_score=0;
	static int p2_score=0;
	
		
	
	 
	public static void main(String[] args) throws FileNotFoundException {
		
		File file = new File(filename); 
		Scanner sc= new Scanner(file);
		valueCard.put("A", 1);
		valueCard.put("T", 10);
		valueCard.put("J", 11);
		valueCard.put("Q", 12);
		valueCard.put("K", 13);
		int line=1;
				
		while(sc.hasNextLine()){
			
			String card = sc.nextLine();
			System.out.println(line++);
			
			for(int i=0;i<30;i+=3){
				if(i<15){
					p1.add(card.substring(i, i+1));
					p1.add(card.substring(i+1, i+2));
				}
				else{
					p2.add(card.substring(i, i+1));
					p2.add(card.substring(i+1, i+2));
				}
			}
				
					
				if(RoyalFlush.isRoyalFlush(p1) &&
						((!RoyalFlush.isRoyalFlush(p2))))
				{
					p1_score++;
					System.out.println("Royal Flush");
					PokerMain.p1_hands.put("RF", 1);
					PokerMain.p2_hands.put("RF", 0);
					break;
					
				}  
				
				else if(RoyalFlush.isRoyalFlush(p2) && 
							(!RoyalFlush.isRoyalFlush(p1)))
					
				{
					p2_score++;
					System.out.println("Royal Flush");
					PokerMain.p2_hands.put("RF", 1);
					PokerMain.p1_hands.put("RF", 0);
					break;
				} 
				
				else if(RoyalFlush.isRoyalFlush(p2) && 
						RoyalFlush.isRoyalFlush(p1))
				
			{
				System.out.println("Royal Flush tie up, no score for anyone");
				PokerMain.p1_hands.put("RF", 1);
				PokerMain.p2_hands.put("RF", 1);
				
			}else {
				PokerMain.p1_hands.put("RF", 0);
				PokerMain.p2_hands.put("RF", 0);
				
				if (StraightFlush.isStraightFlush(p1) && 				
						(!StraightFlush.isStraightFlush(p2))){
					
					p1_score++;
					System.out.println("Straight Flush");
					p1_hands.put("SF", 1);
					p2_hands.put("SF", 0);
					//continue;
					
				}
					else if (StraightFlush.isStraightFlush(p2) && 								
								(!StraightFlush.isStraightFlush(p1))){
							
							p2_score++;
							System.out.println("Straight Flush");
							p2_hands.put("SF", 1);
							p2_hands.put("SF", 0);
							//continue;
							
						}
				
					else if (StraightFlush.isStraightFlush(p2) && 								
							StraightFlush.isStraightFlush(p1)){					
						
						System.out.println("Straight Flush tie up, check for high card");
						PokerMain.p1_hands.put("SF", 1);
						PokerMain.p2_hands.put("SF", 1);
						if (HighCard.isHighCard(p1, p2)==1)
							p1_score++;
						else
							p2_score++;
							
						
						
					} 
					
					else {
						PokerMain.p1_hands.put("SF", 0);
						PokerMain.p2_hands.put("SF", 0);						
				
				//checking for cards not in same suit
						if(FourKind.isFourKind(p1) && 
								(!FourKind.isFourKind(p2))){
						p1_score++;
						System.out.println("Four Kind");
						PokerMain.p1_hands.put("FK", 1);
						PokerMain.p2_hands.put("FK", 0);
						//continue;
					
						} else if(FourKind.isFourKind(p2) && 
								(!FourKind.isFourKind(p1))){
							p2_score++;
							System.out.println("Four Kind");
							PokerMain.p2_hands.put("FK", 1);
							PokerMain.p1_hands.put("FK", 0);
							//continue;
						
					} else if(FourKind.isFourKind(p2) && 
							FourKind.isFourKind(p1)){
						
						System.out.println("Four Kind Tie Up,check for high card");
						PokerMain.p1_hands.put("FK", 1);
						PokerMain.p2_hands.put("FK", 1);
						if (HighCard.isHighCard(p1, p2)==1)
							p1_score++;
						else
							p2_score++;
						
					} 
						
					else {
						PokerMain.p1_hands.put("FK", 0);
						PokerMain.p2_hands.put("FK", 0);					
						
						if(FullHouse.isFullHouse(p1) &&
								(!FullHouse.isFullHouse(p2))){
							p1_score++;
							System.out.println("Full House");
							PokerMain.p1_hands.put("FH", 1);
							PokerMain.p2_hands.put("FH", 0);
							
						}else if(FullHouse.isFullHouse(p2) &&
								(!FullHouse.isFullHouse(p1))){
							p2_score++;
							System.out.println("Full House");
							PokerMain.p2_hands.put("FH", 1);
							PokerMain.p1_hands.put("FH", 0);
							
						}else if(FullHouse.isFullHouse(p2) &&
								(FullHouse.isFullHouse(p1))){
							System.out.println("Full House Tie Up");
							//check for high card
							if (HighCard.isHighCard(p1, p2)==1)
								p1_score++;
							else
								p2_score++;
							
							PokerMain.p1_hands.put("FH", 1);
							PokerMain.p2_hands.put("FH", 1);
						}
						
						else {
							PokerMain.p1_hands.put("FH", 0);
							PokerMain.p2_hands.put("FH", 0);					
						
						if(Flush.isFlush(p1) && 
								(!Flush.isFlush(p2))){
							p1_score++;
							System.out.println("Flush");
							PokerMain.p1_hands.put("FL", 1);
							PokerMain.p2_hands.put("FL", 0);
							
						}else if(Flush.isFlush(p2) && 
								(!Flush.isFlush(p1))){
							p2_score++;
							System.out.println("Flush");
							PokerMain.p2_hands.put("FL", 1);
							PokerMain.p1_hands.put("FL", 0);
							
						}else if(Flush.isFlush(p2) && 
								(Flush.isFlush(p1))){
							System.out.println("Flush");
							//check for high card
							PokerMain.p1_hands.put("FL", 1);
							PokerMain.p2_hands.put("FL", 1);
							if (HighCard.isHighCard(p1, p2)==1)
								p1_score++;
							else
								p2_score++;
							
						}
						
						else {
							PokerMain.p1_hands.put("FL", 0);
							PokerMain.p2_hands.put("FL", 0);						
						
						if(Straight.isStraight(p1) && 
								(!Straight.isStraight(p2))){
							p1_score++;
							System.out.println("Straight");
							PokerMain.p1_hands.put("ST", 1);
							PokerMain.p2_hands.put("ST", 0);
							
						} else if(Straight.isStraight(p2) && 
								(!Straight.isStraight(p1))){
							p2_score++;
							System.out.println("Straight");
							PokerMain.p2_hands.put("ST", 1);
							PokerMain.p1_hands.put("ST", 0);
							
						}else if(Straight.isStraight(p2) && 
								(Straight.isStraight(p1))){
							System.out.println("Straight Tie Up");
							//check for high card
							PokerMain.p1_hands.put("ST", 1);
							PokerMain.p2_hands.put("ST", 1);
							if (HighCard.isHighCard(p1, p2)==1)
								p1_score++;
							else
								p2_score++;
							
						}
						else {
							PokerMain.p1_hands.put("ST", 0);
							PokerMain.p2_hands.put("ST", 0);
												
						if(ThreeKind.isThreeKind(p1) && 
								(!ThreeKind.isThreeKind(p2))){
							p1_score++;
							System.out.println("Three Kind");
							PokerMain.p1_hands.put("TK", 1);
							PokerMain.p2_hands.put("TK", 0);
							
						}else if(ThreeKind.isThreeKind(p2) && 
								(!ThreeKind.isThreeKind(p1))){
							p2_score++;
							System.out.println("Three Kind");
							PokerMain.p2_hands.put("TK", 1);
							PokerMain.p1_hands.put("TK", 0);
							
						} else if(ThreeKind.isThreeKind(p2) && 
								(ThreeKind.isThreeKind(p1))){
							System.out.println("Three Kind Tie Up");
							//check for high card
							PokerMain.p1_hands.put("TK", 1);
							PokerMain.p2_hands.put("TK", 1);
							if (HighCard.isHighCard(p1, p2)==1)
								p1_score++;
							else
								p2_score++;
							
						} 
						else {
							PokerMain.p1_hands.put("TK", 0);
							PokerMain.p2_hands.put("TK", 0);
												
						if(TwoPairs.isTwoPairs(p1) && 
								(!TwoPairs.isTwoPairs(p2))){
							p1_score++;
							System.out.println("Two Pairs");
							PokerMain.p1_hands.put("TP", 1);
							PokerMain.p2_hands.put("TP", 0);
							
						}else if(TwoPairs.isTwoPairs(p2) && 
								(!TwoPairs.isTwoPairs(p1))){
							p2_score++;
							System.out.println("Two Pairs");
							PokerMain.p2_hands.put("TP", 1);
							PokerMain.p1_hands.put("TP", 0);
							
						}else if(TwoPairs.isTwoPairs(p2) && 
								(TwoPairs.isTwoPairs(p1))){
							System.out.println("Two Pairs,Tie Up");
							//check for high card
							PokerMain.p1_hands.put("TP", 1);
							PokerMain.p2_hands.put("TP", 1);
							if (HighCard.isHighCard(p1, p2)==1)
								p1_score++;
							else
								p2_score++;
						}
						else {
							PokerMain.p1_hands.put("TP", 0);
							PokerMain.p2_hands.put("TP", 0);
												
						if(OnePair.isOnePair(p1) && 
								(!OnePair.isOnePair(p2))){
							p1_score++;
							System.out.println("One Pair");
							PokerMain.p1_hands.put("OP", 1);
							PokerMain.p2_hands.put("OP", 0);
							
						} else if(OnePair.isOnePair(p2) && 
								(!OnePair.isOnePair(p1))){
							p2_score++;
							System.out.println("One Pair");
							PokerMain.p2_hands.put("OP", 1);
							PokerMain.p1_hands.put("OP", 0);
							
						} else if(OnePair.isOnePair(p2) && 
								(OnePair.isOnePair(p1))){
							System.out.println("One Pair, Tie Up");
							//check for high card
							PokerMain.p1_hands.put("OP", 1);
							PokerMain.p2_hands.put("OP", 1);
							if (HighCard.isHighCard(p1, p2)==1)
								p1_score++;
							else
								p2_score++;
						}
						else {
							PokerMain.p1_hands.put("OP", 0);
							PokerMain.p2_hands.put("OP", 0);
							if (HighCard.isHighCard(p1, p2)==1)
								p1_score++;
							else
								p2_score++;
						}
						}
						}
						}
						}
						}
					}
					}
			}
				
						
						
				
				//System.out.println(p1 + " " + p2 + "\n");
				p1.removeAll(p1);
				p2.removeAll(p2);
				p1_hands.clear();
				p2_hands.clear();
				
					}
			
		sc.close();
		System.out.println("The score of Player 1 is : " + p1_score);
		System.out.println("The score of Player 2 is : " + p2_score);
				
				
			}
	
	
}


		
			


			
			
				
		
	
	

    
 
 
 
 
 
 
 
 
 
 
 
 
 
 


