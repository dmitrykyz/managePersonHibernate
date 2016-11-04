package by.academy.it.pojos;

/**
 * Created by Dmitry on 11/3/2016.
 */
public class Product{
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nameProduct;
    private Double price;
    private String status;
    private Double totalprice;

    public Product() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public double getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Double totalprice) {
        this.totalprice = totalprice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        if (id != null ? !id.equals(product.id) : product.id != null) return false;
        if (nameProduct != null ? !nameProduct.equals(product.nameProduct) : product.nameProduct != null) return false;
        if (price != null ? !price.equals(product.price) : product.price != null) return false;
        if (status != null ? !status.equals(product.status) : product.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nameProduct != null ? nameProduct.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "" + getId() + " " + nameProduct + " " + price + "$ " + status + " total price = " + getTotalprice();
    }
}
