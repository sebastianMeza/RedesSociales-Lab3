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

public class JSONReaderFile {
    public static void main(String[] args) throws FileNotFoundException,
            IOException, ParseException {
        int contador = 0;
        FileWriter nodos;
        FileWriter nodos_ocurrencias;
        FileWriter aristas;
        FileWriter aristas_id;
        ArrayList<String> lista_nodos = new ArrayList<String>();
        ArrayList<Integer> lista_nodos_ocurrencias = new ArrayList<Integer>();
        
        ArrayList<String[]> lista_aristas = new ArrayList<String[]>();
        ArrayList<Integer[]> lista_aristas_id = new ArrayList<Integer[]>();
        ArrayList<String> lista_20 = new ArrayList<String>();
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
        try {
            nodos = new FileWriter(new File("nodos.txt"));
            aristas = new FileWriter(new File("aristas.txt"));
            aristas_id = new FileWriter(new File("aristas_id.txt"));
            nodos_ocurrencias = new FileWriter(new File("nodos_ocurrencias.txt"));
            JSONParser parser = new JSONParser();
            JSONArray jsonArray = (JSONArray) parser.parse(new FileReader("C:\\Users\\Sebastian\\Documents\\GitHub\\RedesSociales-Lab3\\corpus.json"));
            for (Object objeto : jsonArray) {
                contador++;
                JSONObject tweet = (JSONObject) objeto;
                //String text = (String) tweet.get("text");
                //System.out.println("Text: '" + text+"'");
                JSONObject usuarios = (JSONObject) tweet.get("user");
                String screen_name = (String) usuarios.get("screen_name");
                JSONObject entities = (JSONObject) tweet.get("entities");
                JSONArray user_mentions = (JSONArray) entities.get("user_mentions");
                //System.out.println("Usuario: '" + screen_name+"'");
                //System.out.println("Menciones:");
                for (Object mencion : user_mentions) {
                    JSONObject mencion_o = (JSONObject) mencion;            
                    String screen_name_mencionado = (String) mencion_o.get("screen_name");
                    if((screen_name.equals("Karolcariola") || screen_name.equals("GiorgioJackson") || screen_name.equals("SenadorGuillier") || screen_name.equals("felipeharboe") || screen_name.equals("camila_vallejo") || screen_name.equals("gabrielboric") || screen_name.equals("gustavohasbun") || screen_name.equals("senadornavarro") || screen_name.equals("ivanmoreirab") || screen_name.equals("Chile_Vamos_") || screen_name.equals("NuevaMayoriacl") || screen_name.equals("ceciperez1") || screen_name.equals("urrutiaosvaldo") || screen_name.equals("ignaciowalker") || screen_name.equals("lautarocarmona") || screen_name.equals("RojoEdwards") || screen_name.equals("Hugo_Gutierrez_") || screen_name.equals("marconunez") || screen_name.equals("iallendebussi") || screen_name.equals("hgonzaduran"))
                            && (screen_name_mencionado.equals("Karolcariola") || screen_name_mencionado.equals("GiorgioJackson") || screen_name_mencionado.equals("SenadorGuillier") || screen_name_mencionado.equals("felipeharboe") || screen_name_mencionado.equals("camila_vallejo") || screen_name_mencionado.equals("gabrielboric") || screen_name_mencionado.equals("gustavohasbun") || screen_name_mencionado.equals("senadornavarro") || screen_name_mencionado.equals("ivanmoreirab") || screen_name_mencionado.equals("Chile_Vamos_") || screen_name_mencionado.equals("NuevaMayoriacl") || screen_name_mencionado.equals("ceciperez1") || screen_name_mencionado.equals("urrutiaosvaldo") || screen_name_mencionado.equals("ignaciowalker") || screen_name_mencionado.equals("lautarocarmona") || screen_name_mencionado.equals("RojoEdwards") || screen_name_mencionado.equals("Hugo_Gutierrez_") || screen_name_mencionado.equals("marconunez") || screen_name_mencionado.equals("iallendebussi") || screen_name_mencionado.equals("hgonzaduran"))){
                        System.out.print("Usuario: '" + screen_name+"'");
                        System.out.print("\tMencionado: '" + screen_name_mencionado+"'");                    
                        System.out.println();
                        if (!(lista_nodos.contains(screen_name))){
                            lista_nodos.add(screen_name);
                            lista_nodos_ocurrencias.add(0);
                        }
                        else{
                            int index_sm_temp = lista_nodos.indexOf(screen_name);
                            int contador_temp = lista_nodos_ocurrencias.get(index_sm_temp);
                            contador_temp++;
                            lista_nodos_ocurrencias.set(index_sm_temp, contador_temp);
                        }
                        if (!(lista_nodos.contains(screen_name_mencionado))){
                            lista_nodos.add(screen_name_mencionado);
                            lista_nodos_ocurrencias.add(0);
                        }
                        else{
                            int index_sm_temp = lista_nodos.indexOf(screen_name_mencionado);
                            int contador_temp = lista_nodos_ocurrencias.get(index_sm_temp);
                            contador_temp++;
                            lista_nodos_ocurrencias.set(index_sm_temp, contador_temp);
                        }
                        String[] arista_temporal  = new String[2];            
                        Integer[] aristaID_temporal  = new Integer[2];            
                        arista_temporal[0] = screen_name;
                        arista_temporal[1] = screen_name_mencionado;
                        lista_aristas.add(arista_temporal);
                        int index1_temp = lista_nodos.indexOf(screen_name);
                        int index2_temp = lista_nodos.indexOf(screen_name_mencionado);
                        aristaID_temporal[0] = index1_temp+1;
                        aristaID_temporal[1] = index2_temp+1;
                        lista_aristas_id.add(aristaID_temporal);
                    }

                }
            }
            System.out.println("contador: "+contador);
            int size_nodo_list = lista_nodos.size();
            int size_nodo_ocu_list = lista_nodos_ocurrencias.size();
            int size_arista_list = lista_aristas.size();
            int size_arista_id_list = lista_aristas_id.size();
            int contador_20 = 0;
            System.out.println("cantidad nodos: "+size_nodo_list);
            System.out.println("cantidad nodos ocu: "+size_nodo_ocu_list);
            System.out.println("cantidad aristas: "+size_arista_list);
            System.out.println("cantidad aristas_id: "+size_arista_id_list);
            for(int i= 0;i<size_nodo_list;i++){
                if(lista_20.contains(lista_nodos.get(i))){
                    nodos.write(String.format("%d %s",(i+1),lista_nodos.get(i)));
                    nodos.write(System.lineSeparator());
                    contador_20++;
                }
                else{
                    nodos.write(String.format("%d",(i+1)));
                    nodos.write(System.lineSeparator());
                }
            }
            System.out.println("contador 20: "+contador_20);

            for(int i= 0;i<size_nodo_ocu_list;i++){
                nodos_ocurrencias.write(String.format("%d, %d,%s",lista_nodos_ocurrencias.get(i),(i+1),lista_nodos.get(i)));
                nodos_ocurrencias.write(System.lineSeparator());
            }

            aristas.write(String.format("Nodes: %s Edges: %s",size_nodo_list,size_arista_list));
            aristas.write(System.lineSeparator());
            aristas.write(String.format("FromNodeId ToNodeId"));
            aristas.write(System.lineSeparator());
            for(int j= 0;j<size_arista_list;j++){
                aristas.write(String.format("%s %s",lista_aristas.get(j)[0],lista_aristas.get(j)[1]));
                aristas.write(System.lineSeparator());
            }

            aristas_id.write(String.format("Nodes: %s Edges: %s",size_nodo_list,size_arista_list));
            aristas_id.write(System.lineSeparator());
            aristas_id.write(String.format("FromNodeId ToNodeId"));
            aristas_id.write(System.lineSeparator());
            for(int j= 0;j<size_arista_list;j++){
                aristas_id.write(String.format("%s %s",lista_aristas_id.get(j)[0],lista_aristas_id.get(j)[1]));
                aristas_id.write(System.lineSeparator());
            }
            
            
            
            nodos.close();
            nodos_ocurrencias.close();
            aristas.close();
            aristas_id.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}    