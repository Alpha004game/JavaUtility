package encryption;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Symmetric
    {
    public static SecretKey createSecretAESKey(String keyStr) throws Exception{
        //byte[] decodedKey = Base64.getDecoder().decode(keyStr);

        byte[] decodedKey =completeKey(keyStr).getBytes();
        return new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
    }

    private static String completeKey(String key)
    {
        int diff;
        StringBuilder sb=new StringBuilder();
        sb.append(key.toString());
        if((diff=16-key.length())!=0)
        {
            for(int i=0; i<diff; i++)
            {
                sb.append("0");
            }
        }
        //System.out.println(sb);
        return sb.toString();
    }

    private static final char padChar='\u200B';
    private static String extendMessage(String message)
    {
        int diff;
        StringBuilder sb=new StringBuilder();
        sb.append(message.toString());
        if((diff=16-message.length())!=0)
        {
            for(int i=0; i<diff; i++)
            {
                sb.append(padChar);
            }
        }
        //System.out.println(sb);
        return sb.toString();
    }
    private static String getOriginalMessage(String messageExt)
    {
        int index = messageExt.indexOf(padChar);
        if (index != -1) {
            return messageExt.substring(0, index);
        }
        return messageExt;
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

    public String encryptAES(String plaintext) throws Exception
    {
        if(key==null)
            throw new NoSuchKeyException();
        Cipher cipher=Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes= cipher.doFinal(extendMessage(plaintext).getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public String decryptAES(String cryptedText) throws Exception
    {
        if(key==null)
            throw new NoSuchKeyException();
        Cipher cipher=Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedBytes=cipher.doFinal(Base64.getDecoder().decode(cryptedText));
        return getOriginalMessage(new String(decryptedBytes));
    }


}
