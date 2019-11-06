package storeX.extentions;

public enum FieldsInItem {
    PHONE(15),COMPUTER(16),VEGETABLES(13),SWEETS(12),FRESHWATER(5),
    SWEETWATER(12),CLOTHES(9);

    public final int index;

    FieldsInItem(int index) {
        this.index=index;
    }
}
