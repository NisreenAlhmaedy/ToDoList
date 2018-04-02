package DBHandler;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import Model.*;
/*
 *@author Nisreen Alhmaedy
 */


/**
 * Reads and writes data to file
 */
public class DBHandler {

/**
 *Applied the deserialization to restore the state of the
 *Task List object that was saved in "Info.ser " file
 *
 *@return tasksList that restored from memory
 */
    public TasksList loadFile() {
        TasksList tasksList=new TasksList() ;

        if (new File("Info.ser").exists()) {
            try {
                FileInputStream fis = new FileInputStream("Info.ser");
                ObjectInputStream ois = new ObjectInputStream(fis);
                tasksList = (TasksList) ois.readObject();
                fis.close();
                ois.close();
               // System.out.println("Deserialize data has been created in the memory");
            } catch (IOException | ClassNotFoundException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return tasksList;
    }
/**
 *  Applied the serialization to save the state of the TasksList object that was
 *  created in the memory in an external file "Info.ser" then we can restore it when
 *  the program starts again
 *
 *@param tasksList the current tasks list
 */
    public void saveFile(TasksList tasksList) {
        try
        {
            FileOutputStream fos = new FileOutputStream("Info.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(tasksList);
            oos.close();
            fos.flush();
            fos.close();
            //System.out.println("Serialized data has been saved in the project in a file called Info.ser");
        }
        catch(IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }


}




















