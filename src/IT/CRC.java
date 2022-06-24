package IT;

public class CRC {
    public static int[] checksum(int[] frame, int[] generator){
        int[] result = new int[generator.length];
        int bringDown = result.length;
        int[] bigFrame = new int[frame.length + generator.length - 1];

        //Fill bigFrame
        for(int b = 0; b < frame.length; b++){
            bigFrame[b] = frame[b];
        }

        //Fill first result
        for (int r = 0; r < result.length; r++){
            result[r] = frame[r];
        }

        //calculate
        for (int i = 0; i < result.length; i++){
            if(result[0] == 1){
                for (int f = 0; f < result.length; f++){
                    if(result[f] < generator[f]){
                        result[f] = generator[f] - result[f];
                    } else {
                        result[f] = result[f] - generator[f];
                    }
                }
            }
            //move numbers
             if(i != result.length - 1) {
                for (int n = 0; n < result.length - 1; n++) {
                    result[n] = result[n + 1];
                }
            }
            result[result.length - 1] = bigFrame[bringDown];
            if(bringDown < bigFrame.length - 1) {
                bringDown++;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] frame = {1,0,1,1,1};
        int[] generator = {1,0,1,0};
        int [] result = CRC.checksum(frame, generator);
        for (int i = 0; i < result.length ; i++){
            System.out.println(result[i]);
        }
    }
}
