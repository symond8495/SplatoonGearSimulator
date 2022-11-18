package weapon;

import java.io.IOException;
import java.io.File;

// Jsonを読む為の外部ライブラリ
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Brush extends Weapon {
    public Brush(String MainWeaponName) {
        super(MainWeaponName);
    }

    @Override
    protected void setWeaponInfo() {
        readWeaponInfo();

        try {
            this.weaponTag = "フデ";
            this.range = Integer.valueOf(getNodeValue("Range"));
            this.paintRange = Integer.valueOf(getNodeValue("PaintRange"));
            this.subWeaponName = getNodeValue("SubWeaponName");
            this.special = getNodeValue("Special");
            this.specialPoint = Integer.valueOf(getNodeValue("SpecialPoint"));
            this.killTime = Float.valueOf(getNodeValue("KillTime"));
            this.dps = Float.valueOf(getNodeValue("DPS"));
            this.heavyWeight = getNodeValue("HeavyWeight");
        } catch (NullPointerException e) {
            System.out.printf("\"%s\"は存在しません。\n", this.mainWeaponName);
            System.exit(0);
        }
    }

    // Jsonファイルを読み込む
    @Override
    protected void readWeaponInfo() {
        // 初期化しないとreturn出来ない
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode node = mapper.readTree(new File("src\\json\\weapon\\brush.json"));
            this.weaponNode = node.get(getMainWeaponName());

            // 値が適切でない
            // String weapon = node.get(this.getMainWeaponName()).asText();
            // String weapon = node.get("hoge").asText();

        } catch (NullPointerException e) {
            System.out.printf("\"%s\"が見つかりませんでした。\n", this.getMainWeaponName());
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
