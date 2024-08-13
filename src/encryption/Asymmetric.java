package encryption;

import javax.crypto.Cipher;
import java.security.*;
import java.util.Base64;

public class Asymmetric {

    private static KeyPair generateKeys(String algorithm, int keysize) throws NoSuchAlgorithmException
    {
        KeyPairGenerator generator= KeyPairGenerator.getInstance(algorithm);
        generator.initialize(keysize);
        return generator.generateKeyPair();
    }

    public static KeyPair generateRSAKeys() throws NoSuchAlgorithmException
    {
        KeyPairGenerator generator= KeyPairGenerator.getInstance("RSA");
        generator.initialize(2048);
        return generator.generateKeyPair();
    }

    private KeyPair keys;


    public Asymmetric(KeyPair keys)
    {
        this.keys=keys;
    }

    public Asymmetric(PublicKey publicKey, PrivateKey privateKey)
    {
        this.keys= new KeyPair(publicKey, privateKey);
    }

    public boolean destroy(boolean confirm)
    {
        if(confirm)
        {
            try
            {
                keys.getPrivate().destroy();
                keys=null;
                return true;
            }
            catch(Exception e)
            {
                return false;
            }
        }
        return false;
    }

    public String encryptPublicRSA(String plainText)  throws Exception
    {
        if(keys.getPublic()==null)
            throw new NoSuchKeyException();
        Cipher cipher= Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, keys.getPublic());
        byte[] encryptedBytes=cipher.doFinal(plainText.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }


    private String encryptPublic(String plainText, String algorithm)  throws Exception
    {
        if(keys.getPublic()==null)
            throw new NoSuchKeyException();
        Cipher cipher= Cipher.getInstance(algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, keys.getPublic());
        byte[] encryptedBytes=cipher.doFinal(plainText.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public String decryptPrivateRSA(String encryptedText) throws Exception
    {
        if(keys.getPrivate()==null)
            throw new NoSuchKeyException();
        Cipher cipher=Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, keys.getPrivate());
        byte[] decryptedBytes= cipher.doFinal(Base64.getDecoder().decode(encryptedText));
        return new String(decryptedBytes);
    }

    private String decryptPrivate(String encryptedText, String algorithm) throws Exception
    {
        if(keys.getPrivate()==null)
            throw new NoSuchKeyException();
        Cipher cipher=Cipher.getInstance(algorithm);
        cipher.init(Cipher.DECRYPT_MODE, keys.getPrivate());
        byte[] decryptedBytes= cipher.doFinal(Base64.getDecoder().decode(encryptedText));
        return new String(decryptedBytes);
    }

    public String[] convertToPEM()
    {
        String[] keysPEM=new String[2];
        StringBuilder builder;
        if(keys.getPrivate()==null)
            keysPEM[0]=null;
        else
        {
            builder=new StringBuilder("-----BEGIN PRIVATE KEY-----\n");
            builder.append(Base64.getMimeEncoder(64, "\n".getBytes()).encodeToString(keys.getPrivate().getEncoded()));
            builder.append("\n-----END PRIVATE KEY-----\n");
            keysPEM[0]=builder.toString();
        }
        if(keys.getPublic()==null)
            keysPEM[1]=null;
        else
        {
            builder=new StringBuilder("-----BEGIN PUBLIC KEY-----\n");
            builder.append(Base64.getMimeEncoder(64, "\n".getBytes()).encodeToString(keys.getPublic().getEncoded()));
            builder.append("\n-----END PUBLIC KEY-----\n");
            keysPEM[1]=builder.toString();
        }
        return keysPEM;
    }



    public static void main(String[] args)
    {
        try {
            Asymmetric test=new Asymmetric(generateRSAKeys().getPublic(), null);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }


}
