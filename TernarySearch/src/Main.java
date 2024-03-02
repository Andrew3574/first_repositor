//Алгоритм тернарного(троичного) поиска
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите размерность массива:");
        int len = in.nextInt();
        int[] myArray = new int[len];

        System.out.println("Введите элементы массива:");
        for(int i = 0; i < myArray.length; i++)
        {
            myArray[i] = in.nextInt();
        }

        System.out.println("Введите элемент для нахождения:");
        int elem = in.nextInt();

        sort(myArray);
        printer(myArray);
        System.out.printf("Необходимый элемент на индексе: %d",ternarySearch(myArray,elem));
    }

    public static void sort(int[] myArray)
    {
        for(int i = myArray.length - 1; i > 0; i--)
        {
            for(int j = 0; j < i; j++)
            {
                if(myArray[j] > myArray[j+1])
                {
                    int tmp = myArray[j];
                    myArray[j] = myArray[j+1];
                    myArray[j+1] = tmp;
                }
            }
        }
    }

    public static void printer(int[] myArray)
    {
        System.out.println("Полученный массив: ");
        for(int i = 0; i < myArray.length; i++)
        {
            System.out.println(myArray[i]);
        }
    }

    public static int ternarySearch(int[] myArray, int element)
    {
       int l = 0;
       int r = myArray.length - 1;
       for(; l <= r;)
       {
           int h = (r - l) / 3;
           int m1 = l + h;
           int m2 = r - h;

           if (myArray[m1] == element)
           {
               return m1;
           }
           if (myArray[m2] == element)
           {
               return m2;
           }
           if (myArray[m1] < element && myArray[m2] > element)
           {
               l = m1 + 1;
               r = m2 - 1;
           }
           else if (element < myArray[m1])
           {
               r = m1 - 1;
           }
           else
           {
               l = m2 + 1;
           }
       }
       return -1;
    }
}