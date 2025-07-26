c:\Users\himas\OneDrive\Desktop\DSAwithJAVA\java_projects\bank_pro.java c:\Users\himas\OneDrive\Desktop\DSAwithJAVA\java_projects\college_fest_pro.java c:\Users\himas\OneDrive\Desktop\DSAwithJAVA\java_projects\movie_ticket_booking.javapackage oops;
class Animal{
    void sound(){
        System.out.println("Animal makes sound");
    }
}
class Dog extends Animal{
    @Override
    void sound(){
        System.out.println("Dog barks");
    }
}
class Cat extends Animal{
    @Override
    void sound(){
        System.out.println("Cat meows");
    }
}
public class polymorphism {
    public static void main(String[] args) {
        Animal a;//refernce of parent class
        a = new Dog();
        a.sound();
        a = new Cat();
        a.sound();
    }
}