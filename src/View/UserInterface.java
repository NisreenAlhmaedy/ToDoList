package View;


public class UserInterface {



    public void welcome() {

        System.out.println("###########################################");
        System.out.println("##########  Welcome to ToDoly  ############");
        System.out.println("###########################################");
        options();
    }


    public void options() {
        System.out.println(">> Pick an option: ");
        System.out.println(">> Press 1 to Show Task List");
        System.out.println(">> press 2  Add New Task");
        System.out.println(">> press 3 to Edit Task (update, mark as done, remove)");
        System.out.println(">> press Q to  Save and Quit");


    }


 }

