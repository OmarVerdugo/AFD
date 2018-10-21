import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

	
	class miPanel extends JPanel{
		
		Image icono=new ImageIcon("img/logo.jpeg").getImage();
		
		public miPanel(){
			
		}
		
		public void paintComponent(Graphics g){
			g.drawImage(icono,0,0,getWidth(),getHeight(),this);
		}
	}

	public class AFD extends JFrame{
		int ancho=1300;
		JPanel panelMenu=new miPanel();
		boolean visible=false;
		int[][] matriz;
		
		public AFD() {
			
			setVisible(true);
			setSize(ancho,530);
			setTitle("TEOCOM: AFD");
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setLocation(10,10);
			setResizable(false);
			setLayout(null);
			matriz=new int[4][2];
			for (int x=0; x < matriz.length; x++) {
				  for (int y=0; y < matriz[x].length; y++) {
					  matriz[x][y]=0;
				    System.out.print (matriz[x][y]);
				  }
				  System.out.println("");
				}
			matriz[0][0]=1;
			matriz[0][1]=2;
			matriz[1][0]=0;
			matriz[1][1]=3;
			matriz[2][0]=3;
			matriz[2][1]=0;
			matriz[3][0]=2;
			matriz[3][1]=1;
			for (int x=0; x < matriz.length; x++) {
				
				  for (int y=0; y < matriz[x].length; y++) {
				    System.out.print (matriz[x][y]);
				  }
				  System.out.println("");
				}
			menu();
			
		}
		
		public void menu(){
			removeAll();
			add(panelMenu);
			repaint();
			panelMenu.setLayout(null);
			panelMenu.setBounds(0,0, ancho,500);	
			
			JLabel titulo1=new JLabel("TEOCOM: AFD");
			titulo1.setBounds(60, 10, 350, 50);
			font(titulo1, "Times New Roman", 24);
			titulo1.setForeground(Color.WHITE);
		
			panelMenu.add(titulo1); 
			JLabel titulo2=new JLabel("Alumno: Omar Daniel Verdugo Ambriz");
			font(titulo2,"Times New Roman",18);
			titulo2.setBounds(60, 50, 350, 50);
			titulo2.setForeground(Color.WHITE);
			panelMenu.add(titulo2);
			
			
			JLabel cad=new JLabel("Cadena: ");
			cad.setBounds(40, 150, 100, 30);
			cad.setForeground(Color.WHITE);
			panelMenu.add(cad);
			
			JTextField cadena=new JTextField();
			cadena.setBounds(100, 150, 200, 30);
			panelMenu.add(cadena);
			
			JButton limpiar=new JButton("Limpiar");
			limpiar.setBounds(40, 190, 100, 30);
			panelMenu.add(limpiar);
			limpiar.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					cadena.setText("");
				}
				
			});
			
			JButton verificar=new JButton("Verificar");
			verificar.setBounds(190, 190, 100, 30);
			panelMenu.add(verificar);
			verificar.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					//Aqui se realiza el algoritmo de validación
					String cadenaAux=cadena.getText();
					if(cadenaAux.isEmpty())
						JOptionPane.showMessageDialog(null, "Vacío. Ingrese algo.");
					else {
						int estado=0;
						int cont=0;
						int tama=cadenaAux.length();
						char car;
						while(cont<tama) {
							car=cadenaAux.charAt(cont);
							System.out.println("Caracter: "+car); 
							int carAux=Character.getNumericValue(car); 
							 System.out.println("Caract aux = :"+carAux);
							estado=matriz[estado][carAux-10];
							cont++;
						}
						if(acepta(estado)) {
							JOptionPane.showMessageDialog(null,"Cadena valida "+"Estado: "+estado);
						}
						else {
							JOptionPane.showMessageDialog(null,"Cadena Invalida "+"Estado: "+estado);

							
						}
					}
					
				}
				
			});
			
			
		}
		public boolean acepta(int estado) {
			if(estado==0 || estado==3)
				return true;
			else
				return false;
		}
		
		public void font(JLabel label,String tipo,int size){
			
			Font font=new Font(tipo,Font.BOLD,size);
			label.setFont(font);
		
		}
		
		
		
		
		public void removeAll() {
			remove(panelMenu);
		}
	}