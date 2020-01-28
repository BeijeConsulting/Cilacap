package it.beije.cilacap.zoo;

public class Tiger extends Feline implements Carnivoro {

		public String getName() {
			return "Tiger";
		}
		
		public boolean striped(){
			return true;
		}
		
		public void mangioCarne() {
			System.out.println("Is eating meat");
		}

		public static void main(String[] args) {
			
			Tiger tiger = new Tiger();
			System.out.println(tiger.getName());
			System.out.println(tiger.striped());
			tiger.mangioCarne();
		}
}
