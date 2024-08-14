package encryption;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Symmetric {

    public static SecretKey createSecretAESKey(String keyStr) throws Exception{
        byte[] decodedKey = Base64.getDecoder().decode(keyStr);
        return new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
    }


    private SecretKey key;

    public Symmetric(SecretKey key)
    {
        this.key=key;
    }

    public Symmetric(String keyStr) throws Exception
    {
        this.key=createSecretAESKey(keyStr);
    }

    public String encryptAES(String plaintext) throws Exception {
        Cipher cipher=Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes= cipher.doFinal(plaintext.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public String decryptAES(String cryptedText) throws Exception
    {
        Cipher cipher=Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedBytes=cipher.doFinal(Base64.getDecoder().decode(cryptedText));
        return new String(decryptedBytes);
    }


}
