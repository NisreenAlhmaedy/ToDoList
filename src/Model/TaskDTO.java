package Model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TaskDTO implements Serializable , Comparable<TaskDTO>{
    private String title;
    private Date dueDate;
    private boolean status;
    private String project;

   public TaskDTO(){
    }

/*
 *@param title  task title.
 *@param dueDate the day the task must be finished.
 *@param status the current state of the task.
 *@param project the project the task belongs to.
 *
 */
    public TaskDTO(String title, Date dueDate , boolean status , String project ) {
        this.dueDate = dueDate;
        this.project = project;
        this.status =status;
        this.title = title;
    }
    /*
     * @return the task title.
     */
    public String getTaskTitle(){
        return title ;
    }
    /*
     * @return the task project which the task belong to.
     */
    public String getTaskProject(){
        return project ;
    }
    /*
     * @return the task status.
     */
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
public Date getDueDate(){
        return dueDate;
}
/*
 *converting the due date from Date type to String type
 *@return due date as a String type
 */
    public String getDateToString() {
        return new SimpleDateFormat("dd.MM.yyyy").format(dueDate);
    }

/*
 * converting the due date which is taken from the user as
 * a string type to Date type
 * @param due date as a String type
 * @return due date as a Date type
*/

public Date getStringToDate(String dueDateFromUser)  {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
    Date d =new Date();
    try {
        d = dateFormat.parse(dueDateFromUser);
    } catch (ParseException e) {
        e.printStackTrace();
    }
    return d;
    }
    @Override
    public int compareTo(TaskDTO task) {

       return  this.dueDate.compareTo(task.dueDate);
    }

}
