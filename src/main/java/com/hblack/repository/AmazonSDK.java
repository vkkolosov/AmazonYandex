package com.hblack.repository;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.stereotype.Service;

@Service
public class AmazonSDK {

    public static AWSCredentials credentials = new AWSCredentials() {
        @Override
        public String getAWSAccessKeyId() {
            return "YCAJESvCAzaofAuyR2GZtw6nv";
        }

        @Override
        public String getAWSSecretKey() {
            return "YCNQAmTKAmwhLcgZNJ7ou3--lKBR46ioJ8z7Tpmw";
        }
    };

    public static AmazonS3 s3 = AmazonS3ClientBuilder.standard()
            .withCredentials(new AWSStaticCredentialsProvider(AmazonSDK.credentials))
            .withEndpointConfiguration(
                    new AmazonS3ClientBuilder.EndpointConfiguration(
                            "storage.yandexcloud.net", "ru-central1"
                    )
            )
            .build();

}
