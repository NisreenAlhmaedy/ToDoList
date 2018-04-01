package Model;

/*
 *To Do List Application
 *@author Nisreen Alhmaedy
 *@Version  2018
 *
 */
import java.io.Serializable;
import java.util.ArrayList;

public class TasksList implements Serializable{

   private ArrayList<TaskDTO> tasksArrayList;

    /**
     * Creates a new instance.
     */
    public TasksList() {
        tasksArrayList = new ArrayList<>();
    }

    public ArrayList<TaskDTO> getArrayList() {
        return tasksArrayList;
    }

    public void addToArrayList(TaskDTO dto){

        tasksArrayList.add(dto);
    }

}

