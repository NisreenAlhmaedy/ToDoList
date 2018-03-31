package View;

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
        System.out.println(">> Pick an option from menu : ");
        System.out.println(">> Press 1 to Show Task List");
        System.out.println(">> press 2  Add New Task");
        System.out.println(">> press 3 to Edit Task ");
        System.out.println(">> press Q to  Save and Quit");
    }
    public void editMenu(){
        System.out.println("*******************************************");
        System.out.println("*************** Edit Menu *****************");
        System.out.println("*******************************************");
        System.out.println(" plz select >>>>> update,mark as done or remove)");
        System.out.println("if you want back to Home Page select  >>>>>> back");
    }


 }

