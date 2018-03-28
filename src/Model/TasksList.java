package Model;


import java.io.Serializable;
import java.util.ArrayList;

public class TasksList implements Serializable{





    ArrayList<TaskDTO> arrayList;



    public TasksList() {


        arrayList = new ArrayList<>();


    }

    public ArrayList<TaskDTO> getArrayList() {
        return arrayList;
    }

    public void addtoarray(TaskDTO dto)
    {

        arrayList.add(dto);


    }

}

