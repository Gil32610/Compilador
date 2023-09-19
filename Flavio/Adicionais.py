TokenList = ["int", "boolean", "String", "float", "double"]
AttrList = ["=", ">", "<"]


class Variavel:
    nome = ""
    tipo = ""
    valor = ""

    def __init__(self, nome, tipo, valor):
        self.nome = nome
        self.tipo = tipo
        self.setValor(valor)
    
    def setValor(self, valor):
        if self.tipo == "int":
            self.valor = valor
        elif self.tipo == "boolean":
            if self.valor == "false" or self.valor == "true":
                self.valor = valor
        elif self.tipo == "String":
            self.valor = valor
    
    def getValor(self):
        return self.valor
    
    def getTipo(self):
        return self.tipo
    
    def getNome(self):
        return self.nome



def getCode():
    code = ""
    with open('ArquivoAqui/arquivo.txt', 'r') as arquivo:
        for v in arquivo:
            code += v
    
    return code