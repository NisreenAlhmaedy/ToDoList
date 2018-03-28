package Model;

import java.io.Serializable;

public class TaskDTO implements Serializable{
    private String taskTitle;
    private String taskDate;
    private boolean taskStatus;
    private String taskProject;



    public TaskDTO(String taskTitle, String taskDate , boolean taskStatus , String taskProject ) {

        this.taskDate = taskDate;
        this.taskProject = taskProject;
        this.taskStatus = taskStatus;
        this.taskTitle = taskTitle;

    }


    /*
     * @return the task title.
     */
    public String getTaskTitle(){


        return taskTitle ;
    }


    /*
     * @return the task date.
     */
    public String getTaskDate(){


        return taskDate ;
    }

    /*
     * @return the task status.
     */
    public String getTaskStatus(){

        if(taskStatus==true) {
            return "Done !";
        }
        else return "not yet ";


    }

    /*
     * @return the task project which the task belong to.
     */
    public String getTaskProject(){


        return taskProject ;
    }



}
