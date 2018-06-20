package phonebookservicecom.example.demo.entity;

public enum Sex {

    BOY("chlopiec"),GIRL("dziewczynka");

    private String value;

    Sex(String value) {
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
