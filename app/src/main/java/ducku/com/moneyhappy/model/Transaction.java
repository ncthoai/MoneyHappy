package ducku.com.moneyhappy.model;

public class Transaction {
    private int id;
    private int type;
    private int walletId;
    private int categoryId;
    private String description;
    private String created;
    private int amount;

    public Transaction(int id, int type, int walletId, int categoryId, String description, String created, int amount) {
        this.id = id;
        this.type = type;
        this.walletId = walletId;
        this.categoryId = categoryId;
        this.description = description;
        this.created = created;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getWalletId() {
        return walletId;
    }

    public void setWalletId(int walletId) {
        this.walletId = walletId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}

