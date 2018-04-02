package View;


/*
 *To Do List Application
 *@author Nisreen Alhmaedy
 *@Version  2018
 */

/**
 * contains the interfaces of the application
 * that will appear to the user
 */
public class UserInterface {

    public void welcome() {
        System.out.println("###########################################");
        System.out.println("##########  Welcome to ToDoly  ############");
        System.out.println("###########################################");
        System.out.println("\n");
        // filtered by project
    }
    public void options() {
        System.out.println("**********************************************");
        System.out.println("************** Options Menu   ****************");
        System.out.println("**********************************************");
        System.out.println(">> Pick an option from the menu : ");
        System.out.println(">> Press 1 to Add New Task");
        System.out.println(">> press 2 to Show Task List ");
        System.out.println(">> press 3 to Edit Task ");
        System.out.println(">> Enter exit to Save and exit");
    }
    public void editMenu(){
        System.out.println("*******************************************");
        System.out.println("*************** Edit Menu *****************");
        System.out.println("*******************************************");
        System.out.println(" plz enter >>>>> update,mark as done or remove)");
        System.out.println("if you want to get back to Home Page enter >>>>>> back");
    }
 }

