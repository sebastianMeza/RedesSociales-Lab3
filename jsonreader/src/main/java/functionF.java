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

public class functionF {
    public static ArrayList<String> funcionF(ArrayList<String> conjunto_x,ArrayList<String> aristas, ArrayList<String> nodos_id, ArrayList<Integer> nodos_peso){
        ArrayList<String> resultado = new ArrayList<String>();
        resultado.addAll(conjunto_x);
        for(String arista: aristas){
            StringTokenizer tokens = new StringTokenizer(arista, " ");
            String token2 = tokens.nextToken();
            String token1 = tokens.nextToken();
            String token_peso = tokens.nextToken();
            Integer peso_arista = Integer.parseInt(token_peso);
            if(conjunto_x.contains(token2) && !conjunto_x.contains(token1)){
                int index_temp = nodos_id.indexOf(token1);
                if(peso_arista>= nodos_peso.get(index_temp)){
                    //System.out.println("el nodo: "+token2+" influencia al nodo: "+token1);
                    resultado.add(token1);
                }
            }
        }
        if(conjunto_x.size()!=resultado.size()){
            //System.out.println("entro");
            resultado = funcionF(resultado,aristas, nodos_id, nodos_peso);
        }
        /*
        for(String nodo_temp:conjunto_x){
            System.out.println("C_X nodo:"+nodo_temp);
        }
        for(String nodo_temp_1:resultado){
            System.out.println("RES nodo:"+nodo_temp_1);
        }
        */
        return resultado;
    }
    public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
        
        ArrayList<String> lista_20_solo20 = new ArrayList<String>();
        ArrayList<String> lista_20_todos = new ArrayList<String>();
        ArrayList<String> lista_20_nombres = new ArrayList<String>();
        //20 actores
        lista_20_solo20.add("1"); 
        lista_20_todos.add("206");
        lista_20_nombres.add("hgonzaduran");
        lista_20_solo20.add("2"); 
        lista_20_todos.add("18");
        lista_20_nombres.add("senadornavarro");
        lista_20_solo20.add("3"); 
        lista_20_todos.add("9");
        lista_20_nombres.add("camila_vallejo");
        lista_20_solo20.add("4"); 
        lista_20_todos.add("12");
        lista_20_nombres.add("Karolcariola");
        lista_20_solo20.add("5"); 
        lista_20_todos.add("22");
        lista_20_nombres.add("iallendebussi");
        lista_20_solo20.add("6"); 
        lista_20_todos.add("2");
        lista_20_nombres.add("Hugo_Gutierrez_");
        lista_20_solo20.add("7"); 
        lista_20_todos.add("138");
        lista_20_nombres.add("marconunez");
        lista_20_solo20.add("8"); 
        lista_20_todos.add("24");
        lista_20_nombres.add("NuevaMayoriacl");
        lista_20_solo20.add("9"); 
        lista_20_todos.add("5");
        lista_20_nombres.add("gabrielboric");
        lista_20_solo20.add("10");
        lista_20_todos.add("20");
        lista_20_nombres.add("GiorgioJackson");
        lista_20_solo20.add("11");
        lista_20_todos.add("7");
        lista_20_nombres.add("SenadorGuillier");
        lista_20_solo20.add("12");
        lista_20_todos.add("496");
        lista_20_nombres.add("lautarocarmona");
        lista_20_solo20.add("13");
        lista_20_todos.add("80");
        lista_20_nombres.add("RojoEdwards");
        lista_20_solo20.add("14");
        lista_20_todos.add("15");
        lista_20_nombres.add("Chile_Vamos_");
        lista_20_solo20.add("15");
        lista_20_todos.add("128");
        lista_20_nombres.add("gustavohasbun");
        lista_20_solo20.add("16");
        lista_20_todos.add("543");
        lista_20_nombres.add("felipeharboe");
        lista_20_solo20.add("17");
        lista_20_todos.add("132");
        lista_20_nombres.add("ignaciowalker");
        lista_20_solo20.add("18");
        lista_20_todos.add("160");
        lista_20_nombres.add("ceciperez1");
        lista_20_solo20.add("19");
        lista_20_todos.add("144");
        lista_20_nombres.add("ivanmoreirab");
        lista_20_solo20.add("20");
        lista_20_todos.add("1222");
        lista_20_nombres.add("urrutiaosvaldo");
        
