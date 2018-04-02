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
 * Performs the desired work
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
        System.out.println("Enter the task number which you want to mark as done");
         taskNo = inputINT.nextInt();
        if (taskNo - 1 < tasksList.getArrayList().size()) {
            tasksList.getArrayList().get(taskNo-1).setStatusAsDone();
            System.out.println("The task is marked as done  \n ");
        } else{
            System.out.println("Not found !! Please enter exist task ");
            markAsDone();
        }
    }

    /**
     * replace name, due date, project name of exist task
     */
    public void updateTask() {
        TaskDTO updatedTask = new TaskDTO();
        System.out.println("Enter the task number which you want to update");
        taskNo = inputINT.nextInt();

        if (taskNo - 1 < tasksList.getArrayList().size()) {

            System.out.println("Enter the task title");
            String newTaskTitle =input.nextLine();
            System.out.println("Enter the task due date >> dd.MM.yyyy ");
            String dueDateFromUser =input.nextLine();
            Date newDueDate = updatedTask.getStringToDate(dueDateFromUser);
            while (newDueDate==null){
               System.out.println("Not valid date format .. Try again!!");
               dueDateFromUser =input.nextLine();
                newDueDate = updatedTask.getStringToDate(dueDateFromUser);
            }
            System.out.println("Enter the project name for that task to belong to ");
            String newProjectName =input.nextLine();
            boolean sameStatus=tasksList.getArrayList().get(taskNo - 1).getTaskStatus();
            updatedTask = new TaskDTO(newTaskTitle, newDueDate,sameStatus , newProjectName);
            tasksList.getArrayList().set(taskNo - 1, updatedTask);
            System.out.println("The task articles have been updated successfully!! \n ");
        }
        else {
            System.out.println("Not found !! Enter exist task ");
            updateTask();
        }
    }
    public void removeTask() {
        System.out.println("Enter the task number which you want to remove");
        taskNo = inputINT.nextInt();

        if (taskNo - 1 < tasksList.getArrayList().size()) {
            tasksList.getArrayList().remove(taskNo - 1);
            System.out.println("The task is removed successfully!! \n ");
        } else{
            System.out.println("Not found !! Enter exist task ");
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
        System.out.println(" You have  " + tasksList.getArrayList().size() + " task");
        System.out.println( X + " task to do and " + Y + " task are done! \n");

        int i;
        for (i = 0; i < tasksList.getArrayList().size(); i++) {
            int j = i + 1;
            System.out.println("The task number " + j + " info is: ");
            System.out.println("Title: " + sortListByDate().get(i).getTaskTitle() + "  ,Due date: " + sortListByDate().get(i).getDateToString() +
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
        System.out.println("Enter the task title  ");
        String taskTitle = input.nextLine();
        System.out.println("Enter the task due date >> dd.MM.yyyy ");
        String dueDateFromUser =input.nextLine();
        Date taskDueDate = newTask.getStringToDate(dueDateFromUser);
        while (taskDueDate==null){
            System.out.println("Not valid date format .. Please try again!!");
             dueDateFromUser =input.nextLine();
             taskDueDate = newTask.getStringToDate(dueDateFromUser);
        }
        System.out.println("Enter the project name for that task to belong to   ");
        String taskProjectName =input.nextLine();
        newTask = new TaskDTO(taskTitle, taskDueDate, false,taskProjectName);
        tasksList.addToArrayList(newTask);
        System.out.println("Your task is created and added to the list successfully!! \n");
    }
    public void save() {
        hr.saveFile(tasksList);
    }
}
