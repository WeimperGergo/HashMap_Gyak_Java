/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adathalmazok_gyakorlas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class ArrayL {

    public static Random rnd = new Random();
    private static ArrayList<Integer> egeszSzamLista;
    private static HashSet<Integer> kulonbozoek;
    public static void main(String[] args) {
        egeszSzamLista = new ArrayList<Integer>();
        listaFeltolt(20);
        kiirLista();
        paratlanKivesz();
        kiirLista();
        szamKigyujt();
        kiirSet();
        mibolMennyi();
    }

    private static void listaFeltolt(int hossz) {
        for (int i = 0; i < hossz; i++) {
           egeszSzamLista.add(i, rnd.nextInt(10, 21));
        }
    }
    
    private static void paratlanKivesz(){
        for (int i = egeszSzamLista.size()-1; i >= 0; i--) {
            if(egeszSzamLista.get(i) % 2 != 0)
            {
                egeszSzamLista.remove(i);
            }
        }
    }
    
    private static void kiirLista(){
        System.out.print(egeszSzamLista.get(0));
        for (int i = 1; i < egeszSzamLista.size(); i++) {
            System.out.print(", " + egeszSzamLista.get(i));
        }
        System.out.println("");
    }
    
    private static void kiirSet(){
        System.out.println("Különböző elemek: ");
        for(int szam : kulonbozoek){
            System.out.print(szam + " ");
        }
        System.out.println("");
        
        
    }
    
    private static void kiir(String szoveg){
        System.out.println(szoveg);
    }
    
    private static void szamKigyujt(){
        kulonbozoek = new HashSet<>(egeszSzamLista);
    }

    private static void mibolMennyi(){
        HashMap<Integer, Integer> statisztika = new HashMap<>();  // < > -> GENERIKUS szerkezet
        for (int kulcs : egeszSzamLista) {
            if(statisztika.containsValue(kulcs)){
               // A meglévő kulcs értékét növeljük 
               int ertek = statisztika.get(kulcs);
               statisztika.put(kulcs, ++ertek); // A kulcsnál lévő érték +1, így növeljük
               // Prefix: ++n  -> betétel előtt növeli meg az értéket
            }
            else{
               // Létrehozzuk a kulcsot az 1 értékkel 
               statisztika.put(kulcs, 1);
            }
        }
        for(Map.Entry<Integer, Integer> entry : statisztika.entrySet() ){
            int kulcs = entry.getKey();
            int ertek = entry.getValue();
            String s = "[%d] = %d%n".formatted(kulcs, ertek);
            System.out.println(s);
        }
        
        
        
        Set<Map.Entry<Integer, Integer>> entry = statisztika.entrySet();
;
        
    }
    
    
}
