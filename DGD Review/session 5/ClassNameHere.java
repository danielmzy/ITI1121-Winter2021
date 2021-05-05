public class ClassNameHere {
   static interface Vehicule {
      public abstract void honk();	
   }
   public static class Car implements Vehicule {
      static int i=0;
      public void honk(){
         System.out.println("The Car is Honking");
      }
   }
   public static class Toyota extends Car {
      public void honk(){
         i = 1;
         System.out.println("The Toyota is Honking");
      }
   }
   public static void main(String[] args) {
      Car newT; // declaring, save me some memory
      newT = new Toyota(); // creating, instanciating filling the memory
      Car newT2; // declaring, save me some memory
      newT2 = new Toyota();
      newT.honk(); 
   }
}