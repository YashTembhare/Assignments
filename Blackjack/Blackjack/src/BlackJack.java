import java.util.*;

public class BlackJack {
	
    public static void Hitstay(int sum,int num1,int num2,int sum2,int num3,int num4 ){
    	System.out.println();
        System.out.println("Would you like to 'hit' or 'stay'?  ");
        System.out.println("Only use word 'hit' or 'stay'");
        Scanner s =new Scanner(System.in);
        String input = s.nextLine();
        System.out.println();
        //if player choose hit
        if(input.equals("hit")) {
        	int min=2;
            int max=11;
            int psum = sum;
            int newno=(int)(Math.random() * (max-min)) + min;
            psum =psum+newno;
            System.out.println("Player draws : "+newno);
            System.out.println("Player's new total is: "+psum);
            sum = psum;
            //check new sum 
            if(psum<21)
            {
            	Hitstay(psum,num1,num2,sum2,num3,num4);
            }
            else if(psum==21){
            	System.out.println();
            	System.out.println("Player Win..!!!");
            }
            else
            {
            	System.out.println();
                System.out.println("Dealer Wins...!!!");
                return;   
            }

        }
        //if player choose stay
        else if(input.equals("stay")){
              System.out.println("Okay, Dealer's turn");
              System.out.println("Dealer Hidden Card is: " +num4);
              System.out.println();
              int dsum = sum2;
              //continuous hit of dealer until sum is less than 16
              while(dsum<=16) {
                  int min=2;
                  int max=11;
                  int newno=(int)(Math.random() * (max-min)) + min;
                  dsum = dsum+newno;
                  System.out.println("Dealer Choose to hit");
                  System.out.println("Dealer draws : "+newno);
                  System.out.println("Dealer's new total is: "+dsum);
                  System.out.println();
              }
              //check dealer sum
              if(dsum<21) {
                  if(sum > dsum) {
                    	System.out.println("Player Wins...!!!");
                    	System.exit(0);
                    }
                    else
                    {	System.out.println("Dealer Wins...!!!");
                    	System.exit(0);
                    }
              }
              //comparison of dealer and player sum
              else if(dsum==21) {
            	  System.out.println("Dealer Wins...!!!");
              }
              else {
            	  System.out.println("Player Wins...!!!");
              }

       
        }
        else {
        	System.out.println("Use only words 'hit' or 'stay'");
        }

    }
	public static void main(String[] args) {
		System.out.println("-------------BlackJack Game-----------");
		System.out.println();
		//number range
		int min = 2;
		int max = 11;
		//choose random number between range
		int plyrA1 = (int) Math.floor(Math.random()*(max-min+1)+min);
		int plyrA2 = (int) Math.floor(Math.random()*(max-min+1)+min);
		int sum1= plyrA1+plyrA2;
		System.out.println("The Player Cards are : "+ plyrA1+ " and " + plyrA2);
		System.out.println("The Sum of Player Cards is: "+ sum1);
		int dlrA1 = (int) Math.floor(Math.random()*(max-min+1)+min);
		int dlrA2 = (int) Math.floor(Math.random()*(max-min+1)+min);
		int sum2= dlrA1+dlrA2;
		System.out.println("The One of the Dealer Card is : "+ dlrA1 +" and a hidden Card");
		System.out.println("Dealer Total is also Hidden");
		//check initially player sum or dealer sum is equal to 21 or not
		if(sum1 == 21) {
			// return
			System.out.println("Player Wins...!");
			System.exit(0);
		}
		if(sum2 == 21) {
			// return
			System.out.println("Dealer Wins...!");
			System.exit(0);
		}
		Hitstay(sum1,plyrA1,plyrA2,sum2,dlrA1,dlrA2);
    }
}

