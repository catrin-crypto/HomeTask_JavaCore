package lesson11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GenericArray<T extends Number> {
    private List<T> arrList;

    public GenericArray(List<T> arrList) {
        this.arrList = arrList;
    }

    public void ExchangeElements(int from,int to){
        if (from!=to) {
            T tmp;
            tmp = arrList.get(to);
            arrList.set(to,arrList.get(from));
            arrList.set(from,tmp);
        }
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        arrList.forEach((t)-> {
            sb.append(t.toString());
            sb.append(", ");
        });
        return "GenericArray{" +
                "arrList=" + sb +
                '}';
    }
}

