package phonebookservicecom.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import phonebookservicecom.example.demo.dto.PersonalDataDto;
import phonebookservicecom.example.demo.entity.PersonalData;
import phonebookservicecom.example.demo.entity.TelephonNumberType;
import phonebookservicecom.example.demo.exceptions.NewEntryExists;
import phonebookservicecom.example.demo.services.PersonalDataService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;


@Controller
public class PhoneBookWebController {

    @Autowired
    private PersonalDataService personalDataService;

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "/phonebook/list", produces = MediaType.TEXT_HTML_VALUE,
            method = RequestMethod.GET)
    public String findPhoneBookList(@RequestParam(value = "personalDataName", required = false) String personalDataName,
                                    @RequestParam(value = "personalDataType", required = false) String personalDataType, Map<String, Object> model) {
        List<PersonalDataDto> personalDataDtoList = personalDataService.findByLastNameAndType(personalDataName, personalDataType);
        model.put("personalDataList", personalDataDtoList);
        return "personalData";
    }

    @RequestMapping(value = "/phonebook/list/search/number", produces = MediaType.TEXT_HTML_VALUE,
            method = RequestMethod.GET)
    public String searchPhoneNumer(@RequestParam(value = "phoneNumber", required = false) String phoneNumber,
                                   Map<String, Object> model) {
        List<PersonalDataDto> personalDataDtoList = personalDataService.findByPhoneNumber(phoneNumber);
        model.put("personalDataList", personalDataDtoList);
        return "personalData";
    }

    private Map<String, String> getTelephonNumberTypesAsMap() {
        Map<String, String> personalTypes = new HashMap<String, String>();
        for (TelephonNumberType numberType : TelephonNumberType.values()) {
            personalTypes.put(numberType.name(), numberType.getValue());
        }
        return personalTypes;
    }

    @RequestMapping(value = "/phonebook/new")
    public String addNumer(Map<String, Object> model) {
        model.put("personalDataModel", new PersonalDataDto());
        model.put("personalDataType", getTelephonNumberTypesAsMap());
        model.put("edit", false);
        return "editPersonalData";
    }

    @RequestMapping(value = "/phonebook/save", method = RequestMethod.POST)
    public String saveProduct(@Valid @ModelAttribute(value = "personalDataModel") PersonalDataDto personalDataDto,
                              BindingResult result, Map<String, Object> model) {
        model.put("personalDataTypes", getTelephonNumberTypesAsMap());
        model.put("personalDataModel", personalDataDto);
        if (result.hasErrors()) {
            return "editPersonalData";
        } else {
            try {
                personalDataService.save(personalDataDto);
            } catch (NewEntryExists e) {
                model.put("errorMessage",
                        messageSource.getMessage("productModel.nameExists",
                                new String[]{personalDataDto.getLastName()}, Locale.getDefault()));
                return "editPersonalData";
            }
            return "redirect:/phonebook/list";
        }
    }

    @RequestMapping(value = "/phonebook/edit/{id}")
    public String editTheEntry(@PathVariable Integer id, Map<String, Object> model) {
        PersonalDataDto personalDataDto = personalDataService.findById(id);
        model.put("personalDataModel", personalDataDto);
        model.put("personalDataType", getTelephonNumberTypesAsMap());
        model.put("edit", true);
        return "editPersonalData";
    }

    @RequestMapping(value = "/phonebook/delete/{id}")
    public String deleteTheEntry(@PathVariable Integer id) {
        personalDataService.delete(id);
        return "redirect:/phonebook/list";
    }
}
