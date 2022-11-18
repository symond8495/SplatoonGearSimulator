package weapon;

import com.fasterxml.jackson.databind.JsonNode;

// TODO: ブキによってイカ速が変わる
// ブキを生成できるのは一つだけ
public abstract class Weapon {
    protected JsonNode weaponNode;

    protected String mainWeaponName;
    protected String weaponTag;
    protected int range;
    protected int paintRange;
    protected String subWeaponName;
    protected String special;
    protected int specialPoint;
    protected float killTime;
    protected float dps;
    protected String heavyWeight;

    public Weapon(String MainWeaponName) {
        this.mainWeaponName = MainWeaponName;
        this.readWeaponInfo();
        this.setWeaponInfo();
    }

    abstract protected void setWeaponInfo();

    abstract protected void readWeaponInfo();

    /*
     *
     * get
     *
     */
    protected String getNodeValue(String Key) {
        return this.weaponNode.get(Key).asText();
    }

    public String getMainWeaponName() {
        return this.mainWeaponName;
    }

    public String getWeaponTag() {
        return this.weaponTag;
    }

    public int getRange() {
        return this.range;
    }

    public int getPaintRange() {
        return this.paintRange;
    }

    public String getSubWeaponName() {
        return this.subWeaponName;
    }

    public String getSpecial() {
        return this.special;
    }

    public int getSpecialPoint() {
        return this.specialPoint;
    }

    public float getKillTime() {
        return this.killTime;
    }

    public float getDPS() {
        return this.dps;
    }

    public String getHeavyWeight() {
        return this.heavyWeight;
    }
}
