package GUI;
import BUS.*;
import DATA.*;
import DTO.*;
import image.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.*;

import static javax.swing.BorderFactory.createLineBorder;

// nguyen dinh hung
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Vector;

//--------------------------------------------------


import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.BorderFactory.createLineBorder;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;



public class QLGV extends JPanel implements KeyListener{
   private GiaoVienBUS gvBUS=new GiaoVienBUS();
    private JTable tbl;
    private BufferedImage i = null;//Hình ảnh chọn từ file
    private JLabel img;
    private String imgName = "null";
    private JTextField txtGT,txtmaGV,txtHoGV,txtTenGV,txtNamSinh,txtDienThoai,txtSearch,sortMaGV,sortTenGV;
    
     private DefaultTableModel model;
    private int DEFALUT_WIDTH;
    private boolean EditOrAdd = true;//Cờ cho button Cofirm True:ADD || False:Edit
    private JComboBox cmbGT;
     public QLGV(int width)
    {
        DEFALUT_WIDTH = width;
        init();
    
    }
    public void init(){
        Color myColor = new Color(99, 116, 198);
        setLayout(null);
        setBackground(null);
        setBounds(new Rectangle(50, 0, this.DEFALUT_WIDTH - 220, 1000));
        Font font0 = new Font("Segoe UI",Font.PLAIN,13);
        Font font1 = new Font("Segoe UI",Font.BOLD,13);
/****************************** PHẦN HIỂN THỊ THÔNG TIN ******************************************/
        JPanel ItemView = new JPanel(null);
        ItemView.setBounds(new Rectangle(30, 20, this.DEFALUT_WIDTH - 220 , 250));
        ItemView.setBackground(myColor);
         /******** Tao Cac Label & TextField ************************/
         JLabel lbIdGV = new JLabel("Mã giáo viên");
         lbIdGV.setBounds(new Rectangle(250,0,200,30));
         lbIdGV.setFont(font0);
         txtmaGV =new JTextField("");
         txtmaGV.setBounds(new Rectangle(350,0,220,30));
         txtmaGV.setFont(font0);

        JLabel lbHoGV = new JLabel("Họ Giáo viên");
        lbHoGV.setBounds(new Rectangle(250,40,200,30));
        lbHoGV.setFont(font0);
        txtHoGV=new JTextField("");
        txtHoGV.setBounds(new Rectangle(350,40,220,30));
        txtHoGV.setFont(font0);

        JLabel lbTenGV = new JLabel("Tên Giáo viên");
        lbTenGV.setBounds(new Rectangle(250,80,200,30));
        lbTenGV.setFont(font0);
        txtTenGV=new JTextField("");
        txtTenGV.setBounds(new Rectangle(350,80,220,30));
        txtTenGV.setFont(font0);

        JLabel lbGioiTinh = new JLabel("Giới Tính");
        lbGioiTinh.setBounds(new Rectangle(250,120,200,30));
        lbGioiTinh.setFont(font0);
        String Phai[]={"Nam", "Nữ"};
        cmbGT=new JComboBox(Phai);
        cmbGT.setBounds(new Rectangle(350,120,220,30));
        cmbGT.setFont(font0);

         txtGT= new JTextField("");

        JLabel lbNamSinh = new JLabel("Năm Sinh ");
        lbNamSinh.setBounds(new Rectangle(250,160,200,30));
        lbNamSinh.setFont(font0);
        txtNamSinh=new JTextField("");
        txtNamSinh.setBounds(new Rectangle(350,160,220,30));
        txtNamSinh.setFont(font0);
        
        JLabel lbDienThoai = new JLabel("Số Điện Thoại ");
        lbDienThoai.setBounds(new Rectangle(250,200,200,30));
        lbDienThoai.setFont(font0);
        txtDienThoai=new JTextField("");
        txtDienThoai.setBounds(new Rectangle(350,200,220,30));
        txtDienThoai.setFont(font0);

        img = new JLabel("Image");
        img.setBorder(createLineBorder(Color.BLACK));
        img.setBounds(new Rectangle(0,0,200,230));

        // THÊM VÀO PHẦN HIỂN THỊ
        ItemView.add(img);
        ItemView.add(txtmaGV);
        ItemView.add(lbIdGV);
        ItemView.add(lbHoGV);
        ItemView.add(txtHoGV);
        ItemView.add(lbTenGV);
        ItemView.add(txtTenGV);
        ItemView.add(lbGioiTinh);
        ItemView.add(cmbGT);
        ItemView.add(lbNamSinh);
        ItemView.add(txtNamSinh);
        ItemView.add(lbDienThoai);
         ItemView.add(txtDienThoai);
        /**************** TẠO CÁC BTN THÊM ,XÓA, SỬA ********************/
        JLabel btnAdd = new JLabel(new ImageIcon("./src/image/btnAdd.png"));
        btnAdd.setBounds(new Rectangle(620,0,200,50));
        btnAdd.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        
        JLabel btnEdit = new JLabel(new ImageIcon("./src/image/btnEdit.png"));
        btnEdit.setBounds(new Rectangle(620,70,200,50));
        btnEdit.setCursor(new Cursor(Cursor.HAND_CURSOR));
       
        
        JLabel btnDelete = new JLabel(new ImageIcon("./src/image/btnDelete.png"));
        btnDelete.setBounds(new Rectangle(620,140,200,50));
        btnDelete.setCursor(new Cursor(Cursor.HAND_CURSOR));

        ItemView.add(btnAdd);
        ItemView.add(btnEdit);
        ItemView.add(btnDelete);
    
        JLabel btnConfirm= new JLabel(new ImageIcon("./src/image/btnConfirm.png"));
        btnConfirm.setVisible(false);
        btnConfirm.setBounds(new Rectangle(620,0,200,50));
        btnConfirm.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        JLabel btnBack = new JLabel(new ImageIcon("./src/image/btnBack.png"));
        btnBack.setVisible(false);
        btnBack.setBounds(new Rectangle(620,70,200,50));
        btnBack.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        JLabel btnFile = new JLabel(new ImageIcon("./src/image/btnFile.png"));
        btnFile.setVisible(false);
        btnFile.setBounds(new Rectangle(620,140,200,50));
        btnFile.setCursor(new Cursor(Cursor.HAND_CURSOR));

        ItemView.add(btnConfirm);
        ItemView.add(btnBack);
        ItemView.add(btnFile);

        // MouseClick btnADD
        //thêm (màu xanh lá , bậc 1) 
        btnAdd.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e)
            {
                EditOrAdd = true;
                
                cleanView();
                
                btnAdd.setVisible(false);
                btnEdit.setVisible(false);
                btnDelete.setVisible(false);
                
                btnConfirm.setVisible(true);
                btnBack.setVisible(true);
                btnFile.setVisible(true);
                
                tbl.clearSelection();
                tbl.setEnabled(false);
            }
        });


        // MouseClick btnDelete
        //xóa (màu xanh bậc 1)
        btnDelete.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e)
            {   
                int i = JOptionPane.showConfirmDialog(null, "Xác nhận xóa","Alert",JOptionPane.YES_NO_OPTION);
                if(i == 0)
                {
                    gvBUS.deleteGV(txtmaGV.getText());
                    cleanView();
                    tbl.clearSelection();
                    outModel(model, gvBUS.getList());
                }
            }
        });
        // MouseClick btnEdit
        //chỉnh sửa (bậc 1)
        btnEdit.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e)
            {
                if(txtmaGV.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Vui lòng giáo viên cần sửa !!!");
                    return;
                }
                
                EditOrAdd = false;
                txtmaGV.setEditable(false);
                
                btnAdd.setVisible(false);
                btnEdit.setVisible(false);
                btnDelete.setVisible(false);
                
                btnConfirm.setVisible(true);
                btnBack.setVisible(true);
                btnFile.setVisible(true);
               

                tbl.setEnabled(false);
            }
        });

        btnFile.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e)
            {
               JFileChooser fc = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "JPG & PNG images", "jpg", "png");
                fc.setFileFilter(filter);
                int result = fc.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) 
                {
                    try {
                        File file = fc.getSelectedFile(); //Lấy URL hình
                        i = ImageIO.read(file); // Lấy hình
                        imgName = txtmaGV.getText().concat(".jpg"); //Tên hình
                        
                        // Thay đổi hình hiển thị
                        img.setText("");
                        img.setIcon(new ImageIcon(i.getScaledInstance(200, 230, Image.SCALE_DEFAULT)));
                        
                        revalidate();
                        repaint();
                    } catch (IOException ex) {
                        //Logger.getLogger(SQGV.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });

        //MouseClick btnBack
        //btnBack bậc 2
        btnBack.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e)
            {
                cleanView();
                
                btnAdd.setVisible(true);
                btnEdit.setVisible(true);
                btnDelete.setVisible(true);
                
                btnConfirm.setVisible(false);
                btnBack.setVisible(false);
                btnFile.setVisible(false);
                
                tbl.setEnabled(true);
            }
        });
        //MouseClick btnConfirm
        //xác nhận thêm (bậc 2) và xac nhận sửa
        btnConfirm.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e)
            {
                int i;
                if(EditOrAdd) //Thêm Sản Phẩm
                {
                    i = JOptionPane.showConfirmDialog(null, "Xác nhận thêm giáo viên","",JOptionPane.YES_NO_OPTION);
                    if(i == 0)
                    {
                        //Lấy dữ liệu từ TextField
                        String magv=txtmaGV.getText();
                        String hoGV=txtHoGV.getText();
                        String tenGV=txtTenGV.getText();
                        String gioiTinh=cmbGT.getSelectedItem().toString();
                        int namsinh  = Integer.parseInt(txtNamSinh.getText());
                        int dienThoai=Integer.parseInt(txtDienThoai.getText());                      
                        String IMG = imgName;

                        if(gvBUS.checkMagv(magv))
                        {
                            JOptionPane.showMessageDialog(null, "Mã giao vien đă tồn tại !!!");
                            return;
                        }
                        //Upload sản phẩm lên DAO và BUS
                        GiaoVienDTO gv=new GiaoVienDTO(magv, hoGV, tenGV, gioiTinh, IMG, namsinh, dienThoai);
                        gvBUS.addGV(gv);

                        outModel(model, gvBUS.getList());// Load lại table

                        saveIMG();// Lưu hình ảnh 

                        cleanView();
                    }
                }
                else    // Edit Sản phẩm
                {
                    i = JOptionPane.showConfirmDialog(null, "Xác nhận sửa thông tin giáo viên","",JOptionPane.YES_NO_OPTION);
                    if(i == 0)
                    {
                        //Lấy dữ liệu từ TextField
                        String magv=txtmaGV.getText();
                        String hoGV=txtHoGV.getText();
                        String tenGV=txtTenGV.getText();
                        String gioiTinh=cmbGT.getSelectedItem().toString();
                        int namsinh  = Integer.parseInt(txtNamSinh.getText());
                        int dienThoai=Integer.parseInt(txtDienThoai.getText());
//                        String maNsx = txtNSX.getText();
                        String IMG = imgName;

                        //Upload sản phẩm lên DAO và BUS
                        GiaoVienDTO gv=new GiaoVienDTO(magv, hoGV, tenGV, gioiTinh, IMG, namsinh, dienThoai);
                       
                        gvBUS.setGV(gv);
                        
                        outModel(model, gvBUS.getList());// Load lại table
                        
                        saveIMG();// Lưu hình ảnh 
                        
                        JOptionPane.showMessageDialog(null, "Sửa thành công","Thành công",JOptionPane.INFORMATION_MESSAGE);
                        
                    }
                }
                
            }
        });
        /************************* PHẦN TABLE *************************************/
