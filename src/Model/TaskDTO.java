package Model;


/*
 *To Do List Application
 *@author Nisreen Alhmaedy
 *@Version  2018
 *
 */
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TaskDTO implements Serializable , Comparable<TaskDTO>{
    private String title;
    private Date dueDate;
    private boolean status;
    private String project;

    /**
     * Creates a new instance.
     */
   public TaskDTO(){
    }

/**
 *Creates a new instance.
 *
 *@param title  the task title.
 *@param dueDate the last day that the task must be done.
 *@param status the status that assigned to the task.
 *@param project the project which the task belong to.
 *
 */
    public TaskDTO(String title, Date dueDate , boolean status , String project ) {
        this.dueDate = dueDate;
        this.project = project;
        this.status =status;
        this.title = title;
    }

    public String getTaskTitle(){
        return title ;
    }
    /**
     * @return the project name which the task belong to.
     */
    public String getTaskProject(){
        return project ;
    }


    public boolean getTaskStatus(){
        return status;
    }
    public void setStatusAsDone() {

        this.status = true;
    }
    public String getTaskStatusAsString(){
        if(status){
            return "Done";
        }
        else return "NOT Done";
        }

/**
 * Converting the due date from Date type to String type
 *@return due date as a String type
 */
    public String getDateToString() {
        return new SimpleDateFormat("dd.MM.yyyy").format(dueDate);
    }

/**
 * Converting the due date which is taken from the user as
 * a string type to Date type
 * @param dueDateFromUser date as a String type
 * @return due date as a Date type
*/
public Date getStringToDate(String dueDateFromUser)  {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
    Date date ;
    try {
        date = dateFormat.parse(dueDateFromUser);
    } catch (ParseException e) {
      //  e.printStackTrace();
        date=null;
    }
    return date;
    }
    @Override
    public int compareTo(TaskDTO task) {

       return  this.dueDate.compareTo(task.dueDate);
    }

}
