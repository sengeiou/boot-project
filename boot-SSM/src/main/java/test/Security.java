package test;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class Security {
    public static String encrypt(String input, String key){
        byte[] crypted = null;
        try{
            SecretKeySpec skey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, skey);
            crypted = cipher.doFinal(input.getBytes());
        }catch(Exception e){
            System.out.println(e.toString());
        }
        return new String(Base64.encodeBase64(crypted));
    }

    public static String decrypt(String input, String key){
        byte[] output = null;
        try{
            SecretKeySpec skey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, skey);
            output = cipher.doFinal(Base64.decodeBase64(input));
        }catch(Exception e){
            System.out.println(e.toString());
        }
        return new String(output);
    }

    public static void main(String[] args) {
        String encodedKey = "NjaxOx9zEJWXw5Yx5BnpXg";

        byte[] keyBytes = Base64.decodeBase64(encodedKey);
        String key = new String(keyBytes);
        String data = "example";
        String msg2 ="{\"contractId\":\"031201707231057438742ne3jEsu06D0\",\"key\":\"txecfc7342b24b488e20a7887d16938c\",\"nonce\":1500971915571,\"page\":1,\"pageSize\":10,\"workerActive\":\"all\"}";

  //      System.out.println(Security.decrypt(Security.encrypt(msg2, key), key));
        System.out.println(Security.encrypt(msg2, key));
    }
}
