/*
1. Java is statically typed, while Python is dynamically typed.
2. Java requires a class and a main method; Python does not.
3. Java code must be compiled before running; Python is interpreted.
 */
public class Power{
    public static void main(String[] args){
        long res = (long) Math.pow(2, 31);
        System.out.println(res);
    }
}