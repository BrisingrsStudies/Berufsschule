public class Kfz {

    // -------------------------------------------------------
    // Instanzvariablen (alle private -> Kapselung!)
    // -------------------------------------------------------
    private String kennzeichen;
    private int tankgroesse;
    private double tankinhalt;
    private double aktGeschw;
    private double maxGeschw;
    private boolean motorLaeuft;


    // -------------------------------------------------------
    // Konstruktor
    // -------------------------------------------------------
    public Kfz(String kennzeichen, int tankgroesse, double tankinhalt, double maxGeschw) {
        this.kennzeichen = kennzeichen;
        this.tankgroesse = tankgroesse;
        this.tankinhalt  = tankinhalt;
        this.maxGeschw   = maxGeschw;
        this.aktGeschw   = 0;      // Fahrzeug startet immer stehend
        this.motorLaeuft = false;  // Motor ist beim Erstellen immer aus
    }


    // -------------------------------------------------------
    // Methoden
    // -------------------------------------------------------

    public void motorStarten() {
        this.motorLaeuft = true;
    }

    public void motorStoppen() {
        this.motorLaeuft = false;
    }

    public void bremsen(double kmh) {
        if (this.aktGeschw - kmh < 0) {
            this.aktGeschw = 0;  // Geschwindigkeit kann nicht negativ werden
        } else {
            this.aktGeschw -= kmh;
        }
    }

    public void beschleunigen(double kmh) {
        if (!this.motorLaeuft) {
            System.out.println("Motor ist aus – kann nicht beschleunigen!");
            return;
        }
        if (this.aktGeschw + kmh > this.maxGeschw) {
            System.out.println("Maximalgeschwindigkeit erreicht!");
            this.aktGeschw = this.maxGeschw;  // Auf Maximum begrenzen statt abbrechen
        } else {
            this.aktGeschw += kmh;
        }
    }

    public void fahren(double km) {
        if (!this.motorLaeuft) {
            System.out.println("Motor ist aus!");
            return;
        }
        if (this.tankinhalt <= 0) {
            System.out.println("Tank ist leer!");
            return;
        }

        // Kraftstoffverbrauch berechnen (vereinfacht: 0.1 Liter pro km)
        double verbrauch = km * 0.1;

        if (verbrauch > this.tankinhalt) {
            // Sprit reicht nicht für die ganze Strecke -> fahren bis Tank leer
            this.tankinhalt = 0;
        } else {
            this.tankinhalt -= verbrauch;
        }
    }

    public void tanken(double liter) {
        if (this.motorLaeuft) {
            System.out.println("Motor muss aus sein zum Tanken!");
            return;
        }
        if (this.tankinhalt + liter > this.tankgroesse) {
            this.tankinhalt = this.tankgroesse;  // Tank wird voll, kein Überlauf
        } else {
            this.tankinhalt += liter;
        }
    }

    public String toString() {
        return "Kennzeichen: "    + this.kennzeichen
                + " | Motor: "       + (this.motorLaeuft ? "an" : "aus")
                + " | Geschwindigkeit: " + this.aktGeschw + " km/h"
                + " | Tank: "        + this.tankinhalt + "/" + this.tankgroesse + "L";
    }


    // -------------------------------------------------------
    // Getter
    // -------------------------------------------------------

    public String getKennzeichen() {
        return this.kennzeichen;
    }

    public int getTankgroesse() {
        return this.tankgroesse;
    }

    public double getTankinhalt() {
        return this.tankinhalt;
    }

    public double getAktGeschw() {
        return this.aktGeschw;
    }

    public double getMaxGeschw() {
        return this.maxGeschw;
    }

    public boolean isMotorLaeuft() {
        return this.motorLaeuft;
    }


    // -------------------------------------------------------
    // Setter (nur fuer Werte, die von aussen geaendert werden duerfen)
    // -------------------------------------------------------

    public void setKennzeichen(String kennzeichen) {
        this.kennzeichen = kennzeichen;
    }

    public void setTankinhalt(double tankinhalt) {
        if (tankinhalt < 0) {
            this.tankinhalt = 0;
        } else if (tankinhalt > this.tankgroesse) {
            this.tankinhalt = this.tankgroesse;
        } else {
            this.tankinhalt = tankinhalt;
        }
    }
// Da ist nur Test
    public void setMaxGeschw(double maxGeschw) {
        if (maxGeschw < 0) {
            System.out.println("Maximalgeschwindigkeit kann nicht negativ sein!");
            return;
        }
        this.maxGeschw = maxGeschw;
    }
}
