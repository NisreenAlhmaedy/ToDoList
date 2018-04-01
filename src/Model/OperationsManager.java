package Model;
import DBHandler.DBHandler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;


/*
 *To Do List Application
 *@author Nisreen Alhmaedy
 *@Version  2018
 *
 */

/**
 * Perform the desired work
 */
public class OperationsManager {

   private DBHandler hr;
   private TasksList tasksList;
   private Scanner input = new Scanner(System.in);
   private Scanner inputINT = new Scanner(System.in);
   private int taskNo;

    /**
     * Creates a new instance.
     */
    public OperationsManager() {
        hr = new DBHandler();
        tasksList = hr.loadFile();
    }

    /**
     * change the status of exist task from Not Done to Done
     */
    public void markAsDone() {
        System.out.println("enter the task number which you want to mark as done");
         taskNo = inputINT.nextInt();
        if (taskNo - 1 < tasksList.getArrayList().size()) {
            tasksList.getArrayList().get(taskNo-1).setStatusAsDone();
            System.out.println("The task is done \n ");
        } else{
            System.out.println("Not found !! enter exist task ");
            markAsDone();
        }
    }

    /**
     * replaced name, due date, project name of exist task
     */
    public void updateTask() {
        TaskDTO updatedTask = new TaskDTO();
        System.out.println("enter the task number which you want to update");
        taskNo = inputINT.nextInt();

        if (taskNo - 1 < tasksList.getArrayList().size()) {

            System.out.println("Enter task title");
            String newTaskTitle =input.nextLine();
            System.out.println("Enter task due date >> dd.MM.yyyy ");
            String dueDateFromUser =input.nextLine();
            Date newDueDate = updatedTask.getStringToDate(dueDateFromUser);
            while (newDueDate==null){
               System.out.println("not valid date format .. try again!!");
               dueDateFromUser =input.nextLine();
                newDueDate = updatedTask.getStringToDate(dueDateFromUser);
            }
            System.out.println("Enter project name for that task to belong to ");
            String newProjectName =input.nextLine();
            boolean sameStatus=tasksList.getArrayList().get(taskNo - 1).getTaskStatus();
            updatedTask = new TaskDTO(newTaskTitle, newDueDate,sameStatus , newProjectName);
            tasksList.getArrayList().set(taskNo - 1, updatedTask);
            System.out.println("updated task replaced successfully!! \n ");
        }
        else {
            System.out.println("Not found !! enter exist task ");
            updateTask();
        }
    }
    public void removeTask() {
        System.out.println("enter the task number which you want to remove");
        taskNo = inputINT.nextInt();

        if (taskNo - 1 < tasksList.getArrayList().size()) {
            tasksList.getArrayList().remove(taskNo - 1);
            System.out.println("The task removed successfully!! \n ");
        } else{
            System.out.println("Not found !! enter exist task ");
      removeTask();
        }
    }
    public void showTaskList() {

        int X = 0;
        int Y = 0;
        int k;
        for (k = 0; k < tasksList.getArrayList().size(); k++) {
            if (tasksList.getArrayList().get(k).getTaskStatus())
                Y = Y + 1;
            else X = X + 1;
        }
        System.out.println(" U have  " + tasksList.getArrayList().size() + " task");
        System.out.println( X + " task to do and " + Y + " task are done! \n");

        int i;
        for (i = 0; i < tasksList.getArrayList().size(); i++) {
            int j = i + 1;
            System.out.println("The task No " + j + " info is: ");
            System.out.println("Title: " + sortListByDate().get(i).getTaskTitle() + "  ,Date: " + sortListByDate().get(i).getDateToString() +
                    "  ,Status: " + sortListByDate().get(i).getTaskStatusAsString() + "  ,Project: " + sortListByDate().get(i).getTaskProject());
            System.out.println("--------------------------------------------------------------------------------");
        }

System.out.println("\n");
    }

/**
 *@return tasks list sorted by date
 */
    private ArrayList<TaskDTO> sortListByDate() {
        if ((tasksList.getArrayList() == null) || (tasksList.getArrayList().isEmpty())) {
            return new ArrayList<>();
        }
        Collections.sort(tasksList.getArrayList());
        return tasksList.getArrayList();
    }

    public void createNewTask() {
        TaskDTO newTask = new TaskDTO();
        System.out.println("Enter task title  ");
        String taskTitle = input.nextLine();
        System.out.println("Enter task due date >> dd.MM.yyyy ");
        String dueDateFromUser =input.nextLine();
        Date taskDueDate = newTask.getStringToDate(dueDateFromUser);
        while (taskDueDate==null){
            System.out.println("not valid date format .. try again!!");
             dueDateFromUser =input.nextLine();
             taskDueDate = newTask.getStringToDate(dueDateFromUser);
        }
        System.out.println("Enter project name for that task to belong to   ");
        String taskProjectName =input.nextLine();
        newTask = new TaskDTO(taskTitle, taskDueDate, false,taskProjectName);
        tasksList.addToArrayList(newTask);
        System.out.println("your task created and added to list successfully!! \n");


    }
    public void save() {
        hr.saveFile(tasksList);

    }


}