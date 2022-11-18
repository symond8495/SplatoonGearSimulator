package weapon;

public class UnknownWeapon extends Weapon {
    private static Weapon unknownWeapon;

    private UnknownWeapon(String MainWeaponName) {
        super(MainWeaponName);
        unknownWeapon = null;
    }

    // Weaponを取得する唯一の方法
    public static Weapon getWeaponInstance(String MainWeaponName) {
        try {
            if (unknownWeapon == null) {
                unknownWeapon = new UnknownWeapon(MainWeaponName);
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("\"Weapon\"クラスのインスタンスは一つしか生成出来ません。");
            System.exit(0);
        }
        return unknownWeapon;
    }

    @Override
    protected void setWeaponInfo() {
    }

    @Override
    protected void readWeaponInfo() {
    }
}