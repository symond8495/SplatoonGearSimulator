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

    protected void setWeaponTag(String tagName) {
        this.weaponTag = tagName;
    }

    public String getWeaponTag() {
        return this.weaponTag;
    }

    public String getMainWeaponName() {
        return this.MainWeaponName;
    }

    public String getSubWeaponName() {
        return this.SubWeaponName;
    }
}
