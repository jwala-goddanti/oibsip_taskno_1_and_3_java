import abs.Account;
import abs.MenuOptions;
import java.util.*;
class ATMInterface{
      
    public static void main(String[] args){
        int option=0;
        Scanner sc = new Scanner(System.in);
        Account ram = new Account(9595,6363);
        Account rani = new Account(4458,5558);
        MenuOptions menu = new MenuOptions();
        while(true){
        System.out.println("Enter Card Number: ");
        int card = sc.nextInt();
        System.out.println("Enter password: ");
        int pwd = sc.nextInt();
             
        if((card==9595 && pwd == 6363)||(card==4458 && pwd == 5558)){
        if(card==9595 && pwd == 6363){
        System.out.println("===========================================================");
        System.out.println("Welcome to ATM Mr.Ram ");
        do{
        prompt();
        option = sc.nextInt();
        menu.handleMenu(option, ram);
        if(option==4)
        rani.credit(menu.transferfund);

        }while(option!=5);
        }

     if(card==4458 && pwd == 5558){
        System.out.println("===========================================================");
        System.out.println("Welcome to ATM Mr.Rani ");
       do{ 
        prompt();
        option = sc.nextInt();
        menu.handleMenu(option, rani);
        if(option==4)
        ram.credit(menu.transferfund);
       }while(option!=5);

        }
    }

    
    else{
        System.out.println("Card number or password is incorrect. please enter valid credentials");
    }
    
    
}
   
        
    }
    public static void prompt(){
        System.out.println("===========================================================");
        System.out.println("choose the appropriate options for corresponding services");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Transfer");
        System.out.println("5. exit");
        System.out.println("===========================================================");
    }
    
}