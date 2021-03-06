package dibuja;


import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Dibuja {
	
	public static void main( String[] args ){
		JFrame frame = new JFrame( "José Carlos Flores Morán" );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		MiPanel panel = new MiPanel();
		frame.add( panel );
		
		frame.setSize( 626, 626 );		
 
		frame.setLocationRelativeTo(null);
		frame.setVisible( true );
		frame.setResizable(false);
		
	}
	
}

class MiPanel extends JPanel{

        @Override
	public void paintComponent (Graphics g){
		
		 super.paintComponent(g);
		 
		 Graphics2D g2d = (Graphics2D) g;
		 
		 //Cielo
		 Color azulbase = new Color(118, 199, 255);
		 Color azulclaro = new Color(255,255,255,60);
                 Color azulito = new Color(170, 240, 240);
                 g2d.setPaint(azulito);
                 g2d.fillRect(0, 0, getWidth(), getHeight());
		 GradientPaint verticalGradient = new GradientPaint(500, 0, azulbase, 500, 300, azulclaro);
		 g2d.setPaint(verticalGradient);
		 g2d.fillRect(0, 0, getWidth(), 360);

		 //Sol
		 g2d.setPaint(azulclaro);
		 g2d.fillOval(1, -40, 90, 90);
		 
		 //Resplandor del sol
		 int pasos = 4;
		 int logitud = (120 / pasos);
		 g2d.setPaint(new Color(255,255,255,25));
		 for (int i = 0; i < logitud; i++) {
		     g.fillOval(50 - i * pasos, -16 - i * pasos, i * pasos * 2, i * pasos * 2);
		 }
                 
                 //Nubes
                 dibuja_nubes(g,280,100);
                 dibuja_nubes(g,50,200);
                 dibuja_nubes(g,350,250);
                 
                 //Pared de fondo
		 Color pared_base = new Color(245,100,28);
		 Color pared_base_sombra = new Color(200,180,164);
		 GradientPaint color_pared_base = new GradientPaint(500, 360, pared_base, 500, 560, pared_base_sombra);
		 g2d.setPaint(color_pared_base);
		 g2d.fillRect(50, 382, 526 , 180);
		 //Pared largo: 1419
		 //Pared ancho: 190
		 
		 //tablas de pared
		 Color tabla_pared_1 = new Color(225,98,8);
		 Color tabla_pared_2 = new Color(255,120,48);
		 Color tabla_pared_3 = new Color(245,90,38);
		 
		 int ancho_tabla = (210 / 17);
		 int separacion_horizontal = 4;
		 int contador = 1;
		
		 //Añade tablas a la pared
		 for(int i = 0; i < 26; i++) {
			 
			 for (int j = 0; j < 16; j++) {
				
				int posicion_tabla_ancho = (210 / 17)*j;
				
                             switch (contador) {
                                 case 1:
                                     g2d.setPaint(tabla_pared_1);
                                     contador = 2;
                                     break;
                                 case 2:
                                     g2d.setPaint(tabla_pared_2);
                                     contador = 3;
                                     break;
                                 case 3:
                                     g2d.setPaint(tabla_pared_3);
                                     contador = 1;
                                     break;
                                 default:
                                     break;
                             }
				
				
				
				
				g2d.fillRect(50, 382 + posicion_tabla_ancho + separacion_horizontal, 526, ancho_tabla-2);
                                //g2d.fillRect(240, 382 + posicion_tabla_ancho + separacion_horizontal, 146, ancho_tabla-2);
				
			}
			 
		 }
                 
                 //Separacion del techo
                 Color sombra_base = new Color(0, 0, 0, 80);
                 Color separacion = new Color(251, 148, 53);
                 g2d.setPaint(separacion);
                 g2d.fillRect(45, 390, 536, 15);
                 //Sombre de la separacion
                 g2d.setPaint(sombra_base);
                 g2d.fillRect(220, 395, 196, 10);
                 g2d.setPaint(separacion);
                 g2d.fillRect(230, 395, 176, 15);
                 
                 //Techo base del edificio 
                 int x[]={30,100,526,596};
                 int y[]={396,345,345,396};
                 Color techo = new Color(114, 102, 88);
                 g.setColor(techo);
                 g.fillPolygon(x,y,4);
                 
                 //Sombra Techo triangulo
                 int x1[]={200, 315, 436};
                 int y1[]={396, 335, 396};
                 g.setColor(sombra_base);
                 g.fillPolygon(x1, y1, 3);
                 
                 //Torre
                 Color torre = new Color(241, 100, 31);
                 g2d.setPaint(torre);
                 g2d.fillRect(277, 286, 81, 110);
                 
                 
                 //Separacion de la torre
                 g2d.setPaint(separacion);
                 g2d.fillRect(267, 276, 101, 10);
                 
                 //Techo torre
                 int x3[]={252, 315, 385};
                 int y3[]={276, 236, 276};
                 g.setColor(techo);
                 g.fillPolygon(x3, y3, 3);
                 
                 //Base del relog
                 dibuja_circulo(g,separacion,316,316,43);
                 
                 //Relog
                 dibuja_circulo(g,Color.WHITE,316,316,30);
                 
                 //Manecillas
                 g2d.setPaint(Color.BLACK);
                 g2d.fillRect(308, 316, 8, 2);
                 g2d.setPaint(Color.BLACK);
                 g2d.fillRect(316, 307, 2, 11);
                 
                 //Techo triangulo
                 int x2[]={215, 315, 416};
                 int y2[]={396, 345, 396};
                 g.setColor(techo);
                 g.fillPolygon(x2, y2, 3);
                 
                 
		 //Base del edificio 
                 Color base = new Color(185,190,193);
                 Color base_blanca = new Color(242, 223, 224);
                 g2d.setPaint(base);
                 g2d.fillRect(40, 550, 546, 300 );
                 g2d.setPaint(base_blanca);
                 g2d.fillRect(40, 550, 546, 5);
                 
                 
                 //Sombra del cuadro frontal
                 Color sombra_cuadro = new Color(0, 0, 0, 80);
                 g2d.setPaint(sombra_cuadro);
                 g2d.fillRect(230, 405, 176, 155);
                 
                 //Escalones
                 //Escalon 1
                 g2d.setPaint(base_blanca);
                 g2d.fillRect(235, 550, 166, 5);
                 g2d.setPaint(base);
                 g2d.fillRect(235, 555, 166, 5);
                 //Escalon 2
                 g2d.setPaint(sombra_base);
                 g2d.fillRect(225, 560, 186, 10);
                 g2d.setPaint(base_blanca);
                 g2d.fillRect(230, 560, 176, 5);
                 g2d.setPaint(base);
                 g2d.fillRect(230, 565, 176, 5);
                 //Escalon 3
                 g2d.setPaint(sombra_base);
                 g2d.fillRect(220, 570, 196, 10);
                 g2d.setPaint(base_blanca);
                 g2d.fillRect(225, 570, 186, 5);
                 g2d.setPaint(base);
                 g2d.fillRect(225, 575, 186, 5);
                 
                 
                 //Cuadro frontal
                 Color cuadro_frontal = new Color(241, 100, 31);
                 g2d.setPaint(cuadro_frontal);
                 g2d.fillRect(240, 405, 156, 145);
                 
                 //Puertas de vidrio
                 Color ventana = new Color(106, 196, 228);
                 g2d.setPaint(techo);
                 g2d.fillRect(282, 490, 70, 60);
                 g2d.setPaint(Color.BLACK);
                 g2d.fillRect(316, 490, 1, 60);
                 g2d.setPaint(ventana);
                 g2d.fillRect(287, 495, 25, 35);
                 g2d.setPaint(ventana);
                 g2d.fillRect(287, 535, 25, 8);
                 g2d.setPaint(ventana);
                 g2d.fillRect(322, 495, 25, 35);
                 g2d.setPaint(ventana);
                 g2d.fillRect(322, 535, 25, 8);
                 
                 //Separacion del primer piso
                 g2d.setPaint(base_blanca);
                 g2d.fillRect(234, 470, 168, 5);
                 g2d.setPaint(base);
                 g2d.fillRect(234, 475, 168, 5);
		 
		 //Banqueta
		 Color gris_calle = new Color(167,168,170);
		 Color gris_calle_sombra = new Color(146,147,149);
		 g2d.setPaint(gris_calle);
		 g2d.fillRect(0, 580, getWidth(), 220);
                 
                 
                 
                 //Calle negra
                 g2d.setPaint(gris_calle_sombra);
                 g2d.fillRect(0, 595, getWidth(), 220);
                
		 //Ventanas del lado izquierdo
                 dibuja_ventanas(g2d,65,417,4);
                 dibuja_ventanas(g2d,65,490,4);
                 
                 //Ventanas del cuadro central
                 dibuja_ventanas(g2d,255,417,3);
		 
                 //Ventanas del lado derecho
                 dibuja_ventanas(g2d,406,417,4);
                 dibuja_ventanas(g2d,406,490,4);
                 
                 //Arbolitos
                 Color verde_pino = new Color(68, 189, 89);
                 Color tronco = new Color(172, 120, 74);
                 g2d.setPaint(tronco);
                 g2d.fillRect(45, 540, 13, 40);
                 g2d.setPaint(tronco);
                 g2d.fillRect(573, 540, 13, 40);
                 
                 //Triangulo del pino izquierdo
                 int x4[]={20, 50, 80};
                 int y4[]={545, 425, 545};
                 g.setColor(verde_pino);
                 g.fillPolygon(x4, y4, 3);
                 
                 //Triangulo del pino derecho
                 int x5[]={548, 578, 608};
                 int y5[]={545, 425, 545};
                 g.setColor(verde_pino);
                 g.fillPolygon(x5, y5, 3);
        }
        
