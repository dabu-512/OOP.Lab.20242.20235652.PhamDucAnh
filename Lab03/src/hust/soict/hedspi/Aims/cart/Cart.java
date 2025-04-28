package hust.soict.hedspi.aims.cart;
import java.util.Collections;

import hust.soict.hedspi.aims.media.Media;

import java.util.ArrayList;
public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<>();

    public ArrayList<Media> getItemsOrdered() {
        return itemsOrdered;
    }
    public void addMedia(Media media) {
    	if (!itemsOrdered.contains(media)) {
    		if (itemsOrdered.size() < MAX_NUMBERS_ORDERED ) {
    			itemsOrdered.add(media);
    			System.out.println("Add this media to the cart");
    		}
    		else {
    			System.out.println("The cart is full");
    		}
    	}
    	else {
    		System.out.println("This cart already exists.");
    	}
    }
    
    public void removeMedia(Media media) {
        if (itemsOrdered.remove(media)) {
            System.out.println("The media has been removed from the cart.");
        } else {
            System.out.println("The media was not found in the cart.");
        }
    }
    
    public void printCart() {
        System.out.println("\nCurrent Cart:");
        for (int i = 0; i < itemsOrdered.size(); i++) {
        	Media media = itemsOrdered.get(i);
        	System.out.println((i + 1) + ". " + media.getTitle() + " - $" + media.getCost());
        }
        System.out.println("Total Cost: $" + totalCost());
        System.out.println("------------------------------");
    }
      
   
    
    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
        	total += media.getCost();
        }
        return total;
    }
    
    public void displayCart() {
        System.out.println("\n---------- CART--------------");
        for (Media media : itemsOrdered) {
            System.out.println(media.toString());
        }
        System.out.println("Total cost: " + totalCost());
        System.out.println("------------------------------\n");
    }
    
    public Media findMediaByTitle(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null; 
    }

    public Media findMediaById(int id) {
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                return media;
            }
        }
        return null;
    }
    
    public void filterById(int id) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println(media.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No media with this ID found in the cart.");
        }
    }

    public void filterByTitle(String title) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                System.out.println(media.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No media with this title found in the cart.");
        }
    }
    public void sortByTitleCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        System.out.println("The cart has been sorted by title.");
    }

    public void sortByCostTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        System.out.println("The cart has been sorted by cost.");
    }
    public void clearCart() {
        itemsOrdered.clear();
        System.out.println("The cart is now empty.");
    }
}
