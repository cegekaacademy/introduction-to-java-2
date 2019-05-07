import javax.sound.midi.SysexMessage;
import java.util.ArrayList;
import java.util.LinkedList;

public class CustomHashMap<T, P> {

    private Cell<P,T> buckets[];
    int initial_capacity = 4;

    public CustomHashMap(){
        this.buckets = new Cell[initial_capacity];
    }

    public CustomHashMap(int capacity){
        this.buckets = new Cell[capacity];
    }

    public int hash_function(Cell cell){
        if(this.buckets.length != 0)
         return cell.key.hashCode() % this.buckets.length;
        return 0;
    }

    public void put(T key, P value){
        Cell<P,T> new_cell = new Cell(key, value, null);
        int index;

        index = this.hash_function(new_cell);
        Cell current = this.buckets[index];
        System.out.println("avem index " + index);
        if(current == null) {
            this.buckets[index] = new_cell;
            return;
        }
        while(current.next != null){
            if(current.key.equals(new_cell.key)){
                current.value = new_cell.value;
                return;
            }
            current = current.next;
        }

        if (current.key.equals(key)) {
            current.value = value;
        } else {
            current.next = new_cell;
        }

        System.out.println("O noua celula a fost adaugata in lista de la indexul " + index);
    }

    public void print(){


        for (int i=0; i<this.buckets.length; i++) {
            System.out.print("Lista de pe pozitia " + i + "  ");
            if(this.buckets[i] != null)
                this.buckets[i].print();
            else
                System.out.println("empty");

            System.out.println();
        }

    }

}
