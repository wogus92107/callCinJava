import java.io.*;
import java.util.ArrayList;
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

     /*       try {
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

                    os.write(data);
                    os.flush();
                }






                System.out.println ("exit: " + p.exitValue());
              //  p.destroy();
               p.wait(100);
            } catch (Exception e) {}*/
            try{

                ArrayList<String> commandlist = new ArrayList<>();
                commandlist.add("echo");
                commandlist.add("hello");




            Scanner scan = new Scanner(System.in);
            ProcessBuilder builder = new ProcessBuilder(commandlist);
            builder.inheritIO();
            builder.redirectErrorStream(true);




            Process process = builder.start();


            OutputStream stdin = process.getOutputStream ();


            InputStream stderr = process.getErrorStream ();
            InputStream stdout = process.getInputStream ();


            BufferedReader reader = new BufferedReader (new InputStreamReader(stdout));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(stdin));


                String line = reader.readLine();
                while (line != null && ! line.trim().equals("--EOF--")) {
                    System.out.println ("Stdout: " + line);
                    line = reader.readLine();
                }

          line = reader.readLine();
                while (line != null) {
                    System.out.println ("Stdout: " + line);
                    line = reader.readLine();
                }

               /* System.out.println(builder.directory().getName());*/
                String input = scan.nextLine();

                input += "\n";
                writer.write(input);
                writer.flush();

                input = scan.nextLine();
                input += "\n";
                writer.write(input);
                writer.flush();

            while (scan.hasNext()) {
             input = scan.nextLine();
                if (input.trim().equals("exit")) {
                    // Putting 'exit' amongst the echo --EOF--s below doesn't work.
                    writer.write("exit\n");
                } else {
                    writer.write("((" + input + ") && echo --EOF--) || echo --EOF--\n");
                }
                writer.flush();

                line = reader.readLine();
                while (line != null && ! line.trim().equals("--EOF--")) {
                    System.out.println ("Stdout: " + line);
                    line = reader.readLine();
                }
                if (line == null) {
                    break;
                }
            }
            }catch(Exception ex){}
        }


}
