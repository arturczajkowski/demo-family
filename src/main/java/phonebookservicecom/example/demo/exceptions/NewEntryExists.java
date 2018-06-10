package phonebookservicecom.example.demo.exceptions;

public class NewEntryExists extends RuntimeException {

    public NewEntryExists(String message) {
        super(message);
    }
}
