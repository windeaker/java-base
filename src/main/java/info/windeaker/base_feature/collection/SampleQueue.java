package info.windeaker.base_feature.collection;

import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.util.PriorityQueue;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/8/22
 */
public class SampleQueue {


    @Test
    public void priorityQueueTest(){
        PriorityQueue priorityQueue=new PriorityQueue<Integer>();
        priorityQueue.add(3);
        priorityQueue.add(6);
        priorityQueue.add(0);
        priorityQueue.add(2);
        for (Object o : priorityQueue) {
            System.out.println(o);
        }
    }

}
