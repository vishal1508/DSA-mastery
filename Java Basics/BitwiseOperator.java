public class BitwiseOperator
{
  public static void main(String[] args){

    int a = 5;
    int b = 3;
    int andOperator  = a & b; // & operator result will be (1,0 = 0) (0,1 = 0) (1,1 = 1) (0,0 = 0)
    int orOperator  = a | b; // | operator result will be (1,0 = 1) (0,1 = 1) (1,1 = 1) (0,0 = 0)
    int xorOperator  = a ^ b; // ^ operator result will be (1,0 = 1) (0,1 = 1) (1,1 = 0) (0,0 = 0)
    int notOperator  = ~a; // ^ operator result will be 1 = 0 and 0 = 1
    int leftShiftOperator = a << 2; // << left shift operator input will be a = 101 output will be a = 1010 if 
    int rightShiftOperator = a >> 2; // >> right shift operator input will be 101 result will be a = 10
    System.out.println("a :=> "+ Integer.toBinaryString(a));
    System.out.println("a :=> "+ Integer.toBinaryString(b));
    System.out.println("And Operator :=> "+ Integer.toBinaryString(andOperator));
    System.out.println("Or Operator :=> "+ Integer.toBinaryString(orOperator));
    System.out.println("Xor Operator :=> "+ Integer.toBinaryString(xorOperator)+","+xorOperator);
    System.out.println("Not Operator :=> "+ Integer.toBinaryString(notOperator)+","+notOperator);
    System.out.println("Left Shift Operator :=> "+ Integer.toBinaryString(leftShiftOperator)+","+leftShiftOperator);
    System.out.println("Right Shift Operator :=> "+ Integer.toBinaryString(rightShiftOperator)+","+rightShiftOperator);
    a = 5;
    System.out.println("a :=> "+Integer.toBinaryString(a) +", "+Integer.toBinaryString(a).length());
   int unSignedIntegerOperator = a >>> 1;
    System.out.println("unSigned Shift Operator :=> "+ Integer.toBinaryString(unSignedIntegerOperator)+", "+Integer.toBinaryString(unSignedIntegerOperator).length()+","+unSignedIntegerOperator);


  
  }
}