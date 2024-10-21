import java.util.Date;

public class Product {

    private Long id;

    private String name;

    private String Description;

    private String category;

    private Float price;

    private Date createDate;

    public Product(Long id, String name, String description, String category, Float price, Date createDate) {
        this.id = id;
        this.name = name;
        Description = description;
        this.category = category;
        this.price = price;
        this.createDate = createDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }    

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", Description=" + Description + ", category=" + category
                + ", createDate=" + createDate + "]";
    }

    
}