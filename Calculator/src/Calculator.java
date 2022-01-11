import java.util.*;
public class Calculator{
    public static void help() {
        //provide help to the user
        System.out.println();
        System.out.println("1.In Two Operands and Operator we have Operations : ");
        System.out.println("    Addition");
        System.out.println("    Subtraction");
        System.out.println("    Multiplication");
        System.out.println("    Division");
        System.out.println("    exponents");
        System.out.println("    modulus");
    }
    public static void main(String[] args){
        System.out.println("--------Calculator--------");
        Scanner input = new Scanner(System.in);
        String operator;
        double num1, num2;
        while ( true )
        {
            System.out.println();
            System.out.print("> ");
            num1 = input.nextDouble();
            // program ends if user enters "0" as first value
            if ( num1 == 0 ){
                System.out.println("Bye Now.");
                break;
            }
            operator = input.next();
            num2 = input.nextDouble();

            Calculate( num1, num2, operator );

        }
    }
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
            System.out.println("Undefined operator: '" + op + "'.");
            help();
            c = 0;
        }
        return c;

    }
}