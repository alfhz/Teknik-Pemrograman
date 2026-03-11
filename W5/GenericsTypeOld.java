public class GenericsTypeOld {

    private Object t; // deklarasi atribut/objek generic

    // getter generic
    public Object get() {
        return t;
    }

    // setter generic
    public void set(Object t) {
        this.t = t;
    }

    public static void main(String[] args) {
        // instansiasi objek    
        GenericsTypeOld type = new GenericsTypeOld();

        // Menyimpan String ke dalam Object
        type.set("Java");

        // Type casting manual: Berisiko menyebabkan ClassCastException di runtime
        String str = (String) type.get(); 
        
        System.out.println("Nilai: " + str);
    }
}
