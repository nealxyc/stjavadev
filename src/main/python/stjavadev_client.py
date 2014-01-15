import pyro_setting
import Pyro4
import os

def printMethods(jdev):
    cls_name=raw_input("Full Class Name: ").strip()
    print jdev.getAllMethods(cls_name)
    
def printCompletion(jdev):
    print jdev.focusProject('AJavaProject')
#     file_name = raw_input("Full Java source file path: ").strip()
    pos = int(raw_input("Position: ").strip())
    print jdev.codeComplete('Main.java', pos)
#("src/Main.java", 103)

if __name__ == '__main__':
    jdev = Pyro4.Proxy("PYRONAME:stjavadev")

    printCompletion(jdev)
    

