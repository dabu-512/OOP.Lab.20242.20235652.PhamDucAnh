package hust.soict.hedspi.aims.store;
import hust.soict.hedspi.aims.media.Playable;
import java.util.ArrayList;

import hust.soict.hedspi.aims.media.Media;
public class Store {
	public static final int MAX_ITEMS = 100;
    private ArrayList<Media> itemsOrdered = new ArrayList<>();    
    
    public ArrayList<Media> getMediaInStore() {
        return itemsOrdered;
    }
    public void addMedia(Media media) {
    	if (itemsOrdered.size() < MAX_ITEMS) {
    		itemsOrdered.add(media);
    		System.out.println("Add this media to the cart");
    	}
    	else {
    		System.out.println("The cart is full");
    	}
    }
    
    public void removeMedia(Media media) {
        if (itemsOrdered.remove(media)) {
            System.out.println("The media has been removed from the store.");
        } else {
            System.out.println("The media was not found in the store.");
        }
    }
    public void searchByID(int id) 	{
    	boolean found = false;
    	for(Media media : itemsOrdered) {
    		if (media.getId() == id) {
    			System.out.println("Found " + media);
    			found = true;
    		}
    	}
    	if (!found) {
    		System.out.println("No media found ");
    	}
    }
    
    public void searchByTitle(String title){
    	boolean found = false;
    	for(Media media : itemsOrdered) {
    		if (media.getTitle().equalsIgnoreCase(title)) {
    			System.out.println("Found " + media);
    			found = true;
    		}
    	}
    	if (!found) {
    		System.out.println("No media found ");
    	}
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
    public void displayStore() {
        System.out.println("-----------------Store----------------");
        for (Media media : itemsOrdered) {
            System.out.println(media.toString());
        }
        System.out.println("--------------------------------------");
    }
    public void playMedia(Media media) {
        if (media == null) {
            System.err.println("Error: Media to play cannot be null.");
            return;
        }
        
        if (media instanceof Playable) {
            ((Playable) media).play();
        } else {
            System.out.println("Error: This media '" + media.getTitle() + "' cannot be played.");
        }
    }
    
}


