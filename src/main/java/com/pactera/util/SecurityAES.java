package com.pactera.util;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
public class SecurityAES {
	
	
	public static void main(String[] args) {
		
		SecurityAES qwe=new SecurityAES();
		String content="[{\"name\":\"李鹏老大\"\"number\":\"+8613306340695\"\"createtime\":\"null\"}, {\"name\":\"吴明朋\"\"number\":\"+8613331190528\"\"createtime\":\"null\"}, {\"name\":\"王丽英\"\"number\":\"+8613501043318\"\"createtime\":\"null\"}, {\"name\":\"赵章红\"\"number\":\"+8613666383131\"\"createtime\":\"null\"}, {\"name\":\"二昌\"\"number\":\"+8615300558131\"\"createtime\":\"null\"}, {\"name\":\"老大新号\"\"number\":\"+8615553252558\"\"createtime\":\"null\"}, {\"name\":\"满新栋家乡\"\"number\":\"+8615853727230\"\"createtime\":\"null\"}, {\"name\":\"福军\"\"number\":\"+8615863553264\"\"createtime\":\"null\"}, {\"name\":\"李凌飞\"\"number\":\"+8615964383542\"\"createtime\":\"null\"}, {\"name\":\"史斌\"\"number\":\"+8615965233842\"\"createtime\":\"null\"}, {\"name\":\"二妹妹\"\"number\":\"+8618365775628\"\"createtime\":\"null\"}, {\"name\":\"满新栋3\"\"number\":\"+8618369738520\"\"createtime\":\"null\"}, {\"name\":\"李鹏\"\"number\":\"+8618663407862\"\"createtime\":\"null\"}, {\"name\":\"小白\"\"number\":\"+8618769001533\"\"createtime\":\"null\"}, {\"name\":\"王朝立\"\"number\":\"+8618954490301\"\"createtime\":\"null\"}, {\"name\":\",999999999666996*96666666,6666696\"\"number\":\",999999999666996*96666666,6666696\"\"createtime\":\"null\"}, {\"name\":\"中才远达\"\"number\":\"010 5601 4598\"\"createtime\":\"null\"}, {\"name\":\"309档案室\"\"number\":\"010 6677 5380\"\"createtime\":\"null\"}, {\"name\":\"聊城结核防治办公室贾科长\"\"number\":\"0635 290 9986\"\"createtime\":\"null\"}, {\"name\":\"爸，\"\"number\":\"0635 707 2888\"\"createtime\":\"null\"}, {\"name\":\"大众\"\"number\":\"06358248777\"\"createtime\":\"null\"}, {\"name\":\"钉钉官方短信\"\"number\":\"10655059113144\"\"createtime\":\"null\"}, {\"name\":\"钉钉官方短信\"\"number\":\"1065752551629604916\"\"createtime\":\"null\"}, {\"name\":\"钉钉官方短信\"\"number\":\"106575258192144\"\"createtime\":\"null\"}, {\"name\":\"钉钉官方短信\"\"number\":\"106590256203144\"\"createtime\":\"null\"}, {\"name\":\"钉钉官方短信\"\"number\":\"106904068039604916\"\"createtime\":\"null\"}, {\"name\":\"钉钉官方短信\"\"number\":\"106906199604916\"\"createtime\":\"null\"}, {\"name\":\"小雅妈\"\"number\":\"130 6109 5795\"\"createtime\":\"null\"}, {\"name\":\"trs_赫旭兰\"\"number\":\"131 2665 7655\"\"createtime\":\"null\"}, {\"name\":\"伊古\"\"number\":\"131 3880 0044\"\"createtime\":\"null\"}, {\"name\":\"老妈 \"\"number\":\"131 8416 9972\"\"createtime\":\"null\"}, {\"name\":\"二姐\"\"number\":\"131 9359 0082\"\"createtime\":\"null\"}]";
		String password="baixin8e9c4226!#";
		String encryptAES=qwe.encryptAES(content,password);
		
		String decrypt=qwe.decrypt(encryptAES, password);
		System.out.println(decrypt);
		
	}
	
    private final static String encoding = "UTF-8"; 
    /**
     * AES加密
     * 
     * @param content
     * @param password
     * @return
     */
    public static String encryptAES(String content, String password) {
            byte[] encryptResult = encrypt(content, password);
            String encryptResultStr = parseByte2HexStr(encryptResult);
            // BASE64位加密
            encryptResultStr = ebotongEncrypto(encryptResultStr);
            return encryptResultStr;
    }

    /**
     * AES解密
     * 
     * @param encryptResultStr
     * @param password
     * @return
     */
    public static String decrypt(String encryptResultStr, String password) {
            // BASE64位解密
            String decrpt = ebotongDecrypto(encryptResultStr);
            byte[] decryptFrom = parseHexStr2Byte(decrpt);
            byte[] decryptResult = decrypt(decryptFrom, password);
            return new String(decryptResult);
    }

