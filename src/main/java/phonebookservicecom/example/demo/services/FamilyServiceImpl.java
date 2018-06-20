package phonebookservicecom.example.demo.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import phonebookservicecom.example.demo.converters.ChildDtoConverter;
import phonebookservicecom.example.demo.converters.FatherDtoConverter;
import phonebookservicecom.example.demo.dto.ChildDto;
import phonebookservicecom.example.demo.dto.FatherDto;
import phonebookservicecom.example.demo.entity.Child;
import phonebookservicecom.example.demo.entity.Father;
import phonebookservicecom.example.demo.exceptions.NewEntryExists;
import phonebookservicecom.example.demo.repository.ChildRepository;
import phonebookservicecom.example.demo.repository.FatherRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class FamilyServiceImpl implements FatherService, ChildService {

    @Autowired
    private FatherRepository fatherRepository;

    @Autowired
    private FatherDtoConverter fatherDtoConverter;

    @Autowired
    private ChildDtoConverter childDtoConverter;

    @Autowired
    private ChildRepository childRepository;

    @Override
    public List<FatherDto> findAll() {
        return StreamSupport.stream(
                fatherRepository.findAll().spliterator(), true)
                .map(personalData -> fatherDtoConverter.convert(personalData))
                .collect(Collectors.toList());
    }

    @Override
    public List<FatherDto> findByLastName(String lastName) {
        return StreamSupport.stream(
                fatherRepository.findByLastName(lastName).spliterator(), true)
                .map(personalData -> fatherDtoConverter.convert(personalData))
                .collect(Collectors.toList());
    }

    @Override
    public FatherDto findById(Integer id) {
        Father father = fatherRepository.findOne(id);
        return fatherDtoConverter.convert(father);
    }

    @Override
    public void save(FatherDto fatherDto) throws NewEntryExists {

        Father father = fatherDtoConverter.convertDto(fatherDto);
        List<FatherDto> fatherDtoByName = this.findByLastName(fatherDto.getLastName());
        if (!CollectionUtils.isEmpty(fatherDtoByName)) {
            throw new NewEntryExists("Father with name " + fatherDto.getLastName() + " already exists");
        } else {
            fatherRepository.save(father);
        }

    }
    @Override
    public void delete(Integer id) {
        fatherRepository.delete(id);
    }

    @Override
    public List<ChildDto> findChildAll() {
        return StreamSupport.stream(
                childRepository.findAll().spliterator(), true)
                .map(child -> childDtoConverter.convert(child))
                .collect(Collectors.toList());
    }

    @Override
    public List<ChildDto> findByChildLastName(String lastName) {
        return StreamSupport.stream(
                childRepository.findByLastName(lastName).spliterator(), true)
                .map(child -> childDtoConverter.convert(child))
                .collect(Collectors.toList());
    }

    @Override
    public ChildDto findByChildId(Integer id) {
        Child child = childRepository.findOne(id);
        return childDtoConverter.convert(child);
    }

    @Override
    public void saveChild(ChildDto childDto) throws NewEntryExists {
        Child child = childDtoConverter.convertDto(childDto);
        List<ChildDto> findByChildLastName = this.findByChildLastName(childDto.getLastName());
        if (!CollectionUtils.isEmpty(findByChildLastName)) {
            throw new NewEntryExists("Child with name " + childDto.getLastName() + " already exists");
        } else {
            childRepository.save(child);
        }
    }

    @Override
    public void deleteChild(Integer id) {
        childRepository.delete(id);
    }


}
