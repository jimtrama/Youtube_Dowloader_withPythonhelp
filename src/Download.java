//import  org.openqa.selenium.*;
//import org.openqa.selenium.chrome.*;
//import org.openqa.selenium.*;
//import org.openqa.selenium.interactions.Actions;
//import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Download {
    ChromeDriver driver;
    ArrayList<String> urls;

    Download()  {
        urls = new ArrayList<>();
        System.setProperty("webdriver.chrome.driver", "./chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://youtube.com");
        driver.findElementByXPath("//button[@jsname='higCR']").click();

        getUrls();
        System.out.println(urls.size());
        try{
            File fout = new File("urls.txt");
            FileOutputStream fos = new FileOutputStream(fout);

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

            for (String url : urls) {
                System.out.println(url);
                bw.write(url);
                bw.newLine();
            }

            bw.close();

        }catch (Exception e){

        }


    }


    private void getUrls() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter url of playlist:");
        driver.get(scanner.nextLine());
        for(WebElement element : driver.findElementsByTagName("ytd-playlist-panel-video-renderer")){
            urls.add(element.findElement(By.tagName("a")).getAttribute("href"));
        }
    }


}




