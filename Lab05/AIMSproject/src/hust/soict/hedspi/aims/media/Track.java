package hust.soict.hedspi.aims.media;

public class Track implements Playable{
	private String title;
	private int length;
	
	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}
	public String getTitle() {
		return title;
	}
	public int getLength() {
	    return length;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || !(obj instanceof Track)) return false;
		Track otherTrack = (Track) obj;
		boolean sameTitle = this.title.equals(otherTrack.title);
		boolean sameLength = this.length == otherTrack.length;
		return sameTitle && sameLength;
	}
	
	@Override
	public void play() {
		System.out.println("Playing Track: " + this.getTitle());
		System.out.println("Track length: " + this.getLength());
	}
}
