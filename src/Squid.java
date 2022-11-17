import gear.*;
import weapon.*;

public class Squid {
    // ブキ、アタマ、フク、クツ
    String name;
    int hp;
    int squidSpeed;
    int runSpeed;
    int inkVolume;

    Gear head;
    Gear clothiong;
    Gear shoe;

    Weapon weapon;

    public Squid(String name) {
        this.name = name;
        hp = 100;
        squidSpeed = 10;
        runSpeed = 6;
        inkVolume = 100;
    }

    public void setWeapon(String MainWeaponName, String SubWeaponName) {
        weapon = new Brush(MainWeaponName, SubWeaponName);
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
                "【ブキ】\nブキ : %s\nボム : %s\n",
                weapon.getMainWeaponName(),
                weapon.getSubWeaponName());
    }
}
