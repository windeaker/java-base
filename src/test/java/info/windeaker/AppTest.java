package info.windeaker;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        Object object=new Object();
        assertTrue( true );
        String a="";
    }

    public Map<Object,Object> convert(Map<Object,Object> origin){
        Map<Object,Object> result=new HashMap<>();
        Iterator<Map.Entry<Object,Object>> iterater=origin.entrySet().iterator();
        while(iterater.hasNext()){
            Map.Entry<Object,Object> entry=iterater.next();
            Object targetKey=entry.getValue();
            Object targetValue=result.getOrDefault(targetKey,null);
            if (targetValue!=null){
                if (targetValue instanceof ArrayList){
                    ((ArrayList)targetValue).add(entry.getKey());
                }else{
                    ArrayList<Object> targetValueList=new ArrayList<>();
                    targetValueList.add(targetValue);
                    targetValueList.add(entry.getKey());
                    result.put(targetKey,targetValueList);
                }
            }else{
                result.put(entry.getValue(),entry.getKey());
            }
        }
        return result;
    }
}
