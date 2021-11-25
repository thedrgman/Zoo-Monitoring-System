/*Welcome to the Atlanta Zoo Monitoring System.
This is used to help monitor both particular animals and habitats at the zoo. 
Also it will provide with any alert message that may be for the area of interest.*/
package zoo.monitoring.system;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class ZooMonitoringSystem {
    @SuppressWarnings("empty-statement")
    public static void main (String[] args) throws IOException {
        Scanner scnr = new Scanner(System.in); //This allows for the system to read the user's inputs
        String userInp; //The first user input is saved here
        String animalInp; //The animal that they have chosen goes here
        String habitatInp; //The habitat that they have chosen goes here
        int i = 0; //This allows for the loops to work
        

        //We ask the user what would they like to do with an option of leaving the program immediately
        System.out.println("What would you like to today: Monitor an animal or monitor a habitat or to exit");
        userInp = scnr.next();
        
        System.out.println();
        
        //Sometimes a user may captilize parts or all of their input, this allows for everything to be lower case
        userInp = userInp.toLowerCase();
        
        //This if statement allows for the user to exit the system and it displays an thank you message to inform they that the system has closed
        if ("exit".equals(userInp)){
            System.out.println("Thank you for using The Atlanta Zoo Monitoring System");
        }
        else{
            while (!"exit".equals(userInp)){ //The while loop allows for the user to repeatedly use the system until they are ready to leave
                if ("animal".equals(userInp)){ // With this if condition we narrow down their search for just animals
                    System.out.println("You chose to monitor an animal");
                    System.out.println();
                    i = 0; /* We reset i before the while loop so that if the user 
                    searches through the animals more than once they are able to get the full list of animals again*/
                    while (i <= 12){ /*The while loop only looks at the first 12 lines for the list of animals, so if the 
                        list is furter down the file or there is more than 12 animals then that number will need to be changed*/
                        String lineAnimal = Files.readAllLines(Paths.get("animals.txt")).get(i); //This reads the line that corresponds to i
                        if (lineAnimal.contains("Details")){ //We search for the lines that only contain Details to get all of the animals on the file
                            System.out.println(lineAnimal); //This prints out that specific line
                        }
                        else{//When there are no more Details to find the loop stops
                            break;
                        }
                        i = i + 1; //We increment i by one ever time the loop runs through
                    }
                    System.out.println();
                    System.out.println("Which animal would you like to monitor? ");
                    animalInp = scnr.next(); //After showing what animals are on the file we then ask the user which animal they would like to monitor
                    
                    System.out.println();
                    System.out.println(Animal.animalMont(animalInp));//For this we gather our information from another class and method
                }
                else if ("habitat".equals(userInp)){//For this we take a look at the habitats that are available to monitor and their information
                    System.out.println("You chose to monitor a habitat");
                    System.out.println();
                    i = 0;/* We reset i before the while loop so that if the user 
                    searches through the habitats more than once they are able to get the full list of habitats again*/
                    while (i <= 12){/*The while loop only looks at the first 12 lines for the list of habitats, so if the 
                        list is furter down the file or there is more than 12 habitats then that number will need to be changed*/
                        String lineHabitats = Files.readAllLines(Paths.get("habitats.txt")).get(i);//This reads the line that corresponds to i
                        if (lineHabitats.contains("Details")){//We search for the lines that only contain Details to get all of the habitats on the file
                            System.out.println(lineHabitats);//This prints out that specific line
                        }
                        else{//When there are no more Details to find the loop stops
                            break;
                        }
                        i = i + 1;//We increment i by one ever time the loop runs through
                    }
                    System.out.println();
                    System.out.println("Which habitat would you like to monitor? ");
                    habitatInp = scnr.next();//After showing what habitats are on the file we then ask the user which habitat they would like to monitor
                    
                    System.out.println(Habitat.habitatMont(habitatInp));//For this we gather our information from another class and method
                }
                System.out.println();
                System.out.println("What would you like to today: Monitor an animal or monitor a habitat or to exit");
                userInp = scnr.next();/*After they get the information they want 
                for the specific animal or habitat they want then they have the option to look some more or to exit*/
            }
        }
        System.out.println();
        System.out.println("Thank you for using The Atlanta Zoo Monitoring System");//We they show this message they they are leaving the system
    }
}