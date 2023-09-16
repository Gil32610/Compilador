import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static LinkedList<String> tokens = new LinkedList<>();
    public static LinkedList<String> attr = new LinkedList<>(); //OPERADORES
    public static LinkedList<Variavel> ids = new LinkedList<>();
    public static LinkedList<String> idSlot = new LinkedList<>();

    public static void main(String[] args) {
        String txt = LeitorArquivoTxt.getCode();

        String lexema = "";
        String strgPrint = "[";

        for(int i = 0; i < txt.length(); i++)
        {
            String c = Character.toString(txt.charAt(i));
            if(c.equals(" "))
            {
                boolean istoken = isToken(lexema);
                boolean isattr = isATTR(lexema); //se e operador
                if(istoken == false && isattr == false)
                {
                    strgPrint = strgPrint + " ID";
                    String token = tokens.removeFirst();
                    if(token.equals("int"))
                    {
                        Variavel var = new Variavel(lexema, "integer", "0");
                        ids.addLast(var);
                        idSlot.addLast(var.getID());
                    }
                    else if(token.equals("boolean"))
                    {
                        Variavel var = new Variavel(lexema, "boolean", "false");
                        ids.addLast(var);
                        idSlot.addLast(var.getID());
                    }
                    else if(token.equals("float"))
                    {
                        Variavel var = new Variavel(lexema, "float", "0.0f");
                        ids.addLast(var);
                        idSlot.addLast(var.getID());
                    }
                    else if(token.equals("double"))
                    {
                        Variavel var = new Variavel(lexema, "double", "0.0");
                        ids.addLast(var);
                        idSlot.addLast(var.getID());
                    }
                }
                else if(istoken)
                {
                    strgPrint = strgPrint + " TOKEN";
                    tokens.addLast(lexema);
                }
                else //attr
                {
                    strgPrint = strgPrint + " ATTR";
                    attr.addLast(lexema);
                }
                lexema = "";
            }
            else if(c.equals(";"))
            {
                strgPrint = pontoVirgula(lexema, strgPrint);
                if(strgPrint.equals("ERRO"))
                {
                    System.out.println("ERRO ENCONTRADO");
                    break;
                }
                System.out.println(strgPrint);
                strgPrint = "[";
                lexema = "";
            }
            else
            {
                int length = c.length();
                int code = Character.valueOf(c.charAt(0)); //seria o vazio/proxima linha
                if(length >= 1 && code != 10)
                {
                    lexema = lexema + c;
                }
            }
        }

        System.out.println("ACABOU");
    }

    public static String pontoVirgula(String lexema, String strgPrint){
        String op = attr.removeFirst();
        if(op.equals("="))
        {
            int pos = findID(idSlot.removeFirst()); //pegar posicao
            if(pos > -1) //a variavel foi declarada
            {
                String status = ids.get(pos).setValue(lexema);
                if(status.equals("ok") == true)
                {
                    return strgPrint + " VALOR ;]";
                }
            }
        }

        return "ERRO";
    }

    public static boolean isToken(String strg){
        for(EnumToken e : EnumToken.values())
        {
            if(strg.equals(e.getDesc()))
            {
                return true;
            }
        }
        return false;
    }

    public static boolean isATTR(String strg){
        for(EnumATTR e : EnumATTR.values())
        {
            if(strg.equals(e.getDesc()))
            {
                return true;
            }
        }
        return false;
    }

    public static int findID(String name){
        if(ids.isEmpty())
        {
            return -1;
        }

        for(int i = 0; i < ids.size(); i++)
        {
            if(name.equals(ids.get(i).getID()))
            {
                return i;
            }
        }
        return -1;
    }
}