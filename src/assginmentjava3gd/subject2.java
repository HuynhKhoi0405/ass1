/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package assginmentjava3gd;


import DAO.ClassDAO2;
import DAO.SubjectDAO2;
import Model.Class2;
import Model.Subject2;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACER
 */
public class subject2 extends javax.swing.JInternalFrame {
    private final List<Subject2> mon = new ArrayList<>();
    private DefaultTableModel table;
//    private final student2 st;
    /**
     * Creates new form subject2
     */
    public subject2() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
        fillTable();
        table = (DefaultTableModel) btnTableMonhoc.getModel();
        chinhjtable();
        chinhbutton();
        
    }
    public void chinhjtable(){
                // Tùy chỉnh giao diện JTable
        btnTableMonhoc.setFont(new Font("Segoe UI", Font.PLAIN, 16)); // chỉnh chữ
        btnTableMonhoc.setRowHeight(30);// chỉnh độ cao của bảng
        btnTableMonhoc.setGridColor(new Color(230, 230, 230));
        btnTableMonhoc.setBackground(new Color(245, 245, 245));
        btnTableMonhoc.setForeground(new Color(50, 50, 50));
        btnTableMonhoc.setSelectionBackground(new Color(0, 120, 215));
        btnTableMonhoc.setSelectionForeground(Color.WHITE);

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
    for (int i = 0; i < btnTableMonhoc.getColumnCount(); i++) {
        btnTableMonhoc.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
    }


        // Căn giữa nội dung các ô
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < btnTableMonhoc.getColumnCount(); i++) {
            btnTableMonhoc.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
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
        
    }
    
    public void addSubject() {
    // Kiểm tra nếu chưa nhập mã môn học và tên môn học
    if (txtma.getText().equals("") && txtten.getText().equals("")) {
        JOptionPane.showMessageDialog(this, "Chưa nhập tên và mã môn học", "Error", JOptionPane.WARNING_MESSAGE);
        JOptionPane.showMessageDialog(this, "Thêm thất bại", "Error", JOptionPane.WARNING_MESSAGE);
        return;
    }

    // Kiểm tra nếu chưa nhập tên môn học
    if (txtten.getText().equals("")) {
        JOptionPane.showMessageDialog(this, "Chưa nhập tên môn học", "Error", JOptionPane.WARNING_MESSAGE);
        JOptionPane.showMessageDialog(this, "Thêm thất bại", "Error", JOptionPane.WARNING_MESSAGE);
        return;
    }

    // Kiểm tra nếu chưa nhập mã môn học
    if (txtma.getText().equals("")) {
        JOptionPane.showMessageDialog(this, "Chưa nhập mã môn học", "Error", JOptionPane.WARNING_MESSAGE);
        JOptionPane.showMessageDialog(this, "Thêm thất bại", "Error", JOptionPane.WARNING_MESSAGE);
        return;
    }

    // Kiểm tra nếu chưa nhập điểm qua môn
    if (txtquamon.getText().equals("")) {
        JOptionPane.showMessageDialog(this, "Chưa nhập điểm qua môn", "Error", JOptionPane.WARNING_MESSAGE);
        return;
    }

    try {
        // Lấy giá trị điểm qua môn và chuyển đổi thành float
        float diemQuaMon = Float.parseFloat(txtquamon.getText());

        // Tạo đối tượng môn học
        Subject2 dp = new Subject2();
        dp.setMamon(txtma.getText());
        dp.setTenmon(txtten.getText());
        dp.setMota(txtmota.getText());
        dp.setDiemQuaMon(diemQuaMon);  // Gán điểm qua môn

        // Thêm môn học vào danh sách nội bộ (nếu có)
//        subjects2.add(dp);

        // Cập nhật bảng
          
        table.addRow(new Object[]{
            dp.getMamon(),
            dp.getTenmon(),
            dp.getMota(),
            dp.getDiemQuaMon()
        });

        // Thêm môn học vào cơ sở dữ liệu (nếu cần)
       SubjectDAO2.insertSub(dp);

        JOptionPane.showMessageDialog(this, "Thêm thành công");
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Điểm qua môn phải là số hợp lệ!", "Error", JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Lỗi khi thêm môn học: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    public void updateSubject() {
        int index = btnTableMonhoc.getSelectedRow(); // Lấy dòng được chọn từ bảng

        if (index == -1 || index >= mon.size()) { // Kiểm tra dòng hợp lệ
            JOptionPane.showMessageDialog(this, "Chưa chọn hàng nào để cập nhật!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Kiểm tra nếu chưa nhập mã môn học và tên môn học
        if (txtma.getText().equals("") && txtten.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Chưa nhập tên và mã môn học", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Kiểm tra nếu chưa nhập tên môn học
        if (txtten.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Chưa nhập tên môn học", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Kiểm tra nếu chưa nhập mã môn học
        if (txtma.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Chưa nhập mã môn học", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Kiểm tra nếu chưa nhập điểm qua môn
        if (txtquamon.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Chưa nhập điểm qua môn", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            // Lấy giá trị điểm qua môn và chuyển đổi thành float
            float diemQuaMon = Float.parseFloat(txtquamon.getText());

            Subject2 dp = mon.get(index);  // Lấy môn học hiện tại từ danh sách
            dp.setMamon(txtma.getText());
            dp.setTenmon(txtten.getText());
            dp.setMota(txtmota.getText());
            dp.setDiemQuaMon(diemQuaMon);  // Cập nhật điểm qua môn

            // Cập nhật lại combobox
    //        st.getCboMon().removeItemAt(index);
    //        st.getCboMon().insertItemAt(dp.getTenmon(), index);
    //        st.getCboMon().revalidate();
    //        st.getCboMon().repaint();
    //
    //        // Cập nhật môn học vào cơ sở dữ liệu
            SubjectDAO2.updateSub(dp);

            // Cập nhật lại bảng
            fillTable();

            JOptionPane.showMessageDialog(this, "Cập nhật thành công");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Điểm qua môn phải là số hợp lệ!", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi cập nhật môn học: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
}

public void removeSubject() {
    int index = btnTableMonhoc.getSelectedRow(); // Lấy dòng được chọn từ bảng

    if (index != -1) { // Kiểm tra dòng hợp lệ
        int choice = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa môn học này?", "Xác nhận", JOptionPane.YES_NO_OPTION);

        if (choice == JOptionPane.YES_OPTION) {
            try {
                // Lấy mã môn học từ bảng
                String mamon = (String) btnTableMonhoc.getValueAt(index, 0);

                // Xóa môn học khỏi cơ sở dữ liệu
                boolean isDeleted = SubjectDAO2.deleteSub(mamon); // Trả về true nếu xóa thành công, false nếu không

                if (isDeleted) {
                    // Xóa môn học khỏi danh sách `mon` dựa vào mã môn
                    for (int i = 0; i < mon.size(); i++) {
                        if (mon.get(i).getMamon().equals(mamon)) {
                            mon.remove(i);
                            break;
                        }
                    }

                    fillTable();
                    JOptionPane.showMessageDialog(this, "Xóa thành công!");
                    
                    if(btnTableMonhoc.getRowCount()>0){ // kiểm tra còn dữ liệu trong bảng ko
                        int newindex = Math.min(index, btnTableMonhoc.getRowCount()-1); // lấy dòng gần nhất
                        btnTableMonhoc.setRowSelectionInterval(newindex, newindex); // CHọn dòng mới
                        loadROwindexfield(newindex); // đưa dữ liệu dòng lên các field
                    }else{
                        clean();
                    }
                    
                    
                } else {
                    JOptionPane.showMessageDialog(this, "Không thể xóa môn học do ràng buộc dữ liệu (foreign key).", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Lỗi khi xóa môn học: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    } else {
        JOptionPane.showMessageDialog(this, "Chưa chọn hàng nào để xóa hoặc dữ liệu không hợp lệ!", "Thông báo", JOptionPane.WARNING_MESSAGE);
    }
}
public void loadROwindexfield(int newrowintdex){
    String mamon = (String) btnTableMonhoc.getValueAt(newrowintdex, 0);
    String tenmon = (String) btnTableMonhoc.getValueAt(newrowintdex, 1);
    String mota = (String) btnTableMonhoc.getValueAt(newrowintdex, 2);
    Float diemquamon = (Float) btnTableMonhoc.getValueAt(newrowintdex, 3);
    
    txtma.setText(mamon);
    txtten.setText(tenmon);
    txtmota.setText(mota);
    txtquamon.setText(diemquamon != null ? diemquamon.toString() : ""); // Chuyển Float thành String

}

  public void fillTable() {
    // Lấy dữ liệu từ cơ sở dữ liệu
    List<Subject2> sub = SubjectDAO2.getAllSubject();
    mon.clear(); // Xóa danh sách cũ
    mon.addAll(sub); // Cập nhật danh sách mới

    // Cập nhật JTable
    DefaultTableModel model = (DefaultTableModel) btnTableMonhoc.getModel();
    model.setRowCount(0); // Xóa dữ liệu cũ trong bảng

    for (Subject2 sb : mon) {
        Object[] row = new Object[]{sb.mamon,sb.tenmon,sb.mota,sb.diemQuaMon};
        model.addRow(row); // Thêm dữ liệu vào bảng
    }


}
     // Cập nhật combobox (nếu cần)
//    st.getCboLop().removeAllItems();
//    for (Subject2 dp : lop) {
//        st.getCboLop().addItem(dp.tenlop);
//    } 
  
    public void clickHere() {
    int row = btnTableMonhoc.getSelectedRow();  // Lấy chỉ số dòng được chọn

    // Kiểm tra xem có dòng nào được chọn không
    if (row != -1) {
        // Lấy dữ liệu từ bảng và điền vào các trường nhập liệu
        String maMon = btnTableMonhoc.getValueAt(row, 0).toString();  // Lấy mã môn từ cột 1
        String tenMon = btnTableMonhoc.getValueAt(row, 1).toString();  // Lấy tên môn từ cột 2
        String moTa = btnTableMonhoc.getValueAt(row, 2).toString();    // Lấy mô tả từ cột 3
        String diemQuaMon = btnTableMonhoc.getValueAt(row, 3).toString(); // Lấy điểm qua môn từ cột 4

        // Cập nhật các trường nhập liệu
        txtma.setText(maMon);
        txtten.setText(tenMon);
        txtmota.setText(moTa);
        txtquamon.setText(diemQuaMon);  // Cập nhật điểm qua môn
    }
}
    public void clean(){
        txtma.setText("");
        txtten.setText("");
        txtmota.setText("");
        txtquamon.setText("");
    }



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnxoa = new javax.swing.JButton();
        btncapnhat = new javax.swing.JButton();
        btnreset = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtmota = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtma = new javax.swing.JTextField();
        txtten = new javax.swing.JTextField();
        btnthem = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtquamon = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        btnTableMonhoc = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        btnxoa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnxoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/9004852_trash_delete_bin_remove_icon.png"))); // NOI18N
        btnxoa.setText("Delete");
        btnxoa.setPreferredSize(new java.awt.Dimension(98, 37));
        btnxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoaActionPerformed(evt);
            }
        });

        btncapnhat.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btncapnhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/8726496_upload_icon.png"))); // NOI18N
        btncapnhat.setText("Update");
        btncapnhat.setPreferredSize(new java.awt.Dimension(98, 37));
        btncapnhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncapnhatActionPerformed(evt);
            }
        });

        btnreset.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnreset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/9856287_reset_reload_sync_update_icon.png"))); // NOI18N
        btnreset.setText("Reset");
        btnreset.setPreferredSize(new java.awt.Dimension(98, 37));
        btnreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnresetActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Subject ID");

        txtmota.setColumns(20);
        txtmota.setRows(5);
        jScrollPane2.setViewportView(txtmota);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Subject Name");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Note");

        btnthem.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnthem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/299068_add_sign_icon.png"))); // NOI18N
        btnthem.setText("Add");
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Pass point");

        btnTableMonhoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Subject ID", "Subject Name", "Note", "Pass point"
            }
        ));
        btnTableMonhoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTableMonhocMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(btnTableMonhoc);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtten, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(36, 36, 36)
                            .addComponent(txtquamon, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(37, 37, 37)
                        .addComponent(txtma, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(222, 222, 222))
            .addGroup(layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(btnthem, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(btnxoa, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(btncapnhat, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(btnreset, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtquamon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(93, 93, 93))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btncapnhat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnreset, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(btnxoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnthem))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed
        addSubject();
    }//GEN-LAST:event_btnthemActionPerformed

    private void btnxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoaActionPerformed
       removeSubject();
    }//GEN-LAST:event_btnxoaActionPerformed

    private void btncapnhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncapnhatActionPerformed
        updateSubject();
    }//GEN-LAST:event_btncapnhatActionPerformed

    private void btnTableMonhocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTableMonhocMouseClicked
        clickHere();
    }//GEN-LAST:event_btnTableMonhocMouseClicked

    private void btnresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresetActionPerformed
       clean();
    }//GEN-LAST:event_btnresetActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable btnTableMonhoc;
    private javax.swing.JButton btncapnhat;
    private javax.swing.JButton btnreset;
    private javax.swing.JButton btnthem;
    private javax.swing.JButton btnxoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField txtma;
    private javax.swing.JTextArea txtmota;
    private javax.swing.JTextField txtquamon;
    private javax.swing.JTextField txtten;
    // End of variables declaration//GEN-END:variables
}
