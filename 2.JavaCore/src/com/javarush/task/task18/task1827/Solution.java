package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Solution {
    BufferedReader bufferedReader = null;
    FileOutputStream fileOutputStream = null;
    String fileName = "";
    List<Integer> idList = new ArrayList<>();
    int length = 0;
    int counter = 0;
//=============================== составление названия товара с учетом пробелов ========================

    public static String getFileName(String[]args){
        String fileName = "";
        for (int i = 1; i <args.length-2 ; i++) {
            fileName+=args[i]+" ";
        }
        return fileName;
    }

    //      ===================== получение id нового товара ===============================
    public int idGetter(String string) throws IOException {
        int id = 0;
        String line;
        bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        String substring;
        try{
            while ((line = bufferedReader.readLine())!=null) {
                length = line.length();
                substring = line.substring(0, 8);
                id = Integer.parseInt(substring.trim());
                idList.add(id);
            }
            Collections.sort(idList);
            id = idList.get(idList.size()-1)+1;
        }catch (IOException e){

        }finally {
            bufferedReader.close();
        }
        return id;
    }
    // =========================== дополнение поля информации до необходимой длины ===========================
    public String spacer(String s) {
        int diff = 0;
        String spacers = "";
        switch (counter) { // считаю кол-ов раз вызова метода для определения, сколько символов должно быть зарезирвировано для поля данных
            case (0): {
                if ((diff = (8 - Integer.parseInt(String.valueOf(s.length())))) > 0) { // если длина строки короче зарезервированного пространства - добавляю пробелов
                    for (int i = 0; i < diff; i++) {
                        spacers = spacers + " ";
                    }
                    counter++;
                    s += spacers;
                    break;
                }
            }
            case (1): {
                if ((diff = (30 - Integer.parseInt(String.valueOf(s.length())))) > 0) {
                    for (int i = 0; i < diff; i++) {
                        spacers = spacers + " ";
                    }
                    counter++;
                    s += spacers;
                    break;
                }
            }
            case (2): {
                if ((diff = (8 - Integer.parseInt(String.valueOf(s.length())))) > 0) {
                    for (int i = 0; i < diff; i++) {
                        spacers = spacers + " ";
                    }
                    counter++;
                    s += spacers;
                    break;
                }
            }
            case (3): {
                if ((diff = (4 - Integer.parseInt(String.valueOf(s.length())))) > 0) {
                    for (int i = 0; i < diff; i++) {
                        spacers = spacers + " ";
                    }
                    counter = 0;
                    s += spacers;
                    break;
                }
            }
        }
        return s;
    }

    private void main0(String... args) {
        int id = 0;
        String newString;
        String price;
        String quantity;
        if (args.length!=0 && args[0].equals("-c")) {
            price = args[args.length-2];
            quantity = args[args.length-1];
            try{
                bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                fileName = bufferedReader.readLine();
                bufferedReader.close();
                fileOutputStream = new FileOutputStream(fileName,true);
                id = idGetter(fileName); // получаю id для нового товара
                // формирую новую строку для записи. если строка длиннее положенной длины - обрезаю по длине
                newString = ("\n" + spacer(String.valueOf(id)).substring(0,8) + spacer(getFileName(args)).substring(0,30) + spacer(price).substring(0,8) + spacer(quantity).substring(0,4));
                fileOutputStream.write((newString.getBytes("Cp1251")));
            }catch (IOException | ArrayIndexOutOfBoundsException e){
                e.printStackTrace();
            }finally {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args){
        new Solution().main0(args);
    }
}