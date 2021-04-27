import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class main {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        //new Download();
        System.out.print("Where to start from ,{len(urls)} videos found ?type 0 is the first:");
        String startFrom = scanner.nextLine().strip();
        System.out.println();
        System.out.print("Where to save the Videos:");
        String pathOfSaveFolder = scanner.nextLine().strip();
        System.out.println();

        try {

            Process process = Runtime.getRuntime().exec("python3 /Users/jim/Desktop/Coding/python/youtubeDownloaderWithJavaHelp/main.py "+"pathtourls "+pathOfSaveFolder+" "+startFrom);
            printResults(process);

        }catch (Exception
        e){
            System.out.println("gg");
            e.printStackTrace();
        }
        }
    public static void printResults(Process p) throws IOException {
        String s = null;
        BufferedReader stdInput = new BufferedReader(new
                InputStreamReader(p.getInputStream()));

        BufferedReader stdError = new BufferedReader(new
                InputStreamReader(p.getErrorStream()));

        // read the output from the command
        System.out.println("Here is the standard output of the command:\n");
        while ((s = stdInput.readLine()) != null) {
            System.out.println(s);
        }

        // read any errors from the attempted command
        System.out.println("Here is the standard error of the command (if any):\n");
        while ((s = stdError.readLine()) != null) {
            System.out.println(s);
        }

        System.exit(0);
    }
}
