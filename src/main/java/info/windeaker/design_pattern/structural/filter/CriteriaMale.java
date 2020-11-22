package info.windeaker.design_pattern.structural.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/8/7
 */
public class CriteriaMale implements Criteria {
    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> malePersons = new ArrayList<>();
        for (Person person : malePersons
        ) {
            if (person.getGender().equalsIgnoreCase("MALE")) {
                malePersons.add(person);
            }
        }
        return malePersons;
    }
}
