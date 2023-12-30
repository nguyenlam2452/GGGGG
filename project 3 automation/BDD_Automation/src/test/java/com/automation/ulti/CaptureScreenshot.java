package com.automation.ulti;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;

public class CaptureScreenshot {
	public static void takeScreenShot(WebDriver driver, String testcaseName) {
		try {
			File theDir = new File("./Screenshots/");
			if(!theDir.exists()) {
				theDir.mkdir();
			}
			
			BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			File img =new File("./Screenshots/"+testcaseName+".jpg");
			ImageIO.write(image, "jpg", img);
		} catch (Exception e) {
			System.out.println("************khong chup duoc");
			e.printStackTrace();
		}
		
	}

}
