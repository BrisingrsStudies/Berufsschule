public class Main {
    public static void main(String[] args) {

        // Objekt erstellen: Kennzeichen "AC-XY-123", Tank 50L,
        // aktuell 20L drin, Maxgeschwindigkeit 200 km/h
        Kfz auto = new Kfz("AC-XY-123", 50, 20.0, 200.0);


        // --- Test 1: toString() ---
        // Erwartung: Motor aus, Geschwindigkeit 0.0, Tank 20.0/50L
        System.out.println("=== Start ===");
        System.out.println(auto.toString());


        // --- Test 2: Beschleunigen ohne Motor ---
        // Erwartung: Fehlermeldung, Geschwindigkeit bleibt 0
        System.out.println("\n=== Beschleunigen ohne Motor ===");
        auto.beschleunigen(50);
        System.out.println("Geschwindigkeit: " + auto.getAktGeschw());


        // --- Test 3: Motor starten und beschleunigen ---
        // Erwartung: Motor an, Geschwindigkeit 80
        System.out.println("\n=== Motor starten + beschleunigen ===");
        auto.motorStarten();
        auto.beschleunigen(80);
        System.out.println(auto.toString());


        // --- Test 4: Über Maximalgeschwindigkeit beschleunigen ---
        // Erwartung: Fehlermeldung, Geschwindigkeit wird auf 200 begrenzt
        System.out.println("\n=== Über Maximum beschleunigen ===");
        auto.beschleunigen(150); // 80 + 150 = 230 -> über dem Maximum von 200
        System.out.println("Geschwindigkeit: " + auto.getAktGeschw());


        // --- Test 5: Bremsen bis Stillstand ---
        // Erwartung: Geschwindigkeit wird 0 (nicht negativ!)
        System.out.println("\n=== Bremsen bis Stillstand ===");
        auto.bremsen(999);
        System.out.println("Geschwindigkeit: " + auto.getAktGeschw());


        // --- Test 6: Fahren ---
        // Erwartung: Tankinhalt sinkt (100km * 0.1 = 10 Liter -> 10L übrig)
        System.out.println("\n=== Fahren 100km ===");
        auto.motorStarten();
        auto.fahren(100);
        System.out.println("Tankinhalt nach 100km: " + auto.getTankinhalt());


        // --- Test 7: Tanken mit laufendem Motor ---
        // Erwartung: Fehlermeldung
        System.out.println("\n=== Tanken mit Motor an ===");
        auto.tanken(20);

        //HALLLOOOOOOOOOO
        // --- Test 8: Normal tanken ---
        // Erwartung: Tankinhalt steigt von 10 auf 50 (voll)
        System.out.println("\n=== Normal tanken ===");
        auto.motorStoppen();
        auto.tanken(40);
        System.out.println("Tankinhalt nach Tanken: " + auto.getTankinhalt());


        // --- Test 9: Tank überfüllen ---
        // Erwartung: Tankinhalt bleibt bei 50 (nicht mehr!)
        System.out.println("\n=== Tank überfüllen ===");
        auto.tanken(999);
        System.out.println("Tankinhalt: " + auto.getTankinhalt());
    }
}