package phonebookservicecom.example.demo.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import phonebookservicecom.example.demo.converters.PersonalDataDtoConverters;
import phonebookservicecom.example.demo.dto.PersonalDataDto;
import phonebookservicecom.example.demo.entity.PersonalData;
import phonebookservicecom.example.demo.entity.TelephonNumberType;
import phonebookservicecom.example.demo.exceptions.NewEntryExists;
import phonebookservicecom.example.demo.repository.PersonalDataRepository;
import phonebookservicecom.example.demo.repository.specification.PersonalDataSpecification;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PersonalDataServiceImpl implements PersonalDataService{

    @Autowired
    private PersonalDataRepository personalDataRepository;

    @Autowired
    private PersonalDataDtoConverters personalDataDtoConverters;


    @Override
    public List<PersonalDataDto> findAll() {
        return StreamSupport.stream(
                personalDataRepository.findAll().spliterator(), true)
                .map(personalData -> personalDataDtoConverters.convert(personalData))
                .collect(Collectors.toList());
    }

    @Override
    public List<PersonalDataDto> findByLastName(String lastName) {
        return StreamSupport.stream(
                personalDataRepository.findByLastName(lastName).spliterator(), true)
                .map(personalData -> personalDataDtoConverters.convert(personalData))
                .collect(Collectors.toList());
    }

    @Override
    public List<PersonalDataDto> findByPhoneNumber(String phoneNumber) {
        return StreamSupport.stream(
                personalDataRepository.findByPhoneNumer(phoneNumber).spliterator(), true)
                .map(personalData -> personalDataDtoConverters.convert(personalData))
                .collect(Collectors.toList());
    }



    @Override
    public PersonalDataDto findById(Integer id) {
        PersonalData personalData = personalDataRepository.findOne(id);
      return personalDataDtoConverters.convert(personalData);


    }

    @Override
    public List<PersonalDataDto> findByLastNameAndType(String lastName, String type) {
            //assing product filters
            PersonalData filterProduct = new PersonalData();
            filterProduct.setLastName(lastName);

            TelephonNumberType telephonNumberType = null;
            if (!StringUtils.isEmpty(type)) {
                telephonNumberType = TelephonNumberType.valueOf(type);
                filterProduct.setType(telephonNumberType);
            }
            return StreamSupport.stream(
                    personalDataRepository.findAll(new PersonalDataSpecification(filterProduct)).spliterator(), true)
                    .map(product -> personalDataDtoConverters.convert(product))
                    .collect(Collectors.toList());
        }

    @Override
    public void save(PersonalDataDto personalDataDto) throws NewEntryExists {
        PersonalData personalData = personalDataDtoConverters.convertDto(personalDataDto);
        List<PersonalDataDto> productsByName=this.findByLastName(personalDataDto.getLastName());
        if (!CollectionUtils.isEmpty(productsByName)) {
            throw new NewEntryExists("Product with name "+personalDataDto.getLastName()+ " already exists");
        } else {
            personalDataRepository.save(personalData);
        }
    }

    @Override
    public void delete(Integer id) {
        personalDataRepository.delete(id);
    }
}