/************** TẠO MODEL VÀ HEADER *********************/
        Vector header = new Vector();
        header.add("Mã giáo viên");
        header.add("Họ giáo viên");
        header.add("Tên giáo viên");
        header.add("giới Tính");
        header.add("Năm Sinh");
        header.add("Điện Thoại");
        header.add("IMG"); 
        model = new DefaultTableModel(header,0)
        {
             public Class getColumnClass(int column)
             {
                 switch(column){
                     case 4:
                         return Integer.class;
                     case 5:
                         return Integer.class;
                     default:
                         return String.class;
                 }
             }
                        
        };
        tbl = new JTable(model);
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<TableModel>(model);
        tbl.setRowSorter(rowSorter);
        listGV(); //Đọc từ database lên table 
        /*********************************************************/
        
/**************** TẠO TABLE ************************************************************/
        // Chỉnh width các cột 
        tbl.getColumnModel().getColumn(0).setPreferredWidth(40);
        tbl.getColumnModel().getColumn(1).setPreferredWidth(40);
        tbl.getColumnModel().getColumn(2).setPreferredWidth(40);
        tbl.getColumnModel().getColumn(3).setPreferredWidth(50);
        tbl.getColumnModel().getColumn(4).setPreferredWidth(40);
        tbl.getColumnModel().getColumn(5).setPreferredWidth(40);
       
         DefaultTableCellRenderer leftAlign = new DefaultTableCellRenderer();
        leftAlign.setHorizontalAlignment(JLabel.LEFT);
        tbl.getColumnModel().getColumn(4).setCellRenderer(leftAlign);
        tbl.getColumnModel().getColumn(5).setCellRenderer(leftAlign);
        
        tbl.setFocusable(false);
        //thể hiện sự ngăn cách ở table
        tbl.setIntercellSpacing(new Dimension(0,0));     
        tbl.getTableHeader().setFont(font1);
        tbl.setRowHeight(30);
        tbl.setShowVerticalLines(false);              
        tbl.getTableHeader().setOpaque(false);
        tbl.setFillsViewportHeight(true);
        tbl.getTableHeader().setBackground(new Color(232,57,99));
        tbl.getTableHeader().setForeground(Color.WHITE);
        tbl.setSelectionBackground(Color.green); 

        // Add table vào ScrollPane
        JScrollPane scroll = new JScrollPane(tbl);
        scroll.setBounds(new Rectangle(30, 360, this.DEFALUT_WIDTH - 400 , 300));
        //này là màu viền (scroll là thanh cuộn)
        scroll.setBackground(null);              
        // cái này là độ rộng của nút di chuyển lên xuống
        scroll.getVerticalScrollBar().setPreferredSize(new Dimension(5,100));
        add(scroll);
        add(ItemView);
