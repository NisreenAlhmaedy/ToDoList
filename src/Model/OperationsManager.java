package Model;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
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
            System.out.println("Title: "+tasksList.getArrayList().get(i).getTaskTitle() +"  ,Date: "+ tasksList.getArrayList().get(i).getDateToString()+
                    "  ,Status: " +tasksList.getArrayList().get(i).getTaskStatus()+ "  ,Project: "+  tasksList.getArrayList().get(i).getTaskProject());
            System.out.println("\n");
        }


        }

    public ArrayList<TaskDTO> sortListByDate(ArrayList arrayList) {
        if (( arrayList== null) || (arrayList.isEmpty())) {
            return new ArrayList<>();
        }
        Collections.sort(arrayList);
        return arrayList;
    }




    public TaskDTO  createNewTask() {


        TaskDTO newTask=new TaskDTO();

        Scanner inputNewTask = new Scanner(System.in);

        System.out.println("please enter task title  ");
        String newTaskTitle = "" + inputNewTask.nextLine();

        System.out.println("please enter task due date >> dd.MM.yyyy ");
        String dueDateFromUser = "" + inputNewTask.nextLine();

        Date newTaskDueDate=newTask.getStringToDate(dueDateFromUser);

        System.out.println("please  enter task project name   ");
        String newTaskProjectName = "" + inputNewTask.nextLine();

        newTask = new TaskDTO(newTaskTitle, newTaskDueDate, false, newTaskProjectName);

return newTask;
    }



}
