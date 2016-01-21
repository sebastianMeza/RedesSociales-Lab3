import java.io.*;
import java.util.*;
import java.math.*;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
/**
 *
 * @author Sebastian
 */

public class MentionImpact {
    public static void main(String[] args) throws FileNotFoundException,
            IOException, ParseException {
        ArrayList<String> lista_20 = new ArrayList<String>();
        //Grafo 20
        lista_20.add("Karolcariola");
        lista_20.add("GiorgioJackson");
        lista_20.add("SenadorGuillier");
        lista_20.add("felipeharboe");
        lista_20.add("camila_vallejo");
        lista_20.add("gabrielboric");
        lista_20.add("gustavohasbun");
        lista_20.add("senadornavarro");
        lista_20.add("ivanmoreirab");
        lista_20.add("Chile_Vamos_");
        lista_20.add("NuevaMayoriacl");
        lista_20.add("ceciperez1");
        lista_20.add("urrutiaosvaldo");
        lista_20.add("ignaciowalker");
        lista_20.add("lautarocarmona");
        lista_20.add("RojoEdwards");
        lista_20.add("Hugo_Gutierrez_");
        lista_20.add("marconunez");
        lista_20.add("iallendebussi");
        lista_20.add("hgonzaduran");
        
        ArrayList<String> aristas = new ArrayList<String>();
        ArrayList<String> nodos_lista = new ArrayList<String>();
        ArrayList<Integer> nodos_contador = new ArrayList<Integer>();
        ArrayList<Integer> nodos_M1 = new ArrayList<Integer>();
        ArrayList<Integer> nodos_M2 = new ArrayList<Integer>();
        ArrayList<Integer> nodos_M3 = new ArrayList<Integer>();
        ArrayList<Integer> nodos_M4 = new ArrayList<Integer>();
        
        String cadena_ar;
        String cadena_no;
        int contador_1 = 0;
        int contador_2 = 0;
        //FileWriter nodos_peso;
        String fileName = "C:\\Users\\Sebastian\\Documents\\GitHub\\RedesSociales-Lab3\\Grafo - Todos\\aristas.txt";
        String fileName_nodo = "C:\\Users\\Sebastian\\Documents\\GitHub\\RedesSociales-Lab3\\Grafo - Todos\\nodos.txt";
        try {
            FileReader nodos = new FileReader(fileName_nodo);
            BufferedReader buffer_nodos = new BufferedReader(nodos);
            //nodos_peso = new FileWriter(new File("nodos_peso.txt"));
            FileReader aristas_id = new FileReader(fileName);
            BufferedReader buffer_aristas_id = new BufferedReader(aristas_id);
            
            cadena_ar = buffer_aristas_id.readLine();
            cadena_ar = buffer_aristas_id.readLine();
            while((cadena_ar = buffer_aristas_id.readLine())!=null) {
                //StringTokenizer tokens = new StringTokenizer(cadena_ar, " ");
                //String token1 = tokens.nextToken();
                //String token2 = tokens.nextToken();
                //System.out.println(token1+" "+token2);
                aristas.add(cadena_ar);
                contador_1++;
            }

            //M2
            for(String nodo_temp: lista_20){
                int contador_temp = 0;
                Set<String> unique = new HashSet<String>(aristas);
                for (String key : unique) {
                    //System.out.println(key + ": " + Collections.frequency(aristas, key));
                    StringTokenizer tokens = new StringTokenizer(key, " ");
                    String token1 = tokens.nextToken();
                    String token2 = tokens.nextToken();
                    if(token1.equals(nodo_temp) && !token2.equals(nodo_temp)){
                        contador_temp++;
                    }                    
                }
                //System.out.println("M2 nodo "+nodo_temp+": "+contador_temp);
                nodos_M2.add(contador_temp);
            }
            //M4
            for(String nodo_temp: lista_20){
                int contador_temp = 0;
                Set<String> unique = new HashSet<String>(aristas);
                for (String key : unique) {
                    //System.out.println(key + ": " + Collections.frequency(aristas, key));
                    StringTokenizer tokens = new StringTokenizer(key, " ");
                    String token1 = tokens.nextToken();
                    String token2 = tokens.nextToken();
                    if(token2.equals(nodo_temp) && !token1.equals(nodo_temp)){
                        contador_temp++;
                    }                    
                }
                //System.out.println("M4 nodo "+nodo_temp+": "+contador_temp);
                nodos_M4.add(contador_temp);
            }
            
            for(String nodo_temp: lista_20){
                int contador_temp = 0;
                for (String arista : aristas) {
                    //System.out.println(key + ": " + Collections.frequency(aristas, key));
                    StringTokenizer tokens = new StringTokenizer(arista, " ");
                    String token1 = tokens.nextToken();
                    String token2 = tokens.nextToken();
                    if(token1.equals(nodo_temp) && !token2.equals(nodo_temp) ){
                        contador_temp++;
                    }                    
                }
                //System.out.println("M4 nodo "+nodo_temp+": "+contador_temp);
                nodos_M1.add(contador_temp);
            }

            for(String nodo_temp: lista_20){
                int contador_temp = 0;
                for (String arista : aristas) {
                    //System.out.println(key + ": " + Collections.frequency(aristas, key));
                    StringTokenizer tokens = new StringTokenizer(arista, " ");
                    String token1 = tokens.nextToken();
                    String token2 = tokens.nextToken();
                    if(token2.equals(nodo_temp) && !token1.equals(nodo_temp) ){
                        contador_temp++;
                    }                    
                }
                //System.out.println("M4 nodo "+nodo_temp+": "+contador_temp);
                nodos_M3.add(contador_temp);
            }
            
            
            //System.out.println(key + ": " + Collections.frequency(aristas, key));
            //aristas_peso.write(String.format("%s %s",));
            //aristas_peso.write(System.lineSeparator());

            /*
            int count_temp = 0;
            for(String nodo_temp: lista_20){
                System.out.println(nodo_temp+": M1: "+nodos_M1.get(count_temp)+", M2: "+nodos_M2.get(count_temp)+", M3: "+nodos_M3.get(count_temp)+", M4: "+nodos_M4.get(count_temp));
                //System.out.println("nodo "+nodo_temp+": "+contador_temp);
                count_temp++;
            }
            */
            int count_temp_1 = 0;
            for(String nodo_temp: lista_20){
                double result_MI_temp = 0;
                double M1,M2,M3,M4;
                M1 = nodos_M1.get(count_temp_1);
                M2 = nodos_M2.get(count_temp_1);
                M3 = nodos_M3.get(count_temp_1);
                M4 = nodos_M4.get(count_temp_1);
                if(M4 != 0 && M2 != 0 ){
                    result_MI_temp = M3*Math.log(M4)-M1*Math.log(M2);
                }
                else if(M4 == 0 && M2 != 0 ){
                    result_MI_temp = -M1*Math.log(M2);
                }
                else if(M4 != 0 && M2 == 0 ){
                    result_MI_temp = M3*Math.log(M4);
                }
                else{
                    result_MI_temp = 0;
                }
                //System.out.println("nodo "+nodo_temp+": "+contador_temp);
                System.out.println(nodo_temp+": "+result_MI_temp);
                count_temp_1++;
            }            
            
            System.out.println("Contador aristas: "+contador_1);
            //System.out.println("Contador nodos: "+contador_2);
            //nodos_peso.close();
            buffer_nodos.close();
            buffer_aristas_id.close();
        }catch(FileNotFoundException ex) {
            System.out.println("No fue posible abrir '"+fileName+"'");                
        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}    