public enum EnumLexico{
    INT("int"),
    FLOAT("float"),
    STRING("String");

    private String description = "";

    EnumLexico(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }
}