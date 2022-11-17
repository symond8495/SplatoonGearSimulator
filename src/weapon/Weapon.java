package weapon;

// TODO: ブキによってイカ速が変わる
public abstract class Weapon {
    private String MainWeaponName;
    private String SubWeaponName;
    private String weaponTag;

    public Weapon(String MainWeaponName, String SubWeaponName) {
        this.MainWeaponName = MainWeaponName;
        this.SubWeaponName = SubWeaponName;
    }

    public String getMainWeaponName() {
        return this.MainWeaponName;
    }

    public String getSubWeaponName() {
        return this.SubWeaponName;
    }
}
