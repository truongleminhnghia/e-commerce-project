package org.project.ecommerce;

import jakarta.xml.bind.DatatypeConverter;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@SpringBootTest
class ECommerceApplicationTests {

    private static final Logger log = LoggerFactory.getLogger(ECommerceApplicationTests.class);

    @Test
    void contextLoads() {
    }

    @Test
    void hash() throws NoSuchAlgorithmException {
        String password = "123456";

        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] digest = md.digest();

        String md5Hash = DatatypeConverter.printBase64Binary(digest);

        log.info("MD5 round 1: {}", md5Hash);

        md.update(password.getBytes());
        digest = md.digest();
        md5Hash = DatatypeConverter.printBase64Binary(digest);

        log.info("MD5 round 2: {}", md5Hash);

    }

}
