package com.hblack.amazonyandex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.io.IOException;

@SpringBootApplication
//@EntityScan("com.hblack.amazonyandex.repository.entity")
//@EnableJpaRepositories("com.hblack.amazonyandex.repository")
@ComponentScan(basePackages = {"com.hblack.amazonyandex"})
public class AmazonYandexApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(AmazonYandexApplication.class, args);

        //работает
        //Bucket b = AmazonSDK.s3.createBucket("newbucketasdads");

        //работает
        //AmazonService.uploadPictureFromFile();

        //работает
        //AmazonService.getImage("123");



    }

}
