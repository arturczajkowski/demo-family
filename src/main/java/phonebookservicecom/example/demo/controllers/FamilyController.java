package phonebookservicecom.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import phonebookservicecom.example.demo.dto.FatherDto;
import phonebookservicecom.example.demo.services.ChildService;
import phonebookservicecom.example.demo.services.FatherService;

import java.util.List;

@RestController
@RequestMapping("/familyData")
public class FamilyController {
    @Autowired
    FatherService fatherService;

    @Autowired
    ChildService childService;

    @RequestMapping(value = "/")
    public List<FatherDto> findAll() {
        return fatherService.findAll();
    }

    @RequestMapping(value = "/{id}")
    public FatherDto findById(@PathVariable Integer id) {
        return fatherService.findById(id);
    }
}
