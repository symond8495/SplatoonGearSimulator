package gear;

import gearSlot.*;

import java.io.IOException;
import java.io.File;
import java.util.Map;
import java.util.HashMap;

// Jsonを読む為の外部ライブラリ
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

// TODO: ギアパワーの数を集計する。
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

        // Json読み込み
        this.readGearInfo();

        // ギア生成
        this.mainGearSlot = new MainGearSlot("MainGear", this.gearNode);
        this.subGearSlot1 = new SubGearSlot("SubGear1", this.gearNode);
        this.subGearSlot2 = new SubGearSlot("SubGear2", this.gearNode);
        this.subGearSlot3 = new SubGearSlot("SubGear3", this.gearNode);

        // ギアパワーセット
        this.mainGearSlot.setGear(this.gearNode, this.mainGearSlot.getSlotPosition());
        this.subGearSlot1.setGear(this.gearNode, this.subGearSlot1.getSlotPosition());
        this.subGearSlot2.setGear(this.gearNode, this.subGearSlot2.getSlotPosition());
        this.subGearSlot3.setGear(this.gearNode, this.subGearSlot3.getSlotPosition());
    }

    abstract protected void setGearType();

    // NOTE: Weaponクラスから参照
    // 似たような形なのでいつかまとめたい
    protected void readGearInfo() {
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

    public static void sumGearPower(Gear head, Gear clothiong, Gear choe) {

        Gear[] gearPower = { head, clothiong, choe };
        String[] mainGear = new String[3];
        String[] subGear = new String[9];
        Map<String, Float> sumGearPower = new HashMap<String, Float>();

        // メインギアとサブギアをリストにしてまとめる。
        for (int i = 0; i <= 2; i++) {
            mainGear[i] = gearPower[i].getMainGearPower();
            subGear[0 + i * 3] = gearPower[i].getSubGearPower1();
            subGear[1 + i * 3] = gearPower[i].getSubGearPower2();
            subGear[2 + i * 3] = gearPower[i].getSubGearPower3();
        }

        sumGearPower = Gear.valueCount(sumGearPower, mainGear, 1f);
        sumGearPower = Gear.valueCount(sumGearPower, subGear, 0.1f);

        sumGearPower.forEach((k, v) -> {
            System.out.printf("%s : %s\n", k, ((float) Math.round(v * 10)) / 10);
        });
    }

    // 値カウント
    public static Map<String, Float> valueCount(Map<String, Float> count, String[] dict, float coefficient) {
        for (String value : dict) {
            if (!count.containsKey(value)) {
                count.put(value, coefficient);
            } else {
                count.replace(value, count.get(value) + coefficient);
            }
        }

        return count;
    }

    /*
     *
     * get
     *
     */
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

    public String getMainGearPower() {
        return this.mainGearSlot.getGearPower();
    }

    public String getSubGearPower1() {
        return this.subGearSlot1.getGearPower();
    }

    public String getSubGearPower2() {
        return this.subGearSlot2.getGearPower();
    }

    public String getSubGearPower3() {
        return this.subGearSlot3.getGearPower();
    }
}
