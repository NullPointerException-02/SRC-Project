private void showProductsFrame() {
    JFrame showFrame = new JFrame("Products List");
    showFrame.setLayout(new BorderLayout());
    String[] columnNames = {"ID", "Name", "Price", "Date"};
    DefaultTableModel model = new DefaultTableModel(columnNames, 0);
    JTable table = new JTable(model);
    JScrollPane scrollPane = new JScrollPane(table);
    showFrame.add(scrollPane, BorderLayout.CENTER);

    // Refresh Button
    JButton refreshButton = new JButton("Refresh");
    refreshButton.addActionListener(e -> {
        List<Product> products = showProducts();
        model.setRowCount(0); // Clear existing data
        for (Product product : products) {
            model.addRow(new Object[]{product.getId(), product.getName(), product.getPrice(), product.getDate()});
        }
    });

    showFrame.add(refreshButton, BorderLayout.SOUTH);
    showFrame.setSize(500, 400);
    showFrame.setVisible(true);
}

private List<Product> showProducts() {
    List<Product> products = new ArrayList<>();
    try (Connection connection = DriverManager.getConnection(url, username, password);
         Statement statement = connection.createStatement();
         ResultSet rs = statement.executeQuery("SELECT * FROM products")) {
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            double price = rs.getDouble("price");
            Date date = rs.getDate("date");
            products.add(new Product(id, name, price, date));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return products;
}