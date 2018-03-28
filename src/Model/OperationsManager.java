package Model;


import java.util.Scanner;

public class OperationsManager {



    public void showTaskList(TasksList tasksList)
    {

        System.out.println(" U have  " + tasksList.getArrayList().size() + " task" );
        int i ;
        for( i =0 ;i<tasksList.getArrayList().size(); i++ )
        {
            int j=i+1;
            System.out.println("The task No "+ j +" info is: ");
            System.out.println("Title: "+tasksList.getArrayList().get(i).getTaskTitle() +"  ,Date: "+ tasksList.getArrayList().get(i).getTaskDate()+
                    "  ,Status: " +tasksList.getArrayList().get(i).getTaskStatus()+ "  ,Project: "+  tasksList.getArrayList().get(i).getTaskProject());
            System.out.println("\n");
        }


        }




    public TaskDTO  createNewTask() {


        TaskDTO newTask;

        Scanner inputNewTask = new Scanner(System.in);

        System.out.println("please enter task title  ");
        String newTaskTitle = "" + inputNewTask.nextLine();

        System.out.println("please enter task date  ");
        String newTaskDate = "" + inputNewTask.nextLine();


        System.out.println("please  enter task project name   ");
        String newTaskProjectName = "" + inputNewTask.nextLine();

        newTask = new TaskDTO(newTaskTitle, newTaskDate, false, newTaskProjectName);

return newTask;
    }



}
