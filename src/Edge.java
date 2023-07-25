public class Edge {
    private int edges[][];

    public Edge(String shape, int sphereMax){
        switch(shape){
            case "cube":
                int cubeEdges[][] ={{0,1}, {1,2}, {2,3}, {3,0}, {0,4}, {1,5}, {2,6}, {3,7}, {4,5}, {5,6}, {6,7}, {7,4}};
                this.edges = cubeEdges;
                break;

            case "sphere": 
                int sphereEdges[][] = new int[(int)Math.pow((double)sphereMax,(double)2)][2];
                int tempStoreX = 0;

                for(int i = 0; i < sphereMax ; i++){
                    for(int j = 0; j < sphereMax; j+=1){
                        if(j == 0){
                            tempStoreX = i * sphereMax + j;
                        }
                        
                        if(j != sphereMax - 1){
                            sphereEdges[i * sphereMax + j][0] = i * sphereMax + j;
                            sphereEdges[i * sphereMax + j][1] = i * sphereMax + j + 1;

                        }else{
                            sphereEdges[i * sphereMax + j][0] = i * sphereMax + j;
                            sphereEdges[i * sphereMax + j][1] = tempStoreX;
                        }
                    }
                }

                this.edges = sphereEdges;
                
                break;

            default:
                System.out.println("shape has yet to be supported");
        }
    }   

    public int[][] getEdges(){
        return edges;
    }
}
