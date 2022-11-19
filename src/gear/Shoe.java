package gear;

public class Shoe extends Gear {
    public Shoe(String name) {
        super(name);
        this.readGearInfo();
    }

    @Override
    protected void setGearType() {
        this.gearType = "shoe";
    }
}
