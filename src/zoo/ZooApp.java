package src.zoo;

import java.util.ArrayList;
import java.util.List;

public class ZooApp {
	public static void main(String[] args) {
		Zoo<Mammal> mammalZoo = new Zoo<>();
		mammalZoo.addAnimal(new Mammal("Arslan"));

		Zoo<Bird> birdZoo = new Zoo<>();
		birdZoo.addAnimal(new Bird("Togoruu"));

		List<Animal> generalZoo = new ArrayList<>();

		
		List<Mammal> mammals = new ArrayList<>(mammalZoo.getAnimals());
		List<Bird> birds = new ArrayList<>(birdZoo.getAnimals());

		
		mammalZoo.transferAnimals(mammals, generalZoo);
		birdZoo.transferAnimals(birds, generalZoo);

	
		generalZoo.forEach(a -> System.out.println(a.getName()));
	}
}
