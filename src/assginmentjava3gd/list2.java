/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package assginmentjava3gd;

import javax.swing.plaf.basic.BasicInternalFrameUI;
import DAO.ListDAO;
import DAO.StudentDAO2;
import Model.Student2;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class list2 extends javax.swing.JInternalFrame {
    private final ListDAO ldo;
    
    public list2() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
        ldo = new ListDAO();
        loadClassName();
        chinhjtable();
    }
    
     private static final String JDBC_URL = "jdbc:mysql://localhost:3306/assjava3"; // Đổi theo cơ sở dữ liệu của bạn
    private static final String USER = "root";
    private static final String PASSWORD = "0359910800"; // Đổi mật khẩu của bạn nếu cần

    static {
        try {
            // Đăng ký driver của MySQL
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        } catch (SQLException e) {
            throw new RuntimeException("Failed to register MySQL driver", e);
        }
    }

    // Phương thức kết nối
    public static Connection connection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
    }
    
     private void loadClassName() {
        String query = getSelectSubjectCodeQuery(); // Gọi câu lệnh SELECT từ phương thức khác
        try (Connection conn = connection();
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
    private String getSelectSubjectCodeQuery() {
        return "SELECT tenlop FROM lophoc"; // Sửa câu lệnh này tùy thuộc vào cơ sở dữ liệu của bạn
    }
    
    public void showData(List<Student2> students) {
    DefaultTableModel model = (DefaultTableModel) tblSearch.getModel();
    model.setRowCount(0); // Xóa dữ liệu cũ
    for (Student2 student : students) {
        model.addRow(new Object[]{
            student.getMasinhvien(),
            student.getTensinhvien(),
            student.getGioitinh() ? "Nam" : "Nữ", // Chuyển boolean thành "Nam" hoặc "Nữ"
            student.getTuoi(),
            student.getTenlop() // Hiển thị tên lớp từ cơ sở dữ liệu
        });
    }
}
    
    public void search(){
        String keyword = txtSearch.getText().trim(); // Lấy từ khóa và xóa khoảng trắng thừa
    if (keyword.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Vui lòng nhập từ khóa tìm kiếm!", "Thông báo", JOptionPane.WARNING_MESSAGE);
        return;
    }

    StudentDAO2 dao = new StudentDAO2(); // Tạo đối tượng DAO
    List<Student2> students = ldo.searchStudents(keyword); // Gọi phương thức tìm kiếm

    if (students.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Không tìm thấy sinh viên nào!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    } else {
        showData(students); // Hiển thị dữ liệu lên bảng
    }
    }
    
    private void loadSinhVienByLop() throws Exception {
    String selectedTenLop = (String) cboLop.getSelectedItem(); // Tên lớp được chọn từ JComboBox
    try (Connection conn = connection(); // Sử dụng phương thức connect để kết nối
         PreparedStatement ps = conn.prepareStatement(
                 "SELECT SinhVien.maSV, SinhVien.tenSV, SinhVien.gioiTinh, SinhVien.tuoi, lp.tenLop " +
                         "FROM SinhVien " +
                         "JOIN lophoc lp ON SinhVien.maLop = lp.maLop " +
                         "WHERE lp.tenLop = ?")) {

        ps.setString(1, selectedTenLop);
        try (ResultSet rs = ps.executeQuery()) {
            // Lấy DefaultTableModel từ JTable
            DefaultTableModel model = (DefaultTableModel) tblSearch.getModel();
            model.setRowCount(0); // Xóa dữ liệu cũ trong bảng

            // Thêm dữ liệu vào bảng
            while (rs.next()) {
                String maSV = rs.getString("maSV");
                String tenSV = rs.getString("tenSV");
                String gioiTinh = rs.getInt("gioiTinh") == 1 ? "Nam" : "Nữ";
                int tuoi = rs.getInt("tuoi");
                String tenLop = rs.getString("tenLop");

                // Thêm dòng mới vào bảng
                model.addRow(new Object[]{maSV, tenSV, gioiTinh, tuoi, tenLop});
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    public void chinhjtable(){
                // Tùy chỉnh giao diện JTable
        tblSearch.setFont(new Font("Segoe UI", Font.PLAIN, 16)); // chỉnh chữ
        tblSearch.setRowHeight(30);// chỉnh độ cao của bảng
        tblSearch.setGridColor(new Color(230, 230, 230));
        tblSearch.setBackground(new Color(245, 245, 245));
        tblSearch.setForeground(new Color(50, 50, 50));
        tblSearch.setSelectionBackground(new Color(0, 120, 215));
        tblSearch.setSelectionForeground(Color.WHITE);

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
    for (int i = 0; i < tblSearch.getColumnCount(); i++) {
        tblSearch.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
    }


        // Căn giữa nội dung các ô
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < tblSearch.getColumnCount(); i++) {
            tblSearch.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cboLop = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSearch = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        cboLop.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cboLop.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All" }));
        cboLop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboLopActionPerformed(evt);
            }
        });

        tblSearch.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã sinh viên", "Tên sinh viên", "Giới tính", "Tuổi ", "Lớp"
            }
        ));
        jScrollPane1.setViewportView(tblSearch);

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(284, 284, 284)
                .addComponent(cboLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jButton1)
                .addContainerGap(291, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        search();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cboLopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboLopActionPerformed
        try {
            loadSinhVienByLop();
        } catch (Exception ex) {
            Logger.getLogger(list2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cboLopActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cboLop;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblSearch;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
