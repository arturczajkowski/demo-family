package phonebookservicecom.example.demo.services;



import phonebookservicecom.example.demo.dto.FatherDto;
import phonebookservicecom.example.demo.exceptions.NewEntryExists;

import java.util.List;

public interface FatherService {

    List<FatherDto> findAll();
    List<FatherDto> findByLastName(String lastName);
    FatherDto findById(Integer id);
    void save(FatherDto personalDataDto) throws NewEntryExists;
    void delete(Integer id);
}
