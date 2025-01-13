import java.util.Scanner;
import java.util.LinkedList;

public class Notes {

    // A LinkedList to store the names of notes
    private static LinkedList<String> notes = new LinkedList<>();
    // A LinkedList to store the content of each note
    private static LinkedList<String> content = new LinkedList<>();
    //chat gpt gave the idea for linked list
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Press 1 to create a new note/file:\nPress 2 to add to a current note:\nPress 3 to import notes together:\nPress 4 to Delete a note:\n");
        int ans = input.nextInt(); 
        input.nextLine();  // flush line
        
        if (ans == 1) {
            // User creates a new note
            System.out.print("What is the new note's name:\n");
            String noteName = input.nextLine();
            System.out.print("What do you want to add:\n");
            String noteContent = input.nextLine();
            
            // Add the new note and content to the LinkedLists
            notes.add(noteName);
            content.add(noteContent);
            
            System.out.println("New note created: " + noteName);
        }
        else if (ans == 2) {
            // User inputs text into an existing note
            System.out.print("What note do you want to add to:\n");
            String existingNoteName = input.nextLine();
            System.out.print("What content do you want to add:\n");
            String additionalContent = input.nextLine();
            
            // Find the note and append the content
            int index = notes.indexOf(existingNoteName);
            if (index != -1) {
                String existingContent = content.get(index);
                content.set(index, existingContent + "\n" + additionalContent);
                System.out.println("Content added to " + existingNoteName);
            } else {
                System.out.println("Note not found!");
            }
        }
        else if (ans == 3) {
            // User wants to combine notes
            System.out.print("What notes do you want to add together (e.g., Note1 and Note2):\n");
            String partOne3 = input.nextLine();
            System.out.print("What note should the content go into:\n");
            String partTwo3 = input.nextLine();
            
            // Find the notes to combine
            int indexOne = notes.indexOf(partOne3);
            int indexTwo = notes.indexOf(partTwo3);
            
            if (indexOne != -1 && indexTwo != -1) {
                String contentOne = content.get(indexOne);
                String contentTwo = content.get(indexTwo);
                
                // Combine the contents and update the second note
                content.set(indexTwo, contentOne + "\n" + contentTwo);
                System.out.println("Notes combined successfully!");
            } else {
                System.out.println("One or both notes not found!");
            }
        }
        else if (ans == 4){

            // User wants to delete a note
            System.out.print("What note do you want to delete:\n");
            
            String partOne4 = input.nextLine();
            // 1: notes.index(title)
            // 2: notes.remove(^)
            // 3. contents.remove(^)
            
        }
        
        // Optionally, print all notes at the end to confirm changes
        System.out.println("\nCurrent Notes:");
        for (int i = 0; i < notes.size(); i++) {
            System.out.println(notes.get(i) + ": " + content.get(i));
        }
    }
}
