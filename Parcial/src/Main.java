interface operable {
    void iniciarOperacion();
    void terminarOperacion();
}
abstract class unidadEntrega implements operable {
    protected String id;
    protected String nombreOperador;
    protected String capacidadCarga;
    protected String zonaOperacion;
    public unidadEntrega(String id, String nombreOperador, String capacidadCarga) {
        this.id=id; this.nombreOperador=nombreOperador; this.capacidadCarga=capacidadCarga;
    }
    public void mostrarInformacion() {
        System.out.println("ID: "+id);
        System.out.println("Operador: "+nombreOperador);
        System.out.println("Capacidad de Carga: "+capacidadCarga);
        System.out.println("Zona de Operacion: "+zonaOperacion);
    }
    public String getId() { return id; }
    public String getNombreOperador() { return nombreOperador; }
    public String getCapacidadCarga() { return capacidadCarga; }
    public String getZonaOperacion() { return zonaOperacion; }
}

class Dron extends unidadEntrega {
    protected String alturaMaxima;
    protected int nivelBateria;
    public Dron(String id, String nombreOperador, String capacidadCarga, String alturaMaxima, int nivelBateria) {
        super(id, nombreOperador, capacidadCarga);
        this.zonaOperacion="Aerea";
        this.alturaMaxima=alturaMaxima;
        this.nivelBateria=nivelBateria;
    }
    public void iniciarOperacion() { System.out.println("Dron despegando"); }
    public void terminarOperacion() { System.out.println("Dron aterrizando"); }
    public String getAlturaMaxima() { return alturaMaxima; }
    public int getNivelBateria() { return nivelBateria; }
    public void mostrarDetalles() {
        System.out.println("Altura Maxima: " + alturaMaxima);
        System.out.println("Nivel de Bateria: " + nivelBateria + "%");
    }
}
class Motocicleta extends unidadEntrega {
    protected int cilindraje;
    protected int velocidadMaxima;
    public Motocicleta(String id, String nombreOperador, String capacidadCarga, int cilindraje, int velocidadMaxima) {
        super(id, nombreOperador, capacidadCarga);
        this.zonaOperacion="Terrestre";
        this.cilindraje=cilindraje;
        this.velocidadMaxima=velocidadMaxima;
    }
    public void iniciarOperacion() { System.out.println("Motocicleta arrancando"); }
    public void terminarOperacion() { System.out.println("Motocicleta deteniendose"); }
    public int getCilindraje() { return cilindraje; }
    public int getVelocidadMaxima() { return velocidadMaxima; }
    public void mostrarDetalles() {
        System.out.println("Cilindraje: " + cilindraje + " cc");
        System.out.println("Velocidad Maxima: " + velocidadMaxima + " km/h");
    }
}
class Bicicleta extends unidadEntrega {
    protected boolean tieneCanasta;
    protected String tipoPedaleo;
    public Bicicleta(String id, String nombreOperador, String capacidadCarga, boolean tieneCanasta, String tipoPedaleo) {
        super(id, nombreOperador, capacidadCarga);
        this.zonaOperacion="Terrestre";
        this.tieneCanasta=tieneCanasta;
        this.tipoPedaleo=tipoPedaleo;
    }
    public void iniciarOperacion() { System.out.println("Bicicleta arrancando"); }
    public void terminarOperacion() { System.out.println("Bicicleta deteniendose"); }
    public boolean isTieneCanasta() { return tieneCanasta; }
    public String getTipoPedaleo() { return tipoPedaleo; }
    public void mostrarDetalles() {
        System.out.println("Tiene Canasta: " + (tieneCanasta ? "Si" : "No"));
        System.out.println("Tipo de Pedaleo: " + tipoPedaleo);
    }
}

class Main {
    public static void main(String[] args) {
        Dron dron1 = new Dron("DRN001", "Drone DJI", "50 kg", "100 metros", 100);
        Motocicleta moto1 = new Motocicleta("MTO001", "KTM", "20 kg", 600, 180);
        Bicicleta bici1 = new Bicicleta("BIC001", "Bicicleta", "10 kg", true, "Normal");

        System.out.println("=== DRON ===");
        dron1.mostrarInformacion();
        dron1.mostrarDetalles();
        dron1.iniciarOperacion();
        dron1.terminarOperacion();

        System.out.println("\n=== MOTOCICLETA ===");
        moto1.mostrarInformacion();
        moto1.mostrarDetalles();
        moto1.iniciarOperacion();
        moto1.terminarOperacion();

        System.out.println("\n=== BICICLETA ===");
        bici1.mostrarInformacion();
        bici1.mostrarDetalles();
        bici1.iniciarOperacion();
        bici1.terminarOperacion();
    }
}