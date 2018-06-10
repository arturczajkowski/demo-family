package phonebookservicecom.example.demo.initializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import phonebookservicecom.example.demo.entity.PersonalData;
import phonebookservicecom.example.demo.entity.TelephonNumberType;
import phonebookservicecom.example.demo.repository.PersonalDataRepository;

import javax.annotation.PostConstruct;

@Component
public class Initializer {

    @Autowired
    private PersonalDataRepository personalDataRepository;

    @PostConstruct
    public void initialzeDate(){
        personalDataRepository.save(new PersonalData(1,"Artur","Czajkowski","792905836", TelephonNumberType.HOMEPHONE));
        personalDataRepository.save(new PersonalData(2,"Patryk", "Czajkowski","543543432",TelephonNumberType.WORKPHONE));
        personalDataRepository.save(new PersonalData(3,"Aneta", "Bartwicka","4324231",TelephonNumberType.WORKPHONE));
        personalDataRepository.save(new PersonalData(4,"Angelika", "Goralska","4324231",TelephonNumberType.HOMEPHONE));
        personalDataRepository.save(new PersonalData(5,"Dawid", "Kielbasa","546534432",TelephonNumberType.WORKPHONE));
        personalDataRepository.save(new PersonalData(6,"Michal", "Zawadki","54223432",TelephonNumberType.HOMEPHONE));
        personalDataRepository.save(new PersonalData(7,"Emil", "Bik","653634542523",TelephonNumberType.HOMEPHONE));
    }
}
