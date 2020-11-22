package info.windeaker.design_pattern.structural.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/8/7
 */
public class CriteriaFemale implements Criteria {
    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> femalePersons = new ArrayList<>();
        for (Person person : femalePersons
        ) {
            if (person.getGender().equalsIgnoreCase("FEMALE")) {
                femalePersons.add(person);
            }
        }
        return femalePersons;
    }
}
