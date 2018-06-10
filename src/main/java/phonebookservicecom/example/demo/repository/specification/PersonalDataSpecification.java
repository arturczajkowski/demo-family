package phonebookservicecom.example.demo.repository.specification;


import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;
import phonebookservicecom.example.demo.entity.PersonalData;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class PersonalDataSpecification implements Specification<PersonalData> {

    private PersonalData personalData;

    public PersonalDataSpecification(PersonalData filter) {
        this.personalData = filter;
    }

    @Override
    public Predicate toPredicate(Root<PersonalData> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        Predicate p = criteriaBuilder.and();
        if (!StringUtils.isEmpty(personalData.getLastName())) {
            p.getExpressions().add(criteriaBuilder.like(root.get("name"), "%" + personalData.getLastName() + "%"));
        }
        if (personalData.getType() != null) {
            p.getExpressions().add(criteriaBuilder.equal(root.get("type"), personalData.getType()));
        }
        return p;
    }
}
