public class App {
    public static void main(String[] args) throws Exception {
        String shape = "cube";
        int sphereMax = 25;

        Vector vector = new Vector(shape, sphereMax);
        Edge edge = new Edge(shape, sphereMax);
        Panel panel = new Panel(500, vector, edge);
        new Frame(panel);
    }
}
