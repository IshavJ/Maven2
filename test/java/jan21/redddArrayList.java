package jan21;

import java.util.*;

public class redddArrayList {
    public static void main(String args[]){
        ArrayList ar = new ArrayList();
        ar.add("We");
        ar.add("Hello");
        ar.add("will");
        ar.add("see");
        ar.add("how");
        System.out.println("Using ArrayList ...");
        Iterator j = ar.iterator();
        while(j.hasNext()){
            System.out.print(j.next()+" ");
        }
        System.out.println("\nUsing HashSet ...");
        HashSet hs = new HashSet(ar);
        Iterator i =hs.iterator();
        while(i.hasNext()){
            System.out.print(i.next()+" ");
        }
    }
}
