import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws Exception{

        FileReader fr = new FileReader("src/input.txt");
        Scanner scan = new Scanner(fr);

        String text =  scan.nextLine(); //начальная строка
        String sample = scan.nextLine(); //строка, которую надо найти

        String text1 = scan.nextLine();
        String sample1 = scan.nextLine();


        String text2 = scan.nextLine();
        String sample2 = scan.nextLine();

        String text3 = scan.nextLine();
        String sample3 = scan.nextLine();

        System.out.println(Arrays.toString(KMPSearch(text, sample).toArray()));
        System.out.println(Arrays.toString(KMPSearch(text1,sample1).toArray()));
        System.out.println(Arrays.toString(KMPSearch(text2,sample2).toArray()));
        System.out.println(Arrays.toString(KMPSearch(text3,sample3).toArray()));
    }

    /**
     *
     * @param sample - массив образца, который надо искать
     * @return - массив префикс функции
     */

    static int[] prefixFunction(String sample)
    {
        int [] values = new int[sample.length()];
        for (int i = 1; i < sample.length(); i++)
        {
            int j = 0;
            while (i + j < sample.length() && sample.charAt(j) == sample.charAt(i + j))
            {
                values[i + j] = Math.max(values[i + j], j + 1);
                j++;
            }
        }
        return values;
    }

    /**
     *
     * @param text - строка, которая нам дана, в которой надо искать
     * @param sample - строка, которую над найти
     * @return - массив входов подстроки
     */

    public static ArrayList<Integer> KMPSearch(String text, String sample)
    {


        ArrayList<Integer> found = new ArrayList<>();

        int[] prefixFunc = prefixFunction(sample);

        int i = 0;
        int j = 0;

        while (i < text.length())
        {
            if (sample.charAt(j) == text.charAt(i))
            {
                j++;
                i++;
            }
            if (j == sample.length())
            {
                found.add(i - j);
                j = prefixFunc[j - 1];
            } else if (i < text.length() && sample.charAt(j) != text.charAt(i))
            {
                if (j != 0)
                {
                    j = prefixFunc[j - 1];
                } else {
                    i = i + 1;
                }
            }
        }

        return found;
    }
}