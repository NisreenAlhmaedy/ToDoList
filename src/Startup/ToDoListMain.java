/*
 *To Do List Application
 *@author Nisreen Alhmaedy
 *@ Version  2018
 *
 */
package Startup;

import Controller.Controller;
import View.UserInterface;

public class ToDoListMain {


    public static void main(String[] args) {

      UserInterface userInterface=new UserInterface();
      Controller ctrl=new Controller();
     userInterface.welcome();
     ctrl.readUserInput();

    }















}



