public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added.");
        } else {
            System.out.println("The cart is full!");
        }
    }
    
    public void addDigitalVideoDisc1(DigitalVideoDisc[] dvdList) {
    	for(DigitalVideoDisc dvd : dvdList) {
    		addDigitalVideoDisc(dvd);
    	}
    }
    
    public void addDigitalVideoDisc2(DigitalVideoDisc... dvds) {
        for (DigitalVideoDisc dvd : dvds) {
            addDigitalVideoDisc(dvd);
        }
    }

    public void addDoubleDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
    	addDigitalVideoDisc(dvd1);
    	addDigitalVideoDisc(dvd2);
    }
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].equals(disc)) {
                found = true;
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null;
                qtyOrdered--;
                System.out.println("The disc has been removed.");
                break;
            }
        }
        if (!found) {
            System.out.println("The disc was not found in the cart.");
        }
    }
    
    public void displayCart() {
        System.out.println("\nCurrent Cart:");
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println((i + 1) + ". " + itemsOrdered[i].getTitle() + " - $" + itemsOrdered[i].getCost());
        }
        System.out.println("Total Cost: $" + totalCost());
    }
    
    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }
}
