private void showAddProductDialog() {
    JDialog addDialog = new JDialog(frame, "Add Product", true);
    addDialog.setLayout(new FlowLayout());
    JTextField nameField = new JTextField(20);
    JTextField priceField = new JTextField(20);
    JTextField dateField = new JTextField(20); // Format: MM/dd/yyyy
    JButton saveButton = new JButton("Save");

    saveButton.addActionListener(e -> {
        try {
            String name = nameField.getText();
            double price = Double.parseDouble(priceField.getText());
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            Date date = new Date(dateFormat.parse(dateField.getText()).getTime());
            Product product = new Product(0, name, price, date); // Assuming ID is auto-generated
            insertProduct(product);
            addDialog.dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(addDialog, "Error: " + ex.getMessage());
        }
    });

    addDialog.add(new JLabel("Name:"));
    addDialog.add(nameField);
    addDialog.add(new JLabel("Price:"));
    addDialog.add(priceField);
    addDialog.add(new JLabel("Date (MM/dd/yyyy):"));
    addDialog.add(dateField);
    addDialog.add(saveButton);

    addDialog.setSize(300, 200);
    addDialog.setVisible(true);
}