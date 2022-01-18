package Calculator;

import java.util.*;
public class Calculator{
	public static void help(){
		//provide help to the user
		System.out.println();
		System.out.println("1.In Two Operands and Operator we have Operations : ");
		System.out.println("Note: num is Number");
		System.out.println("    Addition				[num + num]");
		System.out.println("    Substraction			[num - num]");
		System.out.println("    Multiplication			[num * num]");
		System.out.println("    Division				[num / num]");
		System.out.println("    exponents				[num ^ num]");
		System.out.println("    modulus				[num % num]");
		System.out.println();
		System.out.println("2.In One Operand We Have Two Formats : ");
		System.out.println("	1.Operand First ");
		System.out.println("		Factorials		[num !]");
		System.out.println("	2.Operator First ");
		System.out.println("		Square roots		[sqrt num]");
		System.out.println("		Negation		[-/+ num]");
		System.out.println("		Rounding		[round num]");
		System.out.println("		Decimal To Binary	[binary num]");
		System.out.println("3.Multiple Operand ");
	}
    public static void main(String[] args){
    	Scanner input = new Scanner(System.in);
    	TwoOperands TwoOperands = new TwoOperands();
    	OneOperand OneOperand = new OneOperand();
    	
        System.out.println("--------Calculator--------");
        
        String operator;
        double num1,num2;
        while ( true )
        {
        	System.out.println();
        	System.out.println("1.Two Operands");
        	System.out.println("2.One Operand  and one Operator");
        	System.out.println("3.MultiOperand");
    		System.out.println("4.Help");
        	System.out.print("> ");
        	int a=input.nextInt();
        	//for two operand and a operator
        	if(a==1) {
        		System.out.println();
                System.out.println("Enter The Equation");
                System.out.print("> ");
                num1 = input.nextDouble();
                // program ends if user enters "0" as first value
                if ( num1 == 0 ){
                    System.out.println("Bye Now.");
                    break;
                }
                operator = input.next();
                num2 = input.nextDouble();

                TwoOperands.Calculate(num1, num2, operator);
        	}
        	// for one operand and operator
        	else if(a==2) {
        		System.out.println();
        		System.out.println("1.Operand First ");
        		System.out.println("2.Operator First");
        		System.out.print("> ");
        		int b = input.nextInt();
        		//first operand
        		if(b==1) {
        			System.out.println();
                    System.out.println("Enter The Equation");
                    System.out.print("> ");
                    num1 = input.nextDouble();
                    // program ends if user enters "0" as first value
                    if ( num1 == 0 ){
                        System.out.println("Bye Now.");
                        break;
                    }
                    operator = input.next();
                    OneOperand.Calculate(num1, operator);
        		}
        		//operator first
        		else if(b==2) {
        			System.out.println();
                    System.out.println("Enter The Equation");
                    System.out.print("> ");
                    operator = input.next();
                    num1 = input.nextDouble();
                    // program ends if user enters "0" as first value
                    if ( num1 == 0 ){
                        System.out.println("Bye Now.");
                        break;
                    }
                    
                    OneOperand.Calculate1(operator,num1);
        		}
        		else {
        			System.out.println("Enter Only 1 or 2");
        		}
        	}
        	else if(a==3) {
        		System.out.println("Enter The Equation: ");
        		String multi = input.next();
        		System.out.println(MultiOperands.eval(multi));
        	}
    		else if(a==4) {
    			help();
    		}
        	else {
        		System.out.println("Enter Only 1 or 2 or 3");
        	}
        }
    }
}