package com.starrail.starbuddy.controller;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.ImageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Controller
public class ImageUploadController {


    @PostMapping("/uploadImage")
    @ResponseBody
    public String uploadImage(@RequestParam("imageFile")MultipartFile imageFile) throws IOException {
        System.out.println("Received image: " + imageFile.getOriginalFilename());
        System.out.println("Content Type: " + imageFile.getContentType());
        System.out.println("File Size: " + imageFile.getSize() + " bytes");

        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath("src/main/resources/tessdata/");
        //String whiteList = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789.+%' ";
        //tesseract.setVariable("tessedit_char_whitelist", whiteList);

        BufferedImage testImage = ImageIO.read(imageFile.getInputStream());
        BufferedImage testImage2 = ImageHelper.convertImageToBinary(ImageHelper.convertImageToGrayscale(testImage));


        System.out.println();


        try {
            String testString = tesseract.doOCR(testImage2);
            System.out.println(testString);
        } catch (TesseractException e) {
            System.out.println("meh");
        }


        return "Image uploaded?";
    }

}
