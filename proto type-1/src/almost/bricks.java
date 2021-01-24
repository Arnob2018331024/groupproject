package almost;


/**
 *
 * @author ArNoB
 */
public class bricks  {
    int[]exist=new int[30];
    int[]x=new int[30];
    int[]y=new int[30];
     int i; 
     public bricks(){
        for(i=1;i<9;i++)
    {
      exist[i]=1;
      x[i]=i*60;
      y[i]=10;
    }
    //for(i=0;i<10;i++)
    for(i=10;i<20;i++)
    {
    exist[i]=1;
      x[i]=(i-10)*60;
      y[i]=50;
    
    }
    for(i=21;i<29;i++)
    {
    exist[i]=1;
      x[i]=(i-20)*60;
      y[i]=90;
    
    }
    
     }
}
