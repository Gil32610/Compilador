import Adicionais

Tokens = []
ATTRs = []
ID = []
IDslot = [] #somente string de nomes de variaveis

def isToken(lexema):
    for v in Adicionais.TokenList:
        if lexema == v:
            return True
    return False

def isAttr(lexema):
    for v in Adicionais.AttrList:
        if lexema == v:
            return True
    return False

def findID(name):
    count = 0
    for v in ID:
        if name == v.getNome():
            return count
        count += 1
    return -1

def main():
    code = Adicionais.getCode()
    print(code)
    aspasOpen = False
    lexema = ""

    for c in code:
        if c == ' ':
            if aspasOpen == False:
                istoken = isToken(lexema)
                isattr = isAttr(lexema)
                if not istoken and not isattr:
                    exist = findID(lexema)
                    if exist == -1:
                        token = Tokens.__getitem__(0)
                        var = None
                        if token == "int":
                            var = Adicionais.Variavel(lexema, token, "0")
                        elif token == "boolean":
                            var = Adicionais.Variavel(lexema, token, "false")
                        elif token == "String":
                            var = Adicionais.Variavel(lexema, token, "Text")
                        ID.insert(ID.__len__(), var)
                        IDslot.insert(IDslot.__len__(), var.getNome())
                    
                elif istoken:
                    Tokens.insert(Tokens.__len__(), lexema)
                else: #isattr
                    ATTRs.insert(ATTRs.__len__(), lexema)

                lexema = ""
        elif c == '"':
            aspasOpen = not aspasOpen
        elif c == ';':
            if aspasOpen == True:
                print("ERRO")
            else:
                pos = findID(IDslot.pop())
                ID.__getitem__(pos).setValor(lexema)
                lexema = ""
        else:
            if c != '\n':
                lexema += c





main()
print("aiai")