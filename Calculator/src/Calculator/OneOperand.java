package Calculator;

public class OneOperand {
	public static double Calculate(double a, String op) {
        if ( op.equals("!") ) {
            double fact=1;
            for (int i = 1; i <= a; i++) {
                fact = fact * i;
            }
            System.out.println(fact);
        }
        else {
        	System.out.println("Please Provide Corret Input.");
        }

        return 0;
    }
	public static double Calculate1(String op, double a ) {
        if(op.equals("sqrt")){
        	System.out.println(Math.sqrt(a));
        	
        }
        else if(op.equals("-") || op.equals("+")){
        	if(op.equals("-"))
        		System.out.println(-a);
        	else if(op.equals("+"))
        		System.out.println(a);
        	
        }
        else if(op.equals("round")) {
        	System.out.println(Math.round(a));
        }
        else if(op.equals("binary")) {
        	System.out.println(Integer.toBinaryString((int) a));
        }
        else {
        	System.out.println("Please Provide Corret Input.");
        }
		return 0;
		
	}
	
}
