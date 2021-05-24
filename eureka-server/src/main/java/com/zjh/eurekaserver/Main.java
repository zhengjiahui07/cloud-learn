package com.zjh.eurekaserver;

import java.util.HashMap;

public class Main {

    public int minSwaps(String s) {
        int num1 = 0;
        int num0 = 0;
        int len = s.length();
        if(len == 0){
            return 0;
        }

        for(int i = 0; i < len; i++){
            if(s.charAt(i) == '1'){
                num1++;
            }else{
                num0++;
            }
        }

        if(Math.abs(num0 - num1) > 1){
            return -1;
        }
        int res = 0;
        boolean jude = false;
        for(int i = 0; i < len; i++){
            if(s.charAt(i) == '1'){
               if(jude){
                   res++;
                   jude = false;
               }else{
                   jude = true;
               }
            }else{
                jude = false;
            }
        }
        if(num1 > num0){
            return res;
        }

        int res2 = 0;
        jude = false;
        for(int i = 0; i < len; i++){
            if(s.charAt(i) == '0'){
                if(jude){
                    res2++;
                    jude = false;
                }else{
                    jude = true;
                }
            }else{
                jude = false;
            }
        }
        if(num0 > num1){
            return res2;
        }
        if(res == 0 || res2 == 0){
            return Math.max(res, res2);
        }




        return Math.min(res, res2);

    }
    public static void main(String[] args) {
        int[] nums = {1, 3};
        Main m = new Main();
        m.minSwaps("1110000000100001010100101010000101010101001000001110101000010111101100000111110001000111010111101100001100001001100101011110100011111100000000100011111011110111111011110111010100111101011111111101101100101010110000011110110100101111000100000001100000");


    }
}
class FindSumPairs {
    HashMap<Integer, Integer> map = new HashMap<>();
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    public FindSumPairs(int[] nums1, int[] nums2) {
        for(int i : nums1){
            map.put(i,map.getOrDefault(i, 0) + 1);
        }

        for(int i = 0; i < nums2.length; i++){
            hashMap.put(i, nums2[i]);
        }
    }

    public void add(int index, int val) {
        hashMap.put(index, hashMap.get(index) + val);
    }

    public int count(int tot) {
        int res = 0;
        for(int i : hashMap.values()){
            if(map.containsKey(tot - i)){
                res += map.get(tot - i);
            }
        }

        return res;

    }
}

