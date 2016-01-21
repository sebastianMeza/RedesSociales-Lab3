import java.io.*;
import java.util.*;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
/**
 *
 * @author Sebastian
 */

public class AristasPeso {
    public static void main(String[] args) throws FileNotFoundException,
            IOException, ParseException {
        ArrayList<String> aristas = new ArrayList<String>();
        String cadena;
        int contador_1 = 0;
        FileWriter aristas_peso;
        String fileName = "C:\\Users\\Sebastian\\Documents\\GitHub\\RedesSociales-Lab3\\Grafo - Todos\\aristas_id.txt";
        try {
            FileReader aristas_id = new FileReader(fileName);
            BufferedReader buffer_aristas_id = new BufferedReader(aristas_id);
            aristas_peso = new FileWriter(new File("aristas_peso.txt"));
            cadena = buffer_aristas_id.readLine();
            cadena = buffer_aristas_id.readLine();
            while((cadena = buffer_aristas_id.readLine())!=null) {
                //StringTokenizer tokens = new StringTokenizer(cadena, " ");
                //String token1 = tokens.nextToken();
                //String token2 = tokens.nextToken();
                //System.out.println(token1+" "+token2);
                aristas.add(cadena);
                contador_1++;
            }
            Set<String> unique = new HashSet<String>(aristas);
            for (String key : unique) {
                //System.out.println(key + ": " + Collections.frequency(aristas, key));
                aristas_peso.write(String.format("%s %s",key,Collections.frequency(aristas, key)));
                aristas_peso.write(System.lineSeparator());
            }

            System.out.println("Contador aristas: "+contador_1);
            aristas_peso.close();
            buffer_aristas_id.close();
        }catch(FileNotFoundException ex) {
            System.out.println("No fue posible abrir '"+fileName+"'");                
        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}    