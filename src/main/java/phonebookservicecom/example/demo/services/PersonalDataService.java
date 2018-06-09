package phonebookservicecom.example.demo.services;

import phonebookservicecom.example.demo.dto.PersonalDataDto;
import phonebookservicecom.example.demo.exceptions.NewEntryExists;

import java.util.List;

public interface PersonalDataService {

    List<PersonalDataDto> findAll();
    List<PersonalDataDto> findByLastName(String lastName);
    List<PersonalDataDto> findByPhoneNumber(String phoneNumer);
    PersonalDataDto findById(Integer id);
    List<PersonalDataDto> findByLastNameAndType(String lastName, String type);
    void save(PersonalDataDto personalDataDto) throws NewEntryExists;
    void delete(Integer id);

}