/*****************************************************************************************/
        tbl.addMouseListener(new MouseAdapter() {
             public void mouseClicked(MouseEvent e)
             {
               int i = tbl.getSelectedRow();
                if(tbl.getRowSorter() != null)
                {
                    i = tbl.getRowSorter().convertRowIndexToModel(i);
                }
                imgName = tbl.getModel().getValueAt(i, 6).toString();
                Image newImage ;
                try{
                    newImage = new ImageIcon("./src/image/SanPham/"+imgName).getImage().getScaledInstance(200, 230, Image.SCALE_DEFAULT);
                }catch(NullPointerException E)
                {
                    newImage = new ImageIcon("./src/image/SanPham/NoImage.jpg").getImage().getScaledInstance(200, 230, Image.SCALE_DEFAULT); 
                }
                txtmaGV.setText(tbl.getModel().getValueAt(i, 0).toString());
                txtHoGV.setText(tbl.getModel().getValueAt(i, 1).toString());
                txtTenGV.setText(tbl.getModel().getValueAt(i, 2).toString()); 

                cmbGT.setSelectedItem(tbl.getModel().getValueAt(i, 3).toString());

                txtNamSinh.setText(tbl.getModel().getValueAt(i, 4).toString());
                txtDienThoai.setText(tbl.getModel().getValueAt(i, 5).toString());
 
                img.setText("");
                img.setIcon(new ImageIcon(newImage));
                
             }
        });



