package piechart;
import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Rectangle2D;
import javax.swing.*;

public class PieChart extends JPanel {
    //Constructor
    public PieChart(){
    this.setPreferredSize(new Dimension(300, 250));
    this.setBackground(Color.WHITE);
}
//memberikan label pada legenda
String[] nilaiUjian = {"N01","N02","N03","N04","N05","N06","N07","N08","N09","N10"};
int[] jumlahMahasiswa = {30, 51, 100, 80, 84, 98, 73, 109, 36, 36};
Color[] warna = {Color.decode("#457a7"), Color.decode("#aa4643"),
    Color.decode("#89a54e"),Color.decode("#71588f"),Color.decode("#4198af"),
    Color.decode("#db843d"),Color.decode("#93a9cf"),Color.decode("#d19392"),
    Color.decode("#b9cd96"),Color.decode("#a99bbd")};

    @Override
public void paintComponent(Graphics g){
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D)g;
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
   
    //menampilkan tugas komputer grafik 1
    g2.setColor(Color.BLUE);
    g2.drawString("Tugas Komputer Grafik ", 30, 20);
   
    //pengaturan perpotongan/besar kecilnya pie chart
    float total = 0.0f;
    for(int k = 0; k < jumlahMahasiswa.length; k++)
        total += jumlahMahasiswa[k];
   
    float sudut, awal = 90;
    float lx = 220, ly = 40, lw = 10, lh = 10;
    for(int k = 0; k < jumlahMahasiswa.length; k++){
        sudut = 360.0f*jumlahMahasiswa[9-k]/total;
        int titik1=170;
        int titik2=170;
        int titik3=30;
        int titik4=30;
       
        if(k==3){
            titik1=170;
            titik2=170;
            titik3=35;
            titik4=20;
        }
        Shape sektor = new Arc2D.Float(titik4, titik3, titik2, titik1, awal, sudut, Arc2D.PIE);
        g2.setColor(warna[9-k]);
        g2.fill(sektor);
        awal += sudut;
       
        g2.setColor(Color.BLACK);
        g2.drawString(nilaiUjian[k], lx + lw + 5, ly + lh);
        ly += (lh + 5);
    }
    //Tulisan Legenda
    g2.setColor(Color.BLUE);
    g2.drawString("Legenda", 220, 30);
   
    //pengaturan kotak-kotak legenda
    g2.setColor(Color.decode("#4572a7"));
    g2.fill(new Rectangle2D.Float(220, 40, 10, 10));
   
    g2.setColor(Color.decode("#aa4643"));
    g2.fill(new Rectangle2D.Float(220, 55, 10, 10));
   
    g2.setColor(Color.decode("#89a54e"));
    g2.fill(new Rectangle2D.Float(220, 70, 10, 10));
   
    g2.setColor(Color.decode("#71588f"));
    g2.fill(new Rectangle2D.Float(220, 85, 10, 10));
   
    g2.setColor(Color.decode("#4198af"));
    g2.fill(new Rectangle2D.Float(220, 100, 10, 10));
   
    g2.setColor(Color.decode("#db843d"));
    g2.fill(new Rectangle2D.Float(220, 115, 10, 10));
   
    g2.setColor(Color.decode("#93a9cf"));
    g2.fill(new Rectangle2D.Float(220, 130, 10, 10));
   
    g2.setColor(Color.decode("#d19392"));
    g2.fill(new Rectangle2D.Float(220, 145, 10, 10));
   
    g2.setColor(Color.decode("#b9cd96"));
    g2.fill(new Rectangle2D.Float(220, 160, 10, 10));
   
    g2.setColor(Color.decode("#a99bbd"));
    g2.fill(new Rectangle2D.Float(220, 175, 10, 10));
   
    //Tulisan Yulian
    g2.setColor(Color.BLUE);
    g2.drawString("Created by Yulian Islam Prayoga", 25, 240);
}

    public static void main(String[] args) {
        //membuat frame dengan judul Pie Chart/dll
        JFrame frame = new JFrame();
        frame.setTitle("Pie Chart Yulian");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        //tambahkan objek class sesuai keinginan
        PieChart canvas = new PieChart();
        frame.getContentPane().add(canvas);
        frame.pack();
        frame.setVisible(true);
        // TODO code application logic here
    }
}
