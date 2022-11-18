package weapon;

import java.io.File;
import java.io.IOException;
// import java.util.List;
// import java.util.HashMap;

// Jsonを読む為の外部ライブラリ
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Shooter extends Weapon {
    public Shooter(String MainWeaponName) {
        super(MainWeaponName);
    }

    @Override
    protected void setWeaponInfo() {
        readWeaponInfo();

        this.weaponTag = "シューター";
        this.range = Integer.valueOf(getNodeValue("Range"));
        this.paintRange = Integer.valueOf(getNodeValue("PaintRange"));
        this.subWeaponName = getNodeValue("SubWeaponName");
        this.special = getNodeValue("Special");
        this.specialPoint = Integer.valueOf(getNodeValue("SpecialPoint"));
        this.killTime = Float.valueOf(getNodeValue("KillTime"));
        this.dps = Float.valueOf(getNodeValue("DPS"));
        this.heavyWeight = getNodeValue("HeavyWeight");
    }

    // Jsonファイルを読み込む
    @Override
    protected void readWeaponInfo() {
        // 初期化しないとreturn出来ない
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode node = mapper.readTree(new File("src\\json\\weapon\\shooter.json"));
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
