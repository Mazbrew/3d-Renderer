public class Vector {
    private double vectorMatrix[][];

    private static final int x = 0;
    private static final int y = 1;
    private static final int z = 2;

    private double radius = 100;

    public Vector(String shape, int sphereMax){
        switch(shape){
            case "cube":
                double cubeVectorMatrix[][] = {{50,-50,50},{50,50,50},{-50,50,50},{-50,-50,50},{50,-50,-50},{50,50,-50},{-50,50,-50},{-50,-50,-50}};
                this.vectorMatrix = cubeVectorMatrix;
                break;

            case "sphere":
                double sphereVectorMatrix[][] = new double[sphereMax*sphereMax][3];
                for(int i = 0; i < sphereMax ; i++){
                    for(int j = 0; j < sphereMax ; j++){
                        sphereVectorMatrix[i * sphereMax + j][x] = radius * Math.sin(Math.PI * i/sphereMax) * Math.cos(2 * Math.PI * j/sphereMax);
                        sphereVectorMatrix[i * sphereMax + j][y] = radius * Math.sin(Math.PI * i/sphereMax) * Math.sin(2 * Math.PI * j/sphereMax);
                        sphereVectorMatrix[i * sphereMax + j][z] = radius * Math.cos(Math.PI * i/sphereMax);
                    }
                }
                this.vectorMatrix = sphereVectorMatrix;
                break;

            default:
                System.out.println("invalid number of vectors");

        }
    }

    public void rotateX(double theta){
        double rY = 0;
        double rZ = 0;

        for(int i =0; i < vectorMatrix.length; i++){
            rY = vectorMatrix[i][y] * Math.cos(theta) + vectorMatrix[i][z] * Math.sin(theta);
            rZ = vectorMatrix[i][y] * (-1) * Math.sin(theta) + vectorMatrix[i][z] * Math.cos(theta);

            vectorMatrix[i][y] = rY;
            vectorMatrix[i][z] = rZ;
        }
    }

    public void rotateY(double theta){
        double rX = 0;
        double rZ = 0;

        for(int i =0; i < vectorMatrix.length; i++){
            rX = vectorMatrix[i][x] * Math.cos(theta) + vectorMatrix[i][z] * Math.sin(theta);
            rZ = vectorMatrix[i][x] * (-1) * Math.sin(theta) + vectorMatrix[i][z] * Math.cos(theta);

            vectorMatrix[i][x] = rX;
            vectorMatrix[i][z] = rZ;
        }
    }

    public void rotateZ(double theta){
        double rX = 0;
        double rY = 0;

        for(int i =0; i < vectorMatrix.length; i++){
            rX = vectorMatrix[i][x] * Math.cos(theta) + vectorMatrix[i][y] * Math.sin(theta);
            rY = vectorMatrix[i][x] * (-1) * Math.sin(theta) + vectorMatrix[i][y] * Math.cos(theta);

            vectorMatrix[i][x] = rX;
            vectorMatrix[i][y] = rY;
        }
    }

    public double[][] getVectorMatrix(){
        return vectorMatrix;
    }
}
