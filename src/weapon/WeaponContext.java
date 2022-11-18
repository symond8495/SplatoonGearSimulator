package weapon;

// 条件によって生成するインスタンスを変更する
// デザインパターン:State
public class WeaponContext {
    private Weapon weaponState = null;

    public WeaponContext(String MainWeaponName) {
        weaponState = UnknownWeapon.getWeaponInstance(MainWeaponName);
    }

    public void stateChangeWeapon(String MainWeaponName, String MainWeaponType) {
        switch (MainWeaponType) {
            case "フデ":
                setWeaponState(new Brush(MainWeaponName));
                break;
            case "シューター":
                setWeaponState(new Shooter(MainWeaponName));
                break;
            default: // 0が返る場合。状態変更無し。
                break;
        }
    }

    public void setWeaponState(Weapon weapon) {
        this.weaponState = weapon;
    }

    public Weapon getWeaponInstance() {
        return weaponState;
    }
}
