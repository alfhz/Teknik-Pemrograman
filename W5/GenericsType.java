public class GenericsType<T> {

    private T t;

    public T get() {
        return this.t;
    }

    public void set(T t1) { 
        this.t = t1;
    }

    public static void main(String[] args) {
        // 1. Penggunaan yang Aman (Type-Safe)
        GenericsType<String> type = new GenericsType<>();
        type.set("Java"); // Valid dan aman
        String str = type.get(); // Tidak butuh casting!

        // 2. Penggunaan Raw Type (Tidak Disarankan)
        // Ini tetap valid secara sintaks, tapi menghilangkan manfaat Generics
        GenericsType type1 = new GenericsType();

        type1.set("Java"); // Valid (dianggap Object)
        type1.set(10); // Valid (autoboxing ke Integer, tapi tetap dianggap Object)

        System.out.println("Type 1 (String): " + type1.get());
    }
}
