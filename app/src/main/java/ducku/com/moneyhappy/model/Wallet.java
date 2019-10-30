package ducku.com.moneyhappy.model;

public class Wallet {

    private int _id, _amount, _img;
    private String _name;

    public Wallet(int _id, int _amount, int _img, String _name) {
        this._id = _id;
        this._amount = _amount;
        this._img = _img;
        this._name = _name;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int get_amount() {
        return _amount;
    }

    public void set_amount(int _amount) {
        this._amount = _amount;
    }

    public int get_img() {
        return _img;
    }

    public void set_img(int _img) {
        this._img = _img;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }
}
