import java.util.Queue;

/**
 * Created by dengdechao on 2017/2/8.
 *
 *
 * 猫狗队列
 */
class Pet {
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Pet(String type) {
        this.type = type;
    }

    private String type;
}

class Dog extends Pet {
    public Dog() {
        super("dog");
    }
}

class Cat extends Pet {
    public Cat() {
        super("cat");
    }
}

class PetEnterQueue {
    private Pet pet;
    private long count;

    public PetEnterQueue(Pet pet, long count) {
        this.pet = pet;
        this.count = count;
    }

    public String getPetType() {
        return pet.getType();
    }

    public Pet getPet() {
        return pet;
    }

    public long getCount() {
        return count;
    }
}


public class DogCatQueue {
    private Queue<PetEnterQueue> dogQueue;
    private Queue<PetEnterQueue> catQueue;
    private long count;

    public DogCatQueue(Queue<PetEnterQueue> dogQueue, Queue<PetEnterQueue> catQueue) {
        this.dogQueue = dogQueue;
        this.catQueue = catQueue;
        this.count = 0;
    }

    public void add(Pet pet) {
        if(pet.getType().equals("dog")) {
            PetEnterQueue dogPet = new PetEnterQueue(pet, count++);
            dogQueue.add(dogPet);
        } else if(pet.getType().equals("cat")) {
            PetEnterQueue catPet = new PetEnterQueue(pet, count++);
            catQueue.add(catPet);
        } else {
            throw new RuntimeException("type error");
        }
    }

    public boolean isEmpty() {
        if(dogQueue.isEmpty() && catQueue.isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean isDogEmpty() {
        return dogQueue.isEmpty();
    }

    public boolean isCatEmpty() {
        return catQueue.isEmpty();
    }

    public Pet pollDog() {
        if(!isDogEmpty()) {
            return dogQueue.poll().getPet();
        } else {
            throw new RuntimeException("dogQueue is empty");
        }
    }

    public Pet pollCat() {
        if(!isCatEmpty()) {
            return catQueue.poll().getPet();
        } else {
            throw new RuntimeException("catQueue is empty");
        }
    }

    public Pet pollAll() {
        if(!isCatEmpty() && !isDogEmpty()) {
            if(catQueue.peek().getCount() < dogQueue.peek().getCount()) {
                return catQueue.poll().getPet();
            } else {
                return dogQueue.peek().getPet();
            }
        } else if(!isCatEmpty() && isDogEmpty()) {
            return catQueue.poll().getPet();
        } else if(isCatEmpty() && !isDogEmpty()) {
            return dogQueue.poll().getPet();
        } else {
            throw new RuntimeException("queue is empty");
        }
    }
}
