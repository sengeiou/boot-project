package test;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.net.URLCodec;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class CodecUtils {
	private static final String ENCODING = "UTF-8";

	private static final String AES = "AES";

	private static final String HMACSHA1 = "HmacSHA1";

	private static URLCodec urlCodec = new URLCodec(ENCODING);

	/**
	 * 使用 HMAC-SHA1 签名方法对对src进行签名，然后转换为url可传输的base64形式
	 * 
	 * @param src
	 *            被签名的字符串
	 * @param secret
	 *            密钥
	 * @return
	 * @throws Exception
	 */
	public static String verifyByHmacSHA1Base64URLSafe(String src, String secret)
			throws Exception {
		byte[] data = secret.getBytes(ENCODING);
		// 根据给定的字节数组构造一个密钥,第二参数指定一个密钥算法的名称
		SecretKey secretKey = new SecretKeySpec(data, HMACSHA1);
		// 生成一个指定 Mac 算法 的 Mac 对象
		Mac mac = Mac.getInstance(HMACSHA1);
		// 用给定密钥初始化 Mac 对象
		mac.init(secretKey);

		byte[] text = src.getBytes(ENCODING);
		// 完成 Mac 操作
		byte[] hmacsha1 = mac.doFinal(text);
		// URL Safed Base64 encode
		return Base64.encodeBase64URLSafeString(hmacsha1);
	}

	/**
	 * URLEncoding 编码
	 * 
	 * @param src
	 * @return 编码结果
	 * @throws Exception
	 */
	public static String urlEncode(String src) throws Exception {
		return urlCodec.encode(src);
	}

	/**
	 * URLEncoding解码
	 * 
	 * @param src
	 * @return 解码结果
	 * @throws Exception
	 */
	public static String urlDecode(String src) throws Exception {
		return urlCodec.decode(src);
	}

	/**
	 * 获取密钥
	 *
	 * @param password
	 *            加密密码
	 * @return       NjaxOx9zEJWXw5Yx5BnpXg==
	 *
	 *
	 * @throws NoSuchAlgorithmException
	 */
	private static SecretKeySpec getKey(String password)
			throws NoSuchAlgorithmException {
		// 密钥加密器生成器
		KeyGenerator kgen = KeyGenerator.getInstance(AES);
		SecureRandom random = SecureRandom.getInstance("SHA1PRNG");// 需要自己手动设置
		random.setSeed(password.getBytes());
		kgen.init(128, random);

		// 创建加密器
		SecretKey secretKey = kgen.generateKey();
		byte[] enCodeFormat = secretKey.getEncoded();;
		SecretKeySpec key = new SecretKeySpec(enCodeFormat, AES);
		String bytes = Base64.encodeBase64String(enCodeFormat);
		System.out.println(bytes);
		return key;
	}

	public static String AESEncode2Base64URLSafeString(String data,
			String password) throws Exception {
		Cipher cipher = Cipher.getInstance(AES);
		
		byte[] byteContent = data.getBytes(ENCODING);

		cipher.init(Cipher.ENCRYPT_MODE, getKey(password));
		byte[] result = cipher.doFinal(byteContent);

		return Base64.encodeBase64URLSafeString(result);
	}

	public static String AESDecodeByBase64URLSafeString(String data,
			String password) throws Exception {
		byte[] content = Base64.decodeBase64(data);

		Cipher cipher = Cipher.getInstance(AES);
		cipher.init(Cipher.DECRYPT_MODE, getKey(password));

		byte[] result = cipher.doFinal(content);
		return new String(result, ENCODING);
	}
	 /**
     * sha1加密
     * @param inputStr 待加密文字
     * @return 加密后的十六进制字符串
     */
    public static String SHA1(String inputStr) {
        return encrypt(inputStr, "sha-1");
    }

    /**
     * md5或者sha-1加密
     *
     * @param inputText
     *            要加密的内容
     * @param algorithmName
     *            加密算法名称：md5或者sha-1，不区分大小写
     * @return
     */
    private static String encrypt(String inputText, String algorithmName) {
        String encryptText = null;

        if (inputText == null || "".equals(inputText.trim())) {
            return encryptText;
        }
        if (algorithmName == null || "".equals(algorithmName.trim())) {
            algorithmName = "sha-1";
        }

        try {
            MessageDigest m = MessageDigest.getInstance(algorithmName);
            m.update(inputText.getBytes());
            byte s[] = m.digest();
            return hex(s);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return encryptText;
    }

    // 返回十六进制字符串
    private static String hex(byte[] arr) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < arr.length; ++i) {
            sb.append(Integer.toHexString((arr[i] & 0xFF) | 0x100).substring(1,
                    3));
        }
        return sb.toString();
    }


    
    public static void main(String[] args) {
    	String msg2 ="{\"contractId\":\"031201707231057438742ne3jEsu06D0\",\"key\":\"txecfc7342b24b488e20a7887d16938c\",\"nonce\":1500971915571,\"page\":1,\"pageSize\":10,\"workerActive\":\"all\"}";

        String msg = "[{\"cOrderId\":\"test_1421739049935\",\"cProductId\":\"20141223P8DTZ3\",\"ext\":\"\",\"receiver\":\"13100000000\"},{\"cOrderId\":\"test_1421739049935\",\"cProductId\":\"20141223P8DTZ3\",\"ext\":\"\",\"receiver\":\"13100000000\"}]";
        try {
            String encode = CodecUtils.AESEncode2Base64URLSafeString(msg2, "txecfc7342b24b488e20a7887d16938c");
            System.out.println("加密：" + encode);
            System.out.println("解密：" + CodecUtils.AESDecodeByBase64URLSafeString(encode,"txecfc7342b24b488e20a7887d16938c"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
