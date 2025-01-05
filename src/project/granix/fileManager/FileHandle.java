package fileManager;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class FileHandle {
    //Name Constructor
    String FileName;
    public FileHandle (String FileName){
            this.FileName = FileName;
        }
    public void Action(){
        // File Path
        File file = new File(FileName);

        // Desktop Support Check
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            try {
                // Check if the file exists
                if (file.exists()) {
                    // Open the file 
                    desktop.open(file);
                } else {
                    System.out.println("File not found: " + file.getAbsolutePath());
                }
            } catch (IOException e) {
                System.out.println("An error occurred while opening the file: " + e.getMessage());
            }
        } else {
            System.out.println("Error.");
        }
    }

    public void DeleteFile(){
        try {
            // Sleep to make sure file is open before delete
            Thread.sleep(5000);
        } catch (InterruptedException e) {
             e.getMessage();
        }

        // Path
        File file = new File(FileName);
        // Attempt to delete the file
        if (file.delete()) {
            System.out.println("File deleted successfully: " + file.getAbsolutePath());
        } else {
            System.out.println("Failed to delete the file");
        }
    }

    public void WriteFile(){
        //Get Time and Date
        // Get the current date
        LocalDate currentDate = LocalDate.now();
        
        // Format the date as a string
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = currentDate.format(dateFormatter);
        
        System.out.println("Formatted Date: " + formattedDate);

        // Get the current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Format the date and time as a string
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentDateTime.format(dateTimeFormatter);

        System.out.println("Formatted Date and Time: " + formattedDateTime);
        
        //Write File 
        try(FileWriter WriteFile = new FileWriter("example.txt", true)){
            WriteFile.write("Hello World! \n" + formattedDateTime);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }   
}


