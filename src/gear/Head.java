package gear;

public class Head extends Gear {
    public Head(String name) {
        super(name);
        this.readGearInfo();
    }

    @Override
    protected void setGearType() {
        this.gearType = "head";
    }
}
