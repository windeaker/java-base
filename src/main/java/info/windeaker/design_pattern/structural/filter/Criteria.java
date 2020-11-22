package info.windeaker.design_pattern.structural.filter;

import java.util.List;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/8/7
 */
public interface Criteria {
    public List<Person> meetCriteria(List<Person> persons);
}
