package jan21;
import java.util.ArrayList;
public class RedunArrayList {
    public static void main(String args[]){
        ArrayList ar = new ArrayList();
        ar.add(" ");ar.add("Welcome");
        ar.add("User !");ar.add("Hello");
        ar.add("There");ar.add("How are");ar.add("you doing ?");
        ar.add("Hello");ar.add("??");
        int a =ar.size();
        System.out.println("location(s) Where the 'Hello' word resides in the ArrayList : ");
        for(int i = 0 ;i<=a-1;i++){
            if(ar.get(i) =="Hello"){ System.out.println(i); }
        }
    }
}
