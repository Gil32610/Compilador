public enum EnumOperador {
    EQUALS("="),
    GREATER(">"),
    LESS("<");

    private String description;

    EnumOperador(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }
}