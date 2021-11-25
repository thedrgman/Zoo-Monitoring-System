package zoo.monitoring.system;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Habitat {
    public static String habitatMont(String userHabitInp) throws FileNotFoundException, IOException{ //This method is focused on gathering the information for just habitats
        //We have habitatMont to return back as a string and we are saying that the input will be a string and it will be stored under userHabitatInp
        FileInputStream fileHabitats = null; //This allows for they system to read the file
        Scanner inHFS = null; //This helps with the system to read the file
        int i = 0; //This allows for the loop to work
        String habitatInp; //Once we get the first word from userHabitInp we save it here
        Scanner scnr1 = new Scanner(userHabitInp); //This allows for userHabitInp to be used as an input for the scanner
        
        habitatInp = scnr1.next();//This gets only the first word from the user's input just in case they inputted two words
        
        habitatInp = habitatInp.substring(0, 1).toUpperCase() + habitatInp.substring(1); //With this we capitalize the first letter of the input to match the formatting in the file
        
        if (habitatInp != null && habitatInp.length() > 0 && habitatInp.charAt(habitatInp.length() - 1) == 's') {
            habitatInp = habitatInp.substring(0, habitatInp.length() - 1);//This removes an s if the user inputs the habitat with an s at the end
        }
        fileHabitats = new FileInputStream("habitats.txt");
        inHFS = new Scanner(fileHabitats); //These 2 lines we read the file and write it under inHFS
        
        i = 0; //This resets i back to 0 everytime the loop is finish
        while (i <= 50){//This loop will only run through the first 50 lines of the file and if the information is more then 50 lines then it will need to be changed
            String lineHabitats = Files.readAllLines(Paths.get("habitats.txt")).get(i);//This reads the line that corresponds to i
            if (lineHabitats.equals("Habitat - " + habitatInp)){//This searches every line until it finds "Habitat - " and the habitat that the user has chosen
                
                //This line prints out the "Habitat - " and the habitat that was chosen
                System.out.println(lineHabitats);
                
                ++i;//We then increment i by 1 for the next line of information
                lineHabitats = Files.readAllLines(Paths.get("habitats.txt")).get(i);//This reads the line that corresponds with the habitat's temperature
                if (lineHabitats.startsWith("*****")){//This same if and else statement is repeated 3 times in order to check to see if there are 5* on that line
                    String warning = lineHabitats.replaceAll("\\*","");//If 5* are found then a dialog box is made, it gathers the information from that line and removes the 5*
                    JOptionPane.showMessageDialog(null,warning, "Concern", JOptionPane.INFORMATION_MESSAGE);//This creates the dialog box
                }
                else{//If there is no 5* then no dialog message will pop up
                System.out.println(lineHabitats);
                }
                    
                ++i;//We then increment i by 1 for the next line of information
                lineHabitats = Files.readAllLines(Paths.get("habitats.txt")).get(i);//This reads the line that corresponds with the habitat's food source
                if (lineHabitats.startsWith("*****")){//This same if and else statement is repeated 3 times in order to check to see if there are 5* on that line
                    String warning = lineHabitats.replaceAll("\\*","");//If 5* are found then a dialog box is made, it gathers the information from that line and removes the 5*
                    JOptionPane.showMessageDialog(null,warning, "Concern", JOptionPane.INFORMATION_MESSAGE);//This creates the dialog box
                }
                else{//If there is no 5* then no dialog message will pop up
                System.out.println(lineHabitats);
                }
                
                ++i;//We then increment i by 1 for the next line of information
                lineHabitats = Files.readAllLines(Paths.get("habitats.txt")).get(i);//This reads the line that corresponds with the habitat's cleanliness
                if (lineHabitats.startsWith("*****")){//This same if and else statement is repeated 3 times in order to check to see if there are 5* on that line
                    String warning = lineHabitats.replaceAll("\\*","");//If 5* are found then a dialog box is made, it gathers the information from that line and removes the 5*
                    JOptionPane.showMessageDialog(null,warning, "Concern", JOptionPane.INFORMATION_MESSAGE);//This creates the dialog box
                }
                else{//If there is no 5* then no dialog message will pop up
                System.out.println(lineHabitats);
                }
                break;
            }
            else{
            }
            i = i + 1;//This increments i outside of the if condtions to be able to search through the document until the if condition is true
        }
        return habitatInp;  //Once all of the information is gathered if returns it to the print statement in the main class
    } 
}
