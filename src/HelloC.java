import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class HelloC {

    public static String exec(String command){
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








        /*int exitVal = proc.waitFor();
        System.out.println("Process exitValue: " + exitVal);

        proc.waitFor();*/
        }catch(Exception err){

        return "";
        }

        return result;
    }

        // proc1.waitFor();//process1이 끝날때까지 대기




    public static void main(String[] args) {
            exec("sudo ./demo runtext16.ppm");


    }

}
