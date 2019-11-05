package storeX.extentions;

public enum FieldsInItem {
    PHONE(15),COMPUTER(16),VEGETABLES(4),SWEETS(4),FRESHWATER(5),SWEETWATER(4),CLOTHES(6);

    public final int index;

    FieldsInItem(int index) {
        this.index=index;
    }
}
