package View;

public class View {
        StartFrame startFrame;
        public View(){
               this.startFrame=new StartFrame();
               if(startFrame.getOptionBeenden()==0){
                       this.startFrame.dispose();
                       AuswahlFrame spielAuswahlFrame=new AuswahlFrame();
               }
                }

        public int getteroption(){
                return startFrame.getOptionBeenden();
        }
}
