public class Main {

    public static void main(String[] args) {
        Squid symond = Squid.getSquidInstance("\nしもんど\n");

        // 複数のインスタンスを生成しようとするとエラー吐いて強制終了する。
        // Squid hoge = Squid.getSquid("hogehoge");

        symond.setGear(
                "アナアキスクエアグラス",
                "スミチラシベスト",
                "01STER コハク");
        symond.setWeapon("シャープマーカー", "シュータ");
        symond.display();
    }
}