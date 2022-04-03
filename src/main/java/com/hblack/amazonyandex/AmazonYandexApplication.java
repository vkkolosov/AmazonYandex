package com.hblack.amazonyandex;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import com.hblack.repository.AmazonSDK;
import com.hblack.service.AmazonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;
import java.io.IOException;

@SpringBootApplication
public class AmazonYandexApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(AmazonYandexApplication.class, args);

        //работает
        //Bucket b = AmazonSDK.s3.createBucket("newbucketasdads");

        //работает
        AmazonService.uploadPictureFromFile();

        //работает
        //AmazonService.getImage("123");

    }

}
