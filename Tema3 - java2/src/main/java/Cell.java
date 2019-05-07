public class Cell<T, P> {
    T key;
    P value;
    Cell<T,P> next = null;


    public Cell(T key, P value, Cell next){
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public void print(){
        if(this != null)
            System.out.print("key: " + this.key + ", value: " + this.value + ", ");
        else
            System.out.println("empty");
    }
}
