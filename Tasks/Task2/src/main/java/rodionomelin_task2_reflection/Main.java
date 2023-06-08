package rodionomelin_task2_reflection;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static  void main(String[] args) {
        Pet cat = new Pet(
                "Барсик",
                Status.AVAILABLE,
                List.of(
                        new Photo("Барсик с цветочком", "https://placekitten.com/200/300"),
                        new Photo("Барсик на ручках", "https://placekitten.com/500/605")
                )
        );

        Animal animalCat = mapToProductDto(cat);
        System.out.println(animalCat);

        Pet cat1 = new Pet(
                "Пушок",
                Status.SOLD,
                List.of(
                        new Photo("Пушок с мячиков", "https://testlink.com/200/300"),
                        new Photo("Пушок бегает", "https://testlink.com/500/605")
                )
        );

        Animal animalCat1 = mapToProductDto(cat1);
        System.out.println(animalCat1);
    }

    public static Animal mapToProductDto(Pet pet) {
        Animal animal = new Animal();
        try {
            Field nameField = Pet.class.getDeclaredField("name");
            nameField.setAccessible(true);

            Field titleField = Animal.class.getDeclaredField("title");
            titleField.setAccessible(true);
            titleField.set(animal, nameField.get(pet));


            Field statusField = Pet.class.getDeclaredField("status");
            statusField.setAccessible(true);

            if (statusField.get(pet) == Status.AVAILABLE) {
                Field isAvailableField = Animal.class.getDeclaredField("isAvailable");
                isAvailableField.setAccessible(true);
                isAvailableField.set(animal, true);

                Field isSoldField = Animal.class.getDeclaredField("isSold");
                isSoldField.setAccessible(true);
                isSoldField.set(animal, false);
            } else {
                Field isAvailableField = Animal.class.getDeclaredField("isAvailable");
                isAvailableField.setAccessible(true);
                isAvailableField.set(animal, false);

                Field isSoldField = Animal.class.getDeclaredField("isSold");
                isSoldField.setAccessible(true);
                isSoldField.set(animal, true);
            }

            Field photosListField = Pet.class.getDeclaredField("photosList");
            photosListField.setAccessible(true);

            //~~~
            List<Photo> photosList = (List<Photo>) photosListField.get(pet);

            Map<String, String> photosMap = new HashMap<>();
            for (Photo photo : photosList) {
                photosMap.put(photo.getName(), photo.getURL());
            }

            Field photosMapField = Animal.class.getDeclaredField("photosMap");
            photosMapField.setAccessible(true);
            photosMapField.set(animal, photosMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return animal;
    }
}