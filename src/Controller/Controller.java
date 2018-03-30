package Controller;


import Model.*;
import View.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
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




public String readUserInput() {
    Scanner userInput = new Scanner(System.in);
    String userChoice = userInput.nextLine();
return userChoice;
}

public void userChoice(){
       String s=readUserInput();
    switch (s) {
        case "1":
             callShowTaskList(tasksList.getArrayList() );
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
          callUserChoice();
            break;

    }
}

public void callUserChoice(){

    userChoice();
}
    public void callShowTaskList(ArrayList arrayList){

        arrayList=tasksList.getArrayList();
        arrayList = om.sortListByDate(arrayList);
        om.showTaskList(tasksList);
        userInterface.options();
        userChoice();

    }

    public void callCreateNewTask(){
        TaskDTO newTask;
        newTask=om.createNewTask();
        tasksList.addtoarray(newTask);
        userInterface.options();
        userChoice();
    }


    public ArrayList<TaskDTO> callSortListByDate() {

       return om.sortListByDate(tasksList.getArrayList());
    }









}
