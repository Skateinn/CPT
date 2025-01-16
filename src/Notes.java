import java.util.Scanner;
import java.util.LinkedList;

public class Notes {

    // A LinkedList to store the notes (title and content)
    private static LinkedList<Note> notes = new LinkedList<>();

    public Notes() {
        // Optional: initialize with default values (can be removed if not needed)
        notes.add(new Note("Sample Note", "This is a sample note content."));
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print(
                "Press 1 to create a new note/file:\nPress 2 to add to a current note:\nPress 3 to import notes together:\nPress 4 to Delete a note:\n");
        int ans = input.nextInt();
        // flush line
        input.nextLine(); 

        if (ans == 1) {
            // User creates a new note
            System.out.print("What is the new note's name:\n");
            String noteName = input.nextLine();
            System.out.print("What do you want to add:\n");
            String noteContent = input.nextLine();

            // Add the new note to the LinkedList
            notes.add(new Note(noteName, noteContent));

            System.out.println("New note created: " + noteName);
        } else if (ans == 2) {
            // User inputs text into an existing note
            System.out.print("What note do you want to add to:\n");
            String existingNoteName = input.nextLine();
            System.out.print("What content do you want to add:\n");
            String additionalContent = input.nextLine();

            // Find the note and append the content
            Note noteToUpdate = findNoteByTitle(existingNoteName);
            if (noteToUpdate != null) {
                noteToUpdate.addContent(additionalContent);
                System.out.println("Content added to " + existingNoteName);
            } else {
                System.out.println("Note not found!");
            }
        } else if (ans == 3) {
            // User wants to combine notes
            System.out.print("What notes do you want to add together (e.g., Note1 and Note2):\n");
            String partOne3 = input.nextLine();
            System.out.print("What note should the content go into:\n");
            String partTwo3 = input.nextLine();

            // Find the notes to combine
            Note noteOne = findNoteByTitle(partOne3);
            Note noteTwo = findNoteByTitle(partTwo3);

            if (noteOne != null && noteTwo != null) {
                // Combine the contents of the two notes
                noteTwo.combineContent(noteOne);
                System.out.println("Notes combined successfully!");
            } else {
                System.out.println("One or both notes not found!");
            }
        } else if (ans == 4) {
            // User wants to delete a note
            System.out.print("What note do you want to delete:\n");
            String noteToDelete = input.nextLine();

            // Find the note and delete it from the LinkedList
            Note note = findNoteByTitle(noteToDelete);
            if (note != null) {
                notes.remove(note);
                System.out.println("Note '" + noteToDelete + "' deleted successfully!");
            } else {
                System.out.println("Note not found!");
            }
        }

        // Optionally, print all notes at the end to confirm changes
        System.out.println("\nCurrent Notes:");
        for (Note note : notes) {
            System.out.println(note);
        }
    }

    // Helper method to find a note by its title
    private static Note findNoteByTitle(String title) {
        for (Note note : notes) {
            if (note.title.equals(title)) {
                return note;
            }
        }
        return null;
    }
}
