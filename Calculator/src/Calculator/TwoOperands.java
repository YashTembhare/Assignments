package Calculator;

public class TwoOperands {

	public static double Calculate(double a, double b, String op){
        double c;
        if ( op.equals("+") )
        {
            c = a + b;
            System.out.println( c );
        }
        else if ( op.equals("-") )
        {
            c = a - b;
            System.out.println( c );
        }

        else if ( op.equals("*") )
        {
            c = a * b;
            System.out.println( c );
        }

        else if ( op.equals("/") )
        {
            c = a / b;
            System.out.println( c );
        }

        else if ( op.equals("^") )
        {
            c = Math.pow( a, b );
            System.out.println( c );
        }

        else if ( op.equals("%") )
        {
            c = a % b;
            System.out.println( c );
        }

        else
        {
            System.out.println("Please Provide Corret Input.");
            c = 0;
        }
        return c;

    }

}
