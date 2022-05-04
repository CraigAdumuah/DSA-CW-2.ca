package helpers;

import java.util.ArrayList;

public class Sorts<E extends Comparable<E>> {
    public void swap(ArrayList<E> dataToSort, int index){
        E temp = dataToSort.get(index);
        dataToSort.set(index,dataToSort.get(index + 1) );
        dataToSort.set(index+1,temp );
    }

    public void BSort(ArrayList<E> dataToSort){
        for(int outer = 0; outer < dataToSort.size() - 1; outer++) {
            for (int inner = 0; inner < dataToSort.size() - 1; inner++) {
                if (dataToSort.get(inner).compareTo(dataToSort.get(inner + 1)) > 0) {
                    swap(dataToSort, inner);


                }
            }


        }
    }
}

