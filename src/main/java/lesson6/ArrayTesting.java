package lesson6;

public class ArrayTesting {

    private int[] arr;

    public ArrayTesting(int[] arr) {
        this.arr = arr;
    }

    public int[] getNumbersArrayAfter4() {
        int counter = 0;
        int[] secondArray;
        for (int i = arr.length; i > 0; i--) {
            if (arr[i - 1] == 4) {
                counter = i;
                break;
            }
            counter = 0;
        }
        if (counter <= 0) {
            throw new RuntimeException("В массиве нет цифры 4");
        }
        secondArray = new int[arr.length - counter];
        for (int i = 0; i < secondArray.length; i++) {
            secondArray[i] = arr[counter + i];
        }

        return secondArray;
    }

    public boolean checkFor1And4() {
        boolean number4 = false;
        boolean number1 = false;

        if (arr.length < 2) {
            return false;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 1 && arr[i] != 4) {
                return false;
            }
            if (arr[i] == 4) {
                number4 = true;
            }
            if (arr[i] == 1) {
                number1 = true;
            }
        }

        return (number1 == number4);
    }
}