            /**
     * 加密字符串
     */
    public static String ebotongEncrypto(String str) {
            //BASE64Encoder base64encoder = new BASE64Encoder();
            String result = str;
            if (str != null && str.length() > 0) {
                    try {
                            byte[] encodeByte = str.getBytes(encoding);
                            //result = base64encoder.encode(encodeByte);
                            result=Base64.getEncoder().encodeToString(encodeByte);
                    } catch (Exception e) {
                            e.printStackTrace();
                    }
            }
            //base64加密超过一定长度会自动换行 需要去除换行符
            return result.replaceAll("\r\n", "").replaceAll("\r", "").replaceAll("\n", "");
    }

    /**
     * 解密字符串
     */
    public static String ebotongDecrypto(String str) {
           // BASE64Decoder base64decoder = new BASE64Decoder();
            //byte[] encodeByte = base64decoder.decodeBuffer(str);
			byte[] encodeByte = Base64.getDecoder().decode(str);
			
			return new String(encodeByte);
    }
    /**  
     * 加密  
     *   
     * @param content 需要加密的内容  
     * @param password  加密密码  
     * @return  
     */  
    private static byte[] encrypt(String content, String password) {   
            try {              
                    KeyGenerator kgen = KeyGenerator.getInstance("AES"); 
                    //防止linux下 随机生成key
                    SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG" );   
                    secureRandom.setSeed(password.getBytes());   
                    kgen.init(128, secureRandom);
                    //kgen.init(128, new SecureRandom(password.getBytes()));   
                    SecretKey secretKey = kgen.generateKey();   
                    byte[] enCodeFormat = secretKey.getEncoded();   
                    SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");   
                    Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");// 创建密码器   
                    byte[] byteContent = content.getBytes("utf-8");   
                    cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化   
                    byte[] result = cipher.doFinal(byteContent);   
                    return result; // 加密   
            } catch (NoSuchAlgorithmException e) {   
                    e.printStackTrace();   
            } catch (NoSuchPaddingException e) {   
                    e.printStackTrace();   
            } catch (InvalidKeyException e) {   
                    e.printStackTrace();   
            } catch (UnsupportedEncodingException e) {   
                    e.printStackTrace();   
            } catch (IllegalBlockSizeException e) {   
                    e.printStackTrace();   
            } catch (BadPaddingException e) {   
                    e.printStackTrace();   
            }   
            return null;   
    }  


    /**解密  
     * @param content  待解密内容  
     * @param password 解密密钥  
     * @return  
     */  
    private static byte[] decrypt(byte[] content, String password) {   
            try {   
                     KeyGenerator kgen = KeyGenerator.getInstance("AES"); 
                   //防止linux下 随机生成key
                         SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG" );   
                         secureRandom.setSeed(password.getBytes());   
                         kgen.init(128, secureRandom);
                     //kgen.init(128, new SecureRandom(password.getBytes()));   
                     SecretKey secretKey = kgen.generateKey();   
                     byte[] enCodeFormat = secretKey.getEncoded();   
                     SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");               
                     Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");// 创建密码器   
                    cipher.init(Cipher.DECRYPT_MODE, key);// 初始化   
                    byte[] result = cipher.doFinal(content);   
                    return result; // 加密   
            } catch (NoSuchAlgorithmException e) {   
                    e.printStackTrace();   
            } catch (NoSuchPaddingException e) {   
                    e.printStackTrace();   
            } catch (InvalidKeyException e) {   
                    e.printStackTrace();   
            } catch (IllegalBlockSizeException e) {   
                    e.printStackTrace();   
            } catch (BadPaddingException e) {   
                    e.printStackTrace();   
            }   
            return null;   
    }  

    /**将二进制转换成16进制  
     * @param buf  
     * @return  
     */  
    public static String parseByte2HexStr(byte buf[]) {   
            StringBuffer sb = new StringBuffer();   
            for (int i = 0; i < buf.length; i++) {   
                    String hex = Integer.toHexString(buf[i] & 0xFF);   
                    if (hex.length() == 1) {   
                            hex = '0' + hex;   
                    }   
                    sb.append(hex.toUpperCase());   
            }   
            return sb.toString();   
    }  


    /**将16进制转换为二进制  
     * @param hexStr  
     * @return  
     */  
    public static byte[] parseHexStr2Byte(String hexStr) {   
            if (hexStr.length() < 1)   
                    return null;   
            byte[] result = new byte[hexStr.length()/2];   
            for (int i = 0;i< hexStr.length()/2; i++) {   
                    int high = Integer.parseInt(hexStr.substring(i*2, i*2+1), 16);   
                    int low = Integer.parseInt(hexStr.substring(i*2+1, i*2+2), 16);   
                    result[i] = (byte) (high * 16 + low);   
            }   
            return result;   
    }  


    
}
