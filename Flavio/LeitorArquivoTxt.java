import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LeitorArquivoTxt {
    public static String getCode(){
        Path caminho = Paths.get("Flavio/ArquivoTxtAQUI/codigo.txt");

        try
        {
            byte[] text = Files.readAllBytes(caminho);
            String leitura = new String(text);

            return leitura;
        }
        catch(Exception e)
        {
            System.out.println("File not found");
        }

        return "";
    }
}