import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Scanner;

public class HelloC {

  /*  public static String exec(String command){
        String result ="";
        Runtime rt = Runtime.getRuntime();


        try{
        Process proc = rt.exec(command);

        StringBuffer sb = new StringBuffer();
        //InputStream stderr = proc.getErrorStream();
        InputStream  is = proc.getInputStream();

        InputStreamReader isr = new InputStreamReader(is);

        BufferedReader in = new BufferedReader(isr);

        String str = null;
        while ((str = in.readLine()) != null){
            System.out.println(str);
            sb.append(str);
        }

        result = sb.toString();

        in.close();








        int exitVal = proc.waitFor();
        System.out.println("Process exitValue: " + exitVal);

        proc.waitFor();
        }catch(Exception err){

        return "";
        }

        return result;
    }
*/
        // proc1.waitFor();//process1이 끝날때까지 대기







        public static void main(String args[]) {

            try {
                String s;
                Process p;
                ProcessBuilder pb = new ProcessBuilder();

                p=Runtime.getRuntime().exec("ls");
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(p.getInputStream()));
                while ((s = br.readLine()) != null){
                    System.out.println("line: " + s);}

                InputStream is = System.in;
                OutputStream os = p.getOutputStream();
                int data = is.read();
                while(data != -1){
                    os.
                    os.write(data);
                    os.flush();
                }






                System.out.println ("exit: " + p.exitValue());
              //  p.destroy();
               p.wait(100);
            } catch (Exception e) {}
        }


}
