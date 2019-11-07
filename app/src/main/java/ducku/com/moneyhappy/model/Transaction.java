package ducku.com.moneyhappy.model;

public class Transaction {
    private int id;
    private int type;
    private int walletId;
    private int categoryId;
    private int amount;
    private int imageCategory;
    private int imageWallet;
    private String nameCategory;
    private String created;
    private String description;

    public Transaction(int id, int type, int walletId, int categoryId, int amount, int imageCategory, int imageWallet, String nameCategory, String created, String description) {
        this.id = id;
        this.type = type;
        this.walletId = walletId;
        this.categoryId = categoryId;
        this.amount = amount;
        this.imageCategory = imageCategory;
        this.imageWallet = imageWallet;
        this.nameCategory = nameCategory;
        this.created = created;
        this.description = description;
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getImageCategory() {
        return imageCategory;
    }

    public void setImageCategory(int imageCategory) {
        this.imageCategory = imageCategory;
    }

    public int getImageWallet() {
        return imageWallet;
    }

    public void setImageWallet(int imageWallet) {
        this.imageWallet = imageWallet;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

