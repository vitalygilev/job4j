 package ru.job4j.array;

 public class Min {

     /**
      * проверить, что эталон больше, чем элемент. записать в эталон элемент массива.
      * @param array
      * @return
      */
     public static int findMin(int[] array) {
         int min = array[0];
         for (int index = 1; index < array.length; index++) {
             if (array[index] < min) {
                 min = array[index];
             }
         }
         return min;
     }


 }
