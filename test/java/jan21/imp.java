package jan21;
public class imp extends parent {
    int b=90;
    public void show(int b){
        System.out.println("Processing Commencing...");
        System.out.println(b);
        System.out.println(this.b);
        System.out.println(super.b);
        System.out.println("Processing Completed");
    }
    public static void main(String args[]){
        imp i = new imp();
        i.show(30);
    }
}

