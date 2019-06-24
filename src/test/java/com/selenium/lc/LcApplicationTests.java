package com.selenium.lc;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class LcApplicationTests {
    private static ChromeDriver driver;
    @BeforeClass
    public static void openBrowser() {
        // chromedrive  下载地址：http://chromedriver.storage.googleapis.com/index.html
        System.setProperty("webdriver.chrome.driver","chromedrivers/74.0.3729.6/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts()
                .implicitlyWait(10, TimeUnit.SECONDS);
        String baseUrl = "https://www.baidu.com/";
        driver.get(baseUrl);

    }

    @Test
    public void testSearch() throws InterruptedException {
        driver.findElement(By.id("kw")).sendKeys("刘畅超级帅");
        driver.findElement(By.id("su")).click();
        Thread.sleep(10000);
        driver.findElement(By.id("kw")).clear();
        driver.findElement(By.id("su")).click();
    }

    @Test
    public void testLogin() throws InterruptedException {
        driver.findElement(By.linkText("登录")).click();
        driver.findElement(By.id("TANGRAM__PSP_10__footerULoginBtn")).click();
        driver.findElement(By.id("TANGRAM__PSP_10__userName")).clear();
        driver.findElement(By.id("TANGRAM__PSP_10__userName")).sendKeys("17624402301");
        driver.findElement(By.id("TANGRAM__PSP_10__password")).clear();
        driver.findElement(By.id("TANGRAM__PSP_10__password")).sendKeys("6666666");
        driver.findElement(By.id("TANGRAM__PSP_10__submit")).click();
        Thread.sleep(10000);
    }
    @AfterClass
    public static void testOver(){
        driver.close();
    }

}
