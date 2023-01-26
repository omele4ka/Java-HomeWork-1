//        1. Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i
//        2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
//        3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1
//        4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2
//
//        int i = new Random().nextInt(k); //это кидалка случайных чисел!)

import java.util.Random;

public class HomeWork1 {
    public static void main(String[] args) {
        Random rnd = new Random();
        int i = rnd.nextInt(0, 2001);  //Случайное число из заданного диапозона
        System.out.println(i);

        int n = (int) highestBitNumber(i);  //Номер старшего значащего бита выпавшего числа
        System.out.println(n);

        short minValue = Short.MIN_VALUE;
        int minNum = minValue;
        short maxValue = Short.MAX_VALUE;
        int maxNum = maxValue;

        int m1Length = m1ArrLength(i, n);  // Получение длинны массива m1
        System.out.println(m1Length);
        int[] m1 = new int[m1Length];
        for (int j = 0; j < m1Length; j++) {      // Заполнение массива m1
            for (int k = i; k < maxNum; k++) {
                if (k % n == 0) {
                    m1[j] = k;
                }
            }

        }
        System.out.println(m1);

        int m2Length = m2ArrLenght(i, n);   // Получение длинны массива m2
        System.out.println(m2Length);
        int[] m2 = new int[m2Length];
        for (int j = 0; j < m2Length; j++) {     // Заполнение массива m2
            for (int k = minNum; k < i; k++) {
                if (k % n != 0) {
                    m2[j] = k;
                }
            }

        }
    }
    static double highestBitNumber(int i) {   // Функция подсчета номера старшего значащего бита выпавшего числа
        if (i == 0)
            return 0;
        int degree = 0;
        i = i/2;
        while (i != 0){
            i = i/2;
            degree++;
        }
        return (Math.pow(2, degree));
    }
    static int m1ArrLength(int a, int b) {     // Функция подсчета длинны массива m1
        int count = 0;
        short maxValue = Short.MAX_VALUE;
        int maxNum = maxValue;
        while (a < maxNum) {
            if (a % b == 0){
                count ++;
            }
            a++;
        }
        return count;
    }
    static int m2ArrLenght(int a, int b) {   // Функция подсчета длинны массива m2
        int count = 0;
        short minValue = Short.MIN_VALUE;
        int minNum = minValue;
        while(minNum < a) {
            if (minNum % b != 0) {
                count++;
            }
            minNum ++;
        }
        return count;
    }


}
