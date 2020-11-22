package info.windeaker.design_pattern.structural.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/8/7
 */
public class CriteriaSingle implements Criteria {

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> singlePersons = new ArrayList<Person>();
        for (Person person : persons) {
            if(person.getMaritalStatus().equalsIgnoreCase("SINGLE")){
                singlePersons.add(person);
            }
        }
        return singlePersons;
    }

}
