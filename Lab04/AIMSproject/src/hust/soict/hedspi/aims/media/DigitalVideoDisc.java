package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
	public DigitalVideoDisc(int id, String title, String category, float cost, 
				String director, int length) {
		super(id, title, category, cost, director, length);
	}
	public DigitalVideoDisc(String title) {
        super(0, title, "", 0.0f, "", 0);
    }

	@Override
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length:" + this.getLength());
	}
	
	@Override
	public String toString() {
		return "DVD: " + this.getTitle() +
				", category : " + this.getCategory() +
				", director : " + this.getDirector() +
				", length : " + this.getLength() +
				", cost : " + this.getCost();
	}
}
