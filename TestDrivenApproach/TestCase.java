package Feb4.TestDrivenApproach;

import org.testng.annotations.Test;

public class TestCase {
    @Test
    public void sub(){
        Subtraction s = new Subtraction();
        int total = s.sub(3,2);
        if(total == 1){
            System.out.println("Approach Successful");
        }
        else if(total == 0){
            System.out.println("Error Occurred");
        }
        else{
            System.out.println("Task Failed Successfully");
        }
    }
}
