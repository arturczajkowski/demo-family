package phonebookservicecom.example.demo.repository.specification;


import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;
import phonebookservicecom.example.demo.entity.Father;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class FatherSpecification implements Specification<Father> {

    private Father father;

    public FatherSpecification(Father filter) {
        this.father = filter;
    }

    @Override
    public Predicate toPredicate(Root<Father> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        Predicate p = criteriaBuilder.and();
        if (!StringUtils.isEmpty(father.getLastName())) {
            p.getExpressions().add(criteriaBuilder.like(root.get("name"), "%" + father.getLastName() + "%"));
        }
        return p;
    }
}
