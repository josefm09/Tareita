import javax.swing.*; import java.awt.*;
public class Dibujando extends JFrame{
    public Dibujando(){
         super("Dibujando");
         setSize(400,400);
         getContentPane().add(new Lienzo());
         setDefaultCloseOperation(EXIT_ON_CLOSE);
         setVisible(true);
    }
    public static void main(String [] ar){
        new Dibujando(); 
    }
 }
 class Lienzo extends Canvas{
    public void paint(Graphics g){
     //Dibujando fondo negro
     g.setColor(Color.black);
     g.fillRect(0,0,getWidth(),getHeight());
     //Lado la base de la escuela 
     g.setColor(Color.orange);
     g.fillRect(0,220,getWidth(),155);
     //Base de concreto
     g.setColor(Color.gray);
     g.fillRect(0,375,getWidth(), 65);
     //techo plano de concreto
     g.setColor(Color.gray);
     g.fillRect(0,220,getWidth(), 25);
     /*/Dibujando techo
      int x[]={100,200,300};
      int y[]={100,20,100};
      g.setColor(Color.red);
      g.fillPolygon(x,y,3);*/
     //dibujar ventana
     g.setColor(Color.blue);
     g.fillRect(120,150,40,40);
     //Dibujar puerta 
     g.setColor(Color.gray);
     g.fillRect(180,200,40,100); 
    } 
}
