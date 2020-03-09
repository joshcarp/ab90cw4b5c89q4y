package com.baloise.open.template;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class App {

    public static void main(String[] args) {
        Map<String, Integer> myMap = new HashMap<String, Integer>();
        try {

            Scanner scanner = new Scanner(new File("test.txt"));
            while (scanner.hasNextLine()) {
                String clean = scanner.nextLine().replaceAll("[^a-zA-Z]", " ");
                String[] foo = clean.split(" ");

                for (int i=0; i < foo.length; i++)
                {
                    int bar = 0;
                    if (myMap.containsKey(foo[i])){
                        bar = myMap.get(foo[i]);
                    }
                    bar += 1;
                    myMap.put(foo[i].toLowerCase(), bar);
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Set set = myMap.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry)iterator.next();
            System.out.printf("%d: %s\n", mentry.getValue(),mentry.getKey());
        }

    }

}


