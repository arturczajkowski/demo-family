package phonebookservicecom.example.demo.initializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import phonebookservicecom.example.demo.entity.*;
import phonebookservicecom.example.demo.repository.ChildRepository;
import phonebookservicecom.example.demo.repository.FatherRepository;

import javax.annotation.PostConstruct;

@Component
public class Initializer {


    @Autowired
    private FatherRepository fatherRepository;

    @Autowired
    private ChildRepository childRepository;

    @PostConstruct
    public void initialzeDate(){
        fatherRepository.save(new Father(1,"Artur","Czajkowski","93081502136","15-08-1993"));
        childRepository.save(new Child(1,"Ania", "Czajkowski","11247659481","11-01-2011", Sex.GIRL));
        childRepository.save(new Child(2,"Pawel", "Czajkowski","11247659481","11-01-2011", Sex.BOY));
    }
}
