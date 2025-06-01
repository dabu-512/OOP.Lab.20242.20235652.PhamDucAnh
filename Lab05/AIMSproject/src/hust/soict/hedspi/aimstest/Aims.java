package hust.soict.hedspi.aims.Aims;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.Store;

import java.util.Scanner;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);
    static {
    store.addMedia(new DigitalVideoDisc(1, "The Lion King", "Animation", 19.95f, "Roger Allers", 87));
    store.addMedia(new DigitalVideoDisc(2, "Star Wars", "Science Fiction", 24.95f, "George Lucas", 124));
    store.addMedia(new CompactDisc(3, "Journey With You", "Music", 15.50f, "Queen", 60, "Iris"));
    store.addMedia(new Book(4, "C Language", "Programming", 45.00f));
    }
    public static void main(String[] args) {
        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
                case 1:
                    viewStore();
                    break;
                case 2:
                    updateStore();
                    break;
                case 3:
                    seeCart();
                    break;
                case 0:
                    System.out.println("Exit AIMS. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        } while (choice != 0);
    }

    public static void showMenu() {
        System.out.println("\nAIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void storeMenu() {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void mediaDetailsMenu() {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void cartMenu() {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    public static void viewStore() {
        int option;
        do {
            store.displayStore();
            storeMenu();
            option = scanner.nextInt();
            scanner.nextLine(); // consume newline
            switch (option) {
                case 1:
                    seeMediaDetails();
                    break;
                case 2:
                    addMediaToCart();
                    break;
                case 3:
                    playMedia();
                    break;
                case 4:
                    cart.printCart();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (option != 0);
    }

    public static void updateStore() {
        System.out.println("\nUpdate Store:");
        System.out.println("1. Add media");
        System.out.println("2. Remove media");
        System.out.println("0. Back");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                System.out.println("Enter title: ");
                String title = scanner.nextLine();
                System.out.println("Enter category: ");
                String category = scanner.nextLine();
                System.out.println("Enter cost: ");
                float cost = scanner.nextFloat();
                System.out.println("Enter id: ");
                int id = scanner.nextInt();
                scanner.nextLine(); // consume newline
                Media newMedia = new Media(id, title, category, cost);
                store.addMedia(newMedia);
                break;
            case 2:
                System.out.println("Enter title of media to remove: ");
                String removeTitle = scanner.nextLine();
                Media mediaToRemove = store.findMediaByTitle(removeTitle);
                if (mediaToRemove != null) {
                    store.removeMedia(mediaToRemove);
                } else {
                    System.out.println("Media not found in store.");
                }
                break;
            case 0:
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    public static void seeCart() {
        int option;
        do {
            cart.printCart();
            cartMenu();
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    filterCart();
                    break;
                case 2:
                    sortCart();
                    break;
                case 3:
                    removeFromCart();
                    break;
                case 4:
                    playMedia();
                    break;
                case 5:
                    placeOrder();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (option != 0);
    }

    public static void seeMediaDetails() {
        System.out.println("\nEnter title of media: ");
        String title = scanner.nextLine();
        Media media = store.findMediaByTitle(title);
        if (media != null) {
            System.out.println(media);
            mediaDetailsMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    cart.addMedia(media);
                    break;
                case 2:
                    if (media instanceof CompactDisc) {
                        ((CompactDisc) media).play();
                    } else if (media instanceof DigitalVideoDisc) {
                        ((DigitalVideoDisc) media).play();
                    } else {
                        System.out.println("This media cannot be played.");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void addMediaToCart() {
        System.out.println("Enter title of media to add: ");
        String title = scanner.nextLine();
        Media media = store.findMediaByTitle(title);
        if (media != null) {
            cart.addMedia(media);
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void playMedia() {
        System.out.println("Enter title of media to play: ");
        String title = scanner.nextLine();
        Media media = store.findMediaByTitle(title);
        if (media != null) {
            if (media instanceof CompactDisc) {
                ((CompactDisc) media).play();
            } else if (media instanceof DigitalVideoDisc) {
                ((DigitalVideoDisc) media).play();
            } else {
                System.out.println("This media cannot be played.");
            }
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void filterCart() {
        System.out.println("Filter by: 1. ID  2. Title");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice == 1) {
            System.out.println("Enter ID: ");
            int id = scanner.nextInt();
            cart.filterById(id);
        } else if (choice == 2) {
            System.out.println("Enter Title: ");
            String title = scanner.nextLine();
            cart.filterByTitle(title);
        } else {
            System.out.println("Invalid choice.");
        }
    }

    public static void sortCart() {
        System.out.println("Sort by: 1. Title  2. Cost");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice == 1) {
        	cart.sortByTitleCost();
            System.out.println("Cart sorted by title then cost.");
        } else if (choice == 2) {
            cart.sortByCostTitle();
        } else {
            System.out.println("Invalid choice.");
        }
    }

    public static void removeFromCart() {
        System.out.println("Enter title of media to remove: ");
        String title = scanner.nextLine();
        Media media = cart.findMediaByTitle(title);
        if (media != null) {
            cart.removeMedia(media);
        } else {
            System.out.println("Media not found in cart.");
        }
    }

    public static void placeOrder() {
        System.out.println("An order has been created. Thank you!");
        cart.clearCart();
    }
}
