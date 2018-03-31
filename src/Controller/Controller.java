package Controller;


import Model.OperationsManager;
import View.UserInterface;
import java.util.Scanner;

public class Controller {
    private Scanner input = new Scanner(System.in);
   private OperationsManager om;
  private  UserInterface UI;

    public Controller() {
       om = new OperationsManager();
       UI = new UserInterface();
    }
public void readUserInput() {
        UI.options();
    String userInput = input.nextLine();

    switch (userInput) {
        case "1":
            om.showTaskList();
         readUserInput();
            break;
        case "2":
           om.createNewTask();
        readUserInput();
            break;
        case "3":
            edit();
            break;
        case "Q":
            om.save();
            System.out.println(" goodbye, have a nice day");
            break;
        case "q":
            om.save();
            System.out.println(" goodbye, have a nice day");
            break;
        default:
            System.out.println("please enter a valid option!! ");
            readUserInput();
            break;
    }
}

private void edit(){

        UI.editMenu();
    String userInput = input.nextLine();

    if(userInput.equals("update")){
        om.updateTask();
       edit();
    }
    else if (userInput.equals("mark as done")){
        om.markAsDone();
        edit();
    }
    else if (userInput.equals("remove")){
        om.removeTask();
       edit();
    }
    else if (userInput.equals("back")){
        readUserInput();
    }

    else {
        System.out.println("please select an option from menu !! ");
       edit();
    }
  }

}







