package gear;

public class Head extends Gear {
    public Head(String name) {
        super(name);
    }

    @Override
    protected void setGearType() {
        this.gearType = "head";
    }
}
