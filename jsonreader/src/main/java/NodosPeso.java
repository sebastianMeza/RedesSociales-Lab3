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

public class NodosPeso {
    public static void main(String[] args) throws FileNotFoundException,
            IOException, ParseException {
        ArrayList<String> arista_salida = new ArrayList<String>();
        ArrayList<String> nodos_al = new ArrayList<String>();
        ArrayList<Integer> nodos_contador = new ArrayList<Integer>();

        String cadena_ar;
        String cadena_no;
        int contador_1 = 0;
        int contador_2 = 0;
        FileWriter nodos_peso;
        String fileName = "C:\\Users\\Sebastian\\Documents\\GitHub\\RedesSociales-Lab3\\Grafo - Todos\\aristas_id.txt";
        String fileName_nodo = "C:\\Users\\Sebastian\\Documents\\GitHub\\RedesSociales-Lab3\\Grafo - Todos\\nodos.txt";
        try {
            FileReader nodos = new FileReader(fileName_nodo);
            BufferedReader buffer_nodos = new BufferedReader(nodos);
            nodos_peso = new FileWriter(new File("nodos_peso.txt"));
            FileReader aristas_id = new FileReader(fileName);
            BufferedReader buffer_aristas_id = new BufferedReader(aristas_id);
            
            cadena_ar = buffer_aristas_id.readLine();
            cadena_ar = buffer_aristas_id.readLine();
            while((cadena_ar = buffer_aristas_id.readLine())!=null) {
                //StringTokenizer tokens = new StringTokenizer(cadena_ar, " ");
                //String token1 = tokens.nextToken();
                //String token2 = tokens.nextToken();
                //System.out.println(token1+" "+token2);
                arista_salida.add(cadena_ar);
                contador_1++;
            }
            while((cadena_no = buffer_nodos.readLine())!=null) {
                StringTokenizer tokens = new StringTokenizer(cadena_no, " ");
                String token1 = tokens.nextToken();
                //System.out.println("nodo: "+token1);
                nodos_al.add(token1);
                contador_2++;
            }
            
            
            for(String nodo_temp: nodos_al){
                Integer contador_temp = 1;
                /*
                for(String fin_arista: arista_salida){
                    if(fin_arista.equals(nodo_temp)){
                        contador_temp++;
                    }
                }
                */
                Set<String> unique = new HashSet<String>(arista_salida);
                for (String key : unique) {
                    //System.out.println(key + ": " + Collections.frequency(aristas, key));
                    StringTokenizer tokens = new StringTokenizer(key, " ");
                    String token1 = tokens.nextToken();
                    String token2 = tokens.nextToken();

                    if(token2.equals(nodo_temp)){
                        contador_temp++;
                    }                    
                }

                nodos_contador.add(contador_temp);
                //System.out.println("nodo "+nodo_temp+": "+contador_temp);
                nodos_peso.write(String.format("%s %s",nodo_temp,contador_temp));
                nodos_peso.write(System.lineSeparator());

            }
            //System.out.println(key + ": " + Collections.frequency(aristas, key));
            //aristas_peso.write(String.format("%s %s",));
            //aristas_peso.write(System.lineSeparator());

            System.out.println("Contador aristas: "+contador_1);
            System.out.println("Contador nodos: "+contador_2);
            nodos_peso.close();
            buffer_nodos.close();
            buffer_aristas_id.close();
        }catch(FileNotFoundException ex) {
            System.out.println("No fue posible abrir '"+fileName+"'");                
        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}    