import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {


    public static void main(String[] args) throws IOException {
        File file = new File(
                "C:\\Users\\Admin\\IdeaProjects\\JsonParser\\src\\list.json");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        String result = "";
        while ((st = br.readLine()) != null)         //получаем строку из Json
            result += st;
        int count = 0;
        ///System.out.println(result);
        String[] text = result.split("\"");     //парсим на элементы
        char[] symvols = result.toCharArray();
        for (int i = 0; i < symvols.length; i++){
            if(symvols[i] == '}') count++;            //получаем количество сущностей
        }
        //for (String rt: text) {
           // System.out.println(rt);
       // }
        ArrayList<String> text2 = new ArrayList<>();  //получаем элементы сущностей
        for (int i = 1; i < text.length; i += 2){
            text2.add(text[i]);
        }
        //for (String rt: text2) {
        //    System.out.println(rt);
        //}
        StringBuilder bild = new StringBuilder();      //Билдим согласно заданию
        for (int i = 0; i < count*6; i +=6){            //Учтено разное количество сущностей
            bild.append("Студент ");
            bild.append(text2.get(i + 1));
            bild.append(" получил ");
            bild.append(text2.get(i + 3));
            bild.append(" по предмету ");
            bild.append(text2.get(i + 5));
            bild.append(".");
            bild.append("\n");
        }
        System.out.println(bild);                    //Выводим на экран
    }
}
