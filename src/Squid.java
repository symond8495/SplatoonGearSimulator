import gear.*;
import weapon.*;

// 一つしかインスタンスを作れない
// 二つ以上生成しようとすると例外処理が発生して強制終了する。
// デザインパターン:Singleton
public class Squid {
    private static Squid squid;

    String name;
    int hp;
    int squidSpeed;
    int runSpeed;
    int inkVolume;

    Gear head;
    Gear clothiong;
    Gear shoe;

    Weapon weapon;

    private Squid(String name) {
        this.name = name;
        hp = 100;
        squidSpeed = 10;
        runSpeed = 6;
        inkVolume = 100;

        squid = null;
    }

    // Squidを取得する唯一の方法
    public static Squid getSquid(String name) {
        try {
            if (squid == null) {
                squid = new Squid(name);
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("\"Squid\"クラスのインスタンスは一つしか生成出来ません。");
            System.exit(0);
        }
        return squid;
    }

    public void setWeapon(String MainWeaponName) {
        weapon = new Brush(MainWeaponName);
        // weapon = new Shooter(MainWeaponName);
    }

    public void setGear(String headName, String clothiongName, String shoeName) {
        head = new Head(headName);
        clothiong = new Clothiong(clothiongName);
        shoe = new Shoe(shoeName);
    }

    public void display() {
        System.out.printf("【名前】%s\n", this.name);
        System.out.printf(
                "【ギア】\nアタマ : %s\nフク : %s\nクツ : %s\n",
                head.getName(),
                clothiong.getName(),
                shoe.getName());
        System.out.printf(
                "【ブキ】\nブキ : %s\nボム : %s\n射程 : %s\nブキ重量 : %s",
                weapon.getMainWeaponName(),
                weapon.getSubWeaponName(),
                weapon.getRange(),
                weapon.getHeavyWeight());
    }
}