        //Metodo para dibujar ventanas en serie 
        public void dibuja_ventanas(Graphics2D g2d,int marco_x, int marco_y, int n){
            Color marco = new Color(248, 224, 210);
            Color ventana = new Color(106, 196, 228);
            
            int ventana_x = marco_x + 5;
            int ventana_y = marco_y + 5;
            for(int j = 0; j<n; j++){
                     
                     g2d.setPaint(marco);
                     g2d.fillRect(marco_x, marco_y, 30, 45);
                     g2d.setPaint(ventana);
                     g2d.fillRect(ventana_x, ventana_y, 20, 15);
                     g2d.setPaint(ventana);
                     g2d.fillRect(ventana_x, ventana_y+20, 20, 15);
                     
                     marco_x = marco_x + 45;
                     ventana_x = ventana_x + 45;
                 }
        
        }
        
        //Metodo para dibujar circulos
        public void dibuja_circulo(Graphics g, Color color, int xcirc, int ycirc, int rcirc){
             xcirc = xcirc-(rcirc/2);
             ycirc = ycirc-(rcirc/2);
             g.setColor(color);
             g.fillOval(xcirc,ycirc,rcirc,rcirc);
        }
        
        //Metodo para dibujar nubes
        public void dibuja_nubes(Graphics g,int x,int y){
            Random rand = new Random();
            Color nube = new Color(250, 253, 253);
            int r=50;

            for (int i=0;i<=20;i++){
                
                if(r > 30 && r < 50 ){
                    dibuja_circulo(g,nube,x,y,r);
                    r = r - 20;
                }else {
                    dibuja_circulo(g,nube,x,y,r);
                    r = r + 20;
                }
                r = rand.nextInt(100);
                x=x+10;
            }
            
        }
}