/********************* THANH SEARCH ***********************************************/
        JPanel searchBox = new JPanel(null);
        searchBox.setBackground(null);
        searchBox.setBounds(new Rectangle(620,200,250, 30)); 
        searchBox.setBorder(createLineBorder(Color.red)); //Chỉnh viền 
        
        txtSearch = new JTextField();
        txtSearch.setBounds(new Rectangle(5,0,200,30));
        txtSearch.setBorder(null);
        txtSearch.setOpaque(false);
        txtSearch.setFont(new Font("Segoe UI",Font.PLAIN,15));

        JLabel searchIcon = new JLabel(new ImageIcon("./src/image/search_25px.png"));
        searchIcon.setBounds(new Rectangle(200,-9,50,50));
        searchIcon.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        // Add tất cả vào search box
        searchBox.add(searchIcon);
        searchBox.add(txtSearch);
        
        txtSearch.addFocusListener(new FocusAdapter(){
            @Override
            public void focusGained(FocusEvent e) 
            {
                searchIcon.setIcon(new ImageIcon("./src/image/search_25px_focus.png")); //Đổi màu icon
                searchBox.setBorder(createLineBorder(new Color(52,152,219))); // Đổi màu viền 
            }
            public void focusLost(FocusEvent e) //Trờ về như cũ
            {
                searchIcon.setIcon(new ImageIcon("./src/image/search_25px.png"));
                searchBox.setBorder(createLineBorder(Color.BLACK));
            }
        });
        
        //chưa hiểu
        txtSearch.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = txtSearch.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)^"+ text +".*", 1));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = txtSearch.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)^"+ text +".*", 1));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
        });
        ItemView.add(searchBox);
        /*********************************************************************************/
