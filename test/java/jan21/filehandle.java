package jan21;
import java.io.*;
public class filehandle {
    public static void main(String args[]) throws IOException {
        //File Creation...
        File f = new File("./default_lol.txt");
        f.createNewFile();
        //Writing file..
        System.out.println("Writing process begin..");
        FileWriter fw =  new FileWriter("./default_lol.txt");
        fw.write("This is a Cow.\n");
        fw.write("It has one tail.\n");
        fw.write("It have four legs.\n");
        fw.write("It have 2 eyes.\n");
        fw.write("It has one nose.\n");
        fw.write("It have 2 horns.\n");
        fw.close();
        System.out.println("Writing finished");
        //reading file..
        System.out.println("Reading Commenced..");
        FileReader fr = new FileReader("./default_lol.txt");
        BufferedReader br = new BufferedReader(fr);
        String s ;//br.readLine();
        while((s=br.readLine())!=null){
                System.out.println(s);}
        br.close();
        System.out.println("Reading Completed");
    }
}
