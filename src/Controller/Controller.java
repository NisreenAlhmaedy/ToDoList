package Controller;


import Model.*;
import View.*;
import java.util.Scanner;

public class Controller {


    TasksList tasksList;
    OperationsManager om=new OperationsManager();
    UserInterface userInterface=new UserInterface();


    public Controller(){


    }

    public Controller(TasksList tasksList){
this.tasksList=tasksList;

    }




public void inputFromUser() {
    Scanner inputUserOption = new Scanner(System.in);
    String userOption = inputUserOption.nextLine();


    switch (userOption) {


        case "1":
             callShowTaskList(tasksList );

            break;
        case "2":
            callCreateNewTask();

            break;
        case "3":
            break;
        case "Q":
            System.out.println(" goodbye, have a nice day");
            break;
        case "q":
            System.out.println(" goodbye, have a nice day");
            break;
        default:
            System.out.println("please enter a valid option!! ");
           callInputFromUser();
            break;

    }
}

public void callInputFromUser(){

        inputFromUser();
}




    public void callShowTaskList(TasksList tasksList){

        om.showTaskList(tasksList);
        userInterface.options();
        inputFromUser();

    }

    public void callCreateNewTask(){
        TaskDTO newTask=new TaskDTO("tit","date",false,"pro");
        newTask=om.createNewTask();
        tasksList.addtoarray(newTask);
        userInterface.options();
        inputFromUser();
    }












}
