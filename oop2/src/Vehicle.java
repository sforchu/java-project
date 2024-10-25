public class Vehicle {
    public String name;
    public String lnumber;
    public CoOwner coOwner;
    public Owner owner;


    //static nested inner class (Mostly used)
    public static class CoOwner {
        public String name;
    }

}

// non-static inner class (Rarely used)

class Owner {

    private String name;
}


