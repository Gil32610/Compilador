public enum EnumATTR {
    IGUAL("="),
    MAIOR(">"),
    MENOR("<");

    private String desc;

    EnumATTR(String desc){
        this.desc = desc;
    }

    public String getDesc(){
        return desc;
    }
}