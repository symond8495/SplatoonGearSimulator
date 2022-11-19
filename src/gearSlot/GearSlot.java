package gearSlot;

import com.fasterxml.jackson.databind.JsonNode;

// TODO: メイン、サブごとに効果のステータスを加える
public abstract class GearSlot {
    protected String gearName;
    protected String slotPosition;
    protected JsonNode gearNode;
    private String gearPower;

    public GearSlot(String slotPosition, JsonNode gearNode) {
        this.slotPosition = slotPosition;
        this.gearNode = gearNode;
    }

    public void setGear(JsonNode gearNode, String slotPosition) {
        this.gearPower = gearNode.get(slotPosition).asText();
    }

    public String getGearPower() {
        return this.gearPower;
    }

    public String getSlotPosition() {
        return this.slotPosition;
    }
}
