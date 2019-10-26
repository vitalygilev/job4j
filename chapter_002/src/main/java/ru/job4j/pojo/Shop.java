package ru.job4j.pojo;

public class Shop {

    public static Product[] delete(Product[] products, int index) {
        if (index >= 0 && index < products.length) {
            products[index] = null;
            for (int subIndex = index; subIndex < products.length - 1; subIndex ++ ) {
                //Если все удаляемые элементы удаляются только этим методом, нет необходимости сдвигать текущий null в самый конец массива.
                if (products[subIndex + 1] != null) {
                    Product tmpProduct = products[subIndex];
                    products[subIndex] = products[subIndex + 1];
                    products[subIndex + 1] = tmpProduct;
                }
            }
        }
        return products;
    }

    public static void main(String[] args) {
        Product products[] = new Product[5];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        products[2] = new Product("Egg", 19);

        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            //проверяем, что объект не равен null. тк у нас массив не заполнен целиком.
            if (product != null) {
                System.out.println(product.getName());
            } else {
                System.out.println("null");
            }
        }

        System.out.println();
        System.out.println("Удаляем значение из ячейки с индексом 1");
        //удаляем значение из ячейки с индексом 1
        delete(products, 1);
        //products[1] = null;

        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            //проверяем, что объект не равен null. тк у нас массив не заполнен целиком.
            if (product != null) {
                System.out.println(product.getName());
            } else {
                System.out.println("null");
            }
        }
    }
}
