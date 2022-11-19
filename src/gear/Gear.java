package gear;

import java.io.IOException;
import java.io.File;
import java.util.Map;
import java.util.HashMap;

// Jsonを読む為の外部ライブラリ
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import gearSlot.*;

public abstract class Gear {
    protected JsonNode gearNode;

    private String gearName;
    protected String gearType;

    private Map<String, String> gearTypeName;

    GearSlot mainGearSlot;
    GearSlot subGearSlot1;
    GearSlot subGearSlot2;
    GearSlot subGearSlot3;

    public Gear(String gearName) {
        this.gearName = gearName;
        this.setGearType();

        this.readGearInfo();

        this.mainGearSlot = new MainGearSlot("MainGear", this.gearNode);
        this.subGearSlot1 = new SubGearSlot("SubGear1", this.gearNode);
        this.subGearSlot2 = new SubGearSlot("SubGear2", this.gearNode);
        this.subGearSlot3 = new SubGearSlot("SubGear3", this.gearNode);

        this.mainGearSlot.setGear(this.gearNode, this.mainGearSlot.getSlotPosition());
        this.subGearSlot1.setGear(this.gearNode, this.subGearSlot1.getSlotPosition());
        this.subGearSlot2.setGear(this.gearNode, this.subGearSlot2.getSlotPosition());
        this.subGearSlot3.setGear(this.gearNode, this.subGearSlot3.getSlotPosition());
    }

    abstract protected void setGearType();

    protected JsonNode getGearNode() {
        return this.gearNode;
    };

    // NOTE: Weaponクラスから参照
    // 似たような形なのでいつかまとめたい
    protected void readGearInfo() {
        // 初期化しないとreturn出来ない
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode node = mapper.readTree(new File(
                    String.format("src\\json\\gear\\%s.json", this.gearType)));
            this.gearNode = node.get(this.getGearName());

        } catch (NullPointerException e) {
            System.out.printf("\"%s\"が見つかりませんでした。\n", this.getGearName());
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void display() {
        System.out.printf("名前 : %s\nメインギア : %s\nサブギア1 : %s\nサブギア2 : %s\nサブギア3 : %s\n",
                this.gearName,
                this.getMainGearSlot(),
                this.getSubGearSlot1(),
                this.getSubGearSlot2(),
                this.getSubGearSlot3());
    }

    public String getGearName() {
        return this.gearName;
    }

    public String getGearType() {
        this.gearTypeName = new HashMap<String, String>() {
            {
                put("head", "アタマ");
                put("clothiong", "フク");
                put("shoe", "クツ");
            }
        };

        return this.gearTypeName.get(this.gearType);
    }

    public String getMainGearSlot() {
        return this.mainGearSlot.getGearPower();
    }

    public String getSubGearSlot1() {
        return this.subGearSlot1.getGearPower();
    }

    public String getSubGearSlot2() {
        return this.subGearSlot2.getGearPower();
    }

    public String getSubGearSlot3() {
        return this.subGearSlot3.getGearPower();
    }
}