        String path = "C:\\Users\\Sebastian\\Documents\\GitHub\\RedesSociales-Lab3\\Grafo - Todos\\";
        String fileName = path+"aristas_peso.txt";
        String fileName_nodo = path+"nodos_peso.txt";
        ArrayList<String> aristas = new ArrayList<String>();
        ArrayList<String> nodos_id = new ArrayList<String>();
        ArrayList<Integer> nodos_peso = new ArrayList<Integer>();

        try {
            FileReader reader_nodos = new FileReader(fileName_nodo);
            BufferedReader buffer_nodos = new BufferedReader(reader_nodos);
            FileReader reader_aristas = new FileReader(fileName);
            BufferedReader buffer_aristas = new BufferedReader(reader_aristas);
            String cadena_aristas,cadena_nodos;
            int contador_1=0,contador_2=0;
            //cadena_aristas = buffer_aristas.readLine();
            //cadena_aristas = buffer_aristas.readLine();
            while((cadena_aristas = buffer_aristas.readLine())!=null) {
                //StringTokenizer tokens = new StringTokenizer(cadena_ar, " ");
                //String token1 = tokens.nextToken();
                //String token2 = tokens.nextToken();
                //System.out.println(token1+" "+token2);
                aristas.add(cadena_aristas);
                contador_1++;
            }
            
            while((cadena_nodos = buffer_nodos.readLine())!=null) {
                StringTokenizer tokens = new StringTokenizer(cadena_nodos, " ");
                String token1 = tokens.nextToken();
                String token2 = tokens.nextToken();
                //System.out.println("nodo: "+token1);
                nodos_id.add(token1);
                nodos_peso.add(Integer.parseInt(token2));
                contador_2++;
            }
            

            buffer_nodos.close();
            buffer_aristas.close();
            int contador_3 = 0, contador_4 = 0;
            /*
            for(String jugador : lista_20_todos){
                ArrayList<String> conjunto_total = new ArrayList<String>();
                for(String sub_jugador : lista_20_todos){
                    if(!jugador.equals(sub_jugador)){
                        ArrayList<String> conjunto_x = new ArrayList<String>();
                        conjunto_x.add(jugador);
                        conjunto_x.add(sub_jugador);
                        ArrayList<String> conjunto = funcionF(conjunto_x,aristas, nodos_id, nodos_peso);
                        for(String nodo_temp:conjunto){
                            //System.out.println("Nodo: "+nodo_temp);
                            if(!conjunto_total.contains(nodo_temp)){
                                conjunto_total.add(nodo_temp);
                                //System.out.println(jugador+" y "+sub_jugador+" inserta "+nodo_temp);
                            }
                        }
                    }
                }
                System.out.println("F2-Nodo "+lista_20_nombres.get(contador_3)+": "+conjunto_total.size());
                contador_3++;
            }
            */
            
            for(String jugador : lista_20_solo20){
                ArrayList<String> conjunto_total = new ArrayList<String>();
                for(String sub_jugador : lista_20_solo20){
                    for(String sub_sub_jugador : lista_20_solo20){
                        if(!jugador.equals(sub_jugador) && !jugador.equals(sub_sub_jugador)&& !sub_jugador.equals(sub_sub_jugador)){
                            ArrayList<String> conjunto_x = new ArrayList<String>();
                            conjunto_x.add(jugador);
                            conjunto_x.add(sub_jugador);
                            conjunto_x.add(sub_sub_jugador);
                            ArrayList<String> conjunto = funcionF(conjunto_x,aristas, nodos_id, nodos_peso);
                            for(String nodo_temp:conjunto){
                                //System.out.println("Nodo: "+nodo_temp);
                                if(!conjunto_total.contains(nodo_temp)){
                                    conjunto_total.add(nodo_temp);
                                    //System.out.println(jugador+" y "+sub_jugador+" inserta "+nodo_temp);
                                }
                            }
                        }
                    }
                }
                System.out.println("F3-Nodo "+lista_20_nombres.get(contador_4)+": "+conjunto_total.size());
                contador_4++;

            }
            
            
            //for(String nodo_temp_1:conjunto){
            //    System.out.println("Nodo: "+nodo_temp_1);
            //}

            System.out.println("Aristas analizadas: "+contador_1);
            System.out.println("Nodos analizados: "+contador_2);
            
            
            
        }catch(FileNotFoundException ex) {
            System.out.println("No fue posible abrir '"+fileName+"'");                
        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}