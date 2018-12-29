package test;

import javax.crypto.Cipher;
import java.security.Key;

import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
/**
 * Created by xuzongmeng on 2017/7/26.
 */
public class CryptAES {

    private static final String AESTYPE ="AES/ECB/PKCS5Padding";

    public static String AES_Encrypt(String keyStr, String plainText) {
        byte[] encrypt = null;
        try{
            Key key = generateKey(keyStr);
            Cipher cipher = Cipher.getInstance(AESTYPE);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            encrypt = cipher.doFinal(plainText.getBytes());
        }catch(Exception e){
            e.printStackTrace();
        }
        return new String(Base64.encodeBase64(encrypt));
    }

    public static String AES_Decrypt(String keyStr, String encryptData) {
        byte[] decrypt = null;
        try{
            Key key = generateKey(keyStr);
            Cipher cipher = Cipher.getInstance(AESTYPE);
            cipher.init(Cipher.DECRYPT_MODE, key);
            decrypt = cipher.doFinal(Base64.decodeBase64(encryptData));
        }catch(Exception e){
            e.printStackTrace();
        }
        return new String(decrypt).trim();
    }

    private static Key generateKey(String key)throws Exception{
        try{
            SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
            return keySpec;
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }

    }

    public static void main(String[] args) {

        String keyStr = "1234567890123456";
        String msg2 ="{\"contractId\":\"031201707231057438742ne3jEsu06D0\",\"key\":\"txecfc7342b24b488e20a7887d16938c\",\"nonce\":1500971915571,\"page\":1,\"pageSize\":10,\"workerActive\":\"all\"}";

        String plainText = "this is a string will be AES_Encrypt";

        String encText = AES_Encrypt(keyStr, msg2);
        String decString = AES_Decrypt(keyStr, encText);

        System.out.println(encText);
        System.out.println(decString);

    }
}
