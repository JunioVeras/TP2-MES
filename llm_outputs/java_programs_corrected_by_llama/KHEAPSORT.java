package java_programs;
import java.util.*;

public class KHEAPSORT {

    public static ArrayList<Integer> heapsort(ArrayList<Integer> arr) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < arr.size(); i++) {
            if(i >= arr.size() - k && k > 0){
                break;
            } else{
                heap.add(arr.get(i));
            }
        }

        ArrayList<Integer> output = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            if(k == 0 || i >= arr.size()){
                break;
            }
            output.add(heap.remove());

            if(!heap.isEmpty())
                heap.add(arr.get(i));

        }

        while (!heap.isEmpty()) {
            output.add(heap.remove());
        }

        Collections.reverse(output);

        return output;
    }
}