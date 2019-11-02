package ducku.com.moneyhappy.model;

public class Category {

    private int _id, _parentId , _img, _type;
    private String _name;

    public Category(int _id, int _parentId, int _img, int _type, String _name) {
        this._id = _id;
        this._parentId = _parentId;
        this._img = _img;
        this._type = _type;
        this._name = _name;
    }

    public int get_type() {
        return _type;
    }

    public void set_type(int _type) {
        this._type = _type;
    }

    public Category(){}

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int get_parentId() {
        return _parentId;
    }

    public void set_parentId(int _parentId) {
        this._parentId = _parentId;
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
