package com.yar.onlinestore.service.domain;


import com.yar.onlinestore.common.LogFactory;
import cryptix.util.core.Hex;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.crypto.Cipher;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;


/**
 * Created by EhsanYar on 8/29/2017.
 */

@Service
@Transactional
public class PasswordCodingManagement  {

    private static final String desKey = "0E329232EA6D0D73";
    private static final String DES_ECB_NO_PADDING = "DES/ECB/NoPadding";
    private static final String ALGORITHM_TYPE = "DES";


    public String encoding(String password) {

        return encrypt(desKey, toHexStringAddPadding(password));

    }

    private String encrypt(String sKey, String sData) {

        byte[] encryptedData;
        String sEncryptedData = "";
        try {

            Cipher algorithm = Cipher.getInstance(DES_ECB_NO_PADDING);
            Key key = new SecretKeySpec((new DESKeySpec(Hex.fromString(sKey))).getKey(), ALGORITHM_TYPE);
            algorithm.init(Cipher.ENCRYPT_MODE, key);
            byte[] temparr = Hex.fromString(sData.substring(0, sData.length()));
            encryptedData = algorithm.doFinal(temparr, 0, temparr.length);
            sEncryptedData = Hex.toString(encryptedData);

        } catch (Exception e) {
            LogFactory.log.error(e.getMessage());
        }

        return sEncryptedData;
    }



    public String decoding(String hashedPassword) {
        return toStringFromHEXString(Decrypt(hashedPassword));
    }


    private String toStringFromHEXString(String input) {
        StringBuilder output = new StringBuilder();
//        input.toLowerCase();
        int k;
        for (int i = 0; i < input.length(); i = i + 2) {
            k = Integer.parseInt(input.substring(i, i + 2), 16);
            if (k != 0)
                output.append((char) k);
        }
        return output.toString();
    }

    private String Decrypt(String sData) {
        byte[] decryptedData;
        String sDecryptedData = "";
        try {

            Cipher algorithm = Cipher.getInstance(DES_ECB_NO_PADDING);
            Key key = new SecretKeySpec((new DESKeySpec(Hex.fromString(desKey))).getKey(), ALGORITHM_TYPE);
            algorithm.init(Cipher.DECRYPT_MODE, key);

            decryptedData = algorithm.doFinal(Hex.fromString(sData));
            sDecryptedData = Hex.toString(decryptedData);

        } catch (Exception e) {
            LogFactory.log.error(e.getMessage());
        }

        return sDecryptedData;
    }


    private String toHexStringAddPadding(String input) {
        String hexString;
        int integerTemp;
        StringBuilder hexStringBuilder = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            integerTemp = (int) input.charAt(i);
            hexStringBuilder.append(Integer.toHexString(integerTemp));
        }
        hexString = hexStringBuilder.toString();

        int padingRequired = hexString.length() % 16;
        if (padingRequired != 0) {
            padingRequired = 16 - padingRequired;
            StringBuilder hexStringBuilder1 = new StringBuilder(hexString);
            for (int y = 0; y < padingRequired; y++) {
                hexStringBuilder1.append("0");
            }
            hexString = hexStringBuilder1.toString();
        }

        return hexString;
    }



}
