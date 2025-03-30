public class Aims {
    public static void main(String[] args) {

    	Cart anOrder = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", "John Musker", 90, 18.99f);

        anOrder.addDigitalVideoDisc(dvd1);
        anOrder.addDoubleDigitalVideoDisc(dvd2, dvd3);
        
        /*DigitalVideoDisc[] dvdList = {new DigitalVideoDisc("Avatar", "Sci-Fi", "James Cameron", 162, 29.99f),
                                      new DigitalVideoDisc("Titanic", "Romance", "James Cameron", 195, 19.99f)};
                                      
        anOrder.addDigitalVideoDisc1(dvdList);
        
        anOrder.addDigitalVideoDisc2(new DigitalVideoDisc("Inception", "Sci-Fi", "Christopher Nolan", 148, 22.99f));
        */
        anOrder.displayCart();
   
        anOrder.removeDigitalVideoDisc(dvd3);

        anOrder.displayCart();
    }
}

