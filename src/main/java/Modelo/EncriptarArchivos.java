package Modelo;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;

public class EncriptarArchivos {

    private final String Llave = "1aZ$9Y&4#2F@5!7Q8%6X*0";

    public SecretKeySpec CrearClave(String llave) {
        try {
            byte[] cadena = llave.getBytes(StandardCharsets.UTF_8);
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            cadena = md.digest(cadena);
            cadena = Arrays.copyOf(cadena, 16);
            return new SecretKeySpec(cadena, "AES");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void Encriptar(String filePath) {
        try {
            SecretKey clave = CrearClave(Llave);
            Cipher cifrado = Cipher.getInstance("AES");
            cifrado.init(Cipher.ENCRYPT_MODE, clave);

            byte[] inputBytes = Files.readAllBytes(Paths.get(filePath));
            byte[] encriptadoFinal = cifrado.doFinal(inputBytes);
            Files.write(Paths.get(filePath), Base64.getEncoder().encode(encriptadoFinal));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Desencriptar(String filePath) {
        try {
            SecretKey clave = CrearClave(Llave);
            Cipher cifrado = Cipher.getInstance("AES");
            cifrado.init(Cipher.DECRYPT_MODE, clave);

            byte[] inputBytes = Base64.getDecoder().decode(Files.readAllBytes(Paths.get(filePath)));
            byte[] desencriptado = cifrado.doFinal(inputBytes);
            Files.write(Paths.get(filePath), desencriptado);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}