/*********************** PHẦN SEARCH TABLE *****************************/
        JPanel sort = new JPanel(null);
        sort.setBackground(null);
        sort.setBounds(30,265,this.DEFALUT_WIDTH - 400,100);

        JLabel sortTitle = new JLabel("--------------------------------------------------------------------------- TÌM KIẾM THÔNG TIN ---------------------------------------------------------------------------",JLabel.CENTER); // Mỗi bên 74 dấu ( - )
        sortTitle.setFont(font1);
        sortTitle.setBounds(new Rectangle(0,0,this.DEFALUT_WIDTH - 400,30));
        sort.add(sortTitle);
        
        /******** SORT MAGV **************/
        JLabel lbSortMaGV = new JLabel("Mă giáo viên :");
        lbSortMaGV.setFont(font0);
        lbSortMaGV.setBounds(0,40,80,30);
        sort.add(lbSortMaGV);

        sortMaGV = new JTextField();
        sortMaGV.setFont(font0);
        sortMaGV.setBounds(new Rectangle(90,42,100,30));
        sortMaGV.addKeyListener(this);
        sort.add(sortMaGV);

        JLabel btnSearch = new JLabel(new ImageIcon("./src/image/btnSearch_45px.png"));
        btnSearch.setBounds(new Rectangle(840,26,63,63));
        btnSearch.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnSearch.addMouseListener(new MouseAdapter() {
           public void mouseClicked(MouseEvent e)
           {
               search();
           }
        });
        sort.add(btnSearch);
        add(sort);

        

        


 /*tới đây là kết thúc */
    }
//---------------------------SANG PHAN MOI------------------------------------------
    public void cleanView() //Xóa trắng các TextField
    {
        txtmaGV.setEditable(true);

        txtmaGV.setText("");
        txtHoGV.setText("");
        txtTenGV.setText("");
        txtNamSinh.setText("");
        txtDienThoai.setText("");
        
        img.setIcon(null);
        img.setText("Image");
        
        imgName = "null";
    }
    public void outModel(DefaultTableModel model , ArrayList<GiaoVienDTO> gv) // Xuất ra Table từ ArrayList
    {
        Vector data;
        model.setRowCount(0);
        for(GiaoVienDTO s:gv)
        {
            data = new Vector();
            data.add(s.getMaGV());
            data.add(s.getHoGV());
            data.add(s.getTenGV());
            data.add(s.getGioiTinh());
            data.add(s.getNamSinh());
            data.add(s.getDienThoai());
            data.add(s.getIMG());
            model.addRow(data);
        }
        tbl.setModel(model);
    }

    public void saveIMG()
    {
       try {
            if(i != null)
            {
                File save = new File("src/image/SanPham/"+ imgName);//Tạo file
               ImageIO.write(i,"jpg",save); // Lưu hình i vào đường dẫn file save
                i = null; //Xóa hình trong bộ nhớ 
            }
        } catch (IOException ex) {
            Logger.getLogger(QLGV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    public void listGV() // Chép ArrayList lên table
    {
        if(gvBUS.getList()== null)gvBUS.listGV();
        ArrayList<GiaoVienDTO> gv = gvBUS.getList();
        model.setRowCount(0);
        outModel(model,gv);
    }
    public void search()
    {
        String magv = sortMaGV.getText();
        String tengv= sortTenGV.getText();
        outModel(model,gvBUS.searchGV(magv, tengv));
    }
       




    public void addCombo(JComboBox cmb,ArrayList list)
    {
        for(Object a:list)
        {
            cmb.addItem(a);
        }
    }
     @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        Object a = e.getSource();
        if(a.equals(sortMaGV) || a.equals(sortTenGV) )
        {
            if(e.getKeyCode() == KeyEvent.VK_ENTER)
            {
                search();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}
}