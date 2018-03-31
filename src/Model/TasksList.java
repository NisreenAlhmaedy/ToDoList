package Model;


import java.io.Serializable;
import java.util.ArrayList;

public class TasksList implements Serializable{

   private ArrayList<TaskDTO> tasksArrayList;

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

