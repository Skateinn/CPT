public class Note {
    String title;
    String content;

    // Constructor to initialize the Note with title and content
    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // Method to add content to the note
    public void addContent(String additionalContent) {
        this.content += "\n" + additionalContent;
    }

    // Method to combine the content of another note
    public void combineContent(Note otherNote) {
        this.content += "\n" + otherNote.content;
    }

    @Override
    public String toString() {
        return title + ": " + content;
    }
}
