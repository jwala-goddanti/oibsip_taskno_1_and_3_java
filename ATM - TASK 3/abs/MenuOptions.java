package abs;
public class MenuOptions {
    public  int transferfund=0;
    public MenuOptions(){
        
    }
    public void handleMenu(int op, Account acc){
        
        switch(op){
            case 1: 
            acc.withdraw();
            break;
            
            case 2:
            acc.deposit();
            break;

            case 3:
            acc.checkBalance();
            break;

            case 4:
            transferfund = acc.transfer();
            break;

            default:
            System.out.println("exit");
            break;
        }
    }
}