public class Main {

    public static void main(String[] args) {
        Squid symond = Squid.getSquidInstance("\nしもんど\n");

        symond.setGear(
                "イカパッチン",
                "スミチラシベスト",
                "01STER コハク");
        symond.setWeapon("パブロ", "フデ");
        symond.display();
    }
}