package com.aesencrypt;

import java.io.Serializable;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.Base64;
import java.util.UUID;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;


public class EncrypAES implements Serializable {

    // KeyGenerator ���ѹ�ٱK�_�ͦ������\��A����U�غt��k
    private KeyGenerator keygen;
    // SecretKey �t�d�O�s��ٱK�_
    private SecretKey deskey;
    // Cipher �t�d�����[�K�θѱK�u�@
    private Cipher c;
    //�Ӧr�`�Ʋխt�d�O�s�[�K�����G
    private byte[] cipherByte;

    public EncrypAES()
        throws NoSuchAlgorithmException, NoSuchPaddingException
    {
        Security.addProvider(new com.sun.crypto.provider.SunJCE());
        // ��ҤƤ�� AES �t��k���K�_�ͦ���(�t��k�W�٩R�W�ݫ��W�w�A�_�h�ߥX���`)
        keygen = KeyGenerator.getInstance("AES");
        //�ͦ��K�_
        deskey = keygen.generateKey();
        //�ͦ� Cipher ����,���w������ AES �t��k
        c = Cipher.getInstance("AES");
    }

    /**
     * ��r�Ŧ�[�K
     *
     * @param str
     * @return
     * @throws InvalidKeyException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     */
    public byte[] Encrytor(String str)
        throws InvalidKeyException, IllegalBlockSizeException,
               BadPaddingException
    {
        // �ھڱK�_�A�� Cipher ����i���l�ơAENCRYPT_MODE ��ܥ[�K�Ҧ�
        c.init(Cipher.ENCRYPT_MODE, deskey);
        byte[] src = str.getBytes();
        // �[�K�A���G�O�s�i cipherByte
        cipherByte = c.doFinal(src);
        return cipherByte;
    }

    
    public String Encrytor2(String str)
            throws InvalidKeyException, IllegalBlockSizeException,
                   BadPaddingException
        {
            // �ھڱK�_�A�� Cipher ����i���l�ơAENCRYPT_MODE ��ܥ[�K�Ҧ�
            c.init(Cipher.ENCRYPT_MODE, deskey);
            byte[] src = str.getBytes();
            // �[�K�A���G�O�s�i cipherByte
            cipherByte = c.doFinal(src);
            return toHexString(cipherByte);
        }
    
    public String Encrytor3(String str,SecretKey deskey)
            throws InvalidKeyException, IllegalBlockSizeException,
                   BadPaddingException
        {
            // �ھڱK�_�A�� Cipher ����i���l�ơAENCRYPT_MODE ��ܥ[�K�Ҧ�
            c.init(Cipher.ENCRYPT_MODE, deskey);
            byte[] src = str.getBytes();
            // �[�K�A���G�O�s�i cipherByte
            cipherByte = c.doFinal(src);
            return toHexString(cipherByte);
        }
    
    /**
     * ��r�Ŧ�ѱK
     *
     * @param buff
     * @return
     * @throws InvalidKeyException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     */
    public byte[] Decryptor(byte[] buff)
        throws InvalidKeyException, IllegalBlockSizeException,
               BadPaddingException
    {
        // �ھڱK�_�A�� Cipher ����i���l�ơADECRYPT_MODE ��ܥ[�K�Ҧ�
        c.init(Cipher.DECRYPT_MODE, deskey);
        cipherByte = c.doFinal(buff);
        return cipherByte;
    }

    
    public String Decryptor2(byte[] buff)
            throws InvalidKeyException, IllegalBlockSizeException,
                   BadPaddingException
        {
            // �ھڱK�_�A�� Cipher ����i���l�ơADECRYPT_MODE ��ܥ[�K�Ҧ�
            c.init(Cipher.DECRYPT_MODE, deskey);
            cipherByte = c.doFinal(buff);
            return toHexString(cipherByte);
        }
    
    
    public String Decryptor3(byte[] buff,SecretKey deskey)
            throws InvalidKeyException, IllegalBlockSizeException,
                   BadPaddingException
        {
            // �ھڱK�_�A�� Cipher ����i���l�ơADECRYPT_MODE ��ܥ[�K�Ҧ�
            c.init(Cipher.DECRYPT_MODE, deskey);
            cipherByte = c.doFinal(buff);
            return toHexString(cipherByte);
        }
    
    
    private String toHexString(byte[] in) {
        StringBuilder hexString = new StringBuilder();
        for (int i = 0; i < in.length; i++){
            String hex = Integer.toHexString(0xFF & in[i]);
            if (hex.length() == 1){
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
    
    

    
    /**
     * @param args
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     * @throws InvalidKeyException
     */
    public static void main(String[] args) throws Exception {
        EncrypAES de1 = new EncrypAES();
        String pwd ="c83758341";
        
        UUID uuid = UUID.randomUUID();
        String salt = uuid.toString().replace("-", "");
        System.out.println("salt:"+salt);
        String pwdInDB=de1.Encrytor2(pwd+salt);
        System.out.println(pwdInDB);
        
        
        String userKeyIn="c83758341";
        System.out.println("�ϥΪ̿�J:"+userKeyIn);
        
        
        System.out.println("");
        System.out.println("");

        
        
        System.out.println("============�ϥ�de1================");
        String encryptUserKeyIn = de1.Encrytor2(userKeyIn+salt); 
        System.out.println("encryptUserKeyIn:"+encryptUserKeyIn);
        System.out.println("��J���G"+encryptUserKeyIn.equals(pwdInDB));
        System.out.println("==================================");
        

        
        System.out.println("");
        System.out.println("");
        
        System.out.println("�H�U�l��X");
        byte[] keyBytes = de1.deskey.getEncoded();
        String encodedKey = new String(Base64.getEncoder().encode(keyBytes) ,"UTF-8");
        System.out.print(encodedKey);
//        byte[] encontent = de1.Encrytor(msg);
//        byte[] decontent = de1.Decryptor(encontent);
//        System.out.println("����O:" + msg);
//        System.out.println("�[�K��:" + new String(encontent));
//        System.out.println("�ѱK��:" + new String(decontent));
    }
}