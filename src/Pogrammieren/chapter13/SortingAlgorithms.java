package Pogrammieren.chapter13;

public class SortingAlgorithms {

    private static int quickSortSwapCount = 0;

    public static void main(String[] args) {
        int[] toSort = {50, 70, 100, 80, 40, 30, 20, 10 ,60};
        System.out.println("Unsortiert: ");
        printArray(toSort);


        System.out.println("Unsortierte Arrays:");
        System.out.println("===================");
        System.out.println("Bubble Sort V1 sortiert: ");
        int[] sorted = bubbleSortV1(toSort.clone());
        printArray(sorted);

        System.out.println("Bubble Sort V2 sortiert: ");
        sorted = bubbleSortV2(toSort.clone());
        printArray(sorted);

        System.out.println("Bubble Sort V3 sortiert: ");
        sorted = bubbleSortV3(toSort.clone());
        printArray(sorted);

        System.out.println("Selection Sort sortiert: ");
        sorted = selectionSort(toSort.clone());
        printArray(sorted);

        System.out.println("Quick Sort sortiert: ");
        sorted = quickSort(toSort.clone());
        printArray(sorted);


        System.out.println("Sortierte Arrays:");
        System.out.println("=================");
        System.out.println("Bubble Sort V2 sortiert (auf Sortiertem Array): ");
        sorted = bubbleSortV2(sorted.clone());
        printArray(sorted);

        System.out.println("Bubble Sort V3 sortiert (auf Sortiertem Array): ");
        sorted = bubbleSortV3(sorted.clone());
        printArray(sorted);
    }


    public static int[] quickSort(int[] numbers){
        quickSortSwapCount = 0;
        long startTime = System.nanoTime();

        quickSort(numbers, 0, numbers.length-1);

        long stopTime = System.nanoTime();
        printRuntimeDuration("QuickSort", numbers.length, startTime, stopTime, quickSortSwapCount);
        return numbers;
    }

    private static void quickSort(int[] numbers, int left, int right){

        int indexLeft = left;
        int indexRight = right;

        if(left < right){
            int pivot = numbers[(indexLeft + indexRight) / 2];

            while(indexLeft <= indexRight){
                while(numbers[indexLeft] < pivot){
                    indexLeft++;
                }
                while(numbers[indexRight] > pivot){
                    indexRight--;
                }
                if(indexLeft <= indexRight){
                    swap(numbers, indexLeft, indexRight);
                    quickSortSwapCount++;
                    indexLeft++;
                    indexRight--;
                }
            }

            if(left < indexRight){
                quickSort(numbers, left, indexRight);
            }
            if(indexLeft < right){
                quickSort(numbers, indexLeft, right);
            }

        }

    }

    public static int[] selectionSort(int[] numbers){

        int swapCount = 0;
        long startTime = System.nanoTime();

        int sortedMarker = numbers.length - 1;

        while(sortedMarker > 0){
            int maxPos = sortedMarker;
            for (int i = 0; i < sortedMarker; i++){
                if(numbers[i] > numbers[maxPos]){
                    maxPos = i;
                }
            }
            swap(numbers, maxPos, sortedMarker);
            swapCount++;
            sortedMarker--;

        }

        long stopTime = System.nanoTime();
        printRuntimeDuration("Bubble Sort v1", numbers.length, startTime, stopTime, swapCount);

        return numbers;
    }

    public static int[] bubbleSortV1(int[] numbers){

        int swapCount = 0;
        long startTime = System.nanoTime();

        for (int i = numbers.length; i > 0; i--){
            for (int j = 0; j < numbers.length -1; j++){
                if(numbers[j] > numbers[j+1]){
                    //tauschen
                    swap(numbers, j, j+1);
                    swapCount++;
                }
            }
        }

        long stopTime = System.nanoTime();
        printRuntimeDuration("Bubble Sort v1", numbers.length, startTime, stopTime, swapCount);

        return numbers;
    }

    public static int[] bubbleSortV2(int[] numbers){

        int swapCount = 0;
        long startTime = System.nanoTime();

        for (int i = numbers.length; i > 0; i--){
            for (int j = 0; j < i -1; j++){ // i-1 entscheidend -> Sortierten Bereich nicht mehr berücksichtigen
                if(numbers[j] > numbers[j+1]){
                    //tauschen
                    swap(numbers, j, j+1);
                    swapCount++;

                }
            }
        }

        long stopTime = System.nanoTime();
        printRuntimeDuration("Bubble Sort v1", numbers.length, startTime, stopTime, swapCount);

        return numbers;
    }

    public static int[] bubbleSortV3(int[] numbers){

        int swapCount = 0;
        long startTime = System.nanoTime();
        boolean swapped = false;


        for (int i = numbers.length; i > 0; i--){
            swapped = false;
            for (int j = 0; j < i -1; j++){
                if(numbers[j] > numbers[j+1]){
                    //tauschen
                    swap(numbers, j, j+1);
                    swapCount++;
                    swapped = true;
                }
            }
            if(!swapped){
                break;
            }
        }

        long stopTime = System.nanoTime();
        printRuntimeDuration("Bubble Sort v1", numbers.length, startTime, stopTime, swapCount);

        return numbers;
    }
    private static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void printArray(int[] numbers){
        for(int number : numbers){
            System.out.print(number + ", ");
        }
        System.out.println();
    }

    private static void printRuntimeDuration(String algorithmName, int elementCount, long startTime, long endTime, int swapCount){
        long durationInNanoSeconds = endTime - startTime;
        long durationInMilliSeconds = (long) (durationInNanoSeconds / 10e5);

        System.out.println("Runtime for " + elementCount + " on " + algorithmName + ": " + durationInNanoSeconds + " ns (" + durationInMilliSeconds + " ms); swapped " + swapCount + " times");
    }
}
