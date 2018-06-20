package phonebookservicecom.example.demo.services;



import phonebookservicecom.example.demo.dto.ChildDto;
import phonebookservicecom.example.demo.exceptions.NewEntryExists;

import java.util.List;

public interface ChildService {

    List<ChildDto> findChildAll();
    List<ChildDto> findByChildLastName(String lastName);
    ChildDto findByChildId(Integer id);
    void saveChild(ChildDto childDto) throws NewEntryExists;
    void deleteChild(Integer id);
}
