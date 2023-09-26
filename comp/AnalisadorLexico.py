import re

from tokens import token
from regex import dict
from reader import reader

dct = dict()
tkn = token(dct)
reader = reader(dct, tkn, 'Flavio/ArquivoAqui/arquivo.txt')
reader.read()
print(reader.tkn.tolken_table)