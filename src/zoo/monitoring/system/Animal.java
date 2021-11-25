package zoo.monitoring.system;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Animal {
    public static String animalMont(String userAnimalInp) throws FileNotFoundException, IOException{//This method is focused on gathering the information for just animals
        //We have animalMont to return back as a string and we are saying that the input will be a string and it will be stored under userAnimalInp
        FileInputStream fileAnimals = null; //This allows for they system to read the file
        Scanner inAFS = null; //This helps with the system to read the file
        int i = 0; //This allows for the loop to work
        String animalInp; //Once we get the first word from userAnimalInp we save it here
        Scanner scnr1 = new Scanner(userAnimalInp); //This allows for userAnimalInp to be used as an input for the scanner
        
        animalInp = scnr1.next(); //This gets only the first word from the user's input just in case they inputted two words
        
        animalInp = animalInp.substring(0, 1).toUpperCase() + animalInp.substring(1); //With this we capitalize the first letter of the input to match the formatting in the file
        
        if (animalInp != null && animalInp.length() > 0 && animalInp.charAt(animalInp.length() - 1) == 's') {
            animalInp = animalInp.substring(0, animalInp.length() - 1); /*The animals in the "details" end with an s but further down there is no s at the end.
            This allows for the system to work if they write it plural or not.*/
        }
        fileAnimals = new FileInputStream("animals.txt"); 
        inAFS = new Scanner(fileAnimals);//These 2 lines we read the file and write it under inAFS
        
        i = 0; //This resets i back to 0 everytime the loop is finish
        while (i <= 50){ //This loop will only run through the first 50 lines of the file and if the information is more then 50 lines then it will need to be changed
            String lineAnimal = Files.readAllLines(Paths.get("animals.txt")).get(i); //This reads the line that corresponds to i
            if (lineAnimal.equals("Animal - " + animalInp)){ //This searches every line until it finds "Animal - " and the animal that the user has chosen
                
                //This line prints out the "Animal - " and the animal that was chosen
                System.out.println(lineAnimal);
                
                ++i; //We then increment i by 1 for the next line of information
                lineAnimal = Files.readAllLines(Paths.get("animals.txt")).get(i);//This reads the line that corresponds to the animal's name
                if (lineAnimal.startsWith("*****")){ //This same if and else statement is repeated 4 times in order to check to see if there are 5* on that line
                    String warning = lineAnimal.replaceAll("\\*",""); //If 5* are found then a dialog box is made, it gathers the information from that line and removes the 5*      
                    JOptionPane.showMessageDialog(null,warning, "Concern", JOptionPane.INFORMATION_MESSAGE);//This creates the dialog box
                }
                else{ //If there is no 5* then no dialog message will pop up
                    System.out.println(lineAnimal);
                }
                    
                ++i; //We then increment i by 1 for the next line of information
                lineAnimal = Files.readAllLines(Paths.get("animals.txt")).get(i);//This reads the line that corresponds to the animal's age
                if (lineAnimal.startsWith("*****")){ //This same if and else statement is repeated 4 times in order to check to see if there are 5* on that line
                    String warning = lineAnimal.replaceAll("\\*",""); //If 5* are found then a dialog box is made, it gathers the information from that line and removes the 5*      
                    JOptionPane.showMessageDialog(null,warning, "Concern", JOptionPane.INFORMATION_MESSAGE);//This creates the dialog box
                }
                else{ //If there is no 5* then no dialog message will pop up
                    System.out.println(lineAnimal);
                }
                    
                ++i; //We then increment i by 1 for the next line of information
                lineAnimal = Files.readAllLines(Paths.get("animals.txt")).get(i);//This reads the line that corresponds to the animal's health concerns
                if (lineAnimal.startsWith("*****")){ //This same if and else statement is repeated 4 times in order to check to see if there are 5* on that line
                    String warning = lineAnimal.replaceAll("\\*",""); //If 5* are found then a dialog box is made, it gathers the information from that line and removes the 5*      
                    JOptionPane.showMessageDialog(null,warning, "Concern", JOptionPane.INFORMATION_MESSAGE);//This creates the dialog box
                }
                else{ //If there is no 5* then no dialog message will pop up
                    System.out.println(lineAnimal);
                }
                    
                ++i; //We then increment i by 1 for the next line of information
                lineAnimal = Files.readAllLines(Paths.get("animals.txt")).get(i);//This reads the line that corresponds to the animal's feeding schedule
                if (lineAnimal.startsWith("*****")){ //This same if and else statement is repeated 4 times in order to check to see if there are 5* on that line
                    String warning = lineAnimal.replaceAll("\\*",""); //If 5* are found then a dialog box is made, it gathers the information from that line and removes the 5*      
                    JOptionPane.showMessageDialog(null,warning, "Concern", JOptionPane.INFORMATION_MESSAGE);//This creates the dialog box
                }
                else{ //If there is no 5* then no dialog message will pop up
                    System.out.println(lineAnimal);
                }
                break;
            }
            else{   
            }
            i = i + 1; //This increments i outside of the if condtions to be able to search through the document until the if condition is true
        }
        return animalInp;  //Once all of the information is gathered if returns it to the print statement in the main class
    }
}
