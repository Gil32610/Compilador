public enum EnumToken {
    INT("int"),
    BOOL("boolean"),
    FLOAT("float"),
    DOUBLE("double");

    private String desc;

    EnumToken(String desc){
        this.desc = desc;
    }

    public String getDesc(){
        return desc;
    }
}