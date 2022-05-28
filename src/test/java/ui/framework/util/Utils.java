package ui.framework.util;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import ui.framework.config.Config;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    public static File getDataFile() {
        Path path = Paths.get(Config.getProperties("data.file.location"), Config.getProperties("data.file.name"));
        return path.toFile();
    }

    private static void createDirs(Path path) {
        try {
            if(!Files.exists(path)){
                Files.createDirectories(path);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static String getDateStamp(String pattern){
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(new Date());
    }

    private static String generateFileName(String testName){
        String filePattern = Config.getProperties("screenshot.file.pattern");
        String datePatter = filePattern.substring(filePattern.lastIndexOf("_")+1, filePattern.indexOf("."));
        filePattern = filePattern.replace("TEST_NAME", testName);
        filePattern = filePattern.replace(datePatter,getDateStamp(datePatter));
        return filePattern;
    }
    public static String captureScreenShot(WebDriver driver, String testName, boolean pass) {

        if (pass) {
            String passDir = Config.getProperties("screenshot.pass.dir");
            Path passPath = Paths.get(passDir, getDateStamp("ddMMyyyy"));
            createDirs(passPath);
            Path filePath = Paths.get(passPath.toString(), generateFileName(testName));
            takeScreenshot(driver, filePath);
        }else {
            String faildir = Config.getProperties("screenshot.fail.dir");
            Path failPath = Paths.get(faildir, getDateStamp("ddMMyyyy"));
            createDirs(failPath);
            Path filePath = Paths.get(failPath.toString(), generateFileName(testName));
            takeScreenshot(driver, filePath);

        }
        return generateFileName(testName);
    }
    private static void takeScreenshot(WebDriver driver,Path path) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(screenshot.toPath(), path);
        } catch (IOException e) {
           e.printStackTrace();
        }
    }



}
