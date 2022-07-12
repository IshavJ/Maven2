package jan21;
import java.util.*;
public class collections {
    public static void main(String args[]){
        //Implementing Classes..
        ArrayList ar = new ArrayList();
        HashSet hs = new HashSet();
        HashMap<String,String> hm = new HashMap();
        int m=hm.size();
        //Details Additions...
        ar.add("hello");ar.add(1);ar.add("hello");ar.add(123);ar.add('a');
        hm.put("Country","India");hm.put("Language","hindi");hm.put("Location","South-Asia");
        hs.add("hello");hs.add("yellow");hs.add(1);hs.add("123");hs.add(123456);
        //Iterator Process...
        System.out.println("Elements inside ArrayList ...");
        Iterator i = ar.iterator();
        while(i.hasNext()){
            System.out.print(i.next()+" ");
        }
        System.out.println("\nElements inside HashSet are..");
        Iterator j = hs.iterator();
        while(j.hasNext()){
            System.out.print(j.next()+" ");
        }
        System.out.println("\nValues for HashMap's keys are ..");
        for(String s:hm.values()){
            System.out.print(s+" ");
        }
    }
}
