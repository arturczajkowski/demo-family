package phonebookservicecom.example.demo.repository.specification;


import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;
import phonebookservicecom.example.demo.entity.Child;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class ChildSpecification implements Specification<Child> {

    private Child child;

    public ChildSpecification(Child filter) {
        this.child = filter;
    }

    @Override
    public Predicate toPredicate(Root<Child> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        Predicate p = criteriaBuilder.and();
        if (!StringUtils.isEmpty(child.getLastName())) {
            p.getExpressions().add(criteriaBuilder.like(root.get("name"), "%" + child.getLastName() + "%"));
        }
        if (child.getType() != null) {
            p.getExpressions().add(criteriaBuilder.equal(root.get("type"), child.getType()));
        }
        return p;
    }
}
