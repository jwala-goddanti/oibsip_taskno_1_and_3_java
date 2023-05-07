package abs;
import java.util.*;
public class Account{
    public int balance = 50000;
    public Account(int card, int pwd){
       int cardNo = card;
       int password = pwd;
    }
    Scanner sc = new Scanner(System.in);

    public void withdraw(){
    System.out.println("===========================================================");
    System.out.println("Enter the amount to withdraw: ");
    int withdrawAmt = sc.nextInt();
    if(withdrawAmt> balance){
        System.out.println("Insufficient Amount");
    }
    else{
        balance = balance - withdrawAmt;
        System.out.println("Your amount is debited by "+ withdrawAmt);
        checkBalance();

    }

    }

    public void deposit(){
        System.out.println("===========================================================");
        System.out.println("Enter the amount to deposit : ");
        int depositAmt = sc.nextInt();
        balance = balance + depositAmt;
        checkBalance();

    }

    public void checkBalance(){
        System.out.println("===========================================================");
        System.out.println("Your Present Balance is "+ balance);
        System.out.println("===========================================================");
    }

    public int transfer(){
        int transferAmt;
        System.out.println("===========================================================");
        System.out.println("Enter the amount to transfer : ");
        transferAmt = sc.nextInt();
        if(transferAmt<=balance){
        balance = balance - transferAmt;
        checkBalance();
        return transferAmt;
        }
        else{
            System.out.println("Insufficient Blance...");
            return 0;
        }

    }

    public void credit(int transferAmt){
        this.balance = this.balance + transferAmt;
        return;
    }
       
    }

    
