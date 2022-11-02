public class test_hash_map 
{
    public static void main(String[] args)
    {
        hash_map a = new hash_map();
        for (int i = 0; i < 10000; i++) 
        {
            a.add(i, i + "a");
            System.out.println("key: " + i +"; value: "+ a.getValue(i));
        }
        System.out.println("n = " + a.getSize());
        System.out.println("element 5 deleted");
        a.deleteElement(5);
        System.out.println("value 5 = " + a.getValue(5));
        System.out.println("n = " + a.getSize());
        System.out.println("a = " + a.get_a());
        System.out.println("a_max = " + a.get_a_give_a_max(1.75));
    }
}
