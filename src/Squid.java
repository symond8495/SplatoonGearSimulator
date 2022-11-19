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
        this.hp = 100;
        this.squidSpeed = 10;
        this.runSpeed = 6;
        this.inkVolume = 100;

        squid = null;
    }

    // Squidを取得する唯一の方法
    public static Squid getSquidInstance(String name) {
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

    public void setWeapon(String MainWeaponName, String MainWeaponType) {
        WeaponContext context = new WeaponContext(MainWeaponName);
        context.stateChangeWeapon(MainWeaponName, MainWeaponType);
        this.weapon = context.getWeaponInstance();
    }

    public void setGear(String headName, String clothiongName, String shoeName) {
        head = new Head(headName);
        clothiong = new Clothiong(clothiongName);
        shoe = new Shoe(shoeName);

        head.display();
        clothiong.display();
        shoe.display();
    }

    public void display() {
        System.out.printf("【名前】%s\n", this.name);
        System.out.println("【ギア】");

        this.gearDisplay(this.head);
        this.gearDisplay(this.clothiong);
        this.gearDisplay(this.shoe);
        System.out.printf(
                "【ブキ】\nブキ : %s\nボム : %s\n射程 : %s\nブキ重量 : %s\n",
                this.weapon.getMainWeaponName(),
                this.weapon.getSubWeaponName(),
                this.weapon.getRange(),
                this.weapon.getHeavyWeight());
    }

    private void gearDisplay(Gear gear) {
        System.out.printf("%s : %s\nメインギア : %s\nサブギア : [%s, %s, %s]\n\n",
                gear.getGearType(),
                gear.getGearName(),
                gear.getMainGearSlot(),
                gear.getSubGearSlot1(),
                gear.getSubGearSlot2(),
                gear.getSubGearSlot3());
    }
}
