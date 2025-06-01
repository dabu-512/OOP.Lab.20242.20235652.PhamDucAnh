package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public class Media {
    private static int idCounter = 1;

    private int id;
    private String title;
    private String category;
    private float cost;

    public Media(String title, String category, float cost) {
        this.id = idCounter++;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public float getCost() {
        return cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Media)) return false;
        Media media = (Media) o;
        return this.title.equals(media.title);
    }

    @Override
    public String toString() {
        return "ID :" + this.getId() +
               ", Title : " + this.getTitle() +
               ", category : " + this.getCategory() +
               ", cost : " + this.getCost();
    }

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

    public static void resetIdCounter() {
        idCounter = 1;
    }
}
