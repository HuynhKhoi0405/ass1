/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package assginmentjava3gd;

import DAO.StudentDAO2;
import Model.Student2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Excel.StudentExcel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
/**
 *
 * @author ACER
 */
public class student2 extends javax.swing.JInternalFrame {
    private final List<Student2> sinhvien = new ArrayList<>();
    /**
     * Creates new form student2
     */
    public student2() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
        loadClassNames();
        loadSubjectID();
        fillToTable();
        chinhbutton();
        chinhjtable();
    }
    
    public void chinhjtable(){
                // Tùy chỉnh giao diện JTable
        tblSV.setFont(new Font("Segoe UI", Font.PLAIN, 16)); // chỉnh chữ
        tblSV.setRowHeight(30);// chỉnh độ cao của bảng
        tblSV.setGridColor(new Color(230, 230, 230));
        tblSV.setBackground(new Color(245, 245, 245));
        tblSV.setForeground(new Color(50, 50, 50));
        tblSV.setSelectionBackground(new Color(0, 120, 215));
        tblSV.setSelectionForeground(Color.WHITE);

        // Tùy chỉnh header
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer() {
        @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                // Giữ màu nền và màu chữ của header
                comp.setBackground(new Color(0, 153, 204)); // Màu nền của header
                comp.setForeground(Color.WHITE); // Màu chữ
                setFont(new Font("Segoe UI", Font.BOLD, 18)); // Phông chữ
                setHorizontalAlignment(JLabel.CENTER); // Căn giữa

                return comp;
            }
        };
       
    // Áp dụng renderer cho từng cột
    for (int i = 0; i < tblSV.getColumnCount(); i++) {
        tblSV.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
    }


        // Căn giữa nội dung các ô
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < tblSV.getColumnCount(); i++) {
            tblSV.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

    }
    
    public void chinhbutton(){
        // chỉnh màu và font chữ của btnthem
        btnthem.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btnthem.setBackground(new Color(0, 153, 204)); // Màu nền của button
        btnthem.setForeground(Color.black); // Màu chữ
        btnthem.setPreferredSize(new Dimension(120, 40));
        btnthem.setBorder(BorderFactory.createLineBorder(new Color(0, 120, 215), 2));
        btnthem.setFocusPainted(false);
        btnthem.setOpaque(true);
        btnthem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnthem.setBackground(new Color(0, 120, 215)); // Đổi màu nền khi chuột di chuyển qua
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnthem.setBackground(new Color(0, 153, 204)); // Trở lại màu nền ban đầu khi chuột ra khỏi button
            }
        });
        // chỉnh màu và font chữ của btnxoa
        btnxoa.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btnxoa.setBackground(new Color(0, 153, 204)); 
        btnxoa.setForeground(Color.black);
        btnxoa.setPreferredSize(new Dimension(120, 40));
        btnxoa.setBorder(BorderFactory.createLineBorder(new Color(0, 120, 215), 2));
        btnxoa.setFocusPainted(false);
        btnxoa.setOpaque(true);
        btnxoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnxoa.setBackground(new Color(0, 120, 215));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnxoa.setBackground(new Color(0, 153, 204));
            }
        });
         // chỉnh màu và font chữ của btncapnhat
        btncapnhat.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btncapnhat.setBackground(new Color(0, 153, 204)); 
        btncapnhat.setForeground(Color.black);
        btncapnhat.setPreferredSize(new Dimension(120, 40));
        btncapnhat.setBorder(BorderFactory.createLineBorder(new Color(0, 120, 215), 2));
        btncapnhat.setFocusPainted(false);
        btncapnhat.setOpaque(true);
        btncapnhat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btncapnhat.setBackground(new Color(0, 120, 215));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btncapnhat.setBackground(new Color(0, 153, 204));
            }
        });
         // chỉnh màu và font chữ của btnreset
        btnreset.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btnreset.setBackground(new Color(0, 153, 204)); 
        btnreset.setForeground(Color.black);
        btnreset.setPreferredSize(new Dimension(120, 40));
        btnreset.setBorder(BorderFactory.createLineBorder(new Color(0, 120, 215), 2));
        btnreset.setFocusPainted(false);
        btnreset.setOpaque(true);
        btnreset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnreset.setBackground(new Color(0, 120, 215));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnreset.setBackground(new Color(0, 153, 204));
            }
        });
        jButton4.setFont(new Font("Segoe UI", Font.BOLD, 16));
        jButton4.setBackground(new Color(0, 153, 204)); 
        jButton4.setForeground(Color.black);
        jButton4.setPreferredSize(new Dimension(120, 40));
        jButton4.setBorder(BorderFactory.createLineBorder(new Color(0, 120, 215), 2));
        jButton4.setFocusPainted(false);
        jButton4.setOpaque(true);
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton4.setBackground(new Color(0, 120, 215));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton4.setBackground(new Color(0, 153, 204));
            }
        });
    }
    // Phương thức kết nối cơ sở dữ liệu
    private Connection connect() throws Exception {
        String url = "jdbc:mysql://localhost:3306/assjava3"; // Thay 'ten_database' bằng tên database
        String user = "root"; // Thay username
        String password = "0359910800"; // Thay password
        return DriverManager.getConnection(url, user, password);
    }
    public JComboBox<String> getCboLop() {
        return cboLop;
    }
    // Phương thức để load dữ liệu từ cơ sở dữ liệu lên ComboBox
    private void loadClassNames() {
        String query = getSelectClassQuery(); // Gọi câu lệnh SELECT từ phương thức khác
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            cboLop.removeAllItems(); // Xóa tất cả các mục hiện có trong ComboBox
            while (rs.next()) {
                cboLop.addItem(rs.getString(1)); // Thêm tên lớp vào ComboBox
            }
        } catch (Exception e) {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "Lỗi khi tải danh sách lớp.");
        }
    }

    // Phương thức để trả về câu lệnh SELECT
    private String getSelectClassQuery() {
        return "SELECT maLop FROM LopHoc"; // Sửa câu lệnh này tùy thuộc vào cơ sở dữ liệu của bạn
    }

    
    // phần trên là combobox lấy dữ liệu từ database á
    private void loadSubjectID() {
        String query = getSelectSubjectCodeQuery(); // Gọi câu lệnh SELECT từ phương thức khác
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            cboMon.removeAllItems(); // Xóa tất cả các mục hiện có trong ComboBox
            while (rs.next()) {
                cboMon.addItem(rs.getString(1)); // Thêm tên lớp vào ComboBox
            }
        } catch (Exception e) {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "Lỗi khi tải danh sách lớp.");
        }
    }
    private String getSelectSubjectCodeQuery() {
        return "SELECT maMon FROM MonHoc"; // Sửa câu lệnh này tùy thuộc vào cơ sở dữ liệu của bạn
    }
    // 
    public void addStudent2() {
        // Kiểm tra các trường bắt buộc
        if (txtMaSV.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã sinh viên!");
            return;
        }
        if (txtTenSV.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên sinh viên!");
            return;
        }
        if (txtTuoi.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tuổi sinh viên!");
            return;
        }
        try {
            int tuoi = Integer.parseInt(txtTuoi.getText());
            if (tuoi <= 0) {
                JOptionPane.showMessageDialog(this, "Tuổi phải lớn hơn 0!");
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Tuổi phải là một số hợp lệ!");
            return;
        }

        // Kiểm tra giới tính
        if (!rdbNam.isSelected() && !rdbNu.isSelected()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn giới tính!");
            return;
        }

        // Lấy thông tin từ giao diện
        String maSV = txtMaSV.getText();
        String tenSV = txtTenSV.getText();
        String maMon = (String) cboMon.getSelectedItem();
        boolean gioiTinh = rdbNam.isSelected(); // Nam: true, Nữ: false
        int tuoi = Integer.parseInt(txtTuoi.getText());
        String malop = (String) cboLop.getSelectedItem();

        // Kiểm tra mã sinh viên có trùng hay không
        StudentDAO2 dao = new StudentDAO2();
        if (dao.checkStudentExists(maSV)) {
            JOptionPane.showMessageDialog(this, "Mã sinh viên đã tồn tại, vui lòng nhập mã khác!");
            return; // Kết thúc phương thức nếu mã sinh viên trùng
        }

        // Tạo đối tượng Student2
        Student2 student = new Student2(maSV, tenSV,  maMon, gioiTinh, tuoi ,malop);

        // Gọi phương thức addStudent để thêm sinh viên vào cơ sở dữ liệu
        boolean result = dao.addStudent(student);

        // Kiểm tra kết quả
        if (result) {
            JOptionPane.showMessageDialog(this, "Thêm sinh viên thành công!");
            fillToTable();
            clearForm();
        } else {
            JOptionPane.showMessageDialog(this, "Có lỗi xảy ra khi thêm sinh viên.");
        }
    }


    //
    public void updateStudent2(){
         // Lấy thông tin từ các trường nhập liệu trên form
        String maSV = txtMaSV.getText();          // Giả sử txtMaSV là JTextField nhập mã sinh viên
        String tenSV = txtTenSV.getText();        // Giả sử txtTenSV là JTextField nhập tên sinh viên

        // Lấy giá trị từ ComboBox (mã lớp và mã môn)
        String maLop = (String) cboLop.getSelectedItem();   // cboMaLop là JComboBox cho mã lớp
        String maMon = (String) cboMon.getSelectedItem();   // cboMaMon là JComboBox cho mã môn

        // Lấy giá trị từ RadioButton (giới tính)
        boolean gioiTinh = rdbNam.isSelected();    // rdNam là JRadioButton cho giới tính Nam

        // Lấy giá trị từ trường tuổi
        int tuoi = Integer.parseInt(txtTuoi.getText());  // Giả sử txtTuoi là JTextField nhập tuổi

        // Tạo đối tượng Student2 từ thông tin nhập vào
        Student2 student = new Student2();
        student.setMasinhvien(maSV);
        student.setTensinhvien(tenSV);
        student.setMalop(maLop);
        student.setMamon(maMon);
        student.setGioitinh(gioiTinh);
        student.setTuoi(tuoi);

        // Tạo đối tượng StudentDAO2 và gọi phương thức updateStudent
        StudentDAO2 studentDAO = new StudentDAO2();
        boolean isUpdated = studentDAO.updateStudent(student);

        if (isUpdated) {
            JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
            fillToTable(); // Reload lại dữ liệu trong bảng nếu cần
        } else {
            JOptionPane.showMessageDialog(this, "Cập nhật thất bại!");
        }
    }
    public void fillToTable(){
        DefaultTableModel model = (DefaultTableModel) tblSV.getModel();
        model.setRowCount(0); // Xóa dữ liệu hiện tại trên bảng

        String query = "SELECT maSV, tenSV, maMon, gioiTinh, tuoi, maLop FROM SinhVien"; // Tùy chỉnh câu lệnh SELECT cho phù hợp với CSDL
        try (Connection conn = connect(); // Kết nối CSDL
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                String maSV = rs.getString("maSV");         // Lấy mã sinh viên
                String tenSV = rs.getString("tenSV");       // Lấy tên sinh viên
                String maMon = rs.getString("maMon");       // Lấy mã môn
                boolean gioiTinh = rs.getBoolean("gioiTinh"); // Lấy giới tính (true/false)
                int tuoi = rs.getInt("tuoi");              // Lấy tuổi
                String malop = rs.getString("maLop");          // Lấy lớp

                // Thêm một dòng mới vào JTable
                model.addRow(new Object[]{
                    maSV,
                    tenSV,
                    maMon,
                    gioiTinh ? "Nam" : "Nữ", // Hiển thị Nam hoặc Nữ
                    tuoi, 
                    malop
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi tải dữ liệu từ cơ sở dữ liệu.");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi không xác định.");
        }
    }
    private void clearForm() {
        txtMaSV.setText(""); // Xóa mã sinh viên
        txtTenSV.setText(""); // Xóa tên sinh viên
        cboMon.setSelectedIndex(0); // Reset combo box mã môn về mục đầu tiên
        txtTuoi.setText(""); // Xóa tuổi
        rdbNam.setSelected(true); // Đặt giới tính mặc định là Nam
        cboLop.setSelectedIndex(0); // Reset combo box mã lớp về mục đầu tiên
    }
    private void fillFormTable() {
        int selectedRow = tblSV.getSelectedRow(); // Lấy chỉ số dòng được chọn
        if (selectedRow >= 0) {
            // Lấy thông tin từ bảng và điền vào các trường nhập liệu
            txtMaSV.setText(tblSV.getValueAt(selectedRow, 0).toString());
            txtTenSV.setText(tblSV.getValueAt(selectedRow, 1).toString());
            cboMon.setSelectedItem(tblSV.getValueAt(selectedRow, 2).toString());
            cboLop.setSelectedItem(tblSV.getValueAt(selectedRow, 5).toString());
            boolean isNam = tblSV.getValueAt(selectedRow, 3).toString().equals("Nam");
            rdbNam.setSelected(isNam);
            rdbNu.setSelected(!isNam);
            txtTuoi.setText(tblSV.getValueAt(selectedRow, 4).toString());
        }
    }
    public void removeStudent() {
    int index = tblSV.getSelectedRow(); // Lấy dòng được chọn từ bảng

    if (index != -1) { // Kiểm tra dòng hợp lệ
        int choice = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa sinh viên này?", "Xác nhận", JOptionPane.YES_NO_OPTION);

        if (choice == JOptionPane.YES_OPTION) {
            try {
                // Lấy mã sinh vien học từ bảng
                String masinhvien = (String) tblSV.getValueAt(index, 0);

                // Xóa môn học khỏi cơ sở dữ liệu
                boolean isDeleted = StudentDAO2.deleteST(masinhvien);// Trả về true nếu xóa thành công, false nếu không

                if (isDeleted) {
                    // Xóa môn học khỏi danh sách `sinhvien` dựa vào mã sinh vien
                    for (int i = 0; i < sinhvien.size(); i++) {
                        if (sinhvien.get(i).getMamon().equals(masinhvien)) {
                            sinhvien.remove(i);
                            break;
                        }
                    }

                    fillToTable();
                    JOptionPane.showMessageDialog(this, "Xóa thành công!");
                    
                    if(tblSV.getRowCount()>0){ // kiểm tra còn dữ liệu trong bảng ko
                        int newindex = Math.min(index, tblSV.getRowCount()-1); // lấy dòng gần nhất
                        tblSV.setRowSelectionInterval(newindex, newindex); // CHọn dòng mới
                        loadROwindexfield(newindex); // đưa dữ liệu dòng lên các field
                    }else{
                        cleans();
                    }
                    
                    
                } else {
                    JOptionPane.showMessageDialog(this, "Không thể xóa sinh viên do ràng buộc dữ liệu (foreign key).", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Lỗi khi xóa sinh viên : " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    } else {
        JOptionPane.showMessageDialog(this, "Chưa chọn hàng nào để xóa hoặc dữ liệu không hợp lệ!", "Thông báo", JOptionPane.WARNING_MESSAGE);
    }
}

    public void loadROwindexfield(int newrowintdex) {
        try {
            String masinhvien = tblSV.getValueAt(newrowintdex, 0).toString();
            String tensinhvien = tblSV.getValueAt(newrowintdex, 1).toString();
            String mamon = tblSV.getValueAt(newrowintdex, 2).toString();
            String gioitinh = tblSV.getValueAt(newrowintdex, 3).toString();
            int tuoi = (Integer) tblSV.getValueAt(newrowintdex, 4); // Tuổi là Integer
            String lop = tblSV.getValueAt(newrowintdex, 5).toString();

            txtMaSV.setText(masinhvien);
            txtTenSV.setText(tensinhvien);
            cboMon.setSelectedItem(mamon);
            txtTuoi.setText(String.valueOf(tuoi)); // Chuyển đổi từ Integer sang String
            cboLop.setSelectedItem(lop);

            // Chọn đúng radio button cho giới tính
            if (gioitinh.equalsIgnoreCase("Nam")) {
                rdbNam.setSelected(true);
            } else {
                rdbNu.setSelected(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi tải dữ liệu sinh viên: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

   
   public void cleans() {
        txtMaSV.setText("");
        txtTenSV.setText("");
        txtTuoi.setText("");
        cboMon.setSelectedIndex(-1); // Reset ComboBox
        cboLop.setSelectedIndex(-1);
        buttonGroup1.clearSelection(); // Bỏ chọn radio button
        JOptionPane.showMessageDialog(this, "Đã làm mới!");
    }

    

    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        btncapnhat = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        txtMaSV = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSV = new javax.swing.JTable();
        txtTenSV = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTuoi = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        rdbNam = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        rdbNu = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnthem = new javax.swing.JButton();
        btnxoa = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cboLop = new javax.swing.JComboBox<>();
        cboMon = new javax.swing.JComboBox<>();
        btnreset = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setBackground(new java.awt.Color(255, 255, 255));

        btncapnhat.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btncapnhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/8726496_upload_icon.png"))); // NOI18N
        btncapnhat.setText("Cập nhật");
        btncapnhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncapnhatActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/6296676_excel_microsoft_office_office365_icon.png"))); // NOI18N
        jButton4.setText("Export");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        txtMaSV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMaSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaSVActionPerformed(evt);
            }
        });

        tblSV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Student ID", "Student Name", "Subject ID", "Sex", "Age", "Class"
            }
        ));
        tblSV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSVMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSV);

        txtTenSV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTenSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenSVActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Student ID");

        txtTuoi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Student Name");

        rdbNam.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdbNam);
        rdbNam.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        rdbNam.setText("Male");
        rdbNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbNamActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Subject ID");

        rdbNu.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdbNu);
        rdbNu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        rdbNu.setText("Female");
        rdbNu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbNuActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Sex");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Age");

        btnthem.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnthem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/299068_add_sign_icon.png"))); // NOI18N
        btnthem.setText("Thêm ");
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
            }
        });

        btnxoa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnxoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/9004852_trash_delete_bin_remove_icon.png"))); // NOI18N
        btnxoa.setText("Xóa ");
        btnxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoaActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Class");

        cboLop.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cboLop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboLopActionPerformed(evt);
            }
        });

        cboMon.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnreset.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnreset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/9856287_reset_reload_sync_update_icon.png"))); // NOI18N
        btnreset.setText("Reset");
        btnreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnresetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(38, 38, 38)
                        .addComponent(txtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTenSV, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(cboMon, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(27, 27, 27)
                        .addComponent(rdbNam, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdbNu, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cboLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnthem, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addComponent(btnxoa, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(btncapnhat, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(btnreset, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(txtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTuoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(cboMon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(cboLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTenSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(rdbNam)
                    .addComponent(rdbNu))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnthem)
                    .addComponent(btnxoa)
                    .addComponent(btnreset)
                    .addComponent(btncapnhat)
                    .addComponent(jButton4))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       StudentExcel.exportToExcel(tblSV);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed
       addStudent2();
    }//GEN-LAST:event_btnthemActionPerformed

    private void btncapnhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncapnhatActionPerformed
        updateStudent2();
    }//GEN-LAST:event_btncapnhatActionPerformed

    private void tblSVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSVMouseClicked
        fillFormTable();
    }//GEN-LAST:event_tblSVMouseClicked

    private void btnxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoaActionPerformed
        removeStudent();
    }//GEN-LAST:event_btnxoaActionPerformed

    private void btnresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresetActionPerformed
        cleans();
    }//GEN-LAST:event_btnresetActionPerformed

    private void rdbNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbNamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdbNamActionPerformed

    private void rdbNuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbNuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdbNuActionPerformed

    private void cboLopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboLopActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboLopActionPerformed

    private void txtTenSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenSVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenSVActionPerformed

    private void txtMaSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaSVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaSVActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncapnhat;
    private javax.swing.JButton btnreset;
    private javax.swing.JButton btnthem;
    private javax.swing.JButton btnxoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboLop;
    private javax.swing.JComboBox<String> cboMon;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdbNam;
    private javax.swing.JRadioButton rdbNu;
    private javax.swing.JTable tblSV;
    private javax.swing.JTextField txtMaSV;
    private javax.swing.JTextField txtTenSV;
    private javax.swing.JTextField txtTuoi;
    // End of variables declaration//GEN-END:variables

    
}
