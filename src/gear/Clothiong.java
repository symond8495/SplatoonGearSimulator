package gear;

public class Clothiong extends Gear {
    public Clothiong(String name) {
        super(name);
    }

    @Override
    protected void setGearType() {
        this.gearType = "clothiong";
    }
}
