package com.hblack.amazonyandex.service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.hblack.amazonyandex.repository.AmazonSDK;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Base64;
import java.util.UUID;

@Service
public class AmazonService {

    static String bucketName = "images-vvk";
    static String defaultImageName = "4cf586f3-13a2-4243-92ba-c671ba0c2340.jpg";

    //надо принять byte array, но затестить все равно надо StringBase64
    public static void uploadPictureFromFile() throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("src\\main\\resources\\images\\Stringimage.txt"));
        String imageString = bufferedReader.readLine();

        //Decode from base64
        byte[] decodeImg = Base64.getDecoder().decode(imageString);

        //InputStream inputStream = new ByteArrayInputStream(decodeImg);

        String imageName = UUID.randomUUID() + ".jpg";
        try {
            //AmazonSDK.s3.putObject(bucketName, imageName, new File("src\\main\\resources\\images\\testimage.jpg"));
            AmazonSDK.s3.putObject(bucketName, imageName, new ByteArrayInputStream(decodeImg), new ObjectMetadata());
        } catch (AmazonServiceException e) {
            System.err.println(e.getErrorMessage());
        }
        System.out.println("Picture uploaded with name " + imageName); //тут return добавить
    }

    //defaultImageName - не забыть поменять на imagename
    //ПРОСТО ГЕНЕРИРУЕМ ССЫЛКУ https://storage.yandexcloud.net/images-vvk/6432d699-3b42-4b00-9f43-7c3c752056a0.jpg
    public static void getImage(String imageName) {

        //Честно скачано с Амазона
        try {
            S3Object o = AmazonSDK.s3.getObject(bucketName, defaultImageName);
            S3ObjectInputStream s3is = o.getObjectContent();
            FileOutputStream fos = new FileOutputStream(new File("src\\main\\resources\\images\\out\\" + defaultImageName));
            byte[] read_buf = new byte[1024];
            int read_len = 0;
            while ((read_len = s3is.read(read_buf)) > 0) {
                fos.write(read_buf, 0, read_len);
            }
            s3is.close();
            fos.close();

        } catch (AmazonServiceException e) {
            System.err.println(e.getErrorMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("Done!");

    }

    public void deleteImage(String imageName) {
        try {
            AmazonSDK.s3.deleteObject(bucketName, imageName);
        } catch (AmazonServiceException e) {
            System.err.println(e.getErrorMessage());
        }
    }

}
