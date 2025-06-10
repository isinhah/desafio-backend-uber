package com.ms.email_service.infra.ses;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AwsSesConfig {

    @Value("${aws.region}")
    private String region;

    @Value("${aws.accessKeyId}")
    private String accessKeyId;

    @Value("${aws.secretKey}")
    private String secretKey;

    @Bean
    public AmazonSimpleEmailService amazonSimpleEmailService() {
        AWSCredentials credentials = new BasicAWSCredentials(accessKeyId, secretKey);

        // 2. Construye el cliente de SES especificando la región y las credenciales
        return AmazonSimpleEmailServiceClientBuilder.standard()
                .withRegion(region) // Especifica la región aquí
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .build();
    }
}