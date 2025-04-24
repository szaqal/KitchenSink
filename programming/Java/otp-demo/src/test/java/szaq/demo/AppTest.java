package szaq.demo;

import com.eatthepath.otp.TimeBasedOneTimePasswordGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;

public class AppTest {

    @Test
    public void shouldAnswerWithTrue() throws NoSuchAlgorithmException, InvalidKeyException {
        final TimeBasedOneTimePasswordGenerator totp = new TimeBasedOneTimePasswordGenerator(Duration.of(2, ChronoUnit.MINUTES));
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(new SecureRandom());
        SecretKey key = keyGenerator.generateKey();
        System.out.println(key.getAlgorithm());

        String encoded = Base64.getEncoder().encodeToString(key.getEncoded());
        System.out.println(encoded);

        //send
        Instant now = Instant.now();
        var result = totp.generateOneTimePasswordString(key, now);
        System.out.println(result);

        //heck
        byte[] decodedKey = Base64.getDecoder().decode(encoded);
        key = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
        result = totp.generateOneTimePasswordString(key, now);
        System.out.println(result);
    }
}
