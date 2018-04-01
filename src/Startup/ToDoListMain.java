
/**
 *To Do List Application
 *@author Nisreen Alhmaedy
 *@Version  2018
 *
 */
package Startup;

import Controller.Controller;
import View.UserInterface;

/**
 * Contains the <code>main</code> method.
 */
public class ToDoListMain {

/**
 * Starts the application.
 */
    public static void main(String[] args) {

      UserInterface userInterface=new UserInterface();
      Controller ctrl=new Controller();
      userInterface.welcome();
      ctrl.readUserInput();

    }
}



