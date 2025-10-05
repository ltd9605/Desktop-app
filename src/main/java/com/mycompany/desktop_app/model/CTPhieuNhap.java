package com.mycompany.desktop_app.model;

/**
 * Purchase Order Detail entity class
 */
public class CTPhieuNhap {
    private int ctPhieuNhapId;
    private int phieuNhapId; // foreign key to PhieuNhap
    private int productId;   // foreign key to Product
    private int quantity;
    private float price;

    // Constructor
    public CTPhieuNhap() {}

    public CTPhieuNhap(int ctPhieuNhapId, int phieuNhapId, int productId, int quantity, float price) {
        this.ctPhieuNhapId = ctPhieuNhapId;
        this.phieuNhapId = phieuNhapId;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }

    // GETTER
    public int getCtPhieuNhapId() { return ctPhieuNhapId; }
    public int getPhieuNhapId() { return phieuNhapId; }
    public int getProductId() { return productId; }
    public int getQuantity() { return quantity; }
    public float getPrice() { return price; }

    // SETTER
    public void setCtPhieuNhapId(int ctPhieuNhapId) { this.ctPhieuNhapId = ctPhieuNhapId; }
    public void setPhieuNhapId(int phieuNhapId) { this.phieuNhapId = phieuNhapId; }
    public void setProductId(int productId) { this.productId = productId; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setPrice(float price) { this.price = price; }

    @Override
    public String toString() {
        return "CTPhieuNhap{" + "ctPhieuNhapId=" + ctPhieuNhapId +
               ", phieuNhapId=" + phieuNhapId + ", productId=" + productId +
               ", quantity=" + quantity + ", price=" + price + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        CTPhieuNhap other = (CTPhieuNhap) obj;
        return ctPhieuNhapId == other.ctPhieuNhapId;
    }
}
