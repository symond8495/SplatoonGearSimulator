public class Main {
    public static void main(String[] args) {
        Squid symond = new Squid("\nしもんど\n");
        symond.setGear(
                "アナアキスクエアグラス",
                "スミチラシベスト",
                "01STER コハク");
        symond.setWeapon(
                "パブロ",
                "スプラッシュボム");
        symond.display();
    }
}