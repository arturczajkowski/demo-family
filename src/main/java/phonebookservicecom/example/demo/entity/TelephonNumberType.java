package phonebookservicecom.example.demo.entity;

public enum TelephonNumberType {

    HOMEPHONE("domowy"),WORKPHONE("sluzbowy");

    private String value;

    TelephonNumberType(String value) {
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
