package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove (){
        //create 2 lists
        AListNoResizing<Integer> solidList = new AListNoResizing<>();
        BuggyAList<Integer> bugList = new BuggyAList<>();

        //add sth to both lists
        solidList.addLast(4);
        bugList.addLast(4);

        solidList.addLast(5);
        bugList.addLast(5);

        solidList.addLast(6);
        bugList.addLast(6);

        //remove last item from both lists
//        solidList.removeLast();
//        bugList.removeLast();

        assertEquals(solidList.removeLast(),bugList.removeLast());

//        assertEquals("6", solidList.removeLast().toString());
//        assertEquals("6", bugList.removeLast().toString());
//
//        solidList.removeLast();
//        bugList.removeLast();

//        assertEquals("5", solidList.removeLast().toString());
        assertEquals("5", bugList.removeLast().toString());
//
//        solidList.removeLast();
//        bugList.removeLast();
//
//        assertEquals("4", solidList.removeLast().toString());
//        assertEquals("4", bugList.removeLast().toString());
    }

    @Test
    public void randomizedTest(){
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> broken = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                broken.addLast(randVal);
//                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                int brokenSize = broken.size();
//                System.out.println("size: " + size);
//                System.out.println("size: " + brokenSize);
            } else if (operationNumber == 2 && L.size()>0) {
                L.removeLast();
                broken.removeLast();
//                System.out.println("remove last");
            }else if (operationNumber == 3 && L.size()>0) {
                L.getLast();
                broken.getLast();
//                System.out.println("get last");
            }
        }

    }

}


