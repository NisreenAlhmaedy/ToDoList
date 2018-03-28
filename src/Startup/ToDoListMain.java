/*
 *ToDo List Application
 *@author Nisreen Alhmaedy
 *@ Version  2018
 *
 */
package Startup;

import Controller.Controller;
import DBHandler.DBHandler;
import Model.TasksList;
import View.UserInterface;

public class ToDoListMain {


    public static void main(String[] args) {

        DBHandler hr=new DBHandler();
        TasksList tasksList=hr.loadFile();

        UserInterface UI=new UserInterface();
        Controller ctrl=new Controller(tasksList);
        UI.welcome();
        ctrl.inputFromUser();

       hr.saveFile(tasksList);

    }















}



