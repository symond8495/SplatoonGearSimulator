package gear;

public class Shoe extends Gear {
    public Shoe(String name) {
        super(name);
    }

    @Override
    protected void setGearType() {
        this.gearType = "shoe";
    }
}
