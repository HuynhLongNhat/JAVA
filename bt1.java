import java.awt.*;
import java.awt.event.*;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
public class bt1 implements ActionListener
{
    
    Frame f = new Frame("TINH THUE THU NHAP");
    Label lb1 = new Label("Nhap ho ten:");
    Label lb2 = new Label("Nhap thu nhap :");

    TextField ho_ten = new TextField(30);
     TextField thu_nhap = new TextField(30);
    Choice chon_loai_thu_nhap = new Choice();
    Button tinh_tien  = new Button("Tinh tien");
    Button luu_tep = new Button("Luu tep");
    Button thoat = new Button("Thoat");
    Label lb4 = new Label("Chon thu nhap:");
    Label lb3 = new Label("So tien can tra:");
    Label  ket_qua =  new Label("                    ");
     public bt1()
        {   
             chon_loai_thu_nhap.add("Thu nhap thuong xuyen" );
             chon_loai_thu_nhap.add("Thu nhap khong thuong xuyen");

             f.add(lb1);f.add(ho_ten);
             f.add(lb2);f.add(thu_nhap);
             f.add(lb4);f.add(chon_loai_thu_nhap);
             f.add(lb3);f.add(ket_qua);
             f.add(tinh_tien); f.add(luu_tep);
             f.add(thoat);
            
             tinh_tien.addActionListener(this);
             luu_tep.addActionListener(this);
             thoat.addActionListener(this);
             f.setLayout((new GridLayout(6,2)));
             f.setSize(500, 250);
             f.setVisible(true);
        }
   @Override
     public void actionPerformed(ActionEvent e) {
        if(e.getSource() ==thoat)
          {
            System.exit(0);
          }
        if(e.getSource() == tinh_tien)
           { 
           
             double tinhtien = 0;
             double thunhap = Double.parseDouble(thu_nhap.getText());
               if(chon_loai_thu_nhap.getSelectedItem().equals("Thu nhap thuong xuyen"))
                  {  
                       if( thunhap >5000000)
                             {
                                tinhtien = 0.1 * thunhap;
                             }
                       else 
                             tinhtien = 0;
                        
                  }
                else if(chon_loai_thu_nhap.getSelectedItem().equals("Thu nhap khong thuong xuyen"))
                    {
                        tinhtien = 0.05 * thunhap ;
                    }
                ket_qua.setText("  "+ tinhtien);
           }
         if( e.getSource() == luu_tep)
           {
             luutep("abc.txt", (ho_ten.getText()+"-"+thu_nhap.getText()+"-" + ket_qua.getText()));
           }
        }

    public void luutep(String tentep,String noidung)
       {

            try
              {
                FileOutputStream fo = new FileOutputStream(tentep);
                PrintWriter pw = new PrintWriter(fo);
                 pw.print(noidung);

                 pw.close();
                 fo.close();
              }catch(IOException e)
                 {
                   
                 }
                         
                    
       }
        
    
    public static void main(String[] args) {
        bt1 bt1 = new bt1();
    }
}
