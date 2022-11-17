package gear;

import gearSlot.MainGearSlot;
import gearSlot.SubGearSlot;

public abstract class Gear {
    private String name;
    MainGearSlot mainGearSlot;
    SubGearSlot subGearSlot1;
    SubGearSlot subGearSlot2;
    SubGearSlot subGearSlot3;

    public Gear(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
