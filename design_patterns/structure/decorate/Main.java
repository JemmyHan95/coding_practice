package decorate;

public class Main {
    public static void main(String[] args) {
        T95 t95 = new T95();
        LayserCannon layserCannon = new LayserCannon(t95);
        HighLandWheel highLandWheel = new HighLandWheel(layserCannon);

        System.out.println(highLandWheel.climb());
        System.out.println(highLandWheel.shoot());
    }
}