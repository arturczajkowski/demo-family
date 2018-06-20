package phonebookservicecom.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import phonebookservicecom.example.demo.dto.ChildDto;
import phonebookservicecom.example.demo.dto.FatherDto;
import phonebookservicecom.example.demo.entity.Sex;
import phonebookservicecom.example.demo.exceptions.NewEntryExists;
import phonebookservicecom.example.demo.services.ChildService;
import phonebookservicecom.example.demo.services.FatherService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;


@Controller
public class PhoneBookWebController {


    @Autowired
    private FatherService fatherService;

    @Autowired
    private ChildService childService;

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE,
            method = RequestMethod.GET)
    public String familyTitle(){
        return "familiTitle";
    }

    @RequestMapping(value = "/family/list", produces = MediaType.TEXT_HTML_VALUE,
            method = RequestMethod.GET)
    public String findFamilyList(@RequestParam(value = "fatherLastName", required = false) String fatherLastName,
                                    @RequestParam(value = "childLastName", required = false) String childLastName, Map<String, Object> model) {
        List<FatherDto> fatherDtoList = fatherService.findAll();
        List<ChildDto> childDataDtoList = childService.findChildAll();
        model.put("fatherDataList", fatherDtoList);
        model.put("childDataList", childDataDtoList);
        return "familyData";
    }

    private Map<String, String> getTelephonNumberTypesAsMap() {
        Map<String, String> sexTypes = new HashMap<String, String>();
        for (Sex sexType : Sex.values()) {
            sexTypes.put(sexType.name(), sexType.getValue());
        }
        return sexTypes;
    }

    @RequestMapping(value = "/father/new")
    public String addFather(Map<String, Object> model) {
        model.put("fatherDataModel", new FatherDto());
//        model.put("childDataModel", new ChildDto());
//        model.put("childDataType", getTelephonNumberTypesAsMap());
        model.put("edit", false);
        return "editFatherData";
    }

        @RequestMapping(value = "/father/save", method = RequestMethod.POST)
    public String saveFather(@Valid @ModelAttribute(value = "fatherDataModel") FatherDto fatherDtoData,
                              BindingResult result, Map<String, Object> model) {
        model.put("fatherDataModel", fatherDtoData);
        if (result.hasErrors()) {
            return "editFatherData";
        } else {
            try {
                fatherService.save(fatherDtoData);
            } catch (NewEntryExists e) {
                model.put("errorMessage",
                        messageSource.getMessage("productModel.nameExists",
                                new String[]{fatherDtoData.getLastName()}, Locale.getDefault()));
                return "editFatherData";
            }
            return "redirect:/family/list";
        }
    }

    @RequestMapping(value = "/child/new")
    public String addChild(Map<String, Object> model) {
        model.put("childDataModel", new ChildDto());
        model.put("childDataType", getTelephonNumberTypesAsMap());
        model.put("edit", false);
        return "editChildData";
    }


    @RequestMapping(value = "/child/save", method = RequestMethod.POST)
    public String saveChild(@Valid @ModelAttribute(value = "childDataModel") ChildDto childDto,
                              BindingResult result, Map<String, Object> model) {
        model.put("childDataTypes", getTelephonNumberTypesAsMap());
        model.put("childDataModel", childDto);
        if (result.hasErrors()) {
            return "editChildData";
        } else {
            try {
                childService.saveChild(childDto);
            } catch (NewEntryExists e) {
                model.put("errorMessage",
                        messageSource.getMessage("productModel.nameExists",
                                new String[]{childDto.getLastName()}, Locale.getDefault()));
                return "editChildData";
            }
            return "redirect:/family/list";
        }
    }


    @RequestMapping(value = "/family/list/search", produces = MediaType.TEXT_HTML_VALUE,
            method = RequestMethod.GET)
    public String searchPhoneNumer(@RequestParam(value = "searchFamily", required = false) String lastName,
                                   Map<String, Object> model) {
        List<FatherDto> fatherDtoList = fatherService.findByLastName(lastName);
        List<ChildDto> childDtoList = childService.findByChildLastName(lastName);
        model.put("childDataList", childDtoList);
        model.put("fatherDataList", fatherDtoList);
        return "familyData";
    }




//
//    @RequestMapping(value = "/phonebook/delete/{id}")
//    public String deleteTheEntry(@PathVariable Integer id) {
//        personalDataService.delete(id);
//        return "redirect:/phonebook/list";
//    }
}
