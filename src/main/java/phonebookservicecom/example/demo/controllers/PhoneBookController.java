package phonebookservicecom.example.demo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import phonebookservicecom.example.demo.dto.PersonalDataDto;
import phonebookservicecom.example.demo.services.PersonalDataService;


import java.util.List;

@RestController
@RequestMapping("/personalData")
public class PhoneBookController {

    @Autowired
    PersonalDataService personalDataService;


    @RequestMapping(value = "/")
    public List<PersonalDataDto> findAll() {
        return personalDataService.findAll();
    }

    @RequestMapping(value = "/{id}")
    public PersonalDataDto findById(@PathVariable Integer id) {
        return personalDataService.findById(id);
    }

}
