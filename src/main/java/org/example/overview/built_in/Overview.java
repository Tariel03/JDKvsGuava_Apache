package org.example.overview.built_in;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class Overview {
    public static void main(String[] args) {
        //Dynamisches Array
        List<Integer> list = new ArrayList<>();
        for(int i  = 0 ; i<1000000; i++){
            list.add(i);
        }
        long start = System.nanoTime();

        int t =0;
        for (int i : list){
            t = i;
        }

        long finish  = System.nanoTime();
        System.out.println(finish - start/ Math.pow(10,9));
    }


}
