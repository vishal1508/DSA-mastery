public class ConditionStatement {
  public static void main(String[] args) {
    int a = 2;
    int b = 5;

    System.out.println("relation equal operator '==' "+ (a==b));
    System.out.println("relation not equal operator '!=' "+ (a!=b));
    System.out.println("relation less than operator '<' "+ (a < b));
    System.out.println("relation greater than operator '>' "+ (a > b));
    System.out.println("relation greater than equal operator '>=' "+ (a >= b));
    System.out.println("relation less than equal operator '<=' "+ (a <= b));

    // logical operator
    System.out.println("logical OR  '||' :=> "+ ((a <= b) || ( a>= b)));
    System.out.println("logical AND  '&&' :=> "+ ((a <= b) && ( a>= b)));
    System.out.print("logical NOT  '!' :=> "+ !(a < b));

    //Condition Statement
    if(a > b){
      System.out.printf("\n %d is less than %d",a,b);
    }else{
      System.out.printf("\n %d is greater than %d",b,a);
    }
    
    int unit = 202;
    if(unit >= 1 && unit <= 100){
      System.out.printf("\n your electricity bill is %d Rupees",5);
    }else if(unit >= 101 && unit <= 200){
      System.out.printf("\n your electricity bill is %d Rupees",7);
    }else{
      System.out.printf("\n your electricity bill is %d Rupees\n",10);
    }
    
    int atmMenuNumber = 1;
    System.out.println("Welcome to BOB ATM  choose Below Options \n1. check Balance\n2. Deposite Money\n3. Withdraw Money\n4. Exit");
    switch (atmMenuNumber) {
      case 1:
          System.out.println("your balance is 20000/-");
        break;
      case 2:
        System.out.println("Money has been Deposite Successfully");
        break;
      case 3:
        System.out.println("Money has been Withdraw Successfully");
        break;
      case 4:
        System.out.println("Logout Successfully");
        break;
      default:
        break;
    }

  }
}